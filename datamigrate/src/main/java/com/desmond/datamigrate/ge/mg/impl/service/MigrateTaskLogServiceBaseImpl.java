package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTaskLogDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateTaskLog;

public abstract class MigrateTaskLogServiceBaseImpl {
	public int add(MigrateTaskLog migrateTaskLog) {
		return getDao().add(migrateTaskLog);
	}
	
	public int update(MigrateTaskLog migrateTaskLog) {
		return getDao().update(migrateTaskLog);
	}
	
	public MigrateTaskLog fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateTaskLogDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateTaskLogDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateTaskLogDaoImpl dao;
}
