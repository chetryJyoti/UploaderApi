package com.moreOpp.dataUploader.UploaderApi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private  Integer BookId;

    private  String Title;

    private  String Price;

    private  String Availability;

    public Book(Integer bookId, String title, String price, String availability) {
        BookId = bookId;
        Title = title;
        Price = price;
        Availability = availability;
    }

    public Book() {
    }

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }
}
