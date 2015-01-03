package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateProvider extends BaseModel{
		public long getMigrateProviderId();
	public void setMigrateProviderId(long migrateProviderId);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
	public String getFactoryClass();
	public void setFactoryClass(String factoryClass);
	public String getParameters();
	public void setParameters(String parameters);
	public String getCreatedBy();
	public void setCreatedBy(String createdBy);
	public String getModifiedBy();
	public void setModifiedBy(String modifiedBy);

}
