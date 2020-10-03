/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chadfinal;

import java.util.ArrayList;

/**
 *
 * @author Chad
 */
public abstract class Account {
    private Customer customer;
    private int acc_num;
    private double balance;
    static int num_acc=0;
    protected ArrayList<Transaction> transaction= new ArrayList<>();

  public Account(Customer customer, int acc_num, double balance){
        this.customer = customer;
        this.acc_num = acc_num;
        this.balance = balance;
        num_acc++;
    }
    
    //Getters and Setters
    public Customer getcustomer(){
        return customer;
    }
   
    
  
    public void setcustomer(Customer customer){
        this.customer = customer;
    }
    
    
   
    public int getacc_num(){
      return acc_num;  
    }
    
    
  
    public void setacc_num(int acc_num){
       this.acc_num = acc_num; 
    }
    
     
    
    public double getbalance(){
        return balance;
    }
   
    
  
    public void setbalance(double balance){
        this.balance = balance;
    }
    
   
    public abstract void deposit(double amountt);
    
    public abstract void withdraw(double amount);  

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transaction = transactions;
    }
    
    
    public Transaction lastTrans(){
        return transaction.get(transaction.size()-1);
    }
    
     public void addTransaction(Transaction transaction) {
         transaction.add(transaction);
    }
    //String toString format
    
     @Override
    public String toString() {
        return "Account{" + "customer=" + customer + ", acc_num=" + acc_num + ", balance=" + balance + '}';
    }
}
