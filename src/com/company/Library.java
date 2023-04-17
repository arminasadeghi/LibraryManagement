package com.company;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String Id;
    private String Name;
    private int StablishYear;
    private int DeskNumber;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private List<Book> books = new ArrayList<>();
    private List<Thesis> thesis = new ArrayList<>();

    public Library()
    {

    }

    public boolean IsExistBook(String id)
    {
        Boolean isLibExist = false;
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getId().equals(id))
                isLibExist = true;
        }

        return isLibExist;
    }

    public boolean AddBook(Book book)
    {

        if(this.IsExistBook(book.getId()))
            return false ;

        this.books.add(book);

        return true ;

    }

    public boolean AddThesis(Thesis thesis)
    {

        if(this.IsExistThesis(thesis.getId()))
            return false ;

        this.thesis.add(thesis);

        return true ;

    }
    public boolean IsExistThesis(String id)
    {
        Boolean isExistThesis = false;
        for (int i = 0; i < this.thesis.size(); i++) {
            if (this.thesis.get(i).getId().equals(id))
                isExistThesis = true;
        }

        return isExistThesis;
    }

    public Library(String id, String name, int stablishYear, int deskNumber, String address) {

        this.setId(id);
        this.setDeskNumber(deskNumber);
        this.setName(name);
        this.setStablishYear(stablishYear);
        this.setAddress(address);

    }

    private String Address;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStablishYear() {
        return StablishYear;
    }

    public void setStablishYear(int stablishYear) {
        StablishYear = stablishYear;
    }

    public int getDeskNumber() {
        return DeskNumber;
    }

    public void setDeskNumber(int deskNumber) {
        DeskNumber = deskNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void AddBook()
    {

    }
    public void RemoveBook()
    {

    }

}
