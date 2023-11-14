package com.eidiko.niranjana.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="CCMS_CUSTOMERDETAILSENTITY")
public class CustomerDetailsEntity 
{
	@Id
	private String taskId;
	private String caseReferenceNumber;
	private String createdDate;
	private String customerName;
	private String cifNumber;
	private String civilId;
	private String passportNumber;
	private String mobileNumber;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getCaseReferenceNumber() {
		return caseReferenceNumber;
	}
	public void setCaseReferenceNumber(String caseReferenceNumber) {
		this.caseReferenceNumber = caseReferenceNumber;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCifNumber() {
		return cifNumber;
	}
	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}
	public String getCivilId() {
		return civilId;
	}
	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	

}
