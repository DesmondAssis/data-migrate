package com.desmond.datamigrate.mg.impl;

import com.desmond.datamigrate.mg.intf.MigrateType;

public abstract class MigrateTypeServiceBaseImpl {
	public int add(MigrateType migrateType) {
		return getDao().add(migrateType);
	}
	
	public int update(MigrateType migrateType) {
		return getDao().update(migrateType);
	}
	
	public MigrateType fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateTypeDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateTypeDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateTypeDaoImpl dao;
}
