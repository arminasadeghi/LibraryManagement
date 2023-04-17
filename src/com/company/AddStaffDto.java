package com.company;

public class AddStaffDto {
    public String Code;
    public String FirstName;
    public String LastName;
    public String PassWord;
    public String NationalCode;
    public int BirthDate;
    public String Address;

    public AddStaffDto( String code, String firstName, String lastName, String passWord, String nationalCode, int birthDate, String address) {
        Code = code;
        FirstName = firstName;
        LastName = lastName;
        PassWord = passWord;
        NationalCode = nationalCode;
        BirthDate = birthDate;
        Address = address;
    }
}
