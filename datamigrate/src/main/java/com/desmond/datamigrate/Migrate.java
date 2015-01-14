package com.desmond.datamigrate;

import com.desmond.datamigrate.enums.MigrateStatusEnum;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateBatchDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateProviderDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateBatchLocalServiceImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateProviderLocalServiceImpl;
import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;
import com.desmond.datamigrate.ge.mg.intf.MigrateProvider;
import com.desmond.datamigrate.intf.BatchCreator;
import com.desmond.datamigrate.intf.MigrateObjectFactory;

public class Migrate {

	public void migrate() {
		long privoderId = 1;
		int maxTasks = 2;
		String server = "127.0.0.1";
		boolean enqueue = true;
		boolean returnFailed = false;
		boolean createNewIfExists = false;
		String note = "";
		String userName = "Desmond";
		
		
		MigrateProviderDaoImpl providerDao = new MigrateProviderDaoImpl();
		MigrateBatchDaoImpl batchDao = new MigrateBatchDaoImpl();

		MigrateProviderLocalServiceImpl providerService = new MigrateProviderLocalServiceImpl();
		MigrateBatchLocalServiceImpl batchService = new MigrateBatchLocalServiceImpl();
		
		providerService.setDao(providerDao);
		batchService.setDao(batchDao);
		try {
			MigrateObjectFactory objectFactory = providerService.getMigrateObjectFactory(privoderId);
			BatchCreator batchCreator = objectFactory.getBatchCreator();
			
			MigrateBatch batch = batchCreator.createBatch(maxTasks, server, enqueue, returnFailed,
					createNewIfExists, note, userName, privoderId);
			
			// no task, then nothing to do.
			if(batch.getTotalCount() == 0) {
				batchService.setStatus(batch.getMigrateBatchId(), MigrateStatusEnum.COMPLETED.getId(), userName, true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

























