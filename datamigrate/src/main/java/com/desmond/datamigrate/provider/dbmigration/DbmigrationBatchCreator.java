package com.desmond.datamigrate.provider.dbmigration;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

import com.desmond.datamigrate.QueryManager;
import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;
import com.desmond.datamigrate.intf.BatchCreator;
import com.desmond.datamigrate.util.constants.MigrationConstants;
import com.desmond.datamigrate.util.jdbc.QueryUtil;
import com.desmond.datamigrate.util.service.ServiceUtil;

public class DbmigrationBatchCreator implements BatchCreator {
	
	private long providerId;
	
	public DbmigrationBatchCreator(long providerId) {
		this.providerId = providerId;
	}

	public MigrateBatch createBatch(int maxTasks, String server,
			boolean enqueue, boolean returnFailed, boolean createNewIfExists,
			String note, String userName, long migrateProviderId)
			throws Exception {
		int groupId = 1;
		int typeId = 3;
		int batchSize = 2;
		boolean isHighestFetch = true;
		
		long startId = Long.MAX_VALUE;
		userName = StringUtils.isBlank(userName) ? "Desmond" : userName;
		
		
		Long[] minMaxArticleIds = QueryUtil.getMinMaxArticleId(migrateProviderId, groupId, typeId);
		startId = isHighestFetch ? minMaxArticleIds != null ? minMaxArticleIds[0] : Long.MAX_VALUE 
					: minMaxArticleIds != null ? minMaxArticleIds[1] : Long.MAX_VALUE;
		List<Long> entryIds = QueryManager.getBatchStories(groupId, startId, batchSize);
		AtomicInteger counter = new AtomicInteger();
		
		Properties properties = new Properties();
		properties.setProperty(MigrationConstants.LIMIT, String.valueOf(batchSize));
		properties.setProperty(MigrationConstants.CREATE_IF_EXISTS, String.valueOf(createNewIfExists));
		
		ServiceUtil.getBatchService().addMigrateBatch(migrateProviderId, groupId, server, null, properties, 0, note, userName);
		
		return null;
	}

}
