package com.aavn.trungnguyen.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicantEmail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String contentHTML;
	private String contentText;
	private Date createdDate;
	private Integer numberOfAttachmentFile;
	private String sendFrom;
	private String status;
	private String subject;
	private String applicantName;
	private String applicantPosition;
	private String codeQuestionnare;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContentHTML() {
		return contentHTML;
	}
	public void setContentHTML(String contentHTML) {
		this.contentHTML = contentHTML;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getNumberOfAttachmentFile() {
		return numberOfAttachmentFile;
	}
	public void setNumberOfAttachmentFile(Integer numberOfAttachmentFile) {
		this.numberOfAttachmentFile = numberOfAttachmentFile;
	}
	public String getSendFrom() {
		return sendFrom;
	}
	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantPosition() {
		return applicantPosition;
	}
	public void setApplicantPosition(String applicantPosition) {
		this.applicantPosition = applicantPosition;
	}
	public String getCodeQuestionnare() {
		return codeQuestionnare;
	}
	public void setCodeQuestionnare(String codeQuestionnare) {
		this.codeQuestionnare = codeQuestionnare;
	}

}
