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

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
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

    public void Update(AddBookDto input)
    {
        if(!input.Author.equals("-"))
            this.setAuthor(input.Author);

        if(!input.Publisher.equals("-"))
            this.setPublisher(input.Publisher);

        if(input.PublishYear != -1)
            this.setPublishYear(input.PublishYear);

        if(input.Stock != -1)
            this.setCout(input.Stock);

        if(!input.CategoryId.equals("-"))
            this.setCategoryId(input.CategoryId);
    }


}
