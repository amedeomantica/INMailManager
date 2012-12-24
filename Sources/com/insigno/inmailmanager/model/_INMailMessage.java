// DO NOT EDIT.  Make changes to INMailMessage.java instead.
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
public abstract class _INMailMessage extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INMailMessage";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<Boolean> DID_BOUNCE = new ERXKey<Boolean>("didBounce");
  public static final ERXKey<String> LANGUAGE = new ERXKey<String>("language");
  public static final ERXKey<String> MAIL_BODY = new ERXKey<String>("mailBody");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<NSTimestamp> READ_DATE = new ERXKey<NSTimestamp>("readDate");
  public static final ERXKey<String> RECIPIENT_ADDRESS = new ERXKey<String>("recipientAddress");
  public static final ERXKey<NSTimestamp> SEND_DATE = new ERXKey<NSTimestamp>("sendDate");
  public static final ERXKey<String> SUBJECT = new ERXKey<String>("subject");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INMailing> MAILING = new ERXKey<com.insigno.inmailmanager.model.INMailing>("mailing");
  public static final ERXKey<com.insigno.inmailmanager.model.INMailRecipient> RECIPIENT = new ERXKey<com.insigno.inmailmanager.model.INMailRecipient>("recipient");

  // Attributes
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String DID_BOUNCE_KEY = DID_BOUNCE.key();
  public static final String LANGUAGE_KEY = LANGUAGE.key();
  public static final String MAIL_BODY_KEY = MAIL_BODY.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String READ_DATE_KEY = READ_DATE.key();
  public static final String RECIPIENT_ADDRESS_KEY = RECIPIENT_ADDRESS.key();
  public static final String SEND_DATE_KEY = SEND_DATE.key();
  public static final String SUBJECT_KEY = SUBJECT.key();
  // Relationships
  public static final String MAILING_KEY = MAILING.key();
  public static final String RECIPIENT_KEY = RECIPIENT.key();

  private static Logger LOG = Logger.getLogger(_INMailMessage.class);

  public INMailMessage localInstanceIn(EOEditingContext editingContext) {
    INMailMessage localInstance = (INMailMessage)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INMailMessage.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.CREATION_DATE_KEY);
  }

  public Boolean didBounce() {
    return (Boolean) storedValueForKey(_INMailMessage.DID_BOUNCE_KEY);
  }

  public void setDidBounce(Boolean value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating didBounce from " + didBounce() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.DID_BOUNCE_KEY);
  }

  public String language() {
    return (String) storedValueForKey(_INMailMessage.LANGUAGE_KEY);
  }

  public void setLanguage(String value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating language from " + language() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.LANGUAGE_KEY);
  }

  public String mailBody() {
    return (String) storedValueForKey(_INMailMessage.MAIL_BODY_KEY);
  }

  public void setMailBody(String value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating mailBody from " + mailBody() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.MAIL_BODY_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INMailMessage.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.MODIFICATION_DATE_KEY);
  }

  public NSTimestamp readDate() {
    return (NSTimestamp) storedValueForKey(_INMailMessage.READ_DATE_KEY);
  }

  public void setReadDate(NSTimestamp value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating readDate from " + readDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.READ_DATE_KEY);
  }

  public String recipientAddress() {
    return (String) storedValueForKey(_INMailMessage.RECIPIENT_ADDRESS_KEY);
  }

  public void setRecipientAddress(String value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating recipientAddress from " + recipientAddress() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.RECIPIENT_ADDRESS_KEY);
  }

  public NSTimestamp sendDate() {
    return (NSTimestamp) storedValueForKey(_INMailMessage.SEND_DATE_KEY);
  }

  public void setSendDate(NSTimestamp value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating sendDate from " + sendDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.SEND_DATE_KEY);
  }

  public String subject() {
    return (String) storedValueForKey(_INMailMessage.SUBJECT_KEY);
  }

  public void setSubject(String value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
    	_INMailMessage.LOG.debug( "updating subject from " + subject() + " to " + value);
    }
    takeStoredValueForKey(value, _INMailMessage.SUBJECT_KEY);
  }

  public com.insigno.inmailmanager.model.INMailing mailing() {
    return (com.insigno.inmailmanager.model.INMailing)storedValueForKey(_INMailMessage.MAILING_KEY);
  }
  
  public void setMailing(com.insigno.inmailmanager.model.INMailing value) {
    takeStoredValueForKey(value, _INMailMessage.MAILING_KEY);
  }

  public void setMailingRelationship(com.insigno.inmailmanager.model.INMailing value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
      _INMailMessage.LOG.debug("updating mailing from " + mailing() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setMailing(value);
    }
    else if (value == null) {
    	com.insigno.inmailmanager.model.INMailing oldValue = mailing();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _INMailMessage.MAILING_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _INMailMessage.MAILING_KEY);
    }
  }
  
  public com.insigno.inmailmanager.model.INMailRecipient recipient() {
    return (com.insigno.inmailmanager.model.INMailRecipient)storedValueForKey(_INMailMessage.RECIPIENT_KEY);
  }
  
  public void setRecipient(com.insigno.inmailmanager.model.INMailRecipient value) {
    takeStoredValueForKey(value, _INMailMessage.RECIPIENT_KEY);
  }

  public void setRecipientRelationship(com.insigno.inmailmanager.model.INMailRecipient value) {
    if (_INMailMessage.LOG.isDebugEnabled()) {
      _INMailMessage.LOG.debug("updating recipient from " + recipient() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setRecipient(value);
    }
    else if (value == null) {
    	com.insigno.inmailmanager.model.INMailRecipient oldValue = recipient();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _INMailMessage.RECIPIENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _INMailMessage.RECIPIENT_KEY);
    }
  }
  

  public static INMailMessage createINMailMessage(EOEditingContext editingContext, NSTimestamp creationDate
, Boolean didBounce
, String language
, String mailBody
, NSTimestamp modificationDate
, String recipientAddress
, String subject
, com.insigno.inmailmanager.model.INMailing mailing, com.insigno.inmailmanager.model.INMailRecipient recipient) {
    INMailMessage eo = (INMailMessage) EOUtilities.createAndInsertInstance(editingContext, _INMailMessage.ENTITY_NAME);    
		eo.setCreationDate(creationDate);
		eo.setDidBounce(didBounce);
		eo.setLanguage(language);
		eo.setMailBody(mailBody);
		eo.setModificationDate(modificationDate);
		eo.setRecipientAddress(recipientAddress);
		eo.setSubject(subject);
    eo.setMailingRelationship(mailing);
    eo.setRecipientRelationship(recipient);
    return eo;
  }

  public static ERXFetchSpecification<INMailMessage> fetchSpec() {
    return new ERXFetchSpecification<INMailMessage>(_INMailMessage.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INMailMessage> fetchAllINMailMessages(EOEditingContext editingContext) {
    return _INMailMessage.fetchAllINMailMessages(editingContext, null);
  }

  public static NSArray<INMailMessage> fetchAllINMailMessages(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INMailMessage.fetchINMailMessages(editingContext, null, sortOrderings);
  }

  public static NSArray<INMailMessage> fetchINMailMessages(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INMailMessage> fetchSpec = new ERXFetchSpecification<INMailMessage>(_INMailMessage.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INMailMessage> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INMailMessage fetchINMailMessage(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailMessage.fetchINMailMessage(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailMessage fetchINMailMessage(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INMailMessage> eoObjects = _INMailMessage.fetchINMailMessages(editingContext, qualifier, null);
    INMailMessage eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INMailMessage that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailMessage fetchRequiredINMailMessage(EOEditingContext editingContext, String keyName, Object value) {
    return _INMailMessage.fetchRequiredINMailMessage(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INMailMessage fetchRequiredINMailMessage(EOEditingContext editingContext, EOQualifier qualifier) {
    INMailMessage eoObject = _INMailMessage.fetchINMailMessage(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INMailMessage that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INMailMessage localInstanceIn(EOEditingContext editingContext, INMailMessage eo) {
    INMailMessage localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
