package com.desmond.article.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.article.ge.mg.impl.model.ArticleImpl;

import com.desmond.article.ge.util.db.Counter;
import com.desmond.article.ge.util.db.DBUtil;
import com.desmond.article.ge.mg.intf.Article;

public class ArticleDaoImpl{
	
	public int add(Article article) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(Article.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO art_Article VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
			
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(Article article){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE art_Article set createdDate = ?, modifiedDate = ?,"
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, article.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public Article fetchByPrimaryKey(long primaryKey){
		Article article = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM art_Article WHERE articleId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				article = new ArticleImpl();
				
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return article;
	}
	
	
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM art_Article WHERE articleId = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			update = ps.executeUpdate();
		} catch (SQLException e) {
			log.error("error when delete", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	private static Logger log = Logger.getLogger(ArticleDaoImpl.class.getName());
}