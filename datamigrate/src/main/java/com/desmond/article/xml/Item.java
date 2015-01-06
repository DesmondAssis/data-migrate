package com.desmond.article.xml;

import javax.xml.bind.annotation.XmlElement;

public class Item {
	private String title;
	private String link;
	private String author;
	private String guidStr;
	private String category;
	private String pubDate;
	private String comments;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGuidStr() {
		return guidStr;
	}
	@XmlElement(name="guid")
	public void setGuidStr(String guidStr) {
		this.guidStr = guidStr;
	}
	
	public String getGuid() {
		return guidStr.substring(guidStr.lastIndexOf("/")+1, guidStr.lastIndexOf("."));
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", author=" + author
				+ ", guidStr=" + guidStr + ", category=" + category
				+ ", pubDate=" + pubDate + ", comments=" + comments
				+ ", description=" + description + "]"
				+ ", guid=" + getGuid() + "]";
	}
	
}
