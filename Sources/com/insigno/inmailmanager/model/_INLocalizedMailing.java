// DO NOT EDIT.  Make changes to INLocalizedMailing.java instead.
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
public abstract class _INLocalizedMailing extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INLocalizedMailing";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INMailing> MAILING = new ERXKey<com.insigno.inmailmanager.model.INMailing>("mailing");
  public static final ERXKey<com.insigno.inmailmanager.model.INMailMessage> MAIL_MESSAGES = new ERXKey<com.insigno.inmailmanager.model.INMailMessage>("mailMessages");

  // Attributes
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  // Relationships
  public static final String MAILING_KEY = MAILING.key();
  public static final String MAIL_MESSAGES_KEY = MAIL_MESSAGES.key();

  private static Logger LOG = Logger.getLogger(_INLocalizedMailing.class);

  public INLocalizedMailing localInstanceIn(EOEditingContext editingContext) {
    INLocalizedMailing localInstance = (INLocalizedMailing)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INLocalizedMailing.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INLocalizedMailing.LOG.isDebugEnabled()) {
    	_INLocalizedMailing.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailing.CREATION_DATE_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INLocalizedMailing.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INLocalizedMailing.LOG.isDebugEnabled()) {
    	_INLocalizedMailing.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailing.MODIFICATION_DATE_KEY);
  }

  public com.insigno.inmailmanager.model.INMailing mailing() {
    return (com.insigno.inmailmanager.model.INMailing)storedValueForKey(_INLocalizedMailing.MAILING_KEY);
  }
  
  public void setMailing(com.insigno.inmailmanager.model.INMailing value) {
    takeStoredValueForKey(value, _INLocalizedMailing.MAILING_KEY);
  }

  public void setMailingRelationship(com.insigno.inmailmanager.model.INMailing value) {
    if (_INLocalizedMailing.LOG.isDebugEnabled()) {
      _INLocalizedMailing.LOG.debug("updating mailing from " + mailing() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setMailing(value);
    }
    else if (value == null) {
    	com.insigno.inmailmanager.model.INMailing oldValue = mailing();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _INLocalizedMailing.MAILING_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _INLocalizedMailing.MAILING_KEY);
    }
  }
  
  public NSArray<com.insigno.inmailmanager.model.INMailMessage> mailMessages() {
    return (NSArray<com.insigno.inmailmanager.model.INMailMessage>)storedValueForKey(_INLocalizedMailing.MAIL_MESSAGES_KEY);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailMessage> mailMessages(EOQualifier qualifier) {
    return mailMessages(qualifier, null, false);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailMessage> mailMessages(EOQualifier qualifier, boolean fetch) {
    return mailMessages(qualifier, null, fetch);
  }

  public NSArray<com.insigno.inmailmanager.model.INMailMessage> mailMessages(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<com.insigno.inmailmanager.model.INMailMessage> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.insigno.inmailmanager.model.INMailMessage.LOCALIZED_MAILING_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = com.insigno.inmailmanager.model.INMailMessage.fetchINMailMessages(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = mailMessages();
      if (qualifier != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INMailMessage>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.insigno.inmailmanager.model.INMailMessage>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToMailMessages(com.insigno.inmailmanager.model.INMailMessage object) {
    includeObjectIntoPropertyWithKey(object, _INLocalizedMailing.MAIL_MESSAGES_KEY);
  }

  public void removeFromMailMessages(com.insigno.inmailmanager.model.INMailMessage object) {
    excludeObjectFromPropertyWithKey(object, _INLocalizedMailing.MAIL_MESSAGES_KEY);
  }

  public void addToMailMessagesRelationship(com.insigno.inmailmanager.model.INMailMessage object) {
    if (_INLocalizedMailing.LOG.isDebugEnabled()) {
      _INLocalizedMailing.LOG.debug("adding " + object + " to mailMessages relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToMailMessages(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _INLocalizedMailing.MAIL_MESSAGES_KEY);
    }
  }

  public void removeFromMailMessagesRelationship(com.insigno.inmailmanager.model.INMailMessage object) {
    if (_INLocalizedMailing.LOG.isDebugEnabled()) {
      _INLocalizedMailing.LOG.debug("removing " + object + " from mailMessages relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromMailMessages(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _INLocalizedMailing.MAIL_MESSAGES_KEY);
    }
  }

  public com.insigno.inmailmanager.model.INMailMessage createMailMessagesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.insigno.inmailmanager.model.INMailMessage.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _INLocalizedMailing.MAIL_MESSAGES_KEY);
    return (com.insigno.inmailmanager.model.INMailMessage) eo;
  }

  public void deleteMailMessagesRelationship(com.insigno.inmailmanager.model.INMailMessage object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _INLocalizedMailing.MAIL_MESSAGES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMailMessagesRelationships() {
    Enumeration<com.insigno.inmailmanager.model.INMailMessage> objects = mailMessages().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMailMessagesRelationship(objects.nextElement());
    }
  }


  public static INLocalizedMailing createINLocalizedMailing(EOEditingContext editingContext, NSTimestamp creationDate
, NSTimestamp modificationDate
, com.insigno.inmailmanager.model.INMailing mailing) {
    INLocalizedMailing eo = (INLocalizedMailing) EOUtilities.createAndInsertInstance(editingContext, _INLocalizedMailing.ENTITY_NAME);    
		eo.setCreationDate(creationDate);
		eo.setModificationDate(modificationDate);
    eo.setMailingRelationship(mailing);
    return eo;
  }

  public static ERXFetchSpecification<INLocalizedMailing> fetchSpec() {
    return new ERXFetchSpecification<INLocalizedMailing>(_INLocalizedMailing.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INLocalizedMailing> fetchAllINLocalizedMailings(EOEditingContext editingContext) {
    return _INLocalizedMailing.fetchAllINLocalizedMailings(editingContext, null);
  }

  public static NSArray<INLocalizedMailing> fetchAllINLocalizedMailings(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INLocalizedMailing.fetchINLocalizedMailings(editingContext, null, sortOrderings);
  }

  public static NSArray<INLocalizedMailing> fetchINLocalizedMailings(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INLocalizedMailing> fetchSpec = new ERXFetchSpecification<INLocalizedMailing>(_INLocalizedMailing.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INLocalizedMailing> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INLocalizedMailing fetchINLocalizedMailing(EOEditingContext editingContext, String keyName, Object value) {
    return _INLocalizedMailing.fetchINLocalizedMailing(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INLocalizedMailing fetchINLocalizedMailing(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INLocalizedMailing> eoObjects = _INLocalizedMailing.fetchINLocalizedMailings(editingContext, qualifier, null);
    INLocalizedMailing eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INLocalizedMailing that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INLocalizedMailing fetchRequiredINLocalizedMailing(EOEditingContext editingContext, String keyName, Object value) {
    return _INLocalizedMailing.fetchRequiredINLocalizedMailing(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INLocalizedMailing fetchRequiredINLocalizedMailing(EOEditingContext editingContext, EOQualifier qualifier) {
    INLocalizedMailing eoObject = _INLocalizedMailing.fetchINLocalizedMailing(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INLocalizedMailing that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INLocalizedMailing localInstanceIn(EOEditingContext editingContext, INLocalizedMailing eo) {
    INLocalizedMailing localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
