// DO NOT EDIT.  Make changes to INMailGroup.java instead.
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
public abstract class _INMailGroup extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INMailGroup";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INMailRecipient> RECIPIENTS = new ERXKey<com.insigno.inmailmanager.model.INMailRecipient>("recipients");

  // Attributes
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String RECIPIENTS_KEY = RECIPIENTS.key();

  private static Logger LOG = Logger.getLogger(_INMailGroup.class);

  public INMailGroup localInstanceIn(EOEditingContext editingContext) {
    INMailGroup localInstance = (INMailGroup)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INMailGroup.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INMailGroup.LOG.isDebugEnabled()) {
    	_INMailGroup.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailGroup.CREATION_DATE_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INMailGroup.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INMailGroup.LOG.isDebugEnabled()) {
    	_INMailGroup.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailGroup.MODIFICATION_DATE_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_INMailGroup.NAME_KEY);
  }

  public void setName(String value) {
    if (_INMailGroup.LOG.isDebugEnabled()) {
    	_INMailGroup.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailGroup.NAME_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailRecipient> recipients() {
    return (NSArray<com.insigno.inmailmanager.model.INMailRecipient>)storedValueForKey(_INMailGroup.RECIPIENTS_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailRecipient> recipients(EOQualifier qualifier) {
    return recipients(qualifier, null);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailRecipient> recipients(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<com.insigno.inmailmanager.model.INMailRecipient> results;
      results = recipients();
      if (qualifier != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INMailRecipient>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INMailRecipient>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToRecipients(com.insigno.inmailmanager.model.INMailRecipient object) {
    includeObjectIntoPropertyWithKey(object, _INMailGroup.RECIPIENTS_KEY);
  }

  public void removeFromRecipients(com.insigno.inmailmanager.model.INMailRecipient object) {
    excludeObjectFromPropertyWithKey(object, _INMailGroup.RECIPIENTS_KEY);
  }

  public void addToRecipientsRelationship(com.insigno.inmailmanager.model.INMailRecipient object) {
    if (_INMailGroup.LOG.isDebugEnabled()) {
      _INMailGroup.LOG.debug("adding " + object + " to recipients relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRecipients(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _INMailGroup.RECIPIENTS_KEY);
    }
  }

  public void removeFromRecipientsRelationship(com.insigno.inmailmanager.model.INMailRecipient object) {
    if (_INMailGroup.LOG.isDebugEnabled()) {
      _INMailGroup.LOG.debug("removing " + object + " from recipients relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromRecipients(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailGroup.RECIPIENTS_KEY);
    }
  }

  public com.insigno.inmailmanager.model.INMailRecipient createRecipientsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.insigno.inmailmanager.model.INMailRecipient.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _INMailGroup.RECIPIENTS_KEY);
    return (com.insigno.inmailmanager.model.INMailRecipient) eo;
  }

  public void deleteRecipientsRelationship(com.insigno.inmailmanager.model.INMailRecipient object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailGroup.RECIPIENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllRecipientsRelationships() {
    Enumeration<com.insigno.inmailmanager.model.INMailRecipient> objects = recipients().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRecipientsRelationship(objects.nextElement());
    }
  }


  public static INMailGroup createINMailGroup(EOEditingContext editingContext, NSTimestamp creationDate
, NSTimestamp modificationDate
, String name
) {
    INMailGroup eo = (INMailGroup) EOUtilities.createAndInsertInstance(editingContext, _INMailGroup.ENTITY_NAME);    
		eo.setCreationDate(creationDate);
		eo.setModificationDate(modificationDate);
		eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<INMailGroup> fetchSpec() {
    return new ERXFetchSpecification<INMailGroup>(_INMailGroup.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INMailGroup> fetchAllINMailGroups(EOEditingContext editingContext) {
    return _INMailGroup.fetchAllINMailGroups(editingContext, null);
  }

  public static NSArray<INMailGroup> fetchAllINMailGroups(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INMailGroup.fetchINMailGroups(editingContext, null, sortOrderings);
  }

  public static NSArray<INMailGroup> fetchINMailGroups(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INMailGroup> fetchSpec = new ERXFetchSpecification<INMailGroup>(_INMailGroup.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INMailGroup> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INMailGroup fetchINMailGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailGroup.fetchINMailGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailGroup fetchINMailGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INMailGroup> eoObjects = _INMailGroup.fetchINMailGroups(editingContext, qualifier, null);
    INMailGroup eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INMailGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailGroup fetchRequiredINMailGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailGroup.fetchRequiredINMailGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailGroup fetchRequiredINMailGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    INMailGroup eoObject = _INMailGroup.fetchINMailGroup(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INMailGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailGroup localInstanceIn(EOEditingContext editingContext, INMailGroup eo) {
    INMailGroup localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
