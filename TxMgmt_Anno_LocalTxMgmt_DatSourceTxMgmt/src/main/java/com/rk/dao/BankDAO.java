package com.rk.dao;

public interface BankDAO {

	public int withdraw(long acno,float amount);
	public int deposite(long acno,float amount);
}
