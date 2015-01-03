package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateProvider;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateProviderImpl extends BaseModelImpl implements MigrateProvider{
		private long migrateProviderId;
	private String name;
	private String description;
	private String factoryClass;
	private String parameters;
	private String createdBy;
	private String modifiedBy;

		public long getMigrateProviderId() {		return migrateProviderId;	}
	public void setMigrateProviderId(long migrateProviderId) {		this.migrateProviderId = migrateProviderId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getDescription() {		return description;	}
	public void setDescription(String description) {		this.description = description;	}
	public String getFactoryClass() {		return factoryClass;	}
	public void setFactoryClass(String factoryClass) {		this.factoryClass = factoryClass;	}
	public String getParameters() {		return parameters;	}
	public void setParameters(String parameters) {		this.parameters = parameters;	}
	public String getCreatedBy() {		return createdBy;	}
	public void setCreatedBy(String createdBy) {		this.createdBy = createdBy;	}
	public String getModifiedBy() {		return modifiedBy;	}
	public void setModifiedBy(String modifiedBy) {		this.modifiedBy = modifiedBy;	}

	
	public MigrateProvider mockMigrateProviderImpl() {
		MigrateProvider migrateprovider = new MigrateProviderImpl();
				migrateprovider.setMigrateProviderId(Math.round(10000));		migrateprovider.setName("Name" + Math.round(100000000));		migrateprovider.setDescription("Description" + Math.round(100000000));		migrateprovider.setFactoryClass("FactoryClass" + Math.round(100000000));		migrateprovider.setParameters("Parameters" + Math.round(100000000));		migrateprovider.setCreatedBy("CreatedBy" + Math.round(100000000));		migrateprovider.setModifiedBy("ModifiedBy" + Math.round(100000000));
		
		return migrateprovider;
	}
}
