package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateStatusDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateStatus;

public abstract class MigrateStatusServiceBaseImpl {
	public int add(MigrateStatus migrateStatus) {
		return getDao().add(migrateStatus);
	}
	
	public int update(MigrateStatus migrateStatus) {
		return getDao().update(migrateStatus);
	}
	
	public MigrateStatus fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateStatusDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateStatusDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateStatusDaoImpl dao;
}
