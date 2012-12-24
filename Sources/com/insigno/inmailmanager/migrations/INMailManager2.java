package com.insigno.inmailmanager.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class INMailManager2 extends ERXMigrationDatabase.Migration {
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
		

		ERXMigrationTable inLocalizedMailingTable = database.newTableNamed("INLocalizedMailing");
		inLocalizedMailingTable.newTimestampColumn("creationDate", false);
		inLocalizedMailingTable.newIntegerColumn("id", false);
		inLocalizedMailingTable.newIntegerColumn("inMailingID", false);
		inLocalizedMailingTable.newStringColumn("language", 10, false);
		inLocalizedMailingTable.newStringColumn("mailBody", 10000000, false);
		inLocalizedMailingTable.newTimestampColumn("modificationDate", false);
		inLocalizedMailingTable.newStringColumn("subject", 255, false);
		inLocalizedMailingTable.create();
	 	inLocalizedMailingTable.setPrimaryKey("id");

		ERXMigrationTable inMailMessageTable = database.newTableNamed("INMailMessage");
		inMailMessageTable.newTimestampColumn("creationDate", false);
		inMailMessageTable.newBooleanColumn("didBounce", false);
		inMailMessageTable.newIntegerColumn("id", false);
		inMailMessageTable.newIntegerColumn("inMailingID", false);
		inMailMessageTable.newIntegerColumn("inMailRecipientID", false);
		inMailMessageTable.newStringColumn("language", 10, false);
		inMailMessageTable.newStringColumn("mailBody", 10000000, false);
		inMailMessageTable.newTimestampColumn("modificationDate", false);
		inMailMessageTable.newTimestampColumn("readDate", true);
		inMailMessageTable.newStringColumn("recipientAddress", 255, false);
		inMailMessageTable.newTimestampColumn("sendDate", true);
		inMailMessageTable.newStringColumn("subject", 255, false);
		inMailMessageTable.create();
	 	inMailMessageTable.setPrimaryKey("id");

		ERXMigrationTable inMailingTable = database.newTableNamed("INMailing");
		inMailingTable.newTimestampColumn("creationDate", false);
		inMailingTable.newIntegerColumn("id", false);
		inMailingTable.newStringColumn("mailingDescription", 255, true);
		inMailingTable.newTimestampColumn("modificationDate", false);
		inMailingTable.newStringColumn("ownerEntityName", 255, true);
		inMailingTable.newIntegerColumn("ownerPrimaryKey", true);
		inMailingTable.newStringColumn("title", 255, false);
		inMailingTable.create();
	 	inMailingTable.setPrimaryKey("id");

		inLocalizedMailingTable.addForeignKey("inMailingID", "INMailing", "id");
		inMailMessageTable.addForeignKey("inMailingID", "INMailing", "id");
		inMailMessageTable.addForeignKey("inMailRecipientID", "INMailRecipient", "id");
	}
}