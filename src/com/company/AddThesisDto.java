

package com.company;

public class AddThesisDto {



    public String Id;
    public String Title;
    public String StudentName;
    public String ProfessorName;
    public int DefenceDate;
    public String CategoryId;
    public String LibId ;


    public AddThesisDto(String id, String title, String studentName, String professorName, int defenceDate,
            String categoryId, String libId) {
        Id = id;
        Title = title;
        StudentName = studentName;
        ProfessorName = professorName;
        DefenceDate = defenceDate;
        CategoryId = categoryId;
        LibId = libId;
    }



}
