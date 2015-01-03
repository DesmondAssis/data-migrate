package com.desmond.datamigrate.ge.mg.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.desmond.datamigrate.ge.mg.impl.model.MigrateProviderImpl;

import com.desmond.datamigrate.ge.util.db.Counter;
import com.desmond.datamigrate.ge.util.db.DBUtil;
import com.desmond.datamigrate.ge.mg.intf.MigrateProvider;

public class MigrateProviderDaoImpl{
	
	public int add(MigrateProvider migrateProvider) {
		int update = 0;
		Connection conn = DBUtil.getConnection();
		long nextPrimaryKey = Counter.getPrimaryKey(MigrateProvider.class.getName(), conn);
		
		PreparedStatement ps = null;
		String sql = "INSERT INTO migrate_MigrateProvider VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
	
	public int update(MigrateProvider migrateProvider){
		int update=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		String sql = "UPDATE migrate_MigrateProvider set createdDate = ?, modifiedDate = ?,"
		try {
			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, migrateProvider.getCreatedDate());
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
	
	public MigrateProvider fetchByPrimaryKey(long primaryKey){
		MigrateProvider migrateProvider = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateProvider WHERE migrateProviderId = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, primaryKey);
			rs = ps.executeQuery();
			while(rs.next()) {
				migrateProvider = new MigrateProviderImpl();
				
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by primaryKey: " + primaryKey, e);
		}
		
		return migrateProvider;
	}
	
	public java.util.List<MigrateProvider> findByName(String name){
		java.util.List<MigrateProvider> migrateProviders = new java.util.ArrayList<MigrateProvider>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM migrate_MigrateProvider WHERE name = ?";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				MigrateProvider migrateProvider = new MigrateProviderImpl();
				
				
				migrateProviders.add(migrateProvider);
			}
		} catch (SQLException e) {
			log.error("error when get ${User} by String name ", e);
		}
		
		return migrateProviders;
}
	
	public int delete(long primaryKey){
		int update = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM migrate_MigrateProvider WHERE migrateProviderId = ?";
		
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
	
	private static Logger log = Logger.getLogger(MigrateProviderDaoImpl.class.getName());
}