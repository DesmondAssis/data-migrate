package com.desmond.datamigrate.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.desmond.datamigrate.util.jdbc.QueryUtil;

public class QueryUtilTest extends JdbcBase{

	@Test
	public void testGetMinMaxArticleId() {
		Long[] maxArtcleId = QueryUtil.getMinMaxArticleId(1, 1, 3);
		System.out.println(maxArtcleId.length);
		assertEquals(true, maxArtcleId != null && maxArtcleId.length > 0);
	}
	
	@Ignore
	@Test
	public void testQueryList() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testQueryMap() {
		fail("Not yet implemented");
	}

}
