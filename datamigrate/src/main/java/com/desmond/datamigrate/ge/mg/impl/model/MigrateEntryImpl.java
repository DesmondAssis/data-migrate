package com.desmond.datamigrate.ge.mg.impl.model;

import com.desmond.datamigrate.ge.mg.intf.MigrateEntry;

import com.desmond.datamigrate.ge.mg.impl.model.base.BaseModelImpl;

public class MigrateEntryImpl extends BaseModelImpl implements MigrateEntry{
		private long sourceId;
	private String migrateTypeId;
	private String gorupId;
	private String migrateProviderId;
	private String classPK;
	private String properties;
	private String classnameId;
	private String address;
	private String phone;
	private String question;
	private String answer;

		public long getSourceId() {		return sourceId;	}
	public void setSourceId(long sourceId) {		this.sourceId = sourceId;	}
	public String getMigrateTypeId() {		return migrateTypeId;	}
	public void setMigrateTypeId(String migrateTypeId) {		this.migrateTypeId = migrateTypeId;	}
	public String getGorupId() {		return gorupId;	}
	public void setGorupId(String gorupId) {		this.gorupId = gorupId;	}
	public String getMigrateProviderId() {		return migrateProviderId;	}
	public void setMigrateProviderId(String migrateProviderId) {		this.migrateProviderId = migrateProviderId;	}
	public String getClassPK() {		return classPK;	}
	public void setClassPK(String classPK) {		this.classPK = classPK;	}
	public String getProperties() {		return properties;	}
	public void setProperties(String properties) {		this.properties = properties;	}
	public String getClassnameId() {		return classnameId;	}
	public void setClassnameId(String classnameId) {		this.classnameId = classnameId;	}
	public String getAddress() {		return address;	}
	public void setAddress(String address) {		this.address = address;	}
	public String getPhone() {		return phone;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public String getQuestion() {		return question;	}
	public void setQuestion(String question) {		this.question = question;	}
	public String getAnswer() {		return answer;	}
	public void setAnswer(String answer) {		this.answer = answer;	}

	
	public MigrateEntry mockMigrateEntryImpl() {
		MigrateEntry migrateentry = new MigrateEntryImpl();
				migrateentry.setSourceId(Math.round(10000));		migrateentry.setMigrateTypeId("MigrateTypeId" + Math.round(100000000));		migrateentry.setGorupId("GorupId" + Math.round(100000000));		migrateentry.setMigrateProviderId("MigrateProviderId" + Math.round(100000000));		migrateentry.setClassPK("ClassPK" + Math.round(100000000));		migrateentry.setProperties("Properties" + Math.round(100000000));		migrateentry.setClassnameId("ClassnameId" + Math.round(100000000));		migrateentry.setAddress("Address" + Math.round(100000000));		migrateentry.setPhone("Phone" + Math.round(100000000));		migrateentry.setQuestion("Question" + Math.round(100000000));		migrateentry.setAnswer("Answer" + Math.round(100000000));
		
		return migrateentry;
	}
}
