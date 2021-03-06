/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.26 at 03:48:04 PM EST 
//


package com.healthcit.cacure.export.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tableElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tableElementType">
 *   &lt;complexContent>
 *     &lt;extension base="{}FormElementType">
 *       &lt;sequence>
 *         &lt;element name="tableShortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="question" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{}questionType">
 *                 &lt;sequence>
 *                   &lt;element name="descriptions" type="{}Description"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="isIdentifying" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="tableType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="SIMPLE"/>
 *             &lt;enumeration value="DYNAMIC"/>
 *             &lt;enumeration value="STATIC"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tableElementType", propOrder = {
    "tableShortName",
    "question"
})
public class TableElementType
    extends FormElementType
{

    @XmlElement(required = true)
    protected String tableShortName;
    @XmlElement(required = true)
    protected List<TableElementType.Question> question;
    @XmlAttribute(required = true)
    protected String tableType;

    /**
     * Gets the value of the tableShortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableShortName() {
        return tableShortName;
    }

    /**
     * Sets the value of the tableShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableShortName(String value) {
        this.tableShortName = value;
    }

    /**
     * Gets the value of the question property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the question property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TableElementType.Question }
     * 
     * 
     */
    public List<TableElementType.Question> getQuestion() {
        if (question == null) {
            question = new ArrayList<TableElementType.Question>();
        }
        return this.question;
    }

    /**
     * Gets the value of the tableType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * Sets the value of the tableType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableType(String value) {
        this.tableType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{}questionType">
     *       &lt;sequence>
     *         &lt;element name="descriptions" type="{}Description"/>
     *       &lt;/sequence>
     *       &lt;attribute name="isIdentifying" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "descriptions"
    })
    public static class Question
        extends QuestionType
    {

        @XmlElement(required = true)
        protected Description descriptions;
        @XmlAttribute
        protected Boolean isIdentifying;

        /**
         * Gets the value of the descriptions property.
         * 
         * @return
         *     possible object is
         *     {@link Description }
         *     
         */
        public Description getDescriptions() {
            return descriptions;
        }

        /**
         * Sets the value of the descriptions property.
         * 
         * @param value
         *     allowed object is
         *     {@link Description }
         *     
         */
        public void setDescriptions(Description value) {
            this.descriptions = value;
        }

        /**
         * Gets the value of the isIdentifying property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsIdentifying() {
            return isIdentifying;
        }

        /**
         * Sets the value of the isIdentifying property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsIdentifying(Boolean value) {
            this.isIdentifying = value;
        }

    }

}
