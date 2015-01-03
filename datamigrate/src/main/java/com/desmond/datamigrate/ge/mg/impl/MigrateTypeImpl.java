package com.desmond.datamigrate.ge.mg.impl;

import com.desmond.datamigrate.ge.mg.intf.MigrateType;

import com.desmond.datamigrate.ge.mg.impl.base.BaseModelImpl;

public class MigrateTypeImpl extends BaseModelImpl implements MigrateType{
		private long migrateTypeId;
	private String name;

		public long getMigrateTypeId() {		return migrateTypeId;	}
	public void setMigrateTypeId(long migrateTypeId) {		this.migrateTypeId = migrateTypeId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}

	
	public MigrateType mockMigrateTypeImpl() {
		MigrateType migratetype = new MigrateTypeImpl();
				migratetype.setMigrateTypeId(Math.round(10000));		migratetype.setName("Name" + Math.round(100000000));
		
		return migratetype;
	}
}
