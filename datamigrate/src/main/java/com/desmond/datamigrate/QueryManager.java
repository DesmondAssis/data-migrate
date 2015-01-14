package com.desmond.datamigrate;

import java.util.ArrayList;
import java.util.List;

import com.desmond.datamigrate.util.ConverterHelper;
import com.desmond.datamigrate.util.jdbc.QueryUtil;

public class QueryManager {
	public static List<Long> getBatchStories(long siteId, long batchStartId, int batchSize) {
		List<Long> storyIds = null;
		String sql = "select articleId from art_article where"
				+ " groupId=? and articleId < ?"
				+ " order by articleId desc limit ?";
		Object[] params = new Object[] {siteId, batchStartId, batchSize};
		List<Object[]> objList = QueryUtil.queryList(sql, params);
		
		if(objList != null) {
			storyIds = new ArrayList<Long>(objList.size());
			
			for(Object obj[] : objList) {
				storyIds.add(ConverterHelper.toLong(obj[0]));
			}
		}
		
		return storyIds;
	}
}
