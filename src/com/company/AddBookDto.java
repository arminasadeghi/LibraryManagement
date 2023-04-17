package com.company;

public class AddBookDto {


    public String LibId ;
    public String CategoryId;
    public int Stock ;

    public String Id ;
    public String Title;
    public String Author;
    public String Publisher;
    public int PublishYear;



////add-book#B1|C programing|greg perry|Que|2023|10|C1|L1
    public AddBookDto(String id, String title, String author, String publisher, int publishYear , int stock , String categoryId , String libId) {
        LibId = libId;
        CategoryId = categoryId;
        Id = id;
        Title = title;
        Author = author;
        Publisher = publisher;
        PublishYear = publishYear;
        CategoryId = categoryId ;
        LibId = libId ;
        Stock = stock ;
    }

}
