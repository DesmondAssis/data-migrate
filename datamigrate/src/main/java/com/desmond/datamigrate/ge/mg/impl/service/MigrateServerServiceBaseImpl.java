package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateServerDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateServer;

public abstract class MigrateServerServiceBaseImpl {
	public int add(MigrateServer migrateServer) {
		return getDao().add(migrateServer);
	}
	
	public int update(MigrateServer migrateServer) {
		return getDao().update(migrateServer);
	}
	
	public MigrateServer fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateServerDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateServerDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateServerDaoImpl dao;
}
