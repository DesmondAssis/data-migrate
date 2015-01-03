package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTaskDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateTask;

public abstract class MigrateTaskServiceBaseImpl {
	public int add(MigrateTask migrateTask) {
		return getDao().add(migrateTask);
	}
	
	public int update(MigrateTask migrateTask) {
		return getDao().update(migrateTask);
	}
	
	public MigrateTask fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateTaskDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateTaskDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateTaskDaoImpl dao;
}
