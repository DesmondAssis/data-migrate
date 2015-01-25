package com.desmond.datamigrate.enums;

public enum MigrateStatusEnum {
	PENDING(1, "Pending"),
	RUNNING(2, "Running"),
	FAILED(3, "Failed"),
	SUCCESS(4, "Success"),
	PAUSED(5, "Paused"),
	CANCELED(6, "Canceled"),
	COMPLETED(7, "Completed");
	
	int id;
	String name;
	
	MigrateStatusEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getName(int id) {
		for (MigrateStatusEnum status : MigrateStatusEnum.values()) {
			if (id == status.getId()) {
				return status.getName();
			}
		}
		
		return null;
	}

	public static MigrateStatusEnum getMigrateStatus(int id) {
		for (MigrateStatusEnum status : MigrateStatusEnum.values()) {
			if (id == status.getId()) {
				return status;
			}
		}
		
		return null;
	}

	public static MigrateStatusEnum getMigrateStatus(String name) {
		for (MigrateStatusEnum status : MigrateStatusEnum.values()) {
			if (status.getName().equals(name)) {
				return status;
			}
		}
		
		return null;
	}

	public static int getId(String name) throws Exception {
		MigrateStatusEnum migrateEnum = getMigrateStatus(name);
		
		return migrateEnum != null ? migrateEnum.getId() : 0;
	}
	
}
