package com.ploutos.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ploutos.dao.PloutosDAO;
import com.ploutos.dao.PloutosDAOImpl;
import com.ploutos.exception.BusinessException;
import com.ploutos.model.Account;
import com.ploutos.model.Login;
import com.ploutos.model.Transaction;

public class PloutosServiceImpl implements PloutosService {
	final static Logger L = Logger.getLogger(PloutosServiceImpl.class);
	private PloutosDAO dao = new PloutosDAOImpl();

	@Override
	public boolean isValidUsername(String username) {
		if (username.matches("[a-z0-9]{1,32}"))
			return true;
		return false;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		if (password.matches("[A-Za-z0-9]{1,32}"))
			return true;
		return false;
	}

	@Override
	public boolean isValidEmployee(String username, String password) throws BusinessException {
		if (isValidUsername(username)) {
			return dao.isEmployee(username, password);
		} else {
			throw new BusinessException("The username " + username + " is invalid. Usernames must be less than 33 characters long, lowercase letters and numbers only.");
		}
	}
	
	@Override
	public Login getLogin(String username, String password) throws BusinessException { // checks to see if the Login is in the db
		if (isValidUsername(username)) {
			return dao.getLogin(username,password);
		} else {
			throw new BusinessException("The username " + username + " is invalid. Usernames must be less than 33 characters long, lowercase letters and numbers only.");
		}
	}
	
	@Override
	public boolean isValidLogin(Login login) throws BusinessException {
		if (isValidUsername(login.getUsername())) {
			if (getLogin(login.getUsername(),login.getPassword()) != null) {
				return true;
			} else {
				throw new BusinessException("Login does not exist.");
			}
		} else {
			throw new BusinessException("The username " + login.getUsername() + " associated with this account is invalid. Please contact your SYSADMIN for help.");
		}
	}

	@Override
	public List<Account> accountListByLogin(Login login) throws BusinessException {
		if (isValidUsername(login.getUsername())) {
			if (isValidLogin(login)) {
				return dao.getAccountList(login);
			} else {
				throw new BusinessException("Cannot access the accounts of an invalid login.");
			}
		} else {
			throw new BusinessException("The username " + login.getUsername() + " associated with this account is invalid. Please contact your SYSADMIN for help.");
		}
	}

	@Override
	public Account getAccountByNumber(long accountNumber) throws BusinessException {
		if (((Long) accountNumber).toString().matches("[0-9]{10}")) {
			return dao.getAccount(accountNumber);
		} else {
			throw new BusinessException("Invalid Account Number format. Account Numbers should consist of 10 numbers.");
		}
	}

	@Override
	public Account makeAccount(Login login, int balance) throws BusinessException {
		if (balance < 0) {
			throw new BusinessException("You cannot create an account with a negative balance.");
		}
		Account res = new Account();
		if (isValidUsername(login.getUsername())) {
			if (isValidLogin(login)) {
				Account account = new Account(login.getUsername(), balance);
				res = dao.insertAccount(account);
			} else {
				throw new BusinessException("You cannot create a bank account for an invalid login.");
			}
		} else {
			throw new BusinessException("The username " + login.getUsername() + " associated with this account is invalid. Please contact your SYSADMIN for help.");
		}
		return res;
	}



	@Override
	public void makeLoginRequest(String username, String password) throws BusinessException { // signup
		if (isValidUsername(username)) {
			Login res = new Login(username, password, 0);
			dao.insertLogin(res);
		} else {
			throw new BusinessException("The username " + username + " is invalid. Usernames must be less than 33 characters long, lowercase letters and numbers only.");
		}
	}

	@Override
	public List<Login> listLoginsActive() throws BusinessException {
		return dao.getLoginList(1);
	}

	@Override
	public List<Login> listLoginsInactive() throws BusinessException {
		return dao.getLoginList(0);
	}
	
	@Override
	public Set<String> listUsernames() throws BusinessException {
		return dao.getUsernameList();
	}
	
