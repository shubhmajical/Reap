package com.ttnd.reap.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "karmareason")
public class KarmaReason {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "dateTime")
	private Date dateTime;

	@OneToOne
	@JoinColumn(name = "senderId")
	private Employee senderId;

	@Column(name = "reason")
	private String reason;
	@Column(name = "badgeReceived")
	private String badgeReceived;
	@Column(name = "karma")
	private String karma;

	@OneToOne
	@JoinColumn(name = "receiverId")
	private Employee receiverId;

	@Column(name = "revokedreason")
	private String revokedReason;

	@Column(name = "status")
	private boolean status;

	
	
	public Employee getSenderId() {
		return senderId;
	}

	public void setSenderId(Employee senderId) {
		this.senderId = senderId;
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

	public Employee getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Employee receiverId) {
		this.receiverId = receiverId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
