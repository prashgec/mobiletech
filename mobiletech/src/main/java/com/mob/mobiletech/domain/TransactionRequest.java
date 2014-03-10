/**
 * 
 */
package com.mob.mobiletech.domain;

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
@Table(name="TNX_REQUEST")
@Entity
public class TransactionRequest {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment") 
	@Column(name="req_id")
	
	private Integer reqId;
	@Column(name="req_type")
	private Integer reqType;
	@Column(name="requested_by")
	private Integer requestedBy;
	@Column(name="requester_name")
	private String requesterName;
	@Column(name="requested_to")
	private Integer requestedTo;
	@Column(name="requester_remark")
	private String requesterRemark;
	@Column(name="approver_remark")
	private String approverRemark;
	@Column(name="status")
	private Integer status;
	@Column(name="amt")
	private Integer amt;
	@Column(name="create_date")
	private String createDate;
	@Column(name="approval_date")
	private String approvalDate;
	
	
	public Integer getAmt() {
		return amt;
	}
	public void setAmt(Integer amt) {
		this.amt = amt;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	public Integer getReqType() {
		return reqType;
	}
	public void setReqType(Integer reqType) {
		this.reqType = reqType;
	}
	public Integer getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(Integer requestedBy) {
		this.requestedBy = requestedBy;
	}
	public String getRequesterName() {
		return requesterName;
	}
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
	public Integer getRequestedTo() {
		return requestedTo;
	}
	public void setRequestedTo(Integer requestedTo) {
		this.requestedTo = requestedTo;
	}
	public String getRequesterRemark() {
		return requesterRemark;
	}
	public void setRequesterRemark(String requesterRemark) {
		this.requesterRemark = requesterRemark;
	}
	public String getApproverRemark() {
		return approverRemark;
	}
	public void setApproverRemark(String approverRemark) {
		this.approverRemark = approverRemark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
