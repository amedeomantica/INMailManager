// DO NOT EDIT.  Make changes to INMailTemplate.java instead.
package com.insigno.inmailmanager.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _INMailTemplate extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INMailTemplate";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INLocalizedMailTemplate> LOCALIZED_TEMPLATES = new ERXKey<com.insigno.inmailmanager.model.INLocalizedMailTemplate>("localizedTemplates");

  // Attributes
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String LOCALIZED_TEMPLATES_KEY = LOCALIZED_TEMPLATES.key();

  private static Logger LOG = Logger.getLogger(_INMailTemplate.class);

  public INMailTemplate localInstanceIn(EOEditingContext editingContext) {
    INMailTemplate localInstance = (INMailTemplate)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INMailTemplate.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INMailTemplate.LOG.isDebugEnabled()) {
    	_INMailTemplate.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailTemplate.CREATION_DATE_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INMailTemplate.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INMailTemplate.LOG.isDebugEnabled()) {
    	_INMailTemplate.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailTemplate.MODIFICATION_DATE_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_INMailTemplate.NAME_KEY);
  }

  public void setName(String value) {
    if (_INMailTemplate.LOG.isDebugEnabled()) {
    	_INMailTemplate.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailTemplate.NAME_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate> localizedTemplates() {
    return (NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate>)storedValueForKey(_INMailTemplate.LOCALIZED_TEMPLATES_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate> localizedTemplates(EOQualifier qualifier) {
    return localizedTemplates(qualifier, null, false);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate> localizedTemplates(EOQualifier qualifier, boolean fetch) {
    return localizedTemplates(qualifier, null, fetch);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate> localizedTemplates(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.insigno.inmailmanager.model.INLocalizedMailTemplate.TEMPLATE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = com.insigno.inmailmanager.model.INLocalizedMailTemplate.fetchINLocalizedMailTemplates(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = localizedTemplates();
      if (qualifier != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INLocalizedMailTemplate>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToLocalizedTemplates(com.insigno.inmailmanager.model.INLocalizedMailTemplate object) {
    includeObjectIntoPropertyWithKey(object, _INMailTemplate.LOCALIZED_TEMPLATES_KEY);
  }

  public void removeFromLocalizedTemplates(com.insigno.inmailmanager.model.INLocalizedMailTemplate object) {
    excludeObjectFromPropertyWithKey(object, _INMailTemplate.LOCALIZED_TEMPLATES_KEY);
  }

  public void addToLocalizedTemplatesRelationship(com.insigno.inmailmanager.model.INLocalizedMailTemplate object) {
    if (_INMailTemplate.LOG.isDebugEnabled()) {
      _INMailTemplate.LOG.debug("adding " + object + " to localizedTemplates relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToLocalizedTemplates(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _INMailTemplate.LOCALIZED_TEMPLATES_KEY);
    }
  }

  public void removeFromLocalizedTemplatesRelationship(com.insigno.inmailmanager.model.INLocalizedMailTemplate object) {
    if (_INMailTemplate.LOG.isDebugEnabled()) {
      _INMailTemplate.LOG.debug("removing " + object + " from localizedTemplates relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromLocalizedTemplates(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailTemplate.LOCALIZED_TEMPLATES_KEY);
    }
  }

  public com.insigno.inmailmanager.model.INLocalizedMailTemplate createLocalizedTemplatesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.insigno.inmailmanager.model.INLocalizedMailTemplate.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _INMailTemplate.LOCALIZED_TEMPLATES_KEY);
    return (com.insigno.inmailmanager.model.INLocalizedMailTemplate) eo;
  }

  public void deleteLocalizedTemplatesRelationship(com.insigno.inmailmanager.model.INLocalizedMailTemplate object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailTemplate.LOCALIZED_TEMPLATES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllLocalizedTemplatesRelationships() {
    Enumeration<com.insigno.inmailmanager.model.INLocalizedMailTemplate> objects = localizedTemplates().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteLocalizedTemplatesRelationship(objects.nextElement());
    }
  }


  public static INMailTemplate createINMailTemplate(EOEditingContext editingContext, NSTimestamp creationDate
, NSTimestamp modificationDate
, String name
) {
    INMailTemplate eo = (INMailTemplate) EOUtilities.createAndInsertInstance(editingContext, _INMailTemplate.ENTITY_NAME);    
		eo.setCreationDate(creationDate);
		eo.setModificationDate(modificationDate);
		eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<INMailTemplate> fetchSpec() {
    return new ERXFetchSpecification<INMailTemplate>(_INMailTemplate.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INMailTemplate> fetchAllINMailTemplates(EOEditingContext editingContext) {
    return _INMailTemplate.fetchAllINMailTemplates(editingContext, null);
  }

  public static NSArray<INMailTemplate> fetchAllINMailTemplates(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INMailTemplate.fetchINMailTemplates(editingContext, null, sortOrderings);
  }

  public static NSArray<INMailTemplate> fetchINMailTemplates(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INMailTemplate> fetchSpec = new ERXFetchSpecification<INMailTemplate>(_INMailTemplate.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INMailTemplate> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INMailTemplate fetchINMailTemplate(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailTemplate.fetchINMailTemplate(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailTemplate fetchINMailTemplate(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INMailTemplate> eoObjects = _INMailTemplate.fetchINMailTemplates(editingContext, qualifier, null);
    INMailTemplate eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INMailTemplate that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailTemplate fetchRequiredINMailTemplate(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailTemplate.fetchRequiredINMailTemplate(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailTemplate fetchRequiredINMailTemplate(EOEditingContext editingContext, EOQualifier qualifier) {
    INMailTemplate eoObject = _INMailTemplate.fetchINMailTemplate(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INMailTemplate that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailTemplate localInstanceIn(EOEditingContext editingContext, INMailTemplate eo) {
    INMailTemplate localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
