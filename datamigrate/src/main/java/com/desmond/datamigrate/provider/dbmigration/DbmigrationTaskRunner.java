package com.desmond.datamigrate.provider.dbmigration;

import com.desmond.datamigrate.TaskRunnerBase;
import com.desmond.datamigrate.ge.mg.intf.MigrateEntry;
import com.desmond.datamigrate.ge.mg.intf.MigrateTask;
import com.desmond.datamigrate.intf.TaskRunner;

public class DbmigrationTaskRunner extends TaskRunnerBase implements TaskRunner {

	public DbmigrationTaskRunner(MigrateTask task, MigrateEntry entry) {
		super(task, entry);
	}

	public void migrate() throws Exception {
		DbMigration.getInstance().migrate(null, this.getMigrateEntryPK(), this);;
	}

}
