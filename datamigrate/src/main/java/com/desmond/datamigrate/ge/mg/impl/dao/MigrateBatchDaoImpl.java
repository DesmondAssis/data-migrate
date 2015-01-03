package com.desmond.datamigrate.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.mg.impl.model.MigrateBatchImpl;

import com.desmond.datamigrate.ge.util.db.Counter;
import com.desmond.datamigrate.ge.util.db.DBUtil;
import com.desmond.datamigrate.ge.mg.intf.MigrateBatch;

public class MigrateBatchDaoImpl{
	
	public int add(MigrateBatch migrateBatch) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateBatch.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateBatch VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setLong(4, migrateBatch.getMigrateProviderId());			ps.setLong(5, migrateBatch.getGroupId());			ps.setString(6, migrateBatch.getGroupName());			ps.setInt(7, migrateBatch.getMigrateStatusId());			ps.setString(8, migrateBatch.getName());			ps.setString(9, migrateBatch.getParameters());			ps.setString(10, migrateBatch.getServer());			ps.setLong(11, migrateBatch.getTotalCount());			ps.setLong(12, migrateBatch.getSuccessCount());			ps.setLong(13, migrateBatch.getFailureCount());			ps.setString(14, migrateBatch.getNote());			ps.setLong(15, migrateBatch.getCreatedBy());			ps.setLong(16, migrateBatch.getModifiedBy());
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(MigrateBatch migrateBatch){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateBatch set createdDate = ?, modifiedDate = ?,"				+ "migrateProviderId = ?,"				+ "groupId = ?,"				+ "groupName = ?,"				+ "migrateStatusId = ?,"				+ "name = ?,"				+ "parameters = ?,"				+ "server = ?,"				+ "totalCount = ?,"				+ "successCount = ?,"				+ "failureCount = ?,"				+ "note = ?,"				+ "createdBy = ?,"				+ "modifiedBy = ?" 				+" where migrateBatchId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateBatch.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setLong(3, migrateBatch.getMigrateProviderId());			ps.setLong(4, migrateBatch.getGroupId());			ps.setString(5, migrateBatch.getGroupName());			ps.setInt(6, migrateBatch.getMigrateStatusId());			ps.setString(7, migrateBatch.getName());			ps.setString(8, migrateBatch.getParameters());			ps.setString(9, migrateBatch.getServer());			ps.setLong(10, migrateBatch.getTotalCount());			ps.setLong(11, migrateBatch.getSuccessCount());			ps.setLong(12, migrateBatch.getFailureCount());			ps.setString(13, migrateBatch.getNote());			ps.setLong(14, migrateBatch.getCreatedBy());			ps.setLong(15, migrateBatch.getModifiedBy());			ps.setLong(16, migrateBatch.getPrimaryKey());
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public MigrateBatch fetchByPrimaryKey(long primaryKey){
		MigrateBatch migrateBatch = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateBatch WHERE migrateBatchId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateBatch = new MigrateBatchImpl();
								migrateBatch.setPrimaryKey(rs.getLong(1));				migrateBatch.setCreatedDate(rs.getTimestamp(2));				migrateBatch.setModifiedDate(rs.getTimestamp(3));				migrateBatch.setMigrateProviderId(rs.getLong(4));				migrateBatch.setGroupId(rs.getLong(5));				migrateBatch.setGroupName(rs.getString(6));				migrateBatch.setMigrateStatusId(rs.getInt(7));				migrateBatch.setName(rs.getString(8));				migrateBatch.setParameters(rs.getString(9));				migrateBatch.setServer(rs.getString(10));				migrateBatch.setTotalCount(rs.getLong(11));				migrateBatch.setSuccessCount(rs.getLong(12));				migrateBatch.setFailureCount(rs.getLong(13));				migrateBatch.setNote(rs.getString(14));				migrateBatch.setCreatedBy(rs.getLong(15));				migrateBatch.setModifiedBy(rs.getLong(16));
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateBatch;
	}
	
	
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateBatch WHERE migrateBatchId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateBatchDaoImpl.class.getName());
}
