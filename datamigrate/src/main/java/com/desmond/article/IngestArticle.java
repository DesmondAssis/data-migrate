package com.desmond.article;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
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
import com.desmond.article.xml.Channel;
import com.desmond.article.xml.Item;

public class IngestArticle {

	public static void main(String[] args) throws Exception {
		IngestArticle ing = new IngestArticle();
		ing.ingest();
	}
	
	public void transformLToR(Item item, Article article, long groupId) {
		article.setCompanyId(1l);
		article.setGroupId(groupId);
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
	
	public InputStream getSource(File file) {
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return is;
	}
	
	public void ingest() {
		String path = "L:/gitHub/projects/data-migrate/datamigrate/data/xml-source";
		File[] sourceFiles = new File(path)
			.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.toString().endsWith(".xml");
			}
		});
		
		int count = 1;
		ArticleDaoImpl dao = new ArticleDaoImpl();
		
		for(File sourceFile : sourceFiles) {
			long groupId = count%2 == 0 ? 1 : 2;
			count++;
			
			System.out.println(sourceFile.getName());
			InputStream is = getSource(sourceFile);
			ArticleEntry article = parseXML(is);
			Channel channel = article.getChannel();
			if(channel != null && channel.getItems()!= null) {
				for(Item item : channel.getItems()) {
					Article art = new ArticleImpl();
					transformLToR(item, art, groupId);
					dao.add(art);
//					System.out.println(item);
				}
			}
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
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
