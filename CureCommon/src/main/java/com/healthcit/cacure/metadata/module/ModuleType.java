//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.06 at 03:59:27 PM EDT 
//


package com.healthcit.cacure.metadata.module;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ModuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="form" type="{http://www.healthcit.com/ModuleMetadata}FormType" maxOccurs="unbounded"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isFlat" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="availableActions" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isEditable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="status" type="{http://www.healthcit.com/ModuleMetadata}ModuleStatusType" />
 *       &lt;attribute name="owner" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="updatedBy" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dateModified" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="estimatedCompletionTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleType", propOrder = {
    "form",
    "description"
})
public class ModuleType {

    @XmlElement(required = true)
    protected List<FormType> form;
    protected String description;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute
    protected Boolean isFlat;
    @XmlAttribute
    protected String availableActions;
    @XmlAttribute(required = true)
    protected boolean isEditable;
    @XmlAttribute
    protected ModuleStatusType status;
    @XmlAttribute
    protected String owner;
    @XmlAttribute
    protected String updatedBy;
    @XmlAttribute
    protected XMLGregorianCalendar dateModified;
    @XmlAttribute
    protected String estimatedCompletionTime;

    /**
     * Gets the value of the form property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the form property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormType }
     * 
     * 
     */
    public List<FormType> getForm() {
        if (form == null) {
            form = new ArrayList<FormType>();
        }
        return this.form;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the isFlat property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsFlat() {
        return isFlat;
    }

    /**
     * Sets the value of the isFlat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsFlat(Boolean value) {
        this.isFlat = value;
    }

    /**
     * Gets the value of the availableActions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailableActions() {
        return availableActions;
    }

    /**
     * Sets the value of the availableActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailableActions(String value) {
        this.availableActions = value;
    }

    /**
     * Gets the value of the isEditable property.
     * 
     */
    public boolean isIsEditable() {
        return isEditable;
    }

    /**
     * Sets the value of the isEditable property.
     * 
     */
    public void setIsEditable(boolean value) {
        this.isEditable = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleStatusType }
     *     
     */
    public ModuleStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleStatusType }
     *     
     */
    public void setStatus(ModuleStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the updatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the value of the updatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedBy(String value) {
        this.updatedBy = value;
    }

    /**
     * Gets the value of the dateModified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateModified() {
        return dateModified;
    }

    /**
     * Sets the value of the dateModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateModified(XMLGregorianCalendar value) {
        this.dateModified = value;
    }

    /**
     * Gets the value of the estimatedCompletionTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    /**
     * Sets the value of the estimatedCompletionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimatedCompletionTime(String value) {
        this.estimatedCompletionTime = value;
    }

}
