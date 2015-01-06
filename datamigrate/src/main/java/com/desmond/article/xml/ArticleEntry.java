package com.desmond.article.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "rss")
@XmlType(name = "rss")
public class ArticleEntry {
	private String title;
	private List<Item> items;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Item> getItems() {
		return items;
	}
	
    @XmlElement(name = "item")
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
