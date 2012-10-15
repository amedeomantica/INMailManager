package com.insigno.inmailmanager.model;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class INMailRecipient extends _INMailRecipient {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(INMailRecipient.class);
	
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		
		this.setCreationDate(new NSTimestamp());
		this.setModificationDate(new NSTimestamp());
	}
	
}
