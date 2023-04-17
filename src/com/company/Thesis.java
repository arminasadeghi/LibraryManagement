package com.company;

public class Thesis {
    private String Id;
    private String Title;
    private String StudentName;
    private String ProfessorName;
    private int DefenceDate;
    private Category Category;

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

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getProfessorName() {
        return ProfessorName;
    }

    public void setProfessorName(String professorName) {
        ProfessorName = professorName;
    }

    public int getDefenceDate() {
        return DefenceDate;
    }

    public void setDefenceDate(int defenceDate) {
        DefenceDate = defenceDate;
    }

    public com.company.Category getCategory() {
        return Category;
    }

    public void setCategory(com.company.Category category) {
        Category = category;
    }

    public com.company.Library getLibrary() {
        return Library;
    }

    public void setLibrary(com.company.Library library) {
        Library = library;
    }

    private Library Library;
}
