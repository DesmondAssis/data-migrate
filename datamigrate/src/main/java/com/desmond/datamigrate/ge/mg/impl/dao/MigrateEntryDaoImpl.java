package com.desmond.datamigrate.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.mg.impl.model.MigrateEntryImpl;

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
		String sql = "UPDATE migrate_MigrateEntry set createdDate = ?, modifiedDate = ?,"
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateEntry.getCreatedDate());
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
			ps.setString(1, classnameId);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateEntry migrateEntry = new MigrateEntryImpl();
				
				
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