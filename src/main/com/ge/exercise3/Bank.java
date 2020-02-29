package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
        getAccount(accountNumber).withdraw(amount);
    }

    public int numAccounts() {
        return accountMap.size();
    }
    
    /**
     * The method returns sum of balances of all the accounts in the bank.
     * @return
     */
    public double sumOfCurrentHoldings() {
    	double sum = 0;
    	
    	for(Account account : accountMap.values())
    		sum += account.getBalance();
    	
    	return sum;
    }
    
    /**
     * The method projects profit for the bank in the next month considering the current account holding.
     * Note : If there is loss, the return value will be negative with loss amount as absolute value.
     * @return The profit / loss (if amount is negative) amount.
     */
    public double projectNextMonthProfit() {
    	double profitAmount = 0.0;
    	
    	for(Account account : accountMap.values())
    		profitAmount += (account.valueNextMonth() - account.getBalance());
    	
    	return profitAmount;
    }
}
