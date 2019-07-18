package com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + " : Doing my DB Work - Add Account");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

}
