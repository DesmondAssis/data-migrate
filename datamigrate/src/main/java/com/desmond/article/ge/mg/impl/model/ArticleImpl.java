package com.desmond.article.ge.mg.impl.model;

import java.sql.Timestamp;
import com.desmond.article.ge.mg.intf.Article;

import com.desmond.article.ge.mg.impl.model.base.BaseModelImpl;

public class ArticleImpl extends BaseModelImpl implements Article{
		private Long articleId;
	private Timestamp pubDate;
	private String title;
	private String description;
	private String link;
	private String author;
	private String guid;
	private String category;
	private String comments;

		public Long getArticleId() {		return articleId;	}
	public void setArticleId(Long articleId) {		this.articleId = articleId;	}
	public Timestamp getPubDate() {		return pubDate;	}
	public void setPubDate(Timestamp pubDate) {		this.pubDate = pubDate;	}
	public String getTitle() {		return title;	}
	public void setTitle(String title) {		this.title = title;	}
	public String getDescription() {		return description;	}
	public void setDescription(String description) {		this.description = description;	}
	public String getLink() {		return link;	}
	public void setLink(String link) {		this.link = link;	}
	public String getAuthor() {		return author;	}
	public void setAuthor(String author) {		this.author = author;	}
	public String getGuid() {		return guid;	}
	public void setGuid(String guid) {		this.guid = guid;	}
	public String getCategory() {		return category;	}
	public void setCategory(String category) {		this.category = category;	}
	public String getComments() {		return comments;	}
	public void setComments(String comments) {		this.comments = comments;	}

	
	public Article mockArticleImpl() {
		Article article = new ArticleImpl();
				article.setArticleId(Math.round(10000d));		article.setPubDate(new java.sql.Timestamp(new java.util.Date().getTime()));		article.setTitle("Title" + Math.round(100000000));		article.setDescription("Description" + Math.round(100000000));		article.setLink("Link" + Math.round(100000000));		article.setAuthor("Author" + Math.round(100000000));		article.setGuid("Guid" + Math.round(100000000));		article.setCategory("Category" + Math.round(100000000));		article.setComments("Comments" + Math.round(100000000));
		
		return article;
	}
}
