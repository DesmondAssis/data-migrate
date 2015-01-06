package com.desmond.datamigrate.provider.dbmigration;

import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;
import com.desmond.datamigrate.intf.BatchCreator;

public class DbmigrationBatchCreator implements BatchCreator {
	
	private long providerId;
	
	public DbmigrationBatchCreator(long providerId) {
		this.providerId = providerId;
	}

	public MigrateBatch createBatch(int maxTasks, long server, boolean enqueue,
			boolean returnFailed, boolean createNewIfExists, String note,
			String userName, long migrateProviderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
