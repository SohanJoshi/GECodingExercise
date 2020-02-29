package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", AccountType.CHECKING, 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", AccountType.CHECKING, 100.0f);
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("0041", AccountType.CHECKING, 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("0041", 100.0f);
        assertEquals(0.0f, account.getBalance(), 0.01);
        
        account = new Account("0042", AccountType.CHECKING, 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("0042", 300.0f);
        assertEquals(100.0f, account.getBalance(), 0.01);
        
        account = new Account("0043", AccountType.SAVINGS, 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("0043", 101.0f);
        assertEquals(100.0f, account.getBalance(), 0.01);
    }
    
    @Test
    public void sumOfCurrentHoldingsTest() {
    	Account account1 = new Account("0051", AccountType.CHECKING, 100.0f);
        bank.addAccount(account1);
        Account account2 = new Account("0052", AccountType.CHECKING, 140.0f);
        bank.addAccount(account2);
        bank.depositToAccount("0052", 100.0f);
        Account account3 = new Account("0053", AccountType.SAVINGS, 360.0f);
        bank.addAccount(account3);
        bank.withdrawFromAccount("0053", 35.0f);
        
        assertEquals(665.0f, bank.sumOfCurrentHoldings(), 0.01);
    }
    
    @Test
    public void projectNextMonthProfitTest() {
    	Account account1 = new Account("0061", AccountType.CHECKING, 100.0f);
        bank.addAccount(account1);
        Account account2 = new Account("0062", AccountType.CHECKING, 140.0f);
        bank.addAccount(account2);
        bank.depositToAccount("0062", 100.0f);
        Account account3 = new Account("0063", AccountType.SAVINGS, 360.0f);
        bank.addAccount(account3);
        bank.withdrawFromAccount("0063", 35.0f);
        
        assertEquals(3.25f, bank.projectNextMonthProfit(), 0.01);
    }
}