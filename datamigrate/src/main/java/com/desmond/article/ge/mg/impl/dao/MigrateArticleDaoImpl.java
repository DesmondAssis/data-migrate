package com.desmond.article.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.article.ge.mg.impl.model.MigrateArticleImpl;

import com.desmond.article.ge.util.db.Counter;
import com.desmond.article.ge.util.db.DBUtil;
import com.desmond.article.ge.mg.intf.MigrateArticle;

public class MigrateArticleDaoImpl{
	
	public int add(MigrateArticle migrateArticle) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateArticle.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO art_MigrateArticle VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setTimestamp(4, migrateArticle.getPubDate());			ps.setString(5, migrateArticle.getTitle());			ps.setString(6, migrateArticle.getDescription());			ps.setString(7, migrateArticle.getLink());			ps.setString(8, migrateArticle.getAuthor());			ps.setString(9, migrateArticle.getGuid());			ps.setString(10, migrateArticle.getCategory());			ps.setString(11, migrateArticle.getComments());
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(MigrateArticle migrateArticle){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE art_MigrateArticle set createdDate = ?, modifiedDate = ?,"				+ "pubDate = ?,"				+ "title = ?,"				+ "description = ?,"				+ "link = ?,"				+ "author = ?,"				+ "guid = ?,"				+ "category = ?,"				+ "comments = ?" 				+" where articleId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateArticle.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setTimestamp(3, migrateArticle.getPubDate());			ps.setString(4, migrateArticle.getTitle());			ps.setString(5, migrateArticle.getDescription());			ps.setString(6, migrateArticle.getLink());			ps.setString(7, migrateArticle.getAuthor());			ps.setString(8, migrateArticle.getGuid());			ps.setString(9, migrateArticle.getCategory());			ps.setString(10, migrateArticle.getComments());			ps.setLong(11, migrateArticle.getPrimaryKey());
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public MigrateArticle fetchByPrimaryKey(long primaryKey){
		MigrateArticle migrateArticle = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM art_MigrateArticle WHERE articleId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateArticle = new MigrateArticleImpl();
								migrateArticle.setPrimaryKey(rs.getLong(1));				migrateArticle.setCreatedDate(rs.getTimestamp(2));				migrateArticle.setModifiedDate(rs.getTimestamp(3));				migrateArticle.setPubDate(rs.getTimestamp(4));				migrateArticle.setTitle(rs.getString(5));				migrateArticle.setDescription(rs.getString(6));				migrateArticle.setLink(rs.getString(7));				migrateArticle.setAuthor(rs.getString(8));				migrateArticle.setGuid(rs.getString(9));				migrateArticle.setCategory(rs.getString(10));				migrateArticle.setComments(rs.getString(11));
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateArticle;
	}
	
	
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM art_MigrateArticle WHERE articleId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateArticleDaoImpl.class.getName());
}
