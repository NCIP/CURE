package com.healthcit.cacure.ant;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
 
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
 
/**
*  Mercilessly edited over some other guy's work @ http://www.xinotes.org/notes/note/636/
*  PropertiesMerger provides functionality to merge two separate .properties
*  configuration files into one while preserving user comments.
*/
public class MergeProperties extends Task
{
public static final String FIRST_PRIORITIZED = "_es_ES";
public static final String SECOND_PRIORITIZED = "_en_ES";
 
/** determines source .properties file */
private File baseFile;
/** determines property override file */
private File overrideFile;
/** determines where final properties are saved */
private File destFile;
/** stores a collection of properties added to merged file */
private HashMap map = new HashMap();
 
private Vector<FileSet> filesets = new Vector<FileSet>();
 
public void addFileset(FileSet fileset) {
filesets.add(fileset);
}
/**
*  Configures the source input file to read the source properties.
*
*  @param  file
*      A File object representing the source .properties file to read.
*/
public void setBaseFile(final File file)
{
baseFile = file;
}
 
/**
*  Configures the destination file to overwrite the properties provided
*  in the source file.
*
*  @param  file
*      A File object representing the destination file to merge the
*      combined properties into.
*/
public void setOverrideFile(final File file)
{
overrideFile = file;
}
 
/**
*  Configures the destination file to write the combined properties.
*
*  @param  file
*      A File object representing the destination file to merge the
*      combined properties into.
*/
public void setDestFile(final File file)
{
destFile = file;
}
 
/**
*  Method invoked by the ant framework to execute the action associated
*  with this task.
*
*  @throws BuildException
*      Any fatal exception that occurs while processing the task
*/
public void execute() throws BuildException
{
	// validate provided parameters
	validate();
	 
	List<String> source = loadFile(baseFile);
	List<String> merge = loadFile(overrideFile);
	// get merged property collection
	Properties props = loadProperties(source, merge);
	 
	// iterate through source, and write to file with updated properties
	writeFile(source, merge, props);

}
 
/**
*  Validate that the task parameters are valid.
*
*  @throws BuildException
*      if parameters are invalid
*/
private void validate() throws BuildException
{
	map.clear();
	if (baseFile == null || !baseFile.canRead())
	{
		final String message = "Unable to read from " + baseFile + ".";
		throw new BuildException(message);
	}
	if (overrideFile == null || !overrideFile.canRead())
	{
		final String message = "Unable to read from " + overrideFile + ".";
		throw new BuildException(message);
	}
	
}
 
/**
*  Reads the contents of the selected file and returns them in a List that
*  contains String objects that represent each line of the file in the
*  order that they were read.
*
*  @param  file
*      The file to load the contents into a List.
*  @return a List of the contents of the file where each line of the file
*      is stored as an individual String object in the List in the same
*      physical order it appears in the file.
*  @throws  BuildException
*      An exception can occur if the version file is corrupted or the
*      process is in someway interrupted
*/
private List<String> loadFile(File file) throws BuildException
{
	List<String> list = new ArrayList<String>();
	try
	{
		BufferedReader in = new BufferedReader(new FileReader(file));
		String record;
		try
		{
			while ((record = in.readLine()) != null)
			{
				record = record.trim();
				list.add(record);
			}
		}
		catch (Exception e)
		{
			throw new BuildException("Could not read file:" + file, e);
		}
		finally
		{
			in.close();
		}
	}
	catch (IOException IOe)
	{
	// had an exception trying to open the file
		throw new BuildException("Could not read file:" + file, IOe);
	}
	return list;
}
 

 
/**
*  Loads the properties from the source .properties file specified and
*  over-rides them with those found in the merge file.
*
*  @return a collection of merged properties from both specified
*      .properties files
*  @throws BuildException
*      If either of the .properties files cannot be loaded
*/
private Properties loadProperties(List<String> source, List<String> merge) throws BuildException
{
	Properties props = new Properties();
	Properties newProps = new Properties();
	 
	for (Iterator i = source.iterator(); i.hasNext(); )
	{
		String line = (String) i.next();
		processLine(props, line);
	}
	 
	for (Iterator i = merge.iterator(); i.hasNext(); )
	{
		String line = (String) i.next();
		processLine(newProps, line);
	}
	 
	for (Enumeration e = newProps.propertyNames(); e.hasMoreElements(); )
	{
		String key = (String) e.nextElement();
//		if(props.getProperty(key) == null)
//		{
			props.setProperty(key, newProps.getProperty(key));
//		}
	}
	 
	return props;
}

 
/**
*  Writes the merged properties to a single file while preserving any
*  comments.
*
*  @param  source
*      A list containing the contents of the original source file
*  @param  merge
*      A list containing the contents of the file to merge
*  @param  props
*      A collection of properties with their values merged from both files
*  @throws BuildException
*      if the destination file can't be created
*/
private void writeFile(List<String> source, List<String> merge, Properties props) throws BuildException
{
	Iterator<String> iterate = source.iterator();
	try
	{
		if (!destFile.exists())
		{
			try
			{
				destFile.createNewFile();
			}
			catch (IOException e)
			{
				throw new BuildException("Could not create " + destFile + ".");
			}
		}
	 
		FileOutputStream out = new FileOutputStream(destFile);
		PrintStream p = new PrintStream(out);
		try
		{
			// write original file with updated values
			while (iterate.hasNext())
			{
				String line = (String) iterate.next();
				p.println(updateProperty(line, props));
			}
			// add new properties to file
			Properties newProps = getNewProperties(props);
			 
			writeNewProperties(merge, newProps, p);
		}
		catch (Exception e)
		{
			throw new BuildException("Could not write file: " + destFile, e);
		}
		finally
		{
			out.close();
		}
	}
	catch (IOException IOe)
	{
		throw new BuildException("Could not write file: " + destFile, IOe);
	}
}
 
/**
*  Determines whether the specified line has a corresponding property in
*  the props collection and updates the value accordingly.
*
*  @param  line
*      The original content of the line
*  @param  props
*      A collection of merged property values
*  @return an updated string matching the correct property value
*/
private String updateProperty(String line, Properties props)
{
	if (!line.startsWith("#"))
	{
		if (line.indexOf("=") > 0)
		{
			int index = line.indexOf("=");
			String propName = line.substring(0, index).trim();
			String propValue = props.getProperty(propName);
			if (propValue != null)
			{
				map.put(propName, propValue);
				return (propName + "=" + propValue);
			}
		}
	}
	return line;
}
 
/**
*  Returns a collection of properties that have not yet been added to the
*  destination .properties file.
*
*  @param  allProps
*      A collection of all properties found between the source and merge
*      property files.
*  @return a collection of properties that have not yet been added to the
*      destination .properties files including their final values
*/
private Properties getNewProperties(Properties allProps)
{
	Properties newProps = new Properties();
	Enumeration enumProps = allProps.propertyNames();
	while (enumProps.hasMoreElements())
	{
		String key = (String) enumProps.nextElement();
		if (!map.containsKey(key))
		{
			newProps.setProperty(key, allProps.getProperty(key));
		}
	}
	return newProps;
}
 
/**
*  Writes the elements from the list that have not yet been written.
*
*  @param  list
*      A list containing each line of the file to merge
*  @param  props
*      A collection of the new properties to add to the file
*  @param  p
*      A stream to print to the destination .properties file
*  @throws IOException
*      can occur if an exception occurs while writing to the file
*/
private void writeNewProperties(List list, Properties props, PrintStream p)
throws IOException {
	List tempList = new ArrayList();
	for (Iterator i = list.iterator(); i.hasNext(); ) {
		String line = (String) i.next();
		if (line.startsWith("#")) {
		tempList.add(line);
		}
		else {
		int idx = line.indexOf("=");
		if (idx > 0) {
		String newKey = line.substring(0, idx).trim();
		String newValue = props.getProperty(newKey);
		if (newValue != null) {
		Iterator iterateTemp = tempList.iterator();
		while (iterateTemp.hasNext()) {
		p.println((String) iterateTemp.next());
		}
		p.println(newKey + "=" + newValue);
		}
		tempList.clear();
		}
		else {
		tempList.add(line);
		}
		}
	}
}
 
private void processLine(Properties props, String line) {
	if (! line.startsWith("#")) {
		int idx = line.indexOf("=");
		if (idx > 0) {
		String key = line.substring(0, idx).trim();
		String value = line.substring(idx + 1).trim();
		props.setProperty(key, value);
		}
	}
}
}