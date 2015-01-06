package com.desmond.article.ge.mg.impl.service;

import com.desmond.article.ge.mg.impl.dao.ArticleDaoImpl;

import com.desmond.article.ge.mg.intf.Article;

public abstract class ArticleServiceBaseImpl {
	public int add(Article article) {
		return getDao().add(article);
	}
	
	public int update(Article article) {
		return getDao().update(article);
	}
	
	public Article fetchByPrimaryKey(long primaryKey) {
		return getDao().fetchByPrimaryKey(primaryKey);
	}
	
	public int delete(long primaryKey) {
		return getDao().delete(primaryKey);
	}
	
	public ArticleDaoImpl getDao() {
		return dao;
	}
	
	public void setDao(ArticleDaoImpl dao) {
		this.dao = dao;
	}

	private ArticleDaoImpl dao;
}
