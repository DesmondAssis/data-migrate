package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateServer extends BaseModel{
		public long getServerId();
	public void setServerId(long serverId);
	public String getName();
	public void setName(String name);
	public int getWorkerCount();
	public void setWorkerCount(int workerCount);
	public boolean getEnabled();
	public void setEnabled(boolean enabled);

}
