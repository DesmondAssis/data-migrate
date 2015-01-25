package com.desmond.datamigrate.util;

import org.junit.After;
import org.junit.BeforeClass;

import com.desmond.datamigrate.util.jdbc.DBPool;

public class JdbcBase {
	@BeforeClass
	static public void setUp() throws Exception {
		DBPool.mock();
	}

	@After
	public void tearDown() throws Exception {
	}
}
