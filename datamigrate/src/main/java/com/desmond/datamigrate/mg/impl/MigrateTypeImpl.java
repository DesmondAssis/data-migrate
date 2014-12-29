package com.desmond.datamigrate.mg.impl;

import com.desmond.datamigrate.mg.intf.MigrateType;

import com.desmond.servicebuilder.model.base.impl.BaseModelImpl;

public class MigrateTypeImpl extends BaseModelImpl implements MigrateType{
		private int migrateTypeId;
	private String name;

		public int getMigrateTypeId() {		return migrateTypeId;	}
	public void setMigrateTypeId(int migrateTypeId) {		this.migrateTypeId = migrateTypeId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}

	
	public MigrateType mockMigrateTypeImpl() {
		MigrateType migratetype = new MigrateTypeImpl();
				migratetype.setMigrateTypeId(Math.round(100));		migratetype.setName("Name" + Math.round(100000000));
		
		return migratetype;
	}
}
