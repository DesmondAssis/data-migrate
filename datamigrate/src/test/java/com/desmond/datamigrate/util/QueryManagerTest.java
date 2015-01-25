package com.desmond.datamigrate.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.desmond.datamigrate.QueryManager;
import com.desmond.datamigrate.util.jdbc.DBPool;

public class QueryManagerTest extends JdbcBase{

	@Test
	public void testGetBatchStories() {
		List<Long> ids = QueryManager.getBatchStories(1, 1, 2);
		assertEquals(true, ids.size() > 0);
	}

}
