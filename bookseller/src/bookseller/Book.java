/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookseller;

/**
 *
 * @author Rodrigo
 */
public class Book {

    private String author;
    private String title;
    private String category;
    private double unitCost;
    private double sellingPrice;
    private int quantitySold;
    private int quantityInStock;
    private int reorderLevel;
    private int ISBN;
    private String countryOfOrigin;

    public Book(String author, String title, String category, double unitCost, double sellingPrice, int quantitySold, int quantityInStock, int reorderLevel, int ISBN, String countryOfOrigin) {
        this.author = author;
        this.title = title;
        this.category = category;
        this.unitCost = unitCost;
        this.sellingPrice = sellingPrice;
        this.quantitySold = quantitySold;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = reorderLevel;
        this.ISBN = ISBN;
        this.countryOfOrigin = countryOfOrigin;
    }

    public void add(int amount){
        quantityInStock+=amount;
    }
        
    public void add(){
        quantityInStock++;
    }
    
    public void sell(int amount){
        quantityInStock-= amount;
        quantitySold+= amount;
    }
    
    public double computeProfit(){
        double costPrice = quantitySold*unitCost;
        double profit = computeGross()-costPrice;
       
        
        return profit;
    }
     
    public double computeGross(){
        return quantitySold*sellingPrice;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQauntitySold() {
        return quantitySold;
    }

    public void setQauntitySold(int qauntitySold) {
        this.quantitySold = qauntitySold;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public int compareTo(Book b){
        if(this.ISBN > b.getISBN()){
            return 1;
        }
        else if(this.ISBN < b.getISBN()){
            return -1;
        }
        
        return 0;
    }
        
    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", title=" + title + ", category=" + category + ", unitCost=" + unitCost + ", sellingPrice=" + sellingPrice + ", quantitySold=" + quantitySold + ", quantityInStock=" + quantityInStock + ", reorderLevel=" + reorderLevel + ", ISBN=" + ISBN + ", countryOfOrigin=" + countryOfOrigin + '}';
    }
    
    

}
