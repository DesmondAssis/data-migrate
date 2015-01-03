package com.desmond.datamigrate.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.mg.impl.model.MigrateStatusImpl;

import com.desmond.datamigrate.ge.util.db.Counter;
import com.desmond.datamigrate.ge.util.db.DBUtil;
import com.desmond.datamigrate.ge.mg.intf.MigrateStatus;

public class MigrateStatusDaoImpl{
	
	public int add(MigrateStatus migrateStatus) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateStatus.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateStatus VALUES(?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setString(4, migrateStatus.getName());
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(MigrateStatus migrateStatus){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateStatus set createdDate = ?, modifiedDate = ?,"				+ "name = ?" 				+" where migrateStatusId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateStatus.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setString(3, migrateStatus.getName());			ps.setLong(4, migrateStatus.getPrimaryKey());
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public MigrateStatus fetchByPrimaryKey(long primaryKey){
		MigrateStatus migrateStatus = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateStatus WHERE migrateStatusId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateStatus = new MigrateStatusImpl();
								migrateStatus.setPrimaryKey(rs.getInt(1));				migrateStatus.setCreatedDate(rs.getTimestamp(2));				migrateStatus.setModifiedDate(rs.getTimestamp(3));				migrateStatus.setName(rs.getString(4));
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateStatus;
	}
	
	public java.util.List<MigrateStatus> findByName(String name){
		java.util.List<MigrateStatus> migrateStatuss = new java.util.ArrayList<MigrateStatus>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateStatus WHERE name = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateStatus migrateStatus = new MigrateStatusImpl();
								migrateStatus.setPrimaryKey(rs.getInt(1));				migrateStatus.setCreatedDate(rs.getTimestamp(2));				migrateStatus.setModifiedDate(rs.getTimestamp(3));				migrateStatus.setName(rs.getString(4));
				
				migrateStatuss.add(migrateStatus);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by String name ", e);
		}
		
		return migrateStatuss;
}
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateStatus WHERE migrateStatusId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateStatusDaoImpl.class.getName());
}
