/*******************************************************************************
 * Copyright (C) 2013 HealthCare IT, Inc. - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.10 at 05:08:13 PM EST 
//


package com.healthcit.cacure.security;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.healthcit.cacure.security package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Security_QNAME = new QName("http://www.healthcit.com/CollectorSecurity", "security");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.healthcit.cacure.security
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModuleTagPermissions }
     * 
     */
    public ModuleTagPermissions createModuleTagPermissions() {
        return new ModuleTagPermissions();
    }

    /**
     * Create an instance of {@link Security }
     * 
     */
    public Security createSecurity() {
        return new Security();
    }

    /**
     * Create an instance of {@link FormTag }
     * 
     */
    public FormTag createFormTag() {
        return new FormTag();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link Permissions }
     * 
     */
    public Permissions createPermissions() {
        return new Permissions();
    }

    /**
     * Create an instance of {@link ModuleTag }
     * 
     */
    public ModuleTag createModuleTag() {
        return new ModuleTag();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link FormTagPermissions }
     * 
     */
    public FormTagPermissions createFormTagPermissions() {
        return new FormTagPermissions();
    }

    /**
     * Create an instance of {@link Entities }
     * 
     */
    public Entities createEntities() {
        return new Entities();
    }

    /**
     * Create an instance of {@link EntityTagPermissions }
     * 
     */
    public EntityTagPermissions createEntityTagPermissions() {
        return new EntityTagPermissions();
    }

    /**
     * Create an instance of {@link Tags }
     * 
     */
    public Tags createTags() {
        return new Tags();
    }

    /**
     * Create an instance of {@link GroupRef }
     * 
     */
    public GroupRef createGroupRef() {
        return new GroupRef();
    }

    /**
     * Create an instance of {@link SharingGroups }
     * 
     */
    public SharingGroups createSharingGroups() {
        return new SharingGroups();
    }

    /**
     * Create an instance of {@link Tag }
     * 
     */
    public Tag createTag() {
        return new Tag();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Security }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.healthcit.com/CollectorSecurity", name = "security")
    public JAXBElement<Security> createSecurity(Security value) {
        return new JAXBElement<Security>(_Security_QNAME, Security.class, null, value);
    }

}
