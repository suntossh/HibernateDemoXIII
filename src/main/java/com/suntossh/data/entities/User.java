package com.suntossh.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;


@Entity
@Table(name = "FINANCES_USER")
@Access(value = javax.persistence.AccessType.FIELD)
public class User {

	/*
	 * select * from account_typeCREATE TABLE `finances_user` ( `USER_ID`
	 * bigint(20) NOT NULL AUTO_INCREMENT, `FIRST_NAME` varchar(45) NOT NULL,
	 * `LAST_NAME` varchar(45) NOT NULL, `BIRTH_DATE` date NOT NULL,
	 * `EMAIL_ADDRESS` varchar(100) NOT NULL, `LAST_UPDATED_BY` varchar(45) NOT
	 * NULL, `LAST_UPDATED_DATE` datetime NOT NULL, `CREATED_BY` varchar(45) NOT
	 * NULL, `CREATED_DATE` datetime NOT NULL, `USER_ADDRESS_LINE_1`
	 * varchar(100) DEFAULT NULL, `USER_ADDRESS_LINE_2` varchar(100) DEFAULT
	 * NULL, `CITY` varchar(100) DEFAULT NULL, `STATE` varchar(2) DEFAULT NULL,
	 * `ZIP_CODE` varchar(5) DEFAULT NULL, PRIMARY KEY (`USER_ID`) )
	 * ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 */

	@Id

	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_gen_name" )
	@SequenceGenerator(name="seq_gen_name", sequenceName="ORACLEDB_SEQNAME")*/
	
	/*@GeneratedValue(strategy=GenerationType.TABLE, generator="table_gen_name")
	@TableGenerator(name="table_gen_name", 
					table="ifinances_keys", 
					pkColumnName="PK_NAME", valueColumnName="PK_VALUE")*/
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="BIRTH_DATE", nullable=false)
	private Date birthDate;

	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name="CREATED_DATE", updatable=false)
	private Date createdDate;

	@Column(name="CREATED_BY", updatable=false)
	private String createdBy;

/*	@ElementCollection
	@CollectionTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@AttributeOverrides({@AttributeOverride(name="addressLine1", column=@Column(name="USER_ADDRESS_LINE_1")),
			@AttributeOverride(name="addressLine2", column=@Column(name="USER_ADDRESS_LINE_2"))})		
	private List<Address> address = new ArrayList<Address>();
*/
	
	@Column(name="USER_ADDRESS_LINE_1")
	private String userAddressLine1;
	
	@Column(name="USER_ADDRESS_LINE_2")
	private String userAddressLine2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zipCode;

	@OneToOne(mappedBy="user") // here we are establishing BiDirectional 1 to 1 entity mapping, due to Bi directional mapping we can get Owining entity(Credentials, why Credential is Owning , becuase it has the FK stored in it, and also it is called Sorce entity and User is Target) info in/from non owning entity (User)
	private Credential credential;
	
	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public String getUserAddressLine1() {
		return userAddressLine1;
	}

	public void setUserAddressLine1(String userAddressLine1) {
		this.userAddressLine1 = userAddressLine1;
	}

	public String getUserAddressLine2() {
		return userAddressLine2;
	}

	public void setUserAddressLine2(String userAddressLine2) {
		this.userAddressLine2 = userAddressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Transient
	private boolean valid;
	
	@Formula("lower(datediff(curDate(),BIRTH_DATE)/365)")
	private int age;


/*	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
*/
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
