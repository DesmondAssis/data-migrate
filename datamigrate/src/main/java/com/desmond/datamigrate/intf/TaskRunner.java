package com.desmond.datamigrate.intf;

import com.desmond.datamigrate.ge.mg.intf.MigrateEntry;
import com.desmond.datamigrate.ge.mg.intf.MigrateTask;

public interface TaskRunner {
	public MigrateTask getMigrateTask();
	public void setMigrateTask(MigrateTask task);
	public MigrateEntry getMigrateEntryPK();
	
	
	public void migrate() throws Exception;
}
