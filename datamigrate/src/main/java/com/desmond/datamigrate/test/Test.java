package com.desmond.datamigrate.test;

import com.desmond.datamigrate.enums.MigrateStatusEnum;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateProviderDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.dao.MigrateTypeDaoImpl;
import com.desmond.datamigrate.ge.mg.impl.model.MigrateProviderImpl;
import com.desmond.datamigrate.ge.mg.impl.model.MigrateStatusImpl;
import com.desmond.datamigrate.ge.mg.impl.model.MigrateTypeImpl;
import com.desmond.datamigrate.ge.mg.intf.MigrateProvider;
import com.desmond.datamigrate.ge.mg.intf.MigrateStatus;
import com.desmond.datamigrate.ge.mg.intf.MigrateType;
import com.desmond.datamigrate.util.service.ServiceUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MigrateProviderDaoImpl dao = new MigrateProviderDaoImpl();
//		MigrateProvider m = new MigrateProviderImpl().mockMigrateProviderImpl();
//		dao.add(m);
		
		for(MigrateStatusEnum en : MigrateStatusEnum.values()) {
			MigrateStatus status = new MigrateStatusImpl();
			status.setMigrateStatusId(en.getId());
			status.setName(en.getName());
			ServiceUtil.getStatusService().add(status);
		}
	}

}
