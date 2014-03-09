/**
 * 
 */
package com.mob.mobiletech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Prashant
 *
 */
@Entity
@Table(name="REF_DATA_MASTER")
public class ReferenceData {
    @Column(name="DATA_ID")
	private Integer dataId;
	@Id
	@Column(name="DATA_CODE")
	private String dataCode;
	@Column(name="DATA_VALUE")
	private String dataValue;
	@Column(name="COMMISSION")
	private Float commission;
	
	
	public Float getCommission() {
		return commission;
	}
	public void setCommission(Float commission) {
		this.commission = commission;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	
	
	
	
}
