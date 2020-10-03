/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chadfinal;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Chad
 */
public class ChadFinal extends Application {
    static private Stage stage;
    static private ArrayList<Account> accounts = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        
   
        //Set Title
        primaryStage.setTitle("Chad");
        //Make Gloabl
        this.stage = primaryStage;
        //Set Menu Scene
        menu();
        //Css
        stage.getScene().getStylesheets().add(ChadFinal.class.getResource("final.css").toExternalForm());
        //Show GUI
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        launch(args);
    }
    
   public static void menu(){
    //Layout
    GridPane menu = new GridPane();
    
    //Make Buttons
    Button open = new Button("Open Account");
    Button deposit = new Button("Deposit");
    Button withdraw = new Button("Withdraw");
    Button pay = new Button("Pay Interest");
    Button trans = new Button("Transaction");
    Button quit = new Button("Quit");
    
    //Format Buttons
    open.setPrefSize(200, 75);
    deposit.setPrefSize(200, 75);
    withdraw.setPrefSize(200, 75);
    pay.setPrefSize(200, 75);
    trans.setPrefSize(200, 75);
    quit.setPrefSize(200, 75);
    //Add Buttons To Layout
    menu.add(open, 0, 0);
    menu.add(deposit, 1, 0);
    menu.add(withdraw, 0,1);
    menu.add(pay,1,1);
    menu.add(trans,2,0);
    menu.add(quit,2,1);
    //Add Events
    open.setOnAction((ActionEvent event)->{
        open();
    });
    deposit.setOnAction((ActionEvent event)->{
        deposit();
    });
    
    withdraw.setOnAction((ActionEvent event)->{
        withdraw();
    });
    
    pay.setOnAction((ActionEvent event)->{
        payInterest();
    });
    
    trans.setOnAction((ActionEvent event)->{
      displayTrans(); 
   });
    //Change Scene
    Scene scene = new Scene(menu, 300, 400);
    stage.setScene(scene);
    }
   
   public static void open(){
      //Layout
      GridPane open = new GridPane(); 
      //Labels
      Label FName = new Label("First Name");
      Label LName = new Label("Last Name");
      Label address = new Label("Address");
      Label email = new Label("Email");
      Label tel_contact = new Label("Telephone Contact");
      Label acc_num = new Label("Account Number");
      Label balance = new Label("Balance");
      Label o_i = new Label("Interest Rate");
      Label acc_type = new Label("Change Account Type To: ");
      
      
      //TextFields
      
      TextField FNameTxt = new TextField();
      TextField LNameTxt  = new TextField();
      TextField addressTxt = new TextField();
      TextField emailTxt = new TextField();
      TextField tel_contactTxt = new TextField();
      TextField acc_numTxt = new TextField();
      TextField balanceTxt = new TextField();
      TextField o_iTxt = new TextField();
      
      
      //Buttons
      Button change = new Button("Chequing");
      Button add = new Button ("Add");
      Button cancel = new Button ("Cancel");
      
      //Events
      change.setOnAction((ActionEvent event) ->{
          if(change.getText().equals("Chequing")){
              o_i.setText("Overdraft");
              change.setText("Savings");
          }else{
              o_i.setText("Interest Rate");
              change.setText("Chequing");
          }
      });
      
      cancel.setOnAction((ActionEvent event)->{
          menu();
      });
      
      add.setOnAction((ActionEvent event)->{
          convert(FNameTxt, LNameTxt, addressTxt, emailTxt, tel_contactTxt, acc_numTxt, balanceTxt, o_iTxt, change);
      });
      
      //Add To Layout
      open.add(FName,0,0);
      open.add(FNameTxt,1,0);
      open.add(LName, 0, 1);
      open.add(LNameTxt, 1, 1);
      open.add(address, 0, 2);
      open.add(addressTxt, 1, 2);
      open.add(tel_contact, 0, 4);
      open.add(tel_contactTxt, 1, 4);
      open.add(email, 0,3);
      open.add(emailTxt, 1, 3);
      open.add(acc_num, 0, 5);
      open.add(acc_numTxt, 1, 5);
      open.add(balance, 0, 6);      
      open.add(balanceTxt, 1, 6);
      open.add(o_i, 0, 7);
      open.add(o_iTxt,1,7);
      open.add(acc_type, 0, 8);
      open.add(change, 1, 8);
      open.add(cancel, 0, 9);
      open.add(add, 1, 9);

      
      
      
      //Change Scene
      Scene scene = new Scene(open, 300, 400);
      stage.setScene(scene);
   }
   
   public static void transaction(char type, int acc_num, double amt){
       //Find Account
       int acc = findAcc(acc_num);
       
       if(acc!=-1){//If Account Found
           
       if(type == 'd'){//If Deposit Type
           System.out.println(accounts.get(acc).getbalance());
           accounts.get(acc).deposit(amt);//Deposit To Found Account
           System.out.println(accounts.get(acc).getbalance());
       }else if(type == 'w'){//If Withdrawl
           accounts.get(acc).withdraw(amt);//Withdraw Type
       }
       }
   }
   
   public static void deposit(){
       //Layout
       GridPane deposit = new GridPane();
       
       //TextFields
       TextField acc_num = new TextField();
       TextField amt = new TextField();
       Button cancel = new Button ("Cancel");
       Button dep = new Button ("Deposit");
        //Add to
       deposit.add(new Label("Account Number: "), 0, 0);
       deposit.add(acc_num, 1, 0);
       deposit.add(new Label("Amount: "), 0, 1);
       deposit.add(amt, 1, 1);
       deposit.add(cancel, 0,2);
       deposit.add(dep,1,2);
       
       //Events
       cancel.setOnAction((ActionEvent event)->{
       menu();
       });
       dep.setOnAction((ActionEvent event)->{
        double a = Double.parseDouble(amt.getText());
        int acc = Integer.parseInt(acc_num.getText());
        transaction('d', acc, a);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);//Create Alert
            alert.setTitle("Deposit");//Set Alert Title 
            alert.setHeaderText("Savings Account Created");//Edit Alert
            alert.setContentText(amt.getText() + " was deposited to " + acc );
            alert.showAndWait();//Alert User
       });
       stage.getScene().setRoot(deposit);
   }
   
    public static void withdraw(){
       //Layout
       GridPane withdraw = new GridPane();
       
       //TextFields
       TextField acc_num = new TextField();
       TextField amt = new TextField();
       Button cancel = new Button ("Cancel");
       Button w = new Button ("Withdraw");
        //Add to
       withdraw.add(new Label("Account Number: "), 0, 0);
       withdraw.add(acc_num, 1, 0);
       withdraw.add(new Label("Amount: "), 0, 1);
       withdraw.add(amt, 1, 1);
       withdraw.add(cancel, 0,2);
       withdraw.add(w,1,2);
       
       //Events
       cancel.setOnAction((ActionEvent event)->{
       menu();
       });
       w.setOnAction((ActionEvent event)->{
        double a = Double.parseDouble(amt.getText());
        int acc = Integer.parseInt(acc_num.getText());
        transaction('d', acc, a);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);//Create Alert
            alert.setTitle("Withdraw");//Set Alert Title 
            alert.setHeaderText("Savings Account Created");//Edit Alert
            alert.setContentText(amt.getText() + " was withdrawn from " + acc );
            alert.showAndWait();//Alert User
       });
       stage.getScene().setRoot(withdraw);
   }
    
    public static void payInterest(){
       //Layout
        
        for(int i = 0; i< accounts.size(); i++){//Traverse
            if(accounts.get(i) instanceof Saving){//If Saviings
                    Saving s = (Saving) accounts.get(i);//Convert
                    s.payInterest();//Pay
                    accounts.set(i, s);//Revert
            }
            }
   }
    
    public static void displayTrans(){
        //Layout
        GridPane grid = new GridPane();
        
        for(int i = 0;i< Transaction.all.size();i++){//Traverse
            Text t = new Text(Transaction.all.get(i).toString());//GUI Format
            grid.add(t, 0, i);//Add
        }
        
       
        Button done = new Button("Done");//Button
        
        done.setOnAction((ActionEvent event)->{//Event
         menu();
            
    });
        grid.add(done,0,Transaction.all.size());//Add Button
            
        stage.getScene().setRoot(grid);//Change Scene Root
    }
   
   public static int findAcc(int acc_num){
       for(int i = 0; i< accounts.size();i++){
           if(accounts.get(i).getacc_num() == acc_num){
               return i;
           }
       }
       return -1;
   }
    
   public static void convert(TextField FName, TextField LName, TextField address,
           TextField email,TextField tel_contact, TextField acc_num, TextField balance, TextField o_i, Button acc_type){
       
       Customer c = new Customer(FName.getText(), LName.getText(),address.getText(), email.getText(), tel_contact.getText());
       int acc_n = Integer.parseInt(acc_num.getText());
       double bal = Double.parseDouble(balance.getText());
       double od_ir = Double.parseDouble(o_i.getText());
       if(acc_type.getText().equals("Savings")){
           accounts.add(new Chequing(acc_n, bal,c, od_ir));
           System.out.println(accounts.get(accounts.size()-1));
       }else{
           accounts.add(new Saving(acc_n, bal, c, od_ir));
       }
       
       menu();
   } 
}


