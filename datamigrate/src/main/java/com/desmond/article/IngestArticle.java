package com.desmond.article;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.desmond.article.ge.mg.impl.dao.ArticleDaoImpl;
import com.desmond.article.ge.mg.impl.model.ArticleImpl;
import com.desmond.article.ge.mg.intf.Article;
import com.desmond.article.xml.ArticleEntry;
import com.desmond.article.xml.Item;

public class IngestArticle {

	public static void main(String[] args) throws Exception {
		IngestArticle ing = new IngestArticle();
		ing.ingest();
		
	}
	
	public void transformLToR(Item item, Article article) {
		article.setAuthor(item.getAuthor());
		article.setCategory(item.getCategory());
		article.setComments(item.getComments());
		article.setDescription(item.getDescription());
		article.setLink(item.getLink());
		article.setTitle(item.getTitle());
		article.setGuid(item.getGuid());
		
		DateFormat fm = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
		Date date = new Date();
		try {
			date = fm.parse(item.getPubDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		article.setPubDate(new Timestamp(date.getTime()));
	}
	
	public InputStream getSource() {
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(new File("L:/gitHub/projects/data-migrate/datamigrate"
					+ "/data/xml-source/RSS-Sina-News.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return is;
	}
	
	public void ingest() {
		InputStream is = getSource();
		ArticleEntry article = parseXML(is);
		if(article != null && article.getItems()!= null) {
			ArticleDaoImpl dao = new ArticleDaoImpl();
			for(Item item : article.getItems()) {
				Article art = new ArticleImpl();
				transformLToR(item, art);
				dao.add(art);
			}
		}
	}
	
	public ArticleEntry parseXML(InputStream is) {
		ArticleEntry article = null;
		try {
            JAXBContext jc = JAXBContext.newInstance(ArticleEntry.class);
            Unmarshaller u = jc.createUnmarshaller();
            article = (ArticleEntry) u.unmarshal(is);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return article;
	}

}
