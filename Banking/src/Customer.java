/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tidus
 */
public class Customer {
    private String FirstName;
    private String LastName;
    private String Address;
    private String Email;
    private int PhoneContact;
    
  
    public Customer(){
        
    
     
    
    
    }
    
    public Customer(String FName,String LName,String Address, String Email,int Contact){
    
    this.FirstName= FName;
    this.LastName= LName;
    this.Address= Address;
    this.Email= Email;
    this.PhoneContact= Contact;        
    
    
    
    
    
    }
  public String getFirstname(){
  
      return this.FirstName;
   }  
  
  public void setFirstName(String FName){
  
  this.FirstName=FName;
  }
    
     public String getLastName(){
  
      return this.LastName;
   }  
  
  public void setLastName(String LName){
  
  this.LastName= LName;
  } public String getAddress(){
  
      return this.Address;
   }  
  
  public void setAddress(String Address){
  
  this.Address= Address;
  }
  public String getEmail(){
  
  return this.Email;
  }
  public void SetEmail(String Email){
  
      this.Email =Email;
  
  }
  public int GetContact(){
  
  return this.PhoneContact;
  
  }
  public void SetContact(int Contact){
  
  this.PhoneContact= Contact;
  }
  
  
  public String toString(){
  
  return ("First Name: "+FirstName+"Last Name: "+ LastName+"Address: "+Address+"Email: "+Email+"Phone Number: " +PhoneContact);
  
  }
  
}
