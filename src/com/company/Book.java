package com.company;


public class Book {

    public Book(String id, String title, String author, String publisher, int publishYear, String categoryId, int cout) {
        Id = id;
        Title = title;
        Author = author;
        Publisher = publisher;
        PublishYear = publishYear;
        CategoryId = categoryId;
        Cout = cout;
    }

    private String Id;
    private String Title;
    private String Author;
    private String Publisher;
    private int PublishYear;
    private String CategoryId;

    public int getCout() {
        return Cout;
    }

    public void setCout(int cout) {
        Cout = cout;
    }

    private int Cout ;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getPublishYear() {
        return PublishYear;
    }

    public void setPublishYear(int publishYear) {
        PublishYear = publishYear;
    }


}
