package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateProviderDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateProvider;

public abstract class MigrateProviderServiceBaseImpl {
	public int add(MigrateProvider migrateProvider) {
		return getDao().add(migrateProvider);
	}
	
	public int update(MigrateProvider migrateProvider) {
		return getDao().update(migrateProvider);
	}
	
	public MigrateProvider fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateProviderDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateProviderDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateProviderDaoImpl dao;
}
