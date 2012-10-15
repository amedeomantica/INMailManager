// DO NOT EDIT.  Make changes to INMailRecipient.java instead.
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
public abstract class _INMailRecipient extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INMailRecipient";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<NSTimestamp> DATE_LAST_SEEN = new ERXKey<NSTimestamp>("dateLastSeen");
  public static final ERXKey<String> EMAIL = new ERXKey<String>("email");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<String> OWNER_ENTITY_NAME = new ERXKey<String>("ownerEntityName");
  public static final ERXKey<Integer> OWNER_PRIMARY_KEY = new ERXKey<Integer>("ownerPrimaryKey");
  public static final ERXKey<String> PREFERRED_LANGUAGE = new ERXKey<String>("preferredLanguage");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INMailGroup> GROUPS = new ERXKey<com.insigno.inmailmanager.model.INMailGroup>("groups");

  // Attributes
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String DATE_LAST_SEEN_KEY = DATE_LAST_SEEN.key();
  public static final String EMAIL_KEY = EMAIL.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String OWNER_ENTITY_NAME_KEY = OWNER_ENTITY_NAME.key();
  public static final String OWNER_PRIMARY_KEY_KEY = OWNER_PRIMARY_KEY.key();
  public static final String PREFERRED_LANGUAGE_KEY = PREFERRED_LANGUAGE.key();
  // Relationships
  public static final String GROUPS_KEY = GROUPS.key();

  private static Logger LOG = Logger.getLogger(_INMailRecipient.class);

  public INMailRecipient localInstanceIn(EOEditingContext editingContext) {
    INMailRecipient localInstance = (INMailRecipient)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INMailRecipient.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.CREATION_DATE_KEY);
  }

  public NSTimestamp dateLastSeen() {
    return (NSTimestamp) storedValueForKey(_INMailRecipient.DATE_LAST_SEEN_KEY);
  }

  public void setDateLastSeen(NSTimestamp value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating dateLastSeen from " + dateLastSeen() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.DATE_LAST_SEEN_KEY);
  }

  public String email() {
    return (String) storedValueForKey(_INMailRecipient.EMAIL_KEY);
  }

  public void setEmail(String value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating email from " + email() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.EMAIL_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INMailRecipient.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.MODIFICATION_DATE_KEY);
  }

  public String ownerEntityName() {
    return (String) storedValueForKey(_INMailRecipient.OWNER_ENTITY_NAME_KEY);
  }

  public void setOwnerEntityName(String value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating ownerEntityName from " + ownerEntityName() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.OWNER_ENTITY_NAME_KEY);
  }

  public Integer ownerPrimaryKey() {
    return (Integer) storedValueForKey(_INMailRecipient.OWNER_PRIMARY_KEY_KEY);
  }

  public void setOwnerPrimaryKey(Integer value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating ownerPrimaryKey from " + ownerPrimaryKey() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.OWNER_PRIMARY_KEY_KEY);
  }

  public String preferredLanguage() {
    return (String) storedValueForKey(_INMailRecipient.PREFERRED_LANGUAGE_KEY);
  }

  public void setPreferredLanguage(String value) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
    	_INMailRecipient.LOG.debug( "updating preferredLanguage from " + preferredLanguage() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailRecipient.PREFERRED_LANGUAGE_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailGroup> groups() {
    return (NSArray<com.insigno.inmailmanager.model.INMailGroup>)storedValueForKey(_INMailRecipient.GROUPS_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailGroup> groups(EOQualifier qualifier) {
    return groups(qualifier, null);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailGroup> groups(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<com.insigno.inmailmanager.model.INMailGroup> results;
      results = groups();
      if (qualifier != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INMailGroup>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INMailGroup>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToGroups(com.insigno.inmailmanager.model.INMailGroup object) {
    includeObjectIntoPropertyWithKey(object, _INMailRecipient.GROUPS_KEY);
  }

  public void removeFromGroups(com.insigno.inmailmanager.model.INMailGroup object) {
    excludeObjectFromPropertyWithKey(object, _INMailRecipient.GROUPS_KEY);
  }

  public void addToGroupsRelationship(com.insigno.inmailmanager.model.INMailGroup object) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
      _INMailRecipient.LOG.debug("adding " + object + " to groups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToGroups(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _INMailRecipient.GROUPS_KEY);
    }
  }

  public void removeFromGroupsRelationship(com.insigno.inmailmanager.model.INMailGroup object) {
    if (_INMailRecipient.LOG.isDebugEnabled()) {
      _INMailRecipient.LOG.debug("removing " + object + " from groups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromGroups(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailRecipient.GROUPS_KEY);
    }
  }

  public com.insigno.inmailmanager.model.INMailGroup createGroupsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.insigno.inmailmanager.model.INMailGroup.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _INMailRecipient.GROUPS_KEY);
    return (com.insigno.inmailmanager.model.INMailGroup) eo;
  }

  public void deleteGroupsRelationship(com.insigno.inmailmanager.model.INMailGroup object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailRecipient.GROUPS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllGroupsRelationships() {
    Enumeration<com.insigno.inmailmanager.model.INMailGroup> objects = groups().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteGroupsRelationship(objects.nextElement());
    }
  }


  public static INMailRecipient createINMailRecipient(EOEditingContext editingContext, NSTimestamp creationDate
, String email
, NSTimestamp modificationDate
) {
    INMailRecipient eo = (INMailRecipient) EOUtilities.createAndInsertInstance(editingContext, _INMailRecipient.ENTITY_NAME);    
		eo.setCreationDate(creationDate);
		eo.setEmail(email);
		eo.setModificationDate(modificationDate);
    return eo;
  }

  public static ERXFetchSpecification<INMailRecipient> fetchSpec() {
    return new ERXFetchSpecification<INMailRecipient>(_INMailRecipient.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INMailRecipient> fetchAllINMailRecipients(EOEditingContext editingContext) {
    return _INMailRecipient.fetchAllINMailRecipients(editingContext, null);
  }

  public static NSArray<INMailRecipient> fetchAllINMailRecipients(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INMailRecipient.fetchINMailRecipients(editingContext, null, sortOrderings);
  }

  public static NSArray<INMailRecipient> fetchINMailRecipients(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INMailRecipient> fetchSpec = new ERXFetchSpecification<INMailRecipient>(_INMailRecipient.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INMailRecipient> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INMailRecipient fetchINMailRecipient(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailRecipient.fetchINMailRecipient(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailRecipient fetchINMailRecipient(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INMailRecipient> eoObjects = _INMailRecipient.fetchINMailRecipients(editingContext, qualifier, null);
    INMailRecipient eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INMailRecipient that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailRecipient fetchRequiredINMailRecipient(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailRecipient.fetchRequiredINMailRecipient(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailRecipient fetchRequiredINMailRecipient(EOEditingContext editingContext, EOQualifier qualifier) {
    INMailRecipient eoObject = _INMailRecipient.fetchINMailRecipient(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INMailRecipient that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailRecipient localInstanceIn(EOEditingContext editingContext, INMailRecipient eo) {
    INMailRecipient localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
