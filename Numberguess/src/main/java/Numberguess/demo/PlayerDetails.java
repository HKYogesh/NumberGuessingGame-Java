package Numberguess.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id ;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class PlayerDetails {
	@Id
	@GeneratedValue
	private int Id;
	@Column(nullable = false)
	private String Name;
	@Column(unique = true)
	private long Contact_Number;
	private int Age;
	private double Amount;
	
	private double totalAmountEarned;
	@CreationTimestamp
	private Date playedDateAndTime;
	private String systemGeneratedNumber;
	private String userEnteredNumber;
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(long contact_Number) {
		Contact_Number = contact_Number;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public double getTotalAmountEarned() {
		return totalAmountEarned;
	}
	public void setTotalAmountEarned(double totalAmountEarned) {
		this.totalAmountEarned = totalAmountEarned;
	}
	public Date getPlayedDateAndTime() {
		return playedDateAndTime;
	}
	public void setPlayedDateAndTime(Date playedDateAndTime) {
		this.playedDateAndTime = playedDateAndTime;
	}
	public String getSystemGeneratedNumber() {
		return systemGeneratedNumber;
	}
	public void setSystemGeneratedNumber(String systemGeneratedNumber) {
		this.systemGeneratedNumber = systemGeneratedNumber;
	}
	public String getUserEnteredNumber() {
		return userEnteredNumber;
	}
	public void setUserEnteredNumber(String userEnteredNumber) {
		this.userEnteredNumber = userEnteredNumber;
	}
	
}
