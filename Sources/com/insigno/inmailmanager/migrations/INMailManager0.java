package com.insigno.inmailmanager.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.jdbc.ERXSQLHelper.ColumnIndex;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationIndex;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class INMailManager0 extends ERXMigrationDatabase.Migration {
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
		ERXMigrationTable inLocalizedMailTemplateTable = database.newTableNamed("INLocalizedMailTemplate");
		inLocalizedMailTemplateTable.newStringColumn("bg_letter", 255, false);
		inLocalizedMailTemplateTable.newStringColumn("bg_pattern", 255, false);
		inLocalizedMailTemplateTable.newStringColumn("bottom", 255, false);
		inLocalizedMailTemplateTable.newTimestampColumn("creationDate", false);
		inLocalizedMailTemplateTable.newIntegerColumn("id", false);
		inLocalizedMailTemplateTable.newIntegerColumn("inMailTemplateID", false);
		inLocalizedMailTemplateTable.newStringColumn("language", 100, false);
		inLocalizedMailTemplateTable.newTimestampColumn("modificationDate", false);
		inLocalizedMailTemplateTable.newStringColumn("splash", 255, false);
		inLocalizedMailTemplateTable.newStringColumn("stylesheet", 10000000, false);
		inLocalizedMailTemplateTable.newStringColumn("top", 255, false);
		inLocalizedMailTemplateTable.create();
	 	inLocalizedMailTemplateTable.setPrimaryKey("id");

		ERXMigrationTable inMailTemplateTable = database.newTableNamed("INMailTemplate");
		inMailTemplateTable.newTimestampColumn("creationDate", false);
		inMailTemplateTable.newIntegerColumn("id", false);
		inMailTemplateTable.newTimestampColumn("modificationDate", false);
		inMailTemplateTable.newStringColumn("name", 100, false);
		inMailTemplateTable.create();
	 	inMailTemplateTable.setPrimaryKey("id");

		inLocalizedMailTemplateTable.addForeignKey("inMailTemplateID", "INMailTemplate", "id");
	}
}