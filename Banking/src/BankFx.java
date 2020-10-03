/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 * @author Tidus
 */

public class BankFx extends Application {
    static private Stage globalStage;
    static private ArrayList<Account> accounts = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
             primaryStage.setTitle("Tidus");

        
              this.globalStage = primaryStage;
        menu();
        globalStage.show();
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
    Button pay = new Button("Pay Intrest");
    Button trans = new Button("Transaction");
    Button quit = new Button("Quit");
    
    //Format Buttons
    open.setPrefSize(200, 100);
    deposit.setPrefSize(200, 100);
    withdraw.setPrefSize(200, 100);
    pay.setPrefSize(200, 100);
    trans.setPrefSize(200, 100);
    quit.setPrefSize(200, 100);
    
//Add Buttons To Layout
    menu.add(open, 0, 0);
     menu.add(deposit, 1, 0);
     menu.add(withdraw, 0,1);
     menu.add(pay,1,1);
     menu.add(trans,0,2);
    menu.add(quit,1,2);
    


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
    Scene scene = new Scene(menu, 400, 400);
    globalStage.setScene(scene);
    }
   
   public static void open(){
      //Layout
      GridPane open = new GridPane(); 
      //Labels
      Label FirstName = new Label("First Name");
      Label LastName = new Label("Last Name");
      Label Address = new Label("Address");
      Label Email = new Label("Email");
      Label PhoneContact = new Label("Telephone Contact");
      Label accountN = new Label("Account Number");
      Label balance = new Label("Balance");
      Label other = new Label("Interest Rate");
      Label acc_type = new Label("Change Account Type To: ");
      
      
      //TextFields
      
      TextField FirstNameTxt = new TextField();
      TextField LastNameTxt  = new TextField();
      TextField AddressTxt = new TextField();
      TextField EmailTxt = new TextField();
      TextField PhoneContactTxt = new TextField();
      TextField accountNTxt = new TextField();
      TextField balanceTxt = new TextField();
      TextField otherTxt = new TextField();
      
      
      //Buttons
      Button type = new Button("Chequing");
      Button add = new Button ("Add");
      Button cancel = new Button ("Cancel");
      
      //Events
      type.setOnAction((ActionEvent event) ->{
          if(type.getText().equals("Chequing Account")){
              other.setText("Overdraft");
              type.setText("Savings Account");
          }else{
              other.setText("Interest Rate");
              type.setText("Chequing");
          }
      });
      
      cancel.setOnAction((ActionEvent event)->{
          menu();
      });
      
      add.setOnAction((ActionEvent event)->{
          addAcc(FirstNameTxt, LastNameTxt, AddressTxt, EmailTxt, PhoneContactTxt, accountNTxt, balanceTxt, otherTxt, type);
      });
      
      //Add To Layout
      open.add(FirstName,0,0);
      open.add(FirstNameTxt,1,0);
      open.add(LastName, 0, 1);
      open.add(LastNameTxt, 1, 1);
      open.add(Address, 0, 2);
      open.add(AddressTxt, 1, 2);
      open.add(PhoneContact, 0, 4);
      open.add(PhoneContactTxt, 1, 4);
      open.add(Email, 0,3);
      open.add(EmailTxt, 1, 3);
      open.add(accountN, 0, 5);
      open.add(accountNTxt, 1, 5);
      open.add(balance, 0, 6);      
      open.add(balanceTxt, 1, 6);
      open.add(other, 0, 7);
      open.add(otherTxt,1,7);
      open.add(acc_type, 0, 8);
      open.add(type, 1, 8);
      open.add(cancel, 0, 9);
      open.add(add, 1, 9);

      
      
      
      //Change Scene
      Scene scene = new Scene(open, 400, 400);
      globalStage.setScene(scene);
   }
   
   public static void transaction(char type, String accountN, double amount){
       //Find Account
       int acc = findAcc(accountN);
       
       if(acc!=-1){//If Account Found
           
       if(type == 'd'){//If Deposit Type
           System.out.println(accounts.get(acc).GetBalance());
           accounts.get(acc).deposit(amount);//Deposit To Found Account
           System.out.println(accounts.get(acc).GetBalance());
       }else if(type == 'w'){//If Withdrawl
           accounts.get(acc).withdraw(amount);//Withdraw Type
       }
       }
   }
   
   public static void deposit(){
       //Layout
       GridPane deposit = new GridPane();
       
       //TextFields
       TextField accountN = new TextField();
       TextField amount = new TextField();
       Button cancel = new Button ("Cancel");
       Button dep = new Button ("Deposit");
        //Add to
       deposit.add(new Label("Account Number: "), 0, 0);
       deposit.add(accountN, 0, 1);
       deposit.add(new Label("Amount: "), 1, 0);
       deposit.add(amount, 1, 1);
       deposit.add(cancel, 0,2);
       deposit.add(dep,1,2);
       
       //Events
       cancel.setOnAction((ActionEvent event)->{
       menu();
       });
       dep.setOnAction((ActionEvent event)->{
        double a = Double.parseDouble(amount.getText());
        String acc = accountN.getText();
        transaction('d', acc, a);
           
       });
       globalStage.getScene().setRoot(deposit);
   }
   
    public static void withdraw(){
       //Layout
       GridPane withdraw = new GridPane();
       
       //TextFields
       TextField accountN = new TextField();
       TextField amount = new TextField();
       Button cancel = new Button ("Cancel");
       Button w = new Button ("Withdraw");
        //Add to
       withdraw.add(new Label("Account Number: "), 0, 0);
       withdraw.add(accountN, 0,1);
       withdraw.add(new Label("Amount: "), 1, 0);
       withdraw.add(amount, 1, 1);
       withdraw.add(cancel, 0,2);
       withdraw.add(w,1,2);
       
       //Events
       cancel.setOnAction((ActionEvent event)->{
       menu();
       });
       w.setOnAction((ActionEvent event)->{
        double a = Double.parseDouble(amount.getText());
        String acc = accountN.getText();
        transaction('d', acc, a);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);//Create Alert
            alert.setTitle("Withdraw");//Set Alert Title 
            alert.setHeaderText("SavingsAccounts Account Created");//Edit Alert
            alert.setContentText(amount.getText() + " was withdrawn from " + acc );
            alert.showAndWait();//Alert User
       });
       globalStage.getScene().setRoot(withdraw);
   }
    
    public static void payInterest(){
       //Layout
        
        for(int i = 0; i< accounts.size(); i++){//Traverse
            if(accounts.get(i) instanceof SavingsAccount){//If Saviings
                    SavingsAccount savings = (SavingsAccount) accounts.get(i);//Convert
                    savings.payInterest();//Pay
                    accounts.set(i, savings);//Revert
            }
            }
   }
    
    public static void displayTrans(){
        //Layout
        GridPane grid = new GridPane();
        
        for(int i = 0;i< Transaction.t.size();i++){//Traverse
            Text t = new Text(Transaction.t.get(i).toString());//GUI Format
            grid.add(t, 0, i);//Add
        }
        
       
        Button done = new Button("Done");//Button
        
        done.setOnAction((ActionEvent event)->{//Event
         menu();
            
    });
        grid.add(done,0,Transaction.t.size());//Add Button
            
        globalStage.getScene().setRoot(grid);//Change Scene Root
    }
   
   public static int findAcc(String accountN){
       for(int i = 0; i< accounts.size();i++){
           if(accounts.get(i).getAccountN().equals(accountN)){
               return i;
           }
       }
       return -1;
   }
    
   public static void addAcc(TextField FirstName, TextField LastName, TextField Address, TextField Email,TextField PhoneContact, TextField accountN, TextField balance, TextField other, Button acc_type){
       
       Customer c = new Customer(FirstName.getText(), LastName.getText(),Address.getText(), Email.getText(), Integer.parseInt(PhoneContact.getText()));
       String account = accountN.getText();
       double bal = Double.parseDouble(balance.getText());
       double od_ir = Double.parseDouble(other.getText());
       if(acc_type.getText().equals("SavingsAccounts")){
           accounts.add(new ChequingAccount(account, bal,c, od_ir));
           System.out.println(accounts.get(accounts.size()-1));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);//Create Alert
            alert.setTitle("Add Account");//Set Alert Title 
            alert.setHeaderText("Chequing Account Created");//Edit Alert
            alert.setContentText("Thank You");
            alert.showAndWait();//Alert User
       }else{
           accounts.add(new SavingsAccount(account, bal, c, od_ir));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);//Create Alert
            alert.setTitle("Add Account");//Set Alert Title 
            alert.setHeaderText("Savings Account Created");//Edit Alert
            alert.setContentText("Thank You");
            alert.showAndWait();//Alert User
       }
       
       menu();
   } 
}


