package com.desmond.datamigrate.mg.impl;

import com.desmond.datamigrate.mg.intf.MigrateEntry;

public abstract class MigrateEntryServiceBaseImpl {
	public int add(MigrateEntry migrateEntry) {
		return getDao().add(migrateEntry);
	}
	
	public int update(MigrateEntry migrateEntry) {
		return getDao().update(migrateEntry);
	}
	
	public MigrateEntry fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateEntryDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateEntryDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateEntryDaoImpl dao;
}
