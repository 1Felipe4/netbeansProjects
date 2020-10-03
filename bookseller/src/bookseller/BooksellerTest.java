/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookseller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rodrigo
 */
public class BooksellerTest {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String check = "";
        do {
            System.out.println("\nMain Menu"
                    + "\nPress 0 To Exit | Press 1 To Add A Title | Press 2 To Manage A Title ");
            check = in.nextLine();
            switch (check) {
              case "0": ;
              break;
              case "1": addTitle();
              break; 
              case "2": manageTitle();    
              break;   
              default: System.out.println("Invalid Command");    
            }
        } while (!check.equals("0"));

    }

    public static void addTitle() {
        String author;
        String title;
        String category;
        double unitCost;
        double sellingPrice;
        int quantitySold;
        int quantityInStock;
        int reorderLevel;
        int ISBN;
        String countryOfOrigin;

        System.out.print("Author: ");
        author = in.nextLine();
        System.out.print("Title: ");
        title = in.nextLine();
        System.out.print("Category: ");
        category = in.nextLine();
        System.out.print("Unit Cost: ");
        unitCost = in.nextInt(); in.nextLine();
        System.out.print("Selling Price: ");
        sellingPrice = in.nextInt(); in.nextLine();
        System.out.print("Quantity Sold: ");
        quantitySold = in.nextInt(); in.nextLine();
        System.out.print("Quantity In Stock: ");
        quantityInStock = in.nextInt();  in.nextLine();
        System.out.print("Reorder Level: ");
        reorderLevel = in.nextInt(); in.nextLine();
        System.out.print("ISBN: ");
        ISBN = in.nextInt(); in.nextLine();
        System.out.print("Country Of Origin: ");
        countryOfOrigin = in.nextLine();

        books.add(
                new Book(author, title, category, unitCost, sellingPrice,
                        quantitySold,quantityInStock, reorderLevel, ISBN,
                        countryOfOrigin));



    }
    
    public static void manageTitle(){
        System.out.print("Please enter ISBN of the book you wish to manage: ");
        int find = in.nextInt(); in.nextLine();
        int id = searchByISBN(find);
        String check;
        if(id!= -1){
            Book current = books.get(id);
            do{
                System.out.println("\nManage " + current.getTitle()
                + "\nPress 0 to go back to Main Menu | Press 1 to add units to stock | Press 2 to sell units | Press 3 to view Financial Calculations | Press 4 To See Book Info");
                check = in.nextLine();
                switch(check){
                    case "0": ;
                        break;
                    case "1": System.out.print("Number of Units Added: ");
                              current.add(in.nextInt()); in.nextLine();
                              break;
                    case "2": System.out.print("Amount of Units Sold: ");
                              current.add(in.nextInt()); in.nextLine();
                              break;
                    case "3": System.out.print("Gross Sales: $"); System.out.printf("%5.2f"  , current.computeGross());
                              System.out.print("Profit: $"); System.out.printf("%5.2f"  , current.computeProfit());
                              break;
                    case "4": System.out.println(current);
                        break;
                    default: System.out.println("Invalid Command");    
                              
                }
                
                
            }while(!check.equals("0"));
        }
        else{System.out.println("Title Not Found");}
        
    }

    public static int searchByISBN(int ISBN){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getISBN() == ISBN){
                return i;
            }

        }
        return-1;
    }

}
