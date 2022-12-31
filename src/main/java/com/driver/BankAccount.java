package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    public String Account="";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

   public void count(String ans,int digit,int sum){
        if(Account.equals("")==false){
            return;
        }
        if(digit>0&&sum>0){
            char a = '0';
            if(ans.equals("")){
                a='1';
            }
            while (a<='9'){
                count(ans+a,digit-1,sum-(a-'0'));
                a++;
            }
        }
        else if(digit==0&&sum==0){
            Account = ans;
            return;
        }
   }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        count("",digits,sum);
        if(Account.length()!=digits){
            throw new Exception("Account Number can not be generated") ;
        }
        return Account;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
      if(balance>=amount){ balance-=amount;}
      if(minBalance>balance){
            throw new Exception("Insufficient Balance");
        }
    }
}