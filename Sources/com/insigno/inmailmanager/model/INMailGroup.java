package com.insigno.inmailmanager.model;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class INMailGroup extends _INMailGroup {
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(INMailGroup.class);
	
	
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		
		this.setCreationDate(new NSTimestamp());
		this.setModificationDate(new NSTimestamp());
	}
	
	public boolean isProtected() {
		return false;
	}
	
	public boolean isEmpty() {
		return this.recipients()==null || this.recipients().count() == 0;
	}
	
}
