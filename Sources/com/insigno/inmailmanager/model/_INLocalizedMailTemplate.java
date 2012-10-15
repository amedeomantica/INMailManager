// DO NOT EDIT.  Make changes to INLocalizedMailTemplate.java instead.
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
public abstract class _INLocalizedMailTemplate extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "INLocalizedMailTemplate";

  // Attribute Keys
  public static final ERXKey<String> BG_LETTER = new ERXKey<String>("bg_letter");
  public static final ERXKey<String> BG_PATTERN = new ERXKey<String>("bg_pattern");
  public static final ERXKey<String> BOTTOM = new ERXKey<String>("bottom");
  public static final ERXKey<NSTimestamp> CREATION_DATE = new ERXKey<NSTimestamp>("creationDate");
  public static final ERXKey<String> LANGUAGE = new ERXKey<String>("language");
  public static final ERXKey<NSTimestamp> MODIFICATION_DATE = new ERXKey<NSTimestamp>("modificationDate");
  public static final ERXKey<String> SPLASH = new ERXKey<String>("splash");
  public static final ERXKey<String> STYLESHEET = new ERXKey<String>("stylesheet");
  public static final ERXKey<String> TOP = new ERXKey<String>("top");
  // Relationship Keys
  public static final ERXKey<com.insigno.inmailmanager.model.INMailTemplate> TEMPLATE = new ERXKey<com.insigno.inmailmanager.model.INMailTemplate>("template");

  // Attributes
  public static final String BG_LETTER_KEY = BG_LETTER.key();
  public static final String BG_PATTERN_KEY = BG_PATTERN.key();
  public static final String BOTTOM_KEY = BOTTOM.key();
  public static final String CREATION_DATE_KEY = CREATION_DATE.key();
  public static final String LANGUAGE_KEY = LANGUAGE.key();
  public static final String MODIFICATION_DATE_KEY = MODIFICATION_DATE.key();
  public static final String SPLASH_KEY = SPLASH.key();
  public static final String STYLESHEET_KEY = STYLESHEET.key();
  public static final String TOP_KEY = TOP.key();
  // Relationships
  public static final String TEMPLATE_KEY = TEMPLATE.key();

  private static Logger LOG = Logger.getLogger(_INLocalizedMailTemplate.class);

  public INLocalizedMailTemplate localInstanceIn(EOEditingContext editingContext) {
    INLocalizedMailTemplate localInstance = (INLocalizedMailTemplate)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String bg_letter() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.BG_LETTER_KEY);
  }

  public void setBg_letter(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating bg_letter from " + bg_letter() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.BG_LETTER_KEY);
  }

  public String bg_pattern() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.BG_PATTERN_KEY);
  }

  public void setBg_pattern(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating bg_pattern from " + bg_pattern() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.BG_PATTERN_KEY);
  }

  public String bottom() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.BOTTOM_KEY);
  }

  public void setBottom(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating bottom from " + bottom() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.BOTTOM_KEY);
  }

  public NSTimestamp creationDate() {
    return (NSTimestamp) storedValueForKey(_INLocalizedMailTemplate.CREATION_DATE_KEY);
  }

  public void setCreationDate(NSTimestamp value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating creationDate from " + creationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.CREATION_DATE_KEY);
  }

  public String language() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.LANGUAGE_KEY);
  }

  public void setLanguage(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating language from " + language() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.LANGUAGE_KEY);
  }

  public NSTimestamp modificationDate() {
    return (NSTimestamp) storedValueForKey(_INLocalizedMailTemplate.MODIFICATION_DATE_KEY);
  }

  public void setModificationDate(NSTimestamp value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating modificationDate from " + modificationDate() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.MODIFICATION_DATE_KEY);
  }

  public String splash() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.SPLASH_KEY);
  }

  public void setSplash(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating splash from " + splash() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.SPLASH_KEY);
  }

  public String stylesheet() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.STYLESHEET_KEY);
  }

  public void setStylesheet(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating stylesheet from " + stylesheet() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.STYLESHEET_KEY);
  }

  public String top() {
    return (String) storedValueForKey(_INLocalizedMailTemplate.TOP_KEY);
  }

  public void setTop(String value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
    	_INLocalizedMailTemplate.LOG.debug( "updating top from " + top() + " to " + value);
    }
    takeStoredValueForKey(value, _INLocalizedMailTemplate.TOP_KEY);
  }

  public com.insigno.inmailmanager.model.INMailTemplate template() {
    return (com.insigno.inmailmanager.model.INMailTemplate)storedValueForKey(_INLocalizedMailTemplate.TEMPLATE_KEY);
  }
  
  public void setTemplate(com.insigno.inmailmanager.model.INMailTemplate value) {
    takeStoredValueForKey(value, _INLocalizedMailTemplate.TEMPLATE_KEY);
  }

  public void setTemplateRelationship(com.insigno.inmailmanager.model.INMailTemplate value) {
    if (_INLocalizedMailTemplate.LOG.isDebugEnabled()) {
      _INLocalizedMailTemplate.LOG.debug("updating template from " + template() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setTemplate(value);
    }
    else if (value == null) {
    	com.insigno.inmailmanager.model.INMailTemplate oldValue = template();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _INLocalizedMailTemplate.TEMPLATE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _INLocalizedMailTemplate.TEMPLATE_KEY);
    }
  }
  

  public static INLocalizedMailTemplate createINLocalizedMailTemplate(EOEditingContext editingContext, String bg_letter
, String bg_pattern
, String bottom
, NSTimestamp creationDate
, String language
, NSTimestamp modificationDate
, String splash
, String stylesheet
, String top
, com.insigno.inmailmanager.model.INMailTemplate template) {
    INLocalizedMailTemplate eo = (INLocalizedMailTemplate) EOUtilities.createAndInsertInstance(editingContext, _INLocalizedMailTemplate.ENTITY_NAME);    
		eo.setBg_letter(bg_letter);
		eo.setBg_pattern(bg_pattern);
		eo.setBottom(bottom);
		eo.setCreationDate(creationDate);
		eo.setLanguage(language);
		eo.setModificationDate(modificationDate);
		eo.setSplash(splash);
		eo.setStylesheet(stylesheet);
		eo.setTop(top);
    eo.setTemplateRelationship(template);
    return eo;
  }

  public static ERXFetchSpecification<INLocalizedMailTemplate> fetchSpec() {
    return new ERXFetchSpecification<INLocalizedMailTemplate>(_INLocalizedMailTemplate.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<INLocalizedMailTemplate> fetchAllINLocalizedMailTemplates(EOEditingContext editingContext) {
    return _INLocalizedMailTemplate.fetchAllINLocalizedMailTemplates(editingContext, null);
  }

  public static NSArray<INLocalizedMailTemplate> fetchAllINLocalizedMailTemplates(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _INLocalizedMailTemplate.fetchINLocalizedMailTemplates(editingContext, null, sortOrderings);
  }

  public static NSArray<INLocalizedMailTemplate> fetchINLocalizedMailTemplates(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<INLocalizedMailTemplate> fetchSpec = new ERXFetchSpecification<INLocalizedMailTemplate>(_INLocalizedMailTemplate.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<INLocalizedMailTemplate> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static INLocalizedMailTemplate fetchINLocalizedMailTemplate(EOEditingContext editingContext, String keyName, Object value) {
    return _INLocalizedMailTemplate.fetchINLocalizedMailTemplate(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INLocalizedMailTemplate fetchINLocalizedMailTemplate(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<INLocalizedMailTemplate> eoObjects = _INLocalizedMailTemplate.fetchINLocalizedMailTemplates(editingContext, qualifier, null);
    INLocalizedMailTemplate eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one INLocalizedMailTemplate that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INLocalizedMailTemplate fetchRequiredINLocalizedMailTemplate(EOEditingContext editingContext, String keyName, Object value) {
    return _INLocalizedMailTemplate.fetchRequiredINLocalizedMailTemplate(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static INLocalizedMailTemplate fetchRequiredINLocalizedMailTemplate(EOEditingContext editingContext, EOQualifier qualifier) {
    INLocalizedMailTemplate eoObject = _INLocalizedMailTemplate.fetchINLocalizedMailTemplate(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no INLocalizedMailTemplate that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static INLocalizedMailTemplate localInstanceIn(EOEditingContext editingContext, INLocalizedMailTemplate eo) {
    INLocalizedMailTemplate localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
