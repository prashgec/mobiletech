/**
 * 
 */
package com.mob.mobiletech.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Prashant
 *
 */
@Entity
@Table(name="TNX_RECHARGE")
public class TransactionRecharge {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment") 
	@Column(name="tnx_id")
	private Integer tnxId;
	private Integer tnxType;
	private String operator;
	private Integer userId;
	private Integer prntId;
	private Date tnxDate;
	private Integer tnxAmount;
	private Integer tnxStatus;
	private String tnxRemark;
	private String joloTnxId;
	private String mobNo;
	private String cycle;
	private String account;
	private Float chargedAmount;
	private Float remainingAmount;
	
	
	
	
	public Float getChargedAmount() {
		return chargedAmount;
	}
	public void setChargedAmount(Float chargedAmount) {
		this.chargedAmount = chargedAmount;
	}
	public Float getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(Float remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	private String dueDate;
	public Integer getTnxId() {
		return tnxId;
	}
	public void setTnxId(Integer tnxId) {
		this.tnxId = tnxId;
	}
	public Integer getTnxType() {
		return tnxType;
	}
	public void setTnxType(Integer tnxType) {
		this.tnxType = tnxType;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the prntId
	 */
	public Integer getPrntId() {
		return prntId;
	}
	/**
	 * @param prntId the prntId to set
	 */
	public void setPrntId(Integer prntId) {
		this.prntId = prntId;
	}
	public Date getTnxDate() {
		return tnxDate;
	}
	public void setTnxDate(Date tnxDate) {
		this.tnxDate = tnxDate;
	}
	public Integer getTnxAmount() {
		return tnxAmount;
	}
	public void setTnxAmount(Integer tnxAmount) {
		this.tnxAmount = tnxAmount;
	}
	public Integer getTnxStatus() {
		return tnxStatus;
	}
	public void setTnxStatus(Integer tnxStatus) {
		this.tnxStatus = tnxStatus;
	}
	public String getTnxRemark() {
		return tnxRemark;
	}
	public void setTnxRemark(String tnxRemark) {
		this.tnxRemark = tnxRemark;
	}
	public String getJoloTnxId() {
		return joloTnxId;
	}
	public void setJoloTnxId(String joloTnxId) {
		this.joloTnxId = joloTnxId;
	}
	/**
	 * @return the mobNo
	 */
	public String getMobNo() {
		return mobNo;
	}
	/**
	 * @param mobNo the mobNo to set
	 */
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	

}
