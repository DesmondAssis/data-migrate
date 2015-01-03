package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateBatchDaoImpl;

import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;

public abstract class MigrateBatchServiceBaseImpl {
	public int add(MigrateBatch migrateBatch) {
		return getDao().add(migrateBatch);
	}
	
	public int update(MigrateBatch migrateBatch) {
		return getDao().update(migrateBatch);
	}
	
	public MigrateBatch fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateBatchDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateBatchDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateBatchDaoImpl dao;
}
