package com.company;

public class Category {
    private String Id;
    private String Name;

    public Category(String id, String name) {
        this.setId(id);
        this.setName(name);
    }

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
}
