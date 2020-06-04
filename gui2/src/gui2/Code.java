/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Student
 */
public class Code {
    private ArrayList<Person> persons = new ArrayList<>();
    private int curr = -1;
    
   
    
    public Code(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"))) {
            persons = (ArrayList<Person>) objectInputStream.readObject();
            for (int i = 0; i < persons.size(); i++) {
                System.out.println(persons.get(i).getFirstName());
            }
            
            if(!persons.isEmpty()){
                curr = persons.size()-1;
            }
            
        } catch (Exception ex) {
             persons = new ArrayList<>();

        }
    }
    
    public void clear(HashMap<String, JTextField> textFields){
        String[] keys = {"First Name", "Last Name", "Age", "Record #" };
        for (String key : keys) {
            if(!key.equals("Record #")){
            textFields.get(key).setText("");
            } 
        }
        
    }
        
    public void save() throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(new FileOutputStream("person.txt"));
        objectOutputStream.writeObject(persons);
        objectOutputStream.close();


        
    }
    
    public void add(HashMap<String, JTextField> textFields){
        String fname = textFields.get("First Name").getText();
        String lname = textFields.get("Last Name").getText();
        int age = Integer.parseInt(textFields.get("Age").getText());
        int recordNumber = Integer.parseInt(textFields.get("Record #").getText());
        textFields.get("Record #").setText(""+ (recordNumber+1));
        persons.add(new Person(fname, lname, age, recordNumber));
        curr++;
        
    }
    
    public Person getCurrentPerson(){
        System.out.println(curr);
        return persons.get(curr);
    }

    
    public void previous(){
    curr = Math.max(0, curr-1);
}
    
    public void next(){
    curr = Math.min(persons.size()-1, curr + 1);
}
    
    public ArrayList<Person> getPersons() {
        return persons;
    }

    public int getCurr() {
        return curr;
    }
    
    public void saveEdit(HashMap<String, JTextField>textFields) throws IOException, ClassNotFoundException{
        String fname = textFields.get("First Name").getText();
        String lname = textFields.get("Last Name").getText();
        int age = Integer.parseInt(textFields.get("Age").getText());
        if(curr!= -1){
        Person person = persons.get(curr);
        person.setFirstName(fname);
        person.setLastName(lname);
        person.setAge(age);
        save();
        }
        
        
        
    }
    
    public void delete(){
        if(curr!= -1){
            persons.remove(curr);
            previous();
        }
        if(persons.isEmpty()){
            curr= -1;
        }
    }
    
}
