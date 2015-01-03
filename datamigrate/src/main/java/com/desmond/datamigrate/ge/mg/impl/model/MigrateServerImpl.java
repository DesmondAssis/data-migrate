package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateServer;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateServerImpl extends BaseModelImpl implements MigrateServer{
		private long serverId;
	private String name;
	private int workerCount;
	private boolean enabled;

		public long getServerId() {		return serverId;	}
	public void setServerId(long serverId) {		this.serverId = serverId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public int getWorkerCount() {		return workerCount;	}
	public void setWorkerCount(int workerCount) {		this.workerCount = workerCount;	}
	public boolean getEnabled() {		return enabled;	}
	public void setEnabled(boolean enabled) {		this.enabled = enabled;	}

	
	public MigrateServer mockMigrateServerImpl() {
		MigrateServer migrateserver = new MigrateServerImpl();
				migrateserver.setServerId(21l);		migrateserver.setName("Name" + Math.round(100000000));		migrateserver.setWorkerCount(Math.round(100));		migrateserver.setEnabled(false);
		
		return migrateserver;
	}
}
