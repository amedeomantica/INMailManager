package com.insigno.inmailmanager;

import java.util.Locale;

import com.webobjects.foundation.NSTimestamp;

public interface INMailableElement {
	
	public NSTimestamp elementDate();
	public String titleForLanguage(Locale locale);
	public String absractForLanguage(Locale locale);
	public String bodyForLanguage(Locale locale);

}
