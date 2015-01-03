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
import com.desmond.datamigrate.ge.mg.intf.MigrateType;

public class MigrateTypeDaoImpl{
	
	public int add(MigrateType migrateType) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateType.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateType VALUES(?, ?, ?, ?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, nextPrimaryKey);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
						ps.setString(4, migrateType.getName());
			
			update = ps.executeUpdate();
			log.debug("count= " + update);
		} catch(SQLException e) {
			log.error("error when insert", e);
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public int update(MigrateType migrateType){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateType set createdDate = ?, modifiedDate = ?,"				+ "name = ?" 				+" where migrateTypeId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateType.getCreatedDate());
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
						ps.setString(3, migrateType.getName());			ps.setLong(4, migrateType.getPrimaryKey());
			
			update=ps.executeUpdate();		
			log.debug("DML:" + sql + " affect " + sql + " row.");
		} catch (SQLException e) {
			log.error("error when update.", e);
		}finally{
			DBUtil.close(conn, ps);
		}
		
		return update;
	}
	
	public MigrateType fetchByPrimaryKey(long primaryKey){
		MigrateType migrateType = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateType WHERE migrateTypeId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateType = new MigrateTypeImpl();
								migrateType.setPrimaryKey(rs.getLong(1));				migrateType.setCreatedDate(rs.getTimestamp(2));				migrateType.setModifiedDate(rs.getTimestamp(3));				migrateType.setName(rs.getString(4));
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateType;
	}
	
	
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateType WHERE migrateTypeId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateTypeDaoImpl.class.getName());
}
