package com.desmond.article.ge.mg.impl.service;

import com.desmond.article.ge.mg.impl.dao.MigrateArticleDaoImpl;

import com.desmond.article.ge.mg.intf.MigrateArticle;

public abstract class MigrateArticleServiceBaseImpl {
	public int add(MigrateArticle migrateArticle) {
		return getDao().add(migrateArticle);
	}
	
	public int update(MigrateArticle migrateArticle) {
		return getDao().update(migrateArticle);
	}
	
	public MigrateArticle fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public MigrateArticleDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(MigrateArticleDaoImpl dao) {
		this.dao = dao;
	}

	private MigrateArticleDaoImpl dao;
}
