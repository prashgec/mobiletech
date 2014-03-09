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
import org.hibernate.annotations.NotFound;







/**
 * @author Prashant
 *
 */

@Table(name="MST_USER")
@Entity
public class User {
	
	 
	 @Column(name="role")
	 
	 private Integer role; 
	 @Id
	 @GeneratedValue(generator="increment")
	 @GenericGenerator(name="increment", strategy = "increment") 
	 @Column(name="userid")
	 private Integer userId;
	 @Column(name="prntid")
	 private Integer prntId;	 
	 @Column(name="salutation")
	 private String salutation;
	 @Column(name="first_name")
	 private String firstName;
	 @Column(name="last_name")
	 private String lastName;
	 @Column(name="dob")
	 private String dob;
	 @Column(name="email_id")
	 private String emailId;
	 @Column(name="phone_no1")
	 private String phoneNo1;
	 @Column(name="phone_no2")
	 private String phoneNo2;
	 @Column(name="city")
	 private String city;
	 @Column(name="state")
	 private String state;
	 @Column(name="country")
	 private String country;	 
	 @Column(name="username")
	 private String userName;
	 @Column(name="password")
	 private String password;
	 @Column(name="login_status")
	 private String loginStatus;
	 @Column(name="registered_on")
	 private String registeredOn;
	 @Column(name="last_login")
	 private String lastLogin;
	 @Column(name="profile_pic")
	 private String profilePic;
	 @Column(name="used_balance")
	 private Float usedBalance;
	 @Column(name="available_balance")
	 private Float availableBalance;
	 @Column(name="commission")
	 private Float commission;
	 @Column(name="agency")
	 private String agency;
	 @Column(name="address")
	 private String address;
	 
	 
	 
	 
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the usedBalance
	 */
	public Float getUsedBalance() {
		return usedBalance;
	}
	/**
	 * @param usedBalance the usedBalance to set
	 */
	public void setUsedBalance(Float usedBalance) {
		this.usedBalance = usedBalance;
	}
	/**
	 * @return the availableBalance
	 */
	public Float getAvailableBalance() {
		return availableBalance;
	}
	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(Float availableBalance) {
		this.availableBalance = availableBalance;
	}
	/**
	 * @return the commission
	 */
	public Float getCommission() {
		return commission;
	}
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(Float commission) {
		this.commission = commission;
	}
	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}
	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the phoneNo1
	 */
	public String getPhoneNo1() {
		return phoneNo1;
	}
	/**
	 * @param phoneNo1 the phoneNo1 to set
	 */
	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}
	/**
	 * @return the phoneNo2
	 */
	public String getPhoneNo2() {
		return phoneNo2;
	}
	/**
	 * @param phoneNo2 the phoneNo2 to set
	 */
	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * @return the loginStatus
	 */
	public String getLoginStatus() {
		return loginStatus;
	}
	/**
	 * @param loginStatus the loginStatus to set
	 */
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	/**
	 * @return the registeredOn
	 */
	public String getRegisteredOn() {
		return registeredOn;
	}
	/**
	 * @param registeredOn the registeredOn to set
	 */
	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}
	/**
	 * @return the lastLogin
	 */
	public String getLastLogin() {
		return lastLogin;
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	/**
	 * @return the profilePic
	 */
	public String getProfilePic() {
		return profilePic;
	}
	/**
	 * @param profilePic the profilePic to set
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
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
	
	 public void recharge( Float amount, Float commission)
	 {
		 Float tempAmt=amount*((100.00F-commission)/100.00F);
		 this.setAvailableBalance(this.availableBalance-tempAmt);
		 this.setUsedBalance(this.usedBalance+tempAmt);
	 }
	

}
