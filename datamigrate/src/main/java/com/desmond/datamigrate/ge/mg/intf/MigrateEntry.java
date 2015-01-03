package com.desmond.datamigrate.ge.mg.intf;


import com.desmond.datamigrate.ge.mg.intf.base.BaseModel;

public interface MigrateEntry extends BaseModel{
		public long getSourceId();
	public void setSourceId(long sourceId);
	public String getMigrateTypeId();
	public void setMigrateTypeId(String migrateTypeId);
	public String getGorupId();
	public void setGorupId(String gorupId);
	public String getMigrateProviderId();
	public void setMigrateProviderId(String migrateProviderId);
	public String getClassPK();
	public void setClassPK(String classPK);
	public String getProperties();
	public void setProperties(String properties);
	public String getClassnameId();
	public void setClassnameId(String classnameId);
	public String getAddress();
	public void setAddress(String address);
	public String getPhone();
	public void setPhone(String phone);
	public String getQuestion();
	public void setQuestion(String question);
	public String getAnswer();
	public void setAnswer(String answer);

}
