package com.desmond.article.ge.mg.intf;

import java.sql.Timestamp;

import com.desmond.article.ge.mg.intf.base.BaseModel;

public interface MigrateArticle extends BaseModel{
		public Long getArticleId();
	public void setArticleId(Long articleId);
	public Long getCompanyId();
	public void setCompanyId(Long companyId);
	public Long getGroupId();
	public void setGroupId(Long groupId);
	public Timestamp getPubDate();
	public void setPubDate(Timestamp pubDate);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public String getLink();
	public void setLink(String link);
	public String getAuthor();
	public void setAuthor(String author);
	public String getGuid();
	public void setGuid(String guid);
	public String getCategory();
	public void setCategory(String category);
	public String getComments();
	public void setComments(String comments);

}
