package com.suntossh.data.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIAL")
@Access(value = AccessType.FIELD)
public class Credential {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CREDENTIAL_ID")
	private long credentialID;

	@Column(name="USERNAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	@OneToOne(cascade=CascadeType.ALL)//Casde all is added to ensure both owning and non owning entity is saved, ie when src is saved then 
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
	public User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCredentialID() {
		return credentialID;
	}

	public void setCredentialID(long credentialID) {
		this.credentialID = credentialID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
