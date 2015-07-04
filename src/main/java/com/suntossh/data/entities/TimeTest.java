package com.suntossh.data.entities;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GeneratorType;

/*CREATE TABLE `time_test` (
 `TIME_TEST_ID` bigint(20) NOT NULL AUTO_INCREMENT,
 `DATETIME_COLUMN` datetime DEFAULT NULL,
 `TIMESTAMP_COLUMN` timestamp NULL DEFAULT NULL,
 `DATE_COLUMN` date DEFAULT NULL,
 `TIME_COLUMN` time DEFAULT NULL,
 `SQL_DATETIME_COLUMN` datetime DEFAULT NULL,
 `SQL_TIMESTAMP_COLUMN` timestamp NULL DEFAULT NULL,
 `SQL_DATE_COLUMN` date DEFAULT NULL,
 `SQL_TIME_COLUMN` time DEFAULT NULL,
 PRIMARY KEY (`TIME_TEST_ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

@Entity
@Table(name="time_test")
@Access(value = javax.persistence.AccessType.FIELD)
public class TimeTest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TIME_TEST_ID")
	private Long timeTestId;

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATETIME_COLUMN")
	private Date dateTime_Col;

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="TIMESTAMP_COLUMN")
	private Date timeStamp_Col;

	@Temporal(value=TemporalType.DATE)
	@Column(name="DATE_COLUMN")
	private Date date_Col;

	@Temporal(value=TemporalType.TIME)
	@Column(name="TIME_COLUMN")
	private Date time_Col;

	@Column(name="SQL_DATETIME_COLUMN")
	private java.sql.Timestamp sqlDateTime_Col;

	@Column(name="SQL_TIMESTAMP_COLUMN")
	private java.sql.Timestamp sqlTimeStamp_Col;

	@Column(name="SQL_DATE_COLUMN")
	private java.sql.Date sqlDate_Col;

	@Column(name="SQL_TIME_COLUMN")
	private java.sql.Time sqlTime_Col;

	public TimeTest(Date date) {
		this.dateTime_Col = date;
		this.timeStamp_Col = date;
		this.time_Col = date;
		this.date_Col = date;
		
		this.sqlDateTime_Col = new java.sql.Timestamp(date.getTime());
		this.sqlTimeStamp_Col = new java.sql.Timestamp(date.getTime());
		this.sqlDate_Col = new java.sql.Date(date.getTime());
		this.sqlTime_Col = new java.sql.Time(date.getTime());
	}
	
	public Long getTimeTestId() {
		return timeTestId;
	}

	public void setTimeTestId(Long timeTestId) {
		this.timeTestId = timeTestId;
	}

	public Date getDateTime_Col() {
		return dateTime_Col;
	}

	public void setDateTime_Col(Date dateTime_Col) {
		this.dateTime_Col = dateTime_Col;
	}

	public Date getTimeStamp_Col() {
		return timeStamp_Col;
	}

	public void setTimeStamp_Col(Date timeStamp_Col) {
		this.timeStamp_Col = timeStamp_Col;
	}

	public Date getDate_Col() {
		return date_Col;
	}

	public void setDate_Col(Date date_Col) {
		this.date_Col = date_Col;
	}

	public Date getTime_Col() {
		return time_Col;
	}

	public void setTime_Col(Date time_Col) {
		this.time_Col = time_Col;
	}

	public java.sql.Timestamp getSqlDateTime_Col() {
		return sqlDateTime_Col;
	}

	public void setSqlDateTime_Col(java.sql.Timestamp sqlDateTime_Col) {
		this.sqlDateTime_Col = sqlDateTime_Col;
	}

	public java.sql.Timestamp getSqlTimeStamp_Col() {
		return sqlTimeStamp_Col;
	}

	public void setSqlTimeStamp_Col(java.sql.Timestamp sqlTimeStamp_Col) {
		this.sqlTimeStamp_Col = sqlTimeStamp_Col;
	}

	public java.sql.Date getSqlDate_Col() {
		return sqlDate_Col;
	}

	public void setSqlDate_Col(java.sql.Date sqlDate_Col) {
		this.sqlDate_Col = sqlDate_Col;
	}

	public java.sql.Time getSqlTime_Col() {
		return sqlTime_Col;
	}

	public void setSqlTime_Col(java.sql.Time sqlTime_Col) {
		this.sqlTime_Col = sqlTime_Col;
	}
	

	@Override
	public String toString() {
		return "TimeTest ["
				+ "\n timeTestId=" + timeTestId + ", "
				+ "\n datetimeColumn=" + dateTime_Col + ","
				+ "\n timestampColumn=" + timeStamp_Col + ", "
				+ "\n dateColumn=" + date_Col + ", "
				+ "\n timeColumn=" + time_Col + ", "
				+ "\n sqlDatetimeColumn=" + sqlDateTime_Col + ", "
				+ "\n sqlTimestampColumn=" + sqlTimeStamp_Col + ", "
			    + "\n sqlDateColumn=" + sqlDate_Col + ", "
			    + "\n sqlTimeColumn=" + sqlTime_Col + "]";
	}
}
