/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
/**
 *
 * @author Tidus
 */import java.util.Date;
public class Transaction {
    
    private Date DATE;
    private char type;
    private double amount;
    private double balance;
    private String description;
    static ArrayList<Transaction> t = new ArrayList<>();
    
    
  public Transaction(){}
  
  public Transaction(Date date,char Type, double amount, double bal, String descrp){
  this.DATE= date;
  this.type= Type;
  this.amount=amount;
  this.balance= bal;
  this.description= descrp;
  
  
  
   t.add(this);
  
  }
  public Date getDate(){
  return this.DATE;
  }
  
  public void setDate(Date date){
  
  this.DATE= date;
  
  }
  public double getAmount(){
  
  return this.amount;
  
  
  }public void setAmount(double amount){
  
  this.amount=amount;
  
  }
  public double GetBalance(){
  
  return this.balance;
  }
  
  public void SetBalance(double bal){
  
  this.balance= bal;
  
  }
  
  public String getDescription(){
  
  return this.description;
  
  }
  public void setDescription(String descrp){}

    public void setType(char Type) {
        this.type = Type;
    }

    
    public char getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "DATE=" + DATE + ", type=" + type + ", amount=" + amount + ", balance=" + balance + ", description=" + description;
    }
  
    
}
