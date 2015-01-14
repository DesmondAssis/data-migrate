package com.desmond.datamigrate.intf;

import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;

public interface BatchCreator {
	MigrateBatch createBatch(int maxTasks, String server, boolean enqueue, boolean returnFailed, boolean createNewIfExists, String note, String userName, long migrateProviderId) throws Exception;
}
