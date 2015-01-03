package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateStatus;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateStatusImpl extends BaseModelImpl implements MigrateStatus{
		private int migrateStatusId;
	private String name;

		public int getMigrateStatusId() {		return migrateStatusId;	}
	public void setMigrateStatusId(int migrateStatusId) {		this.migrateStatusId = migrateStatusId;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}

	
	public MigrateStatus mockMigrateStatusImpl() {
		MigrateStatus migratestatus = new MigrateStatusImpl();
				migratestatus.setMigrateStatusId(Math.round(100));		migratestatus.setName("Name" + Math.round(100000000));
		
		return migratestatus;
	}
}
