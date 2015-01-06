package com.desmond.datamigrate.intf;

import com.desmond.datamigrate.ge.mg.intf.MigrateTask;

public interface MigrateObjectFactory {
	
	void init(long migrateProviderId) throws Exception;
	
	BatchCreator getBatchCreator();
	
	TaskRunner getTaskRunner(MigrateTask task) throws Exception;
}
