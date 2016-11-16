package com.xiaojinzi.code.app.util;

public class StsTokenEntity {
	
	private String accessKeyId;

	private String secretKeyId;

	private String securityToken;

	private String expiration;

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getSecretKeyId() {
		return secretKeyId;
	}

	public void setSecretKeyId(String secretKeyId) {
		this.secretKeyId = secretKeyId;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
}
