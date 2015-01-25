package com.desmond.datamigrate.util.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateBatchDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTaskDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateBatchLocalServiceImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateTaskLocalServiceImpl;

public class ServiceUtil {
	private static MigrateBatchLocalServiceImpl batchService = null;
	private static MigrateTaskLocalServiceImpl taskService = null;
	
	static {
		// batch
		MigrateBatchDaoImpl batchDao = new MigrateBatchDaoImpl();
		batchService = new MigrateBatchLocalServiceImpl();
		batchService.setDao(batchDao);
		
		// task
		MigrateTaskDaoImpl taskDao = new MigrateTaskDaoImpl();
		taskService = new MigrateTaskLocalServiceImpl();
		taskService.setDao(taskDao);
	}
	
	public static MigrateBatchLocalServiceImpl getBatchService() {
		return batchService;
	}
	
	public static MigrateTaskLocalServiceImpl getTaskService() {
		return taskService;
	}
}
