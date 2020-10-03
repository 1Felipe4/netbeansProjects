
package bookstore;

public class Book {
    
    String author, category, isbn, country, title;
    int qtySold, qtyStock, qtyReorder;
    float unitPrice, sellingPrice;
    
    public Book ()
    {
        this.author = "";
        this.title = "";
        this.category = "";
        this.isbn = "";
        this.country = "";
        this.qtySold = 0;
        this.qtyStock = 0;
        this.qtyReorder = 0;
        this.unitPrice = 0;
        this.sellingPrice = 0;    
    }

    public Book(String author, String title, String category, String isbn, String country, int qtySold, int qtyStock, int qtyReorder, float unitPrice, float sellingPrice) {
        this.author = author;
        this.title = title;
        this.category = category;
        this.isbn = isbn;
        this.country = country;
        this.qtySold = qtySold;
        this.qtyStock = qtyStock;
        this.qtyReorder = qtyReorder;
        this.unitPrice = unitPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQtySold() {
        return qtySold;
    }

    public void setQtySold(int qtySold) {
        this.qtySold = qtySold;
    }

    public int getQtyStock() {
        return qtyStock;
    }

    public void setQtyStock(int qtyStock) {
        this.qtyStock = qtyStock;
    }

    public int getQtyReorder() {
        return qtyReorder;
    }

    public void setQtyReorder(int qtyReorder) {
        this.qtyReorder = qtyReorder;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return String.format("|%-16s|%-32s|%-10d|%-10d|%-10d|$%-9.2f|$%-9.2f|",author,title, qtySold , qtyStock , qtyReorder ,  unitPrice , sellingPrice);
        
        //return author + " " + isbn + " " + country + " " + qtySold + " " + qtyStock + " " + qtyReorder + " " + unitPrice + " " + sellingPrice;
    }            
    
}
