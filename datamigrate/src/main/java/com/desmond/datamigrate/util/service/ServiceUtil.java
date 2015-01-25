package com.desmond.datamigrate.util.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateBatchDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateStatusDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTaskDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateBatchLocalServiceImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateStatusLocalServiceImpl;
import com.desmond.datamigrate.ge.mg.impl.service.MigrateTaskLocalServiceImpl;

public class ServiceUtil {
	private static MigrateBatchLocalServiceImpl batchService = null;
	private static MigrateTaskLocalServiceImpl taskService = null;
	private static MigrateStatusLocalServiceImpl statusService = null;
	
	static {
		// batch
		MigrateBatchDaoImpl batchDao = new MigrateBatchDaoImpl();
		batchService = new MigrateBatchLocalServiceImpl();
		batchService.setDao(batchDao);
		
		// task
		MigrateTaskDaoImpl taskDao = new MigrateTaskDaoImpl();
		taskService = new MigrateTaskLocalServiceImpl();
		taskService.setDao(taskDao);
		
		// task
		MigrateStatusDaoImpl statusDao = new MigrateStatusDaoImpl();
		statusService = new MigrateStatusLocalServiceImpl();
		statusService.setDao(statusDao);
	}
	
	public static MigrateBatchLocalServiceImpl getBatchService() {
		return batchService;
	}
	
	public static MigrateTaskLocalServiceImpl getTaskService() {
		return taskService;
	}
	
	public static MigrateStatusLocalServiceImpl getStatusService() {
		return statusService;
	}
}
