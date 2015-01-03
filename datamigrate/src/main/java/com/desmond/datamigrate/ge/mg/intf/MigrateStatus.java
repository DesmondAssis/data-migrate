package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateStatus extends BaseModel{
		public int getMigrateStatusId();
	public void setMigrateStatusId(int migrateStatusId);
	public String getName();
	public void setName(String name);

}
