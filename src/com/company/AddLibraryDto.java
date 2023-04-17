package com.company;

class AddLibraryDto {
    public String Id;
    public String Name;
    public int StablishYear;
    public int DeskNumber;
    public String Address;


    public AddLibraryDto(String id, String name, int stablishYear, int deskNumber, String address) {
        Id = id;
        Name = name;
        StablishYear = stablishYear;
        DeskNumber = deskNumber;
        Address = address;
    }
}
