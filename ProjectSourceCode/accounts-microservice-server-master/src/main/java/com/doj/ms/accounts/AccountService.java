package com.doj.ms.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {

	@Autowired
	AccountRepository dao;
	
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = dao.getAllAccounts();
		return accounts;
	}

	@Override
	public Account getAccount(String number) {
		Account account = dao.getAccount(number);
		return account;
	}
	

	

}
