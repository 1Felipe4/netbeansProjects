/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui1;

import java.io.Serializable;

/**
 *
 * @author Student
 */
public class Person implements Serializable{

    
    private String firstName;
    private String lastName;
    private int age;
    private int recordNumber = 0;

    public Person(String firstName, String lastName, int age, int recordNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.recordNumber = recordNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getRecordNumber() {
        return recordNumber;
    }

   
    
    
    
}
