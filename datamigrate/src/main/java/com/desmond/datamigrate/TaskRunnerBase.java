package com.desmond.datamigrate;

import com.desmond.datamigrate.ge.mg.intf.MigrateEntry;
import com.desmond.datamigrate.ge.mg.intf.MigrateTask;
import com.desmond.datamigrate.intf.TaskRunner;

public abstract class TaskRunnerBase implements TaskRunner {
	protected MigrateTask task;
	protected MigrateEntry entry;

	public TaskRunnerBase(MigrateTask task, MigrateEntry entry) {
		super();
		this.task = task;
		this.entry = entry;
	}

	public MigrateTask getMigrateTask() {
		// TODO Auto-generated method stub
		return task;
	}

	public void setMigrateTask(MigrateTask task) {
		this.task = task;

	}

	public MigrateEntry getMigrateEntryPK() {
		// TODO Auto-generated method stub
		return entry;
	}

}
