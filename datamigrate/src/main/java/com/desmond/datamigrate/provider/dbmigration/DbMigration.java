package com.desmond.datamigrate.provider.dbmigration;

import com.desmond.datamigrate.ge.mg.intf.MigrateEntry;
import com.desmond.datamigrate.intf.TaskRunner;

public class DbMigration {
	
	private static DbMigration _instance = new DbMigration();
	
	public static DbMigration getInstance() {
		return _instance;
	}
	
	public void migrate(Object source, MigrateEntry etnry, TaskRunner tasker) throws Exception {
		
	}
}
