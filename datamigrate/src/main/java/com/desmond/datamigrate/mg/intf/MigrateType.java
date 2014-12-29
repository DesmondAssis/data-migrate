package com.desmond.datamigrate.mg.intf;


import com.desmond.servicebuilder.model.base.intf.BaseModel;

public interface MigrateType extends BaseModel{
		public int getMigrateTypeId();
	public void setMigrateTypeId(int migrateTypeId);
	public String getName();
	public void setName(String name);

}
