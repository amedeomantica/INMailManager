package com.insigno.inmailmanager;

import com.webobjects.foundation.NSLog;

public class INMailManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3261226856686564632L;

	public INMailManagerException(String message) {
		super(message);
		System.out.println(message);
	}
	
}
