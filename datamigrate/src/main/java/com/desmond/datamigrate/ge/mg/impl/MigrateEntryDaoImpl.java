package com.desmond.datamigrate.ge.mg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.util.db.Counter;
import com.desmond.datamigrate.ge.util.db.DBUtil;
import com.desmond.datamigrate.ge.mg.intf.MigrateEntry;

public class MigrateEntryDaoImpl{
	
	public int add(MigrateEntry migrateEntry) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateEntry.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateEntry VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setString(4, migrateEntry.getMigrateTypeId());			ps.setString(5, migrateEntry.getGorupId());			ps.setString(6, migrateEntry.getMigrateProviderId());			ps.setString(7, migrateEntry.getClassPK());			ps.setString(8, migrateEntry.getProperties());			ps.setString(9, migrateEntry.getClassnameId());			ps.setString(10, migrateEntry.getAddress());			ps.setString(11, migrateEntry.getPhone());			ps.setString(12, migrateEntry.getQuestion());			ps.setString(13, migrateEntry.getAnswer());
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(MigrateEntry migrateEntry){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateEntry set createdDate = ?, modifiedDate = ?,"				+ "migrateTypeId = ?,"				+ "gorupId = ?,"				+ "migrateProviderId = ?,"				+ "classPK = ?,"				+ "properties = ?,"				+ "classnameId = ?,"				+ "address = ?,"				+ "phone = ?,"				+ "question = ?,"				+ "answer = ?" 				+" where sourceId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateEntry.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setString(3, migrateEntry.getMigrateTypeId());			ps.setString(4, migrateEntry.getGorupId());			ps.setString(5, migrateEntry.getMigrateProviderId());			ps.setString(6, migrateEntry.getClassPK());			ps.setString(7, migrateEntry.getProperties());			ps.setString(8, migrateEntry.getClassnameId());			ps.setString(9, migrateEntry.getAddress());			ps.setString(10, migrateEntry.getPhone());			ps.setString(11, migrateEntry.getQuestion());			ps.setString(12, migrateEntry.getAnswer());			ps.setLong(13, migrateEntry.getPrimaryKey());
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public MigrateEntry fetchByPrimaryKey(long primaryKey){
		MigrateEntry migrateEntry = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateEntry WHERE sourceId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateEntry = new MigrateEntryImpl();
								migrateEntry.setPrimaryKey(rs.getLong(1));				migrateEntry.setCreatedDate(rs.getTimestamp(2));				migrateEntry.setModifiedDate(rs.getTimestamp(3));				migrateEntry.setMigrateTypeId(rs.getString(4));				migrateEntry.setGorupId(rs.getString(5));				migrateEntry.setMigrateProviderId(rs.getString(6));				migrateEntry.setClassPK(rs.getString(7));				migrateEntry.setProperties(rs.getString(8));				migrateEntry.setClassnameId(rs.getString(9));				migrateEntry.setAddress(rs.getString(10));				migrateEntry.setPhone(rs.getString(11));				migrateEntry.setQuestion(rs.getString(12));				migrateEntry.setAnswer(rs.getString(13));
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateEntry;
	}
	
	public java.util.List<MigrateEntry> findByClassNamePK(String classnameId, String classPK){
		java.util.List<MigrateEntry> migrateEntrys = new java.util.ArrayList<MigrateEntry>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateEntry WHERE classnameId = ? and classPK = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, classnameId);			ps.setString(2, classPK);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateEntry migrateEntry = new MigrateEntryImpl();
								migrateEntry.setPrimaryKey(rs.getLong(1));				migrateEntry.setCreatedDate(rs.getTimestamp(2));				migrateEntry.setModifiedDate(rs.getTimestamp(3));				migrateEntry.setMigrateTypeId(rs.getString(4));				migrateEntry.setGorupId(rs.getString(5));				migrateEntry.setMigrateProviderId(rs.getString(6));				migrateEntry.setClassPK(rs.getString(7));				migrateEntry.setProperties(rs.getString(8));				migrateEntry.setClassnameId(rs.getString(9));				migrateEntry.setAddress(rs.getString(10));				migrateEntry.setPhone(rs.getString(11));				migrateEntry.setQuestion(rs.getString(12));				migrateEntry.setAnswer(rs.getString(13));
				
				migrateEntrys.add(migrateEntry);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by String classnameId, String classPK ", e);
		}
		
		return migrateEntrys;
}
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateEntry WHERE sourceId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateEntryDaoImpl.class.getName());
}
