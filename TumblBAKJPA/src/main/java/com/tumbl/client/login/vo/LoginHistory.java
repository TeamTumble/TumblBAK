package com.tumbl.client.login.vo;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: LoginHistory
 *
 */
@Entity

public class LoginHistory {

	@Id
	@GeneratedValue
	private int idx;
	private int retry;
	private long lastFailedLogin;
	private long lastSuccessedLogin;
	private String clientIP;

	public LoginHistory() {
	}

	public LoginHistory(int idx, int retry, long lastFailedLogin, long lastSuccessedLogin, String clientIP) {
		super();
		this.idx = idx;
		this.retry = retry;
		this.lastFailedLogin = lastFailedLogin;
		this.lastSuccessedLogin = lastSuccessedLogin;
		this.clientIP = clientIP;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}

	public long getLastFailedLogin() {
		return lastFailedLogin;
	}

	public void setLastFailedLogin(long lastFailedLogin) {
		this.lastFailedLogin = lastFailedLogin;
	}

	public long getLastSuccessedLogin() {
		return lastSuccessedLogin;
	}

	public void setLastSuccessedLogin(long lastSuccessedLogin) {
		this.lastSuccessedLogin = lastSuccessedLogin;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
   
}
