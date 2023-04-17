package com.company;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    private String Code;
    private String FirstName;
    private String LastName;
    private String PassWord;
    private String NationalCode;
    private int BirthDate;
    private String Address;
    private List<Book> loanedBook = new ArrayList<>();
    private List<Thesis> LoanedThesis = new ArrayList<>();

    public List<Book> getLoanedBook() {
        return loanedBook;
    }

    public void setLoanedBook(List<Book> loanedBook) {
        this.loanedBook = loanedBook;
    }

    public List<Thesis> getLoanedThesis() {
        return LoanedThesis;
    }

    public void setLoanedThesis(List<Thesis> loanedThesis) {
        LoanedThesis = loanedThesis;
    }

    public Staff(String code, String firstName, String lastName, String passWord, String nationalCode, int birthDate, String address) {
        Code = code;
        FirstName = firstName;
        LastName = lastName;
        PassWord = passWord;
        NationalCode = nationalCode;
        BirthDate = birthDate;
        Address = address;
    }

    public void Update(AddStaffDto input)
    {
        if(!input.Code.equals("-"))
            this.setCode(input.Code);

        if(!input.FirstName.equals("-"))
            this.setFirstName(input.FirstName);

        if(!input.LastName.equals("-"))
            this.setLastName(input.LastName);

        if(input.BirthDate != -1)
            this.setBirthDate(input.BirthDate);

        if(!input.PassWord.equals("-"))
            this.setPassWord(input.PassWord);

        if(!input.NationalCode.equals("-"))
            this.setNationalCode(input.NationalCode);

        if(!input.Address.equals("-"))
            this.setAddress(input.Address);
    }


    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getNationalCode() {
        return NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        NationalCode = nationalCode;
    }

    public int getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(int birthDate) {
        BirthDate = birthDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
