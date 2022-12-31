package com.driver;

public class SavingsAccount extends BankAccount{
    private double rate;
    private double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount > maxWithdrawalLimit) {
            throw new Exception("\"Maximum Withdraw Limit Exceed\"");
        } else if (getBalance() < amount) {
            throw new Exception("Insufficient Balance");
        } else {
            double b = getBalance();
            b -= amount;
            setBalance(b);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        double i = (rate*years*getBalance());
        System.out.println(rate+" "+years+" "+getBalance());
        return i;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double i = (double) times*years;
        double j = (rate/times)+1;
        j = Math.pow(j,i);
        return j*getBalance();
    }

}
