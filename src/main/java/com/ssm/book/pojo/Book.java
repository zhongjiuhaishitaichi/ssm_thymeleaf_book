package com.ssm.book.pojo;

//图书
public class  Book {
    private Integer id ;
    private String bookImg ;
    private String bookName ;
    private Double price ;
    private String author ;
    private Integer saleCount ;
    private Integer bookCount ;
    private Integer bookStatus = 0 ;

    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookImg='" + bookImg + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", saleCount=" + saleCount +
                ", bookCount=" + bookCount +
                ", bookStatus=" + bookStatus +
                '}';
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

}
