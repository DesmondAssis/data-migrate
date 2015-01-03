package com.desmond.datamigrate.test;

import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTypeDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.model.MigrateTypeImpl;
import com.desmond.datamigrate.ge.mg.intf.MigrateType;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MigrateTypeDaoImpl dao = new MigrateTypeDaoImpl();
		MigrateType m = new MigrateTypeImpl().mockMigrateTypeImpl();
		dao.add(m);
	}

}
