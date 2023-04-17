package com.company;

public class Thesis {
    private String Id;
    private String Title;
    private String StudentName;
    private String ProfessorName;
    private int DefenceDate;
    private String CategoryId;
    private String libraryId;

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

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public Thesis(String id, String title, String studentName, String professorName, int defenceDate, String categoryId,
                  String libraryId) {
        Id = id;
        Title = title;
        StudentName = studentName;
        ProfessorName = professorName;
        DefenceDate = defenceDate;
        CategoryId = categoryId;
        libraryId = libraryId;
    }

    public void Update(AddThesisDto input)
    {
        if(!input.Title.equals("-"))
            this.setTitle(input.Title);

        if(!input.StudentName.equals("-"))
            this.setStudentName(input.StudentName);

        if(!input.ProfessorName.equals("-"))
            this.setProfessorName(input.ProfessorName);

        if(input.DefenceDate != -1)
            this.setDefenceDate(input.DefenceDate);

        if(!input.CategoryId.equals("-"))
            this.setCategoryId(input.CategoryId);
    }
}
