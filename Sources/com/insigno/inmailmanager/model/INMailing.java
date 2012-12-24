package com.insigno.inmailmanager.model;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class INMailing extends _INMailing {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(INMailing.class);
	
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		
		this.setCreationDate(new NSTimestamp());
		this.setTitle("Title");
		this.setModificationDate(new NSTimestamp());
		
	}
	
	
	@Override
	public void validateForSave() throws ValidationException {
		super.validateForSave();
		this.setModificationDate(new NSTimestamp());
	}
	
}
