package com.desmond.datamigrate.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.mg.impl.model.MigrateTaskImpl;

import com.desmond.datamigrate.ge.util.db.Counter;
import com.desmond.datamigrate.ge.util.db.DBUtil;
import com.desmond.datamigrate.ge.mg.intf.MigrateTask;

public class MigrateTaskDaoImpl{
	
	public int add(MigrateTask migrateTask) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateTask.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateTask VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setLong(4, migrateTask.getMigrateBatchId());			ps.setLong(5, migrateTask.getSourceId());			ps.setInt(6, migrateTask.getMigrateTypeId());			ps.setString(7, migrateTask.getName());			ps.setInt(8, migrateTask.getPriority());			ps.setInt(9, migrateTask.getMigrateStatusId());			ps.setLong(10, migrateTask.getElapsedMillisec());			ps.setString(11, migrateTask.getResult());			ps.setString(12, migrateTask.getServer());			ps.setInt(13, migrateTask.getSuccessCount());			ps.setInt(14, migrateTask.getFailureCount());			ps.setLong(15, migrateTask.getCreatedBy());			ps.setLong(16, migrateTask.getModifiedBy());
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(MigrateTask migrateTask){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateTask set createdDate = ?, modifiedDate = ?,"				+ "migrateBatchId = ?,"				+ "sourceId = ?,"				+ "migrateTypeId = ?,"				+ "name = ?,"				+ "priority = ?,"				+ "migrateStatusId = ?,"				+ "elapsedMillisec = ?,"				+ "result = ?,"				+ "server = ?,"				+ "successCount = ?,"				+ "failureCount = ?,"				+ "createdBy = ?,"				+ "modifiedBy = ?" 				+" where migrateTaskId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateTask.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setLong(3, migrateTask.getMigrateBatchId());			ps.setLong(4, migrateTask.getSourceId());			ps.setInt(5, migrateTask.getMigrateTypeId());			ps.setString(6, migrateTask.getName());			ps.setInt(7, migrateTask.getPriority());			ps.setInt(8, migrateTask.getMigrateStatusId());			ps.setLong(9, migrateTask.getElapsedMillisec());			ps.setString(10, migrateTask.getResult());			ps.setString(11, migrateTask.getServer());			ps.setInt(12, migrateTask.getSuccessCount());			ps.setInt(13, migrateTask.getFailureCount());			ps.setLong(14, migrateTask.getCreatedBy());			ps.setLong(15, migrateTask.getModifiedBy());			ps.setLong(16, migrateTask.getPrimaryKey());
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public MigrateTask fetchByPrimaryKey(long primaryKey){
		MigrateTask migrateTask = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTask WHERE migrateTaskId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateTask = new MigrateTaskImpl();
								migrateTask.setPrimaryKey(rs.getLong(1));				migrateTask.setCreatedDate(rs.getTimestamp(2));				migrateTask.setModifiedDate(rs.getTimestamp(3));				migrateTask.setMigrateBatchId(rs.getLong(4));				migrateTask.setSourceId(rs.getLong(5));				migrateTask.setMigrateTypeId(rs.getInt(6));				migrateTask.setName(rs.getString(7));				migrateTask.setPriority(rs.getInt(8));				migrateTask.setMigrateStatusId(rs.getInt(9));				migrateTask.setElapsedMillisec(rs.getLong(10));				migrateTask.setResult(rs.getString(11));				migrateTask.setServer(rs.getString(12));				migrateTask.setSuccessCount(rs.getInt(13));				migrateTask.setFailureCount(rs.getInt(14));				migrateTask.setCreatedBy(rs.getLong(15));				migrateTask.setModifiedBy(rs.getLong(16));
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateTask;
	}
	
	public java.util.List<MigrateTask> findByName(String name){
		java.util.List<MigrateTask> migrateTasks = new java.util.ArrayList<MigrateTask>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTask WHERE name = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateTask migrateTask = new MigrateTaskImpl();
								migrateTask.setPrimaryKey(rs.getLong(1));				migrateTask.setCreatedDate(rs.getTimestamp(2));				migrateTask.setModifiedDate(rs.getTimestamp(3));				migrateTask.setMigrateBatchId(rs.getLong(4));				migrateTask.setSourceId(rs.getLong(5));				migrateTask.setMigrateTypeId(rs.getInt(6));				migrateTask.setName(rs.getString(7));				migrateTask.setPriority(rs.getInt(8));				migrateTask.setMigrateStatusId(rs.getInt(9));				migrateTask.setElapsedMillisec(rs.getLong(10));				migrateTask.setResult(rs.getString(11));				migrateTask.setServer(rs.getString(12));				migrateTask.setSuccessCount(rs.getInt(13));				migrateTask.setFailureCount(rs.getInt(14));				migrateTask.setCreatedBy(rs.getLong(15));				migrateTask.setModifiedBy(rs.getLong(16));
				
				migrateTasks.add(migrateTask);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by String name ", e);
		}
		
		return migrateTasks;
}public java.util.List<MigrateTask> findByBatchStatusId(int migrateStatusId, Long migrateBatchId){
		java.util.List<MigrateTask> migrateTasks = new java.util.ArrayList<MigrateTask>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTask WHERE migrateStatusId = ? and migrateBatchId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, migrateStatusId);			ps.setLong(2, migrateBatchId);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateTask migrateTask = new MigrateTaskImpl();
								migrateTask.setPrimaryKey(rs.getLong(1));				migrateTask.setCreatedDate(rs.getTimestamp(2));				migrateTask.setModifiedDate(rs.getTimestamp(3));				migrateTask.setMigrateBatchId(rs.getLong(4));				migrateTask.setSourceId(rs.getLong(5));				migrateTask.setMigrateTypeId(rs.getInt(6));				migrateTask.setName(rs.getString(7));				migrateTask.setPriority(rs.getInt(8));				migrateTask.setMigrateStatusId(rs.getInt(9));				migrateTask.setElapsedMillisec(rs.getLong(10));				migrateTask.setResult(rs.getString(11));				migrateTask.setServer(rs.getString(12));				migrateTask.setSuccessCount(rs.getInt(13));				migrateTask.setFailureCount(rs.getInt(14));				migrateTask.setCreatedBy(rs.getLong(15));				migrateTask.setModifiedBy(rs.getLong(16));
				
