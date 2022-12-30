package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        SavingsAccount s = new SavingsAccount("Azmat",500,500,0.30);
        System.out.println(s.getSimpleInterest(10));
      s.withdraw(600);
    }
}