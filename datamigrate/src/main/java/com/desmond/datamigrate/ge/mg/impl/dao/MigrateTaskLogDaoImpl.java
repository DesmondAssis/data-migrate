package com.desmond.datamigrate.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.mg.impl.model.MigrateTaskLogImpl;

import com.desmond.datamigrate.ge.util.db.Counter;
import com.desmond.datamigrate.ge.util.db.DBUtil;
import com.desmond.datamigrate.ge.mg.intf.MigrateTaskLog;

public class MigrateTaskLogDaoImpl{
	
	public int add(MigrateTaskLog migrateTaskLog) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateTaskLog.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateTaskLog VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
	
	public int update(MigrateTaskLog migrateTaskLog){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateTaskLog set createdDate = ?, modifiedDate = ?,"
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateTaskLog.getCreatedDate());
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
	
	public MigrateTaskLog fetchByPrimaryKey(long primaryKey){
		MigrateTaskLog migrateTaskLog = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTaskLog WHERE migrateTaskLogId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateTaskLog = new MigrateTaskLogImpl();
				
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateTaskLog;
	}
	
	public java.util.List<MigrateTaskLog> findByMigrateTaskId(Long migrateTaskId){
		java.util.List<MigrateTaskLog> migrateTaskLogs = new java.util.ArrayList<MigrateTaskLog>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTaskLog WHERE migrateTaskId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, migrateTaskId);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateTaskLog migrateTaskLog = new MigrateTaskLogImpl();
				
				
				migrateTaskLogs.add(migrateTaskLog);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by Long migrateTaskId ", e);
		}
		
		return migrateTaskLogs;
}public java.util.List<MigrateTaskLog> findByT_S_T(Long migrateTaskId, Long sourceId, int type_){
		java.util.List<MigrateTaskLog> migrateTaskLogs = new java.util.ArrayList<MigrateTaskLog>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTaskLog WHERE migrateTaskId = ? and sourceId = ? and type_ = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, migrateTaskId);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateTaskLog migrateTaskLog = new MigrateTaskLogImpl();
				
				
				migrateTaskLogs.add(migrateTaskLog);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by Long migrateTaskId, Long sourceId, int type_ ", e);
		}
		
		return migrateTaskLogs;
}
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateTaskLog WHERE migrateTaskLogId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateTaskLogDaoImpl.class.getName());
}