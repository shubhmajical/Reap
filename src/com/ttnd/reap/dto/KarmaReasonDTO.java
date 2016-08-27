package com.ttnd.reap.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class KarmaReasonDTO {

	private int id;

	private Date dateTime;

	private EmployeeDTO senderId;

	private int temporarySenderId;

	private String reason;

	private String badgeReceived;

	private String karma;

	private int temporaryReceiverId;

	private EmployeeDTO receiverId;

	private String revokedReason;

	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public EmployeeDTO getSenderId() {
		return senderId;
	}

	public void setSenderId(EmployeeDTO senderId) {
		this.senderId = senderId;
	}

	public int getTemporarySenderId() {
		return temporarySenderId;
	}

	public void setTemporarySenderId(int temporarySenderId) {
		this.temporarySenderId = temporarySenderId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getBadgeReceived() {
		return badgeReceived;
	}

	public void setBadgeReceived(String badgeReceived) {
		this.badgeReceived = badgeReceived;
	}

	public String getKarma() {
		return karma;
	}

	public void setKarma(String karma) {
		this.karma = karma;
	}

	public int getTemporaryReceiverId() {
		return temporaryReceiverId;
	}

	public void setTemporaryReceiverId(int temporaryReceiverId) {
		this.temporaryReceiverId = temporaryReceiverId;
	}

	public EmployeeDTO getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(EmployeeDTO receiverId) {
		this.receiverId = receiverId;
	}

	public String getRevokedReason() {
		return revokedReason;
	}

	public void setRevokedReason(String revokedReason) {
		this.revokedReason = revokedReason;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

}