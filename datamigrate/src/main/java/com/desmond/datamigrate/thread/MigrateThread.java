package com.desmond.datamigrate.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateServerDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTaskDaoImpl;
import com.desmond.datamigrate.ge.mg.intf.MigrateServer;
import com.desmond.datamigrate.ge.mg.intf.MigrateTask;
import com.desmond.datamigrate.util.MigrationTaskUtil;

public class MigrateThread extends Thread{
	protected static String server;
	
	protected boolean stopPolling = false;
	protected boolean stopThread = false;
	
	ThreadPoolExecutor executor;
	
	// poll for server configuration changes every 2 minutes
	protected long serverConfigPollInterval = 2*60*1000;
	long lastConfigCheck = 0L;
	
	public MigrateThread() {
		setName("Migrate");
		try {
			server = MigrationTaskUtil.getLocalIpAddress();
			
			MigrateServer migrateServer = new MigrateServerDaoImpl().fetchByPrimaryKey(1);
			
			executor = new ThreadPoolExecutor(migrateServer.getWorkerCount(),
					migrateServer.getWorkerCount(), 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
			
			stopPolling(migrateServer.getEnabled());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isStopPolling() {
		return stopPolling;
	}
	
	public void stopPolling(boolean stopPolling) {
		this.stopPolling = stopPolling;
	}
	
	public void stopThread() {
		stopThread = true;
	}
	
	public int getWorkerCount() {
		return executor.getMaximumPoolSize();
	}
	
	public void setWorkerCount(int workerCount) {
		executor.setCorePoolSize(workerCount);
		executor.setMaximumPoolSize(workerCount);
	}
	
	public void checkServerConfigurationChange() {
		MigrateServer migrateServer = new MigrateServerDaoImpl().fetchByPrimaryKey(1);
		
		if(migrateServer.getWorkerCount() != getWorkerCount()) {
			setWorkerCount(migrateServer.getWorkerCount());
		}
		
		if(migrateServer.getEnabled() != !isStopPolling()) {
			stopPolling(!migrateServer.getEnabled());
		}
	}
	
	public void run() {
		for(;;) {
			if(stopThread) {
				break;
			}
			
			if(!stopPolling) {
				if(executor.getActiveCount() >= 1 && System.currentTimeMillis() - lastConfigCheck >= serverConfigPollInterval) {
					checkServerConfigurationChange();
				}
				
				MigrateTask task = null;
				
				if(executor.getActiveCount() < executor.getMaximumPoolSize()) {
				}
			}
		}
	}
}
