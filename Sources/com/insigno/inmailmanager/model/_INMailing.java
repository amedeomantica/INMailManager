// DO NOT EDIT.  Make changes to INMailing.java instead.
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
public abstract class _INMailing extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INMailing";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<String> MAILING_DESCRIPTION = new ERXKey<String>("mailingDescription");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<String> OWNER_ENTITY_NAME = new ERXKey<String>("ownerEntityName");
  public static final ERXKey<Integer> OWNER_PRIMARY_KEY = new ERXKey<Integer>("ownerPrimaryKey");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INLocalizedMailing> LOCALIZED_MAILINGS = new ERXKey<com.insigno.inmailmanager.model.INLocalizedMailing>("localizedMailings");

  // Attributes
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String MAILING_DESCRIPTION_KEY = MAILING_DESCRIPTION.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String OWNER_ENTITY_NAME_KEY = OWNER_ENTITY_NAME.key();
  public static final String OWNER_PRIMARY_KEY_KEY = OWNER_PRIMARY_KEY.key();
  public static final String TITLE_KEY = TITLE.key();
  // Relationships
  public static final String LOCALIZED_MAILINGS_KEY = LOCALIZED_MAILINGS.key();

  private static Logger LOG = Logger.getLogger(_INMailing.class);

  public INMailing localInstanceIn(EOEditingContext editingContext) {
    INMailing localInstance = (INMailing)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INMailing.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INMailing.LOG.isDebugEnabled()) {
    	_INMailing.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailing.CREATION_DATE_KEY);
  }

  public String mailingDescription() {
    return (String) storedValueForKey(_INMailing.MAILING_DESCRIPTION_KEY);
  }

  public void setMailingDescription(String value) {
    if (_INMailing.LOG.isDebugEnabled()) {
    	_INMailing.LOG.debug( "updating mailingDescription from " + mailingDescription() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailing.MAILING_DESCRIPTION_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INMailing.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INMailing.LOG.isDebugEnabled()) {
    	_INMailing.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailing.MODIFICATION_DATE_KEY);
  }

  public String ownerEntityName() {
    return (String) storedValueForKey(_INMailing.OWNER_ENTITY_NAME_KEY);
  }

  public void setOwnerEntityName(String value) {
    if (_INMailing.LOG.isDebugEnabled()) {
    	_INMailing.LOG.debug( "updating ownerEntityName from " + ownerEntityName() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailing.OWNER_ENTITY_NAME_KEY);
  }

  public Integer ownerPrimaryKey() {
    return (Integer) storedValueForKey(_INMailing.OWNER_PRIMARY_KEY_KEY);
  }

  public void setOwnerPrimaryKey(Integer value) {
    if (_INMailing.LOG.isDebugEnabled()) {
    	_INMailing.LOG.debug( "updating ownerPrimaryKey from " + ownerPrimaryKey() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailing.OWNER_PRIMARY_KEY_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_INMailing.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_INMailing.LOG.isDebugEnabled()) {
    	_INMailing.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailing.TITLE_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailing> localizedMailings() {
    return (NSArray<com.insigno.inmailmanager.model.INLocalizedMailing>)storedValueForKey(_INMailing.LOCALIZED_MAILINGS_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailing> localizedMailings(EOQualifier qualifier) {
    return localizedMailings(qualifier, null, false);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailing> localizedMailings(EOQualifier qualifier, boolean fetch) {
    return localizedMailings(qualifier, null, fetch);
  }

  public NSArray<com.insigno.inmailmanager.model.INLocalizedMailing> localizedMailings(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<com.insigno.inmailmanager.model.INLocalizedMailing> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.insigno.inmailmanager.model.INLocalizedMailing.MAILING_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = com.insigno.inmailmanager.model.INLocalizedMailing.fetchINLocalizedMailings(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = localizedMailings();
      if (qualifier != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INLocalizedMailing>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INLocalizedMailing>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToLocalizedMailings(com.insigno.inmailmanager.model.INLocalizedMailing object) {
    includeObjectIntoPropertyWithKey(object, _INMailing.LOCALIZED_MAILINGS_KEY);
  }

  public void removeFromLocalizedMailings(com.insigno.inmailmanager.model.INLocalizedMailing object) {
    excludeObjectFromPropertyWithKey(object, _INMailing.LOCALIZED_MAILINGS_KEY);
  }

  public void addToLocalizedMailingsRelationship(com.insigno.inmailmanager.model.INLocalizedMailing object) {
    if (_INMailing.LOG.isDebugEnabled()) {
      _INMailing.LOG.debug("adding " + object + " to localizedMailings relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToLocalizedMailings(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _INMailing.LOCALIZED_MAILINGS_KEY);
    }
  }

  public void removeFromLocalizedMailingsRelationship(com.insigno.inmailmanager.model.INLocalizedMailing object) {
    if (_INMailing.LOG.isDebugEnabled()) {
      _INMailing.LOG.debug("removing " + object + " from localizedMailings relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromLocalizedMailings(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailing.LOCALIZED_MAILINGS_KEY);
    }
  }

  public com.insigno.inmailmanager.model.INLocalizedMailing createLocalizedMailingsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.insigno.inmailmanager.model.INLocalizedMailing.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _INMailing.LOCALIZED_MAILINGS_KEY);
    return (com.insigno.inmailmanager.model.INLocalizedMailing) eo;
  }

  public void deleteLocalizedMailingsRelationship(com.insigno.inmailmanager.model.INLocalizedMailing object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _INMailing.LOCALIZED_MAILINGS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllLocalizedMailingsRelationships() {
    Enumeration<com.insigno.inmailmanager.model.INLocalizedMailing> objects = localizedMailings().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteLocalizedMailingsRelationship(objects.nextElement());
    }
  }


  public static INMailing createINMailing(EOEditingContext editingContext, NSTimestamp creationDate
, NSTimestamp modificationDate
, String title
) {
    INMailing eo = (INMailing) EOUtilities.createAndInsertInstance(editingContext, _INMailing.ENTITY_NAME);    
		eo.setCreationDate(creationDate);
		eo.setModificationDate(modificationDate);
		eo.setTitle(title);
    return eo;
  }

  public static ERXFetchSpecification<INMailing> fetchSpec() {
    return new ERXFetchSpecification<INMailing>(_INMailing.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INMailing> fetchAllINMailings(EOEditingContext editingContext) {
    return _INMailing.fetchAllINMailings(editingContext, null);
  }

  public static NSArray<INMailing> fetchAllINMailings(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INMailing.fetchINMailings(editingContext, null, sortOrderings);
  }

  public static NSArray<INMailing> fetchINMailings(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INMailing> fetchSpec = new ERXFetchSpecification<INMailing>(_INMailing.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INMailing> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INMailing fetchINMailing(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailing.fetchINMailing(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailing fetchINMailing(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INMailing> eoObjects = _INMailing.fetchINMailings(editingContext, qualifier, null);
    INMailing eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INMailing that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailing fetchRequiredINMailing(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailing.fetchRequiredINMailing(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailing fetchRequiredINMailing(EOEditingContext editingContext, EOQualifier qualifier) {
    INMailing eoObject = _INMailing.fetchINMailing(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INMailing that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailing localInstanceIn(EOEditingContext editingContext, INMailing eo) {
    INMailing localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
