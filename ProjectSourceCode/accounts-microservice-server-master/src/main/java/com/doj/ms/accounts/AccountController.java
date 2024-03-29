/**
 * 
 */
package com.doj.ms.accounts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
	@Autowired
	AccountServiceInterface service;

	protected Logger logger = Logger
			.getLogger(AccountController.class.getName());
	
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/accounts")
	public Account[] all() {
		logger.info("accounts-microservice all() invoked");
		List<Account> accounts = service.getAllAccounts();
		logger.info("accounts-microservice all() found: " + accounts.size());
		return accounts.toArray(new Account[accounts.size()]);
	}
	
	@RequestMapping("/accounts/{id}")
	public Account byId(@PathVariable("id") String id) {
		logger.info("accounts-microservice byId() invoked: " + id);
		Account account = service.getAccount(id);
		logger.info("accounts-microservice byId() found: " + account);
		return account;
	}
}
