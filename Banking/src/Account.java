/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tidus
 */
import java.util.ArrayList;
abstract class Account  {
    
 private String AccountNumber;
 private double Balance;
 private Customer cus;
 protected ArrayList<Transaction> savinginformation;
 
 public Account(){

 }  // My default constructor 
 
  public Account (String AccountN, double Bal,Customer cust){
    
    this.AccountNumber= AccountN;
    this.Balance= Bal;
    this.cus= cust;
    savinginformation= new ArrayList<>();
    
    
}
  
 
 
    public abstract void deposit(double amount);
    
    public abstract void withdraw(double amount); 
  
  
  public String getAccountN(){
  
  return this.AccountNumber;
  
  }
  
  public void setAccountN(String AccountN){
  
  this.AccountNumber= AccountN;
  
  }
  
  public double GetBalance(){
  
    return this.Balance;  
  
  }
  public void SetBalance(double Bal){
  
      this.Balance= Bal;
  }
 

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public ArrayList<Transaction> getSavinginformation() {
        return savinginformation;
    }

    public void setSavinginformation(ArrayList<Transaction> savinginformation) {
        this.savinginformation = savinginformation;
    }
    
 
 
 @Override
 public String toString(){
 
 
 return("" + cus +"Account Number: " +AccountNumber+ "Balance: " +Balance + "Transactions: " + savinginformation);
 }
}
