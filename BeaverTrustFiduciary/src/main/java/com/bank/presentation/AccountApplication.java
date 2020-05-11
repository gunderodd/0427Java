package com.bank.presentation;

import com.bank.main.Main;
import com.bank.models.User;
import com.bank.service_implementation.AccountServiceImplementation;
import com.bank.tools.BankException;
import com.bank.tools.QuitOption;

public class AccountApplication {
	
	public static void apply(User user) throws BankException {
		AccountServiceImplementation aci = new AccountServiceImplementation();
		String accountName;
		String initialDeposit;
	
		// maybe use this?
//		if (accountName.equalsIgnoreCase("quit") || initialDeposit.toString().equalsIgnoreCase("quit")) {
//			QuitOption.quit();
//		} else {
		
		Main.myLog.info("\n");
		Main.myLog.info("Create a new bank account.");
		Main.myLog.info("What would you like to name your new account?");
		accountName = Main.scan.nextLine();
		Main.myLog.info("How much will you be depositing as your starting balance?");
		initialDeposit = Main.scan.nextLine().toString();
		
//		// unacceptable deposit
//		if (initialDeposit)
		
		try {
			aci.createAccount(user, accountName, initialDeposit);
			Main.myLog.info("Your new account, " + accountName + ", has been added.");
			Main.myLog.info(".................................");
			UserHomeView.userWelcome(user);
		} catch (NumberFormatException e) {
			Main.myLog.error(e);
//			throw new BankException("Deposit entered in incorrect format. Please try again.");
			Main.myLog.info("Deposit entered in incorrect format. Please try again.");
			apply(user);
		}
		
	}
}
