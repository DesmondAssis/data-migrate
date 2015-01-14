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
		String sql = "INSERT INTO art_MigrateArticle VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setLong(4, migrateArticle.getCompanyId());			ps.setLong(5, migrateArticle.getGroupId());			ps.setTimestamp(6, migrateArticle.getPubDate());			ps.setString(7, migrateArticle.getTitle());			ps.setString(8, migrateArticle.getDescription());			ps.setString(9, migrateArticle.getLink());			ps.setString(10, migrateArticle.getAuthor());			ps.setString(11, migrateArticle.getGuid());			ps.setString(12, migrateArticle.getCategory());			ps.setString(13, migrateArticle.getComments());
			
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
		String sql = "UPDATE art_MigrateArticle set createdDate = ?, modifiedDate = ?,"				+ "companyId = ?,"				+ "groupId = ?,"				+ "pubDate = ?,"				+ "title = ?,"				+ "description = ?,"				+ "link = ?,"				+ "author = ?,"				+ "guid = ?,"				+ "category = ?,"				+ "comments = ?" 				+" where articleId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateArticle.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setLong(3, migrateArticle.getCompanyId());			ps.setLong(4, migrateArticle.getGroupId());			ps.setTimestamp(5, migrateArticle.getPubDate());			ps.setString(6, migrateArticle.getTitle());			ps.setString(7, migrateArticle.getDescription());			ps.setString(8, migrateArticle.getLink());			ps.setString(9, migrateArticle.getAuthor());			ps.setString(10, migrateArticle.getGuid());			ps.setString(11, migrateArticle.getCategory());			ps.setString(12, migrateArticle.getComments());			ps.setLong(13, migrateArticle.getPrimaryKey());
			
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
								migrateArticle.setPrimaryKey(rs.getLong(1));				migrateArticle.setCreatedDate(rs.getTimestamp(2));				migrateArticle.setModifiedDate(rs.getTimestamp(3));				migrateArticle.setCompanyId(rs.getLong(4));				migrateArticle.setGroupId(rs.getLong(5));				migrateArticle.setPubDate(rs.getTimestamp(6));				migrateArticle.setTitle(rs.getString(7));				migrateArticle.setDescription(rs.getString(8));				migrateArticle.setLink(rs.getString(9));				migrateArticle.setAuthor(rs.getString(10));				migrateArticle.setGuid(rs.getString(11));				migrateArticle.setCategory(rs.getString(12));				migrateArticle.setComments(rs.getString(13));
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
