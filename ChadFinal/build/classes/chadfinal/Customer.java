/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chadfinal;

/**
 *
 * @author Chad
 */
public class Customer {
    private String FName;
    private String LName;
    private String address;
    private String email;
    private String tel_contact;
    static int num_customer = 0;


public Customer(String FName, String LName, String address, String email, String tel_contact){
this.FName = FName;
this.LName = LName;
this.address = address;
this.email = email;
this.tel_contact = tel_contact;
num_customer++;
}
//Getters and Setters
public String getFName()
{
    return FName;
}

public void setFName(String FName)
{
    this.FName = FName;
}

public String getLName()
{
    return LName;
}

public void setLName(String LName)
{
    this.LName = LName;
}

public String getaddress()
{
    return address;
}

public void setaddress(String adress)
{
    this.address = address;
}

public String getemail()
{
    return email;
}

public void setemail(String email)
{
    this.email = email;
}

public String gettel_contact()
{
    return tel_contact;
}

public void settel_contact(String tel_contact)
{
    this.tel_contact = tel_contact;
}

    @Override
    public String toString() {
        return "Customer{" + "FName=" + FName + ", LName=" + LName + ", address=" + address + ", email=" + email + ", tel_contact=" + tel_contact + '}';
    }



}