	@Override
	public void updateLoginRequest(Login login, int status) throws BusinessException {
		if (isValidUsername(login.getUsername())) {
			if (isValidLogin(login)) {
				dao.updateLoginStatus(login, status);
			} else {
				throw new BusinessException("The login with username " + login.getUsername() + " either does not exist or has an incorrect password.");
			}
		} else {
			throw new BusinessException("The username " + login.getUsername() + " associated with this account is invalid. Please contact your SYSADMIN for help.");
		}
	}
	
	@Override
	public void deleteLogin(Login login) throws BusinessException {
		if (isValidUsername(login.getUsername())) {
			if (isValidLogin(login)) {
				dao.deleteLogin(login);
			} else {
				throw new BusinessException("The login with username " + login.getUsername() + " either does not exist or has an incorrect password.");
			}
		} else {
			throw new BusinessException("The username " + login.getUsername() + " associated with this account is invalid. Please contact your SYSADMIN for help.");
		}
	}

	@Override
	public List<Transaction> getTransactionList() throws BusinessException {
		return dao.getTransactionList();
	}



	@Override
	public void withdraw(Account account, int amount) throws BusinessException {
		if (amount < 0) {
			L.warn("Customer tried to withdraw a negative amount from a Bank Account.");
			throw new BusinessException("You cannot withdraw a negative amount.");
		}
		if (account.getBalance() >= amount) {
			dao.updateAccountAmount(account, account.getBalance() - amount);
		} else {
			L.warn("Customer tried to withdraw too much money.");
			throw new BusinessException("You are withdrawing too much money.");
		}
	}

	@Override
	public void deposit(Account account, int amount) throws BusinessException {
		if (amount < 0) {
			L.warn("Customer tried to deposit a negative amount to a Bank Account.");
			throw new BusinessException("You cannot deposit a negative amount.");
		}
		dao.updateAccountAmount(account, account.getBalance() + amount);
	}

	@Override
	public Transaction makeTransaction(Account to, Account from, int amount) throws BusinessException {
		if (amount < 0) {
			L.warn("Customer tried to withdraw a negative amount from a Bank Account.");
			throw new BusinessException("You cannot withdraw a negative amount.");
		}
		if (from.getBalance() >= amount) {
			Transaction t = dao.insertTransaction(new Transaction(to.getAccountNumber(), from.getAccountNumber(), amount));
			withdraw(from, amount);
			deposit(to, amount);
			return t;
		} else {
			L.warn("Customer tried to withdraw too much money.");
			throw new BusinessException("You are withdrawing too much money.");
		}
	}

	@Override
	public String accountListString(List<Account> accounts) throws BusinessException {
		if (accounts == null) {
			L.warn("Tried to convert a null list into a String");
			throw new BusinessException("Error, tried to interpret a list that doesn't exist");
		}
		StringBuilder res = new StringBuilder();
		int i = 1;
		for (Account a : accounts) {
			res.append(i++ + ".   " + a.toString() + "\n");
		}
		return res.toString();
	}

	@Override
	public String loginListString(List<Login> logins) throws BusinessException {
		if (logins == null) {
			L.warn("Tried to convert a null list into a String");
			throw new BusinessException("Error, tried to interpret a list that doesn't exist");
		}
		StringBuilder res = new StringBuilder();
		int i = 1;
		for (Login l : logins) {
			res.append(i++ + ".   " + l.toString() + "\n");
		}
		return res.toString();
	}

	@Override
	public String transactionListString(List<Transaction> transactions) throws BusinessException {
		if (transactions == null) {
			L.warn("Tried to convert a null list into a String");
			throw new BusinessException("Error, tried to interpret a list that doesn't exist");
		}
		StringBuilder res = new StringBuilder();
		int i = 1;
		for (Transaction t : transactions) {
			res.append(i++ + ".   " + t.toString() + "\n");
		}
		return res.toString();
	}
	
}