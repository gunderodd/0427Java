package com.application.bank;

import com.application.bank.dao.impl.UserDaoImpl;
import com.application.bank.exception.BusinessException;
import com.application.bank.models.User;
import com.application.bank.models.Account;
import com.application.bank.dao.impl.AccountDaoImpl;
import com.application.bank.services.impl.UserServiceImpl;
import com.application.bank.services.impl.AccountServiceImpl;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MainDriver {
	final static Logger loggy = Logger.getLogger(User.class);

	public static void main(String[] args) {
		
		UserDaoImpl uDI = new UserDaoImpl();
		AccountDaoImpl aDI = new AccountDaoImpl();
		AccountServiceImpl aSI = new AccountServiceImpl();
		UserServiceImpl uSI = new UserServiceImpl();
		
		User u3 = new User();
		
		try {
			uSI.registerNewUser();
		} catch (BusinessException e1) {
			loggy.info(e1.getMessage());
		}
		
//		u3.setName("Boba Fett");
//		u3.setEmail("boba@email.com");
//		u3.setPhoneNumber("1130490");
//		u3.setPassword("slave1");
//		u3.setStatus("customer");
//		try {
//			uDI.insertUser(u3);
//		} catch (BusinessException e) {
//			loggy.warn("Couldn't create a new user. Please try again.");
//			e.printStackTrace();
//		}
		
//		try {
//			List<User> userList = uDI.selectAllUsers();
//		} catch (BusinessException e1) {
//			loggy.error("Internal Error. Please contact the SYSADMIN");
//		}
		
//		try {
//			u3 = uDI.selectUserByColumnName("email", "ben@email.com");
//		} catch (BusinessException e) {
//			loggy.info("Internal Error. Please try again or contact your SYSADMIN");
//			e.printStackTrace();
//		}
//		
//		System.out.println(u3);
		
//		try {
//			uDI.updateUser("serenity@email.com", "name", "Malcom Reynolds");
//		} catch (BusinessException e) {
//			loggy.warn("We couldn't seem to find that account. Please try again");
//			e.printStackTrace();
//		}
		
//		try {
//			uDI.deleteAllUsers();
//		} catch (BusinessException e) {
//			loggy.info("The rows still exist because " + e);
//		}
		
//		try {
//			uDI.deleteUser(u3.getEmail());
//		} catch (BusinessException e) {
//			loggy.warn("The row still exist because " + e);
//		}	
		
//		try {
//			Account a5 = aDI.selectAccountByEmail("serenity@email.com");
//		} catch (BusinessException e) {
//			loggy.error("BusinessException caught");
//			loggy.info("Couldn't select user. Please try again.");
//			e.printStackTrace();
//		}
		
//		try {
//			List<Account> accountList = aDI.selectAllAccounts();
//		} catch (BusinessException e) {
//			loggy.warn("Internal Error. Please try again or contact your SYSADMIN");
//			e.printStackTrace();
//		}
		
//		try {
//			aDI.deleteAllAccounts();
//		} catch (BusinessException e) {
//			loggy.warn("The records remain, peasant");
//			e.printStackTrace();
//		}
		
//		try {
//			aDI.deleteAccount(u3.getEmail());
//		} catch (BusinessException e) {
//			loggy.info("Internal Error. Please try again or contact your SYSADMIN");
//			e.printStackTrace();
//		}
		
//		try {
//			aDI.updateAccount("ben@email.com", "savingsbalance", "1500.00");
//		} catch (BusinessException e) {
//			
//			loggy.info("Internal Error. Please try again or contact your SYSADMIN");
//			e.printStackTrace();
//		}
		
//		Account a2 = new Account();
//		a2.setCheckingAccountNumber("980054");
//		a2.setSavingsAccountNumber("7840032");
//		a2.setCheckingBalance("1500.00");
//		a2.setSavingsBalance("2500.00");
//		a2.setActive("false");
//		a2.setEmail("jabba@email.com");
//		
//		Account a3 = new Account();
//		a3.setCheckingAccountNumber("986954");
//		a3.setSavingsAccountNumber("7110032");
//		a3.setCheckingBalance("100.00");
//		a3.setSavingsBalance("500.00");
//		a3.setActive("false");
//		a3.setEmail("ben@email.com");
//		try {
//			aDI.insertAccount(a3);
//			aDI.insertAccount(a2);
//		} catch (BusinessException e) {
//			loggy.error("Internal Error. Please contact the SYSADMIN");
//			e.printStackTrace();
//		}
//		

	}

}



