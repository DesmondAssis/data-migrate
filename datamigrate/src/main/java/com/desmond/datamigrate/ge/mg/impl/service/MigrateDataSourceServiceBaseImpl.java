package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateDataSourceDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateDataSource;

public abstract class MigrateDataSourceServiceBaseImpl {
	public int add(MigrateDataSource migrateDataSource) {
		return getDao().add(migrateDataSource);
	}
	
	public int update(MigrateDataSource migrateDataSource) {
		return getDao().update(migrateDataSource);
	}
	
	public MigrateDataSource fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateDataSourceDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateDataSourceDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateDataSourceDaoImpl dao;
}
