package com.doj.ms.accounts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountsMicroserviceServerApplicationTests {

	
	
	@InjectMocks
    AccountService manager;
     
    @Mock
    StubAccountRepository dao;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllEmployeesTest()
    {
        List<Account> list = new ArrayList<Account>();
       Account account1 = new Account(1000l, "Lavish" , "9999");
       Account account2 = new Account(1001l, "Karan" , "8888");
       Account account3 = new Account(1002l, "Shubham" , "7777");
         
        list.add(account1);
        list.add(account2);
        list.add(account3);
         
        when(dao.getAllAccounts()).thenReturn(list);
         
        //test
        List<Account> empList = manager.getAllAccounts();
         
        assertEquals(3, empList.size());
        verify(dao, times(1)).getAllAccounts();
    }
     
    @Test
    public void getEmployeeByIdTest()
    {
        when(dao.getAccount("7777")).thenReturn(new Account(1002l, "Shubham" , "7777"));
         
        Account emp = manager.getAccount("7777");
         
        assertEquals(new Long(1002), emp.getAmount());
        assertEquals("Shubham", emp.getName());
        assertEquals("7777", emp.getNumber());
    }
     
   
	 

}
