package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSillyMethod() {
		System.out.println(getClass() + " : Doing my DB Work - Add Account");
	}
}
