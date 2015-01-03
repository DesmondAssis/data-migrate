package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateType extends BaseModel{
		public long getMigrateTypeId();
	public void setMigrateTypeId(long migrateTypeId);
	public String getName();
	public void setName(String name);

}