				migrateTasks.add(migrateTask);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by int migrateStatusId, Long migrateBatchId ", e);
		}
		
		return migrateTasks;
}public java.util.List<MigrateTask> findByMigrateBatchId(Long migrateBatchId){
		java.util.List<MigrateTask> migrateTasks = new java.util.ArrayList<MigrateTask>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateTask WHERE migrateBatchId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, migrateBatchId);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateTask migrateTask = new MigrateTaskImpl();
								migrateTask.setPrimaryKey(rs.getLong(1));				migrateTask.setCreatedDate(rs.getTimestamp(2));				migrateTask.setModifiedDate(rs.getTimestamp(3));				migrateTask.setMigrateBatchId(rs.getLong(4));				migrateTask.setSourceId(rs.getLong(5));				migrateTask.setMigrateTypeId(rs.getInt(6));				migrateTask.setName(rs.getString(7));				migrateTask.setPriority(rs.getInt(8));				migrateTask.setMigrateStatusId(rs.getInt(9));				migrateTask.setElapsedMillisec(rs.getLong(10));				migrateTask.setResult(rs.getString(11));				migrateTask.setServer(rs.getString(12));				migrateTask.setSuccessCount(rs.getInt(13));				migrateTask.setFailureCount(rs.getInt(14));				migrateTask.setCreatedBy(rs.getLong(15));				migrateTask.setModifiedBy(rs.getLong(16));
				
				migrateTasks.add(migrateTask);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by Long migrateBatchId ", e);
		}
		
		return migrateTasks;
}
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateTask WHERE migrateTaskId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateTaskDaoImpl.class.getName());
}
