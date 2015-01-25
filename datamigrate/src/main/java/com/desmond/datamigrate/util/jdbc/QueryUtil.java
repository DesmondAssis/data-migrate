package com.desmond.datamigrate.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.log4j.Logger;

import com.desmond.datamigrate.util.constants.SQLConstants;

public class QueryUtil {
	private static Logger _log = Logger.getLogger(QueryUtil.class);
	
	public static Long[] getMinMaxArticleId(long providerId, long groupId, int typeId) {
		String sql = "select min(t1.sourceId) " + SQLConstants.COLUMN_ALIAS_MINSOURCEID + ","
					+ " max(t1.sourceId) " + SQLConstants.COLUMN_ALIAS_MAXSOURCEID
					+ " from migrate_migratetask t1, migrate_migratebatch t2"
					+ " where t1.migrateBatchId = t2.migrateBatchId"
					+ " and t2.migrateProviderId=? and t2.groupId=? "
					+ " and t1.migrateTypeId=?";
		Map<String, Object> resultMap = QueryUtil.queryMap(sql, new Object[] {providerId, groupId, typeId});
		if(resultMap != null && resultMap.size() == 2) {
			
			return new Long[] {
				(Long)resultMap.get(SQLConstants.COLUMN_ALIAS_MINSOURCEID),
				(Long)resultMap.get(SQLConstants.COLUMN_ALIAS_MAXSOURCEID)
					
			};
		}
		
		return null;
		
	}
	
	public static List<Object[]> queryList(String sql, Object[] params) {
		Connection conn = DBPool.getConnection();
		List<Object[]> objList = null;
		
		try {
			objList = new QueryRunner().query(conn, sql, new ArrayListHandler(), params);
			DbUtils.close(conn);
		} catch (SQLException e) {
			_log.error(e.getMessage(), e);
		}
		
		return objList;
	}
	
	public static Map<String, Object> queryMap(String sql, Object[] params) {
		Connection conn = DBPool.getConnection();
		Map<String, Object> resultMap = null;
		
		try {
			resultMap = new QueryRunner().query(conn, sql, new MapHandler(), params);
			
			DbUtils.close(conn);
		} catch (SQLException e) {
			_log.error(e.getMessage(), e);
		}
		
		return resultMap;
	}
	
	public static void main(String[] args) {
		DBPool.mock();
		
		
		String sql = "select min(age) minAgeId, max(age) maxAgeId from test where ?= ?;";
		
		Object[] params = {1, 1};
		@SuppressWarnings("static-access")
		Map<String, Object> mapObj = new QueryUtil().queryMap(sql, params);
		_log.info(mapObj);;
	}
}
