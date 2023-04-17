package com.company;

public class Student {
    private String Id;
    private String StudentNumber;
    private String FirstName;
    private String LastName;
    private String Password;
    private String NationalCode;
    private int BirthDate;
    private String Address;


    public Student( String studentNumber, String firstName, String lastName, String password, String nationalCode, int birthDate, String address) {
        StudentNumber = studentNumber;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        NationalCode = nationalCode;
        BirthDate = birthDate;
        Address = address;
    }


    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public void Update(AddStudentDto input)
    {
        if(!input.StudentNumber.equals("-"))
            this.setStudentNumber(input.StudentNumber);

        if(!input.FirstName.equals("-"))
            this.setFirstName(input.FirstName);

        if(!input.LastName.equals("-"))
            this.setLastName(input.LastName);

        if(input.BirthDate != -1)
            this.setBirthDate(input.BirthDate);

        if(!input.Password.equals("-"))
            this.setPassword(input.Password);

        if(!input.NationalCode.equals("-"))
            this.setNationalCode(input.NationalCode);

        if(!input.Address.equals("-"))
            this.setAddress(input.Address);
    }
}
