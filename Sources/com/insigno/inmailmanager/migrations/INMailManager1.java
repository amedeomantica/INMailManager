package com.insigno.inmailmanager.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class INMailManager1 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		ERXMigrationTable inMailGroupTable = database.newTableNamed("INMailGroup");
		inMailGroupTable.newTimestampColumn("creationDate", false);
		inMailGroupTable.newIntegerColumn("id", false);
		inMailGroupTable.newTimestampColumn("modificationDate", false);
		inMailGroupTable.newStringColumn("name", 255, false);
		inMailGroupTable.create();
	 	inMailGroupTable.setPrimaryKey("id");

		ERXMigrationTable inMailGroupINMailRecipientTable = database.newTableNamed("INMailGroupINMailRecipient");
		inMailGroupINMailRecipientTable.newIntegerColumn("inMailGroupId", false);
		inMailGroupINMailRecipientTable.newIntegerColumn("inMailRecipientId", false);
		inMailGroupINMailRecipientTable.create();
	 	inMailGroupINMailRecipientTable.setPrimaryKey("inMailGroupId", "inMailRecipientId");

		ERXMigrationTable inMailRecipientTable = database.newTableNamed("INMailRecipient");
		inMailRecipientTable.newTimestampColumn("creationDate", false);
		inMailRecipientTable.newTimestampColumn("dateLastSeen", true);
		inMailRecipientTable.newStringColumn("email", 255, false);
		inMailRecipientTable.newIntegerColumn("id", false);
		inMailRecipientTable.newTimestampColumn("modificationDate", false);
		inMailRecipientTable.newStringColumn("ownerEntityName", 100, true);
		inMailRecipientTable.newIntegerColumn("ownerPrimaryKey", true);
		inMailRecipientTable.newStringColumn("preferredLanguage", 10, true);
		inMailRecipientTable.create();
	 	inMailRecipientTable.setPrimaryKey("id");

		inMailGroupINMailRecipientTable.addForeignKey("inMailGroupId", "INMailGroup", "id");
		inMailGroupINMailRecipientTable.addForeignKey("inMailRecipientId", "INMailRecipient", "id");
	}
}