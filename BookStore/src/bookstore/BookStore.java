
package bookstore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;



public class BookStore {

    String filename;
    ArrayList<Book> inventory = new ArrayList();
    ArrayList<String> categories = new ArrayList();

    public void readFile(String filename) {
        BufferedReader inputFile;
        Scanner lineInput;

        String category = "";
        String author = "";
        String title = "";
        String isbn = "";
        String country = "";
        float costPrice = 0, sellingPrice;
        int quantityStock = 0, quantitySold = 0, reorderLevel = 0;

        try {
            inputFile = new BufferedReader(new FileReader(filename));

            String line;
            boolean stop = false;
            while (((line = inputFile.readLine()) != null) && (stop == false)) {

                if (line.toLowerCase().contains("category:") == true && line.contains("xxxx") == true) {
                    stop = true;
                } else {
                    if (line.toLowerCase().startsWith("category:") == true && line.toLowerCase().contains("xxxx") == false) {
                        category = line.substring(line.indexOf("'"), line.lastIndexOf("'")).trim();
                    } else if (line.startsWith("'") == true) {
                        boolean c = false;
                        String str[] = line.split("'");
                        author = str[1];
                        title = str[3];
                        Scanner scanner = new Scanner(str[4]);
                        costPrice = scanner.nextFloat();
                        sellingPrice = scanner.nextFloat();
                        quantitySold = scanner.nextInt();
                        quantityStock = scanner.nextInt();
                        reorderLevel = scanner.nextInt();
                        isbn = scanner.next();
                        country = scanner.next();
                        
                        Book book = new Book (author, title, category, isbn, country, quantitySold, quantityStock, reorderLevel, costPrice, sellingPrice);
                        inventory.add(book);
                        
                        for (int i = 0; i < categories.size(); i++) {
                           if(categories.get(i).equalsIgnoreCase(category)){
                               c = true;
                           } 
                        }
                        if(!c){
                            categories.add(category);
                        }
                        
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayInventory ()
    {
        
        
        for (String category : categories) {
            System.out.println("");
            System.out.printf("|%-16s|%-32s|%-10s|%-10s|%-10s|%-10s|%-10s|\n","Category: ", category, "Cost Price", "Sell Price", "Amt Sold", "Ext Cost", "Ext Sell", "Profit");
            for (Book b : inventory) {
                if(b.category.equalsIgnoreCase(category))
                    System.out.println(b);
            }
        }
    }
    
    public static void main(String[] args) {
        BookStore bookStore = new BookStore ();
        bookStore.readFile("input1.txt");
        bookStore.displayInventory();
    }

}
