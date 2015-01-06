package com.desmond.datamigrate.provider.dbmigration;

import com.desmond.datamigrate.ge.mg.intf.MigrateTask;
import com.desmond.datamigrate.intf.BatchCreator;
import com.desmond.datamigrate.intf.MigrateObjectFactory;
import com.desmond.datamigrate.intf.TaskRunner;

public class DbmigrationMigrateObjectFactory implements MigrateObjectFactory {
	
	long providerId;
	
	public void init(long migrateProviderId) throws Exception {
		this.providerId = migrateProviderId;
	}

	public BatchCreator getBatchCreator() {
		return new DbmigrationBatchCreator(providerId);
	}

	public TaskRunner getTaskRunner(MigrateTask task) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
