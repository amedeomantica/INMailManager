package com.insigno.inmailmanager.model;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class INLocalizedMailing extends _INLocalizedMailing {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(INLocalizedMailing.class);
	
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		
		this.setCreationDate(new NSTimestamp());
		this.setModificationDate(new NSTimestamp());
		
		this.setLanguage("English");
		
		this.setSubject("Subject");
		this.setMailBody("Body");
		
	}
	
	@Override
	public void validateForSave() throws ValidationException {
		super.validateForSave();
		this.setModificationDate(new NSTimestamp());
	}
	
}
