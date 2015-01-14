package com.desmond.datamigrate.ge.mg.impl.service;

import com.desmond.datamigrate.ge.mg.intf.MigrateProvider;
import com.desmond.datamigrate.intf.MigrateObjectFactory;

public class MigrateProviderLocalServiceImpl extends MigrateProviderServiceBaseImpl{
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. 
	 * Add your custom code here.
	 */
	
	public MigrateObjectFactory getMigrateObjectFactory(long providerId) throws Exception{
		MigrateProvider provider = this.fetchByPrimaryKey(providerId);
		MigrateObjectFactory objectFactory = (MigrateObjectFactory) Class.forName(provider.getFactoryClass()).newInstance();
		
		objectFactory.init(providerId);
		
		return objectFactory;
	} 
}
