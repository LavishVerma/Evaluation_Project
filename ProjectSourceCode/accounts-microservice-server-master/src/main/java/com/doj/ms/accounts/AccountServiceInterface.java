package com.doj.ms.accounts;

import java.util.List;

public interface AccountServiceInterface {
	public List<Account> getAllAccounts();
	public Account getAccount(String number);

}
