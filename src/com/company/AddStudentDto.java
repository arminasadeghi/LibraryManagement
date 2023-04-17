package com.company;

public class AddStudentDto {
    public String StudentNumber;
    public String FirstName;
    public String LastName;
    public String Password;
    public String NationalCode;
    public int BirthDate;
    public String Address;


    public AddStudentDto(String studentNumber, String firstName, String lastName, String password, String nationalCode, int birthDate, String address) {
        StudentNumber = studentNumber;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        NationalCode = nationalCode;
        BirthDate = birthDate;
        Address = address;
    }
}
