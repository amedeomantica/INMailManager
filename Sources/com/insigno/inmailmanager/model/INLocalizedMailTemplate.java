package com.insigno.inmailmanager.model;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class INLocalizedMailTemplate extends _INLocalizedMailTemplate {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(INLocalizedMailTemplate.class);
	
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		this.setCreationDate(new NSTimestamp());
		this.setModificationDate(new NSTimestamp());
	}
	
}
