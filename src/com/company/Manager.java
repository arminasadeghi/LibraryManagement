package com.company;

import java.util.Scanner;

public class Manager {

    private Boolean Exit = false ;
    private String Input ;
    private static final String FinishStateMent = "finish";
    private ObjectContainer objectContainer = new ObjectContainer();
    private String ResponseOutPut = "";
    public void Run()
    {

        while (!Exit)
        {

            Scanner scanner = new Scanner(System.in);
            this.Input = scanner.nextLine();

            if(this.ShouldExit())
                break;

            DoAction();

        }


    }

    private void DoAction()
    {
        String[] spliter = this.Input.split("#");
        String Action = spliter[0];
        String inputs = spliter[1];

        switch (Action)
        {

            case Actions.Add_Library:
                this.ResponseOutPut = this.Add_Library(inputs);
                break;

            case Actions.Add_Category:
                this.ResponseOutPut = this.Add_Category(inputs);
                break;

            case Actions.Add_Book:
                this.ResponseOutPut = this.Add_Book(inputs);
                break;

            case Actions.Edit_Book:
                this.ResponseOutPut = this.Edit_Book(inputs);
                break;
            case Actions.Remove_Book:
                this.ResponseOutPut = this.Remove_Book(inputs);
                break;

            case Actions.Add_Thesis:
                this.ResponseOutPut = this.Add_Thesis(inputs);
                break;
            case Actions.Add_Student:
                this.ResponseOutPut = this.Add_Student(inputs);
                break;
            case Actions.Edit_Student:
                this.ResponseOutPut = this.Edit_Student(inputs);
                break;
            case Actions.Remove_Student:
                this.ResponseOutPut = this.Remove_Student(inputs);
                break;
            case Actions.Add_Staff:
                this.ResponseOutPut = this.Add_Staff(inputs);
                break;
            case Actions.Edit_Staff:
                this.ResponseOutPut = this.Edit_Staff(inputs);
                break;
            case Actions.Remove_Staff:
                this.ResponseOutPut = this.Remove_Staff(inputs);
                break;
            case Actions.Edit_Thesis:
                this.ResponseOutPut = this.Edit_Thesis(inputs);
                break;
            case Actions.Remove_Thesis:
                this.ResponseOutPut = this.Remove_Thesis(inputs);
                break;



            default:
                this.ResponseOutPut = "Invalid-Input" ;
                break;
        }

        System.out.println(ResponseOutPut);

    }

    private boolean ShouldExit() {
        if(this.Input.equals(this.FinishStateMent))
            this.Exit = true ;

        return this.Exit ;
    }

    private String Add_Library(String inputs) {
        String[] spliter = inputs.split("\\|");

        AddLibraryDto dto = new AddLibraryDto(
                spliter[0] ,
                spliter[1] ,
                Integer.parseInt(spliter[2]) ,
                Integer.parseInt(spliter[3]) ,
                spliter[4]
        );

        if(this.objectContainer.IsLibraryExist(dto.Id))
            return Response.duplicate_id;

        Library lib = new Library(dto.Id ,dto.Name , dto.StablishYear ,dto.DeskNumber , dto.Address);
        this.objectContainer.libraries.add(lib);

        return Response.Success;

    }

    private String Add_Category(String inputs) {
        String[] spliter = inputs.split("\\|");

        AddCategoryDto dto = new AddCategoryDto(
                spliter[0] ,
                spliter[1]
        );

        if(this.objectContainer.IsCateoryExist(dto.Id))
            return Response.duplicate_id;

        Category category = new Category(dto.Id , dto.Name);
        this.objectContainer.categories.add(category);

        return Response.Success;

    }

    private String Add_Book(String inputs) {

        String[] spliter = inputs.split("\\|");

        AddBookDto dto = new AddBookDto(
                spliter[0] ,
                spliter[1] ,
                spliter[2] ,
                spliter[3] ,
                Integer.parseInt(spliter[4]) ,
                Integer.parseInt(spliter[5]) ,
                spliter[6] ,
                spliter[7]
        );


        if( !dto.CategoryId.equals("null") && !objectContainer.IsCateoryExist(dto.CategoryId))
            return Response.Not_Found;



        if(!objectContainer.IsLibraryExist(dto.LibId))
            return Response.Not_Found;

        Library lib = null;
        for (int i = 0; i < objectContainer.libraries.size(); i++) {

            if(dto.LibId.equals(objectContainer.libraries.get(i).getId()))
            {
                lib = objectContainer.libraries.get(i);
                break;
            }

        }

        Book book = new Book(dto.Id , dto.Title , dto.Author, dto.Publisher , dto.PublishYear , dto.CategoryId , dto.Stock );

        Boolean result = lib.AddBook(book);

        if(result.equals(false))
            return Response.duplicate_id;

        return Response.Success;
    }

    private String Edit_Book(String inputs) {

        String[] spliter = inputs.split("\\|");

        if(spliter[4].equals("-"))
            spliter[4] = String.valueOf(-1);

        if(spliter[5].equals("-"))
            spliter[5] = String.valueOf(-1);

        AddBookDto dto = new AddBookDto(
                spliter[0] ,
                spliter[1] ,
                spliter[2] ,
                spliter[3] ,
                Integer.parseInt(spliter[4]) ,
                Integer.parseInt(spliter[5]) ,
                spliter[6] ,
                spliter[7]
        );


        if( !dto.CategoryId.equals("null") && !objectContainer.IsCateoryExist(dto.CategoryId))
            return Response.Not_Found;


        if(!objectContainer.IsLibraryExist(dto.LibId))
            return Response.Not_Found;


        Library lib = null;

        for (int i = 0; i < objectContainer.libraries.size(); i++) {

            if (dto.LibId.equals(objectContainer.libraries.get(i).getId())) {
                lib = objectContainer.libraries.get(i);
                break;
            }
        }

        Book book = null;
        for (int i = 0; i < lib.getBooks().size(); i++) {

            if (dto.Id.equals(lib.getBooks().get(i).getId())) {
                book = lib.getBooks().get(i);
                break;
            }
        }
        book.Update(dto);

        return Response.Success;
    }

    private String Remove_Book(String inputs) {

        String[] spliter = inputs.split("\\|");

        RemoveBookDto dto = new RemoveBookDto(
                spliter[0] ,
                spliter[1]
        );


        if(!objectContainer.IsLibraryExist(dto.LibId))
            return Response.Not_Found;


        Library lib = null;

        for (int i = 0; i < objectContainer.libraries.size(); i++) {

            if (dto.LibId.equals(objectContainer.libraries.get(i).getId())) {
                lib = objectContainer.libraries.get(i);
                break;
            }
        }
        if(lib == null)
            return Response.Not_Found;

        for (int i = 0; i < lib.getBooks().size(); i++) {

            if (dto.Id.equals(lib.getBooks().get(i).getId())) {
                lib.getBooks().remove(i);
                return Response.Success;
            }
        }

        return Response.Not_Found;
    }

    private String Add_Thesis(String inputs){

        String[] spliter = inputs.split("\\|");

        AddThesisDto dto = new AddThesisDto(
                spliter[0] ,
                spliter[1] ,
                spliter[2] ,
                spliter[3] ,
                Integer.parseInt(spliter[4]),
                spliter[5],
                spliter[6]
        );


        if( !dto.CategoryId.equals("null") && !objectContainer.IsCateoryExist(dto.CategoryId))
            return Response.Not_Found;



        if(!objectContainer.IsLibraryExist(dto.LibId))
            return Response.Not_Found;


        Library lib = null;
        for (int i = 0; i < objectContainer.libraries.size(); i++) {

            if(objectContainer.libraries.get(i).IsExistThesis(dto.Id))
                return Response.duplicate_id ;

            if(dto.LibId.equals(objectContainer.libraries.get(i).getId()))
            {
                lib = objectContainer.libraries.get(i);
            }

        }

        Thesis thesis = new Thesis(dto.Id , dto.Title , dto.StudentName , dto.ProfessorName , dto.DefenceDate , dto.CategoryId , lib.getId() );

        Boolean result = lib.AddThesis(thesis);

        if(result.equals(false))
            return Response.duplicate_id;

        return Response.Success;
    }

    private String Add_Student(String inputs) {
        String[] spliter = inputs.split("\\|");


        AddStudentDto dto = new AddStudentDto(
                spliter[0] ,
                spliter[1],
                spliter[2],
                spliter[3],
                spliter[4],
                Integer.parseInt(spliter[5]),
                spliter[6]
        );

        if(this.objectContainer.IsStudentExist(dto.StudentNumber))
            return Response.duplicate_id;

        Student student = new Student(dto.StudentNumber,dto.FirstName,dto.LastName,dto.Password,dto.NationalCode,dto.BirthDate,dto.Address);
        this.objectContainer.students.add(student);

        return Response.Success;

    }

    private String Edit_Student(String inputs) {

        String[] spliter = inputs.split("\\|");

        if(spliter[5].equals("-"))
            spliter[5] = String.valueOf(-1);

        AddStudentDto dto = new AddStudentDto(
                spliter[0] ,
                spliter[1],
                spliter[2],
                spliter[3],
                spliter[4],
                Integer.parseInt(spliter[5]),
                spliter[6]
        );

        if(!objectContainer.IsStudentExist(dto.StudentNumber))
            return Response.Not_Found;


        Student student = null;

        for (int i = 0; i < objectContainer.students.size(); i++) {

            if (dto.StudentNumber.equals(objectContainer.students.get(i).getStudentNumber())) {
                student = objectContainer.students.get(i);
                break;
            }
        }

        student.Update(dto);

        return Response.Success;
    }

    private String Remove_Student(String inputs) {

        String[] spliter = inputs.split("\\|");

        String StudentNumber = spliter[0];


        if(!objectContainer.IsStudentExist(StudentNumber))
            return Response.Not_Found;

        for (int i = 0; i < objectContainer.students.size(); i++) {

            if (StudentNumber.equals(objectContainer.students.get(i).getStudentNumber())) {
                if(objectContainer.students.get(i).getLoanedBook().size() > 0 || objectContainer.students.get(i).getLoanedThesis().size() > 0)
                    return Response.Success;
                else {
                    objectContainer.students.remove(i);
                    return Response.Success;
                }
            }
        }
        return Response.Not_Found;
    }

    private String Add_Staff(String inputs) {
        String[] spliter = inputs.split("\\|");


        AddStaffDto dto = new AddStaffDto(
                spliter[0] ,
                spliter[1],
                spliter[2],
                spliter[3],
                spliter[4],
                Integer.parseInt(spliter[5]),
                spliter[6]
        );

        if(this.objectContainer.IsStaffExist(dto.Code))
            return Response.duplicate_id;

        Staff staff = new Staff(dto.Code,dto.FirstName,dto.LastName,dto.PassWord,dto.NationalCode,dto.BirthDate,dto.Address);
        this.objectContainer.staffs.add(staff);

        return Response.Success;

    }

    private String Edit_Staff(String inputs) {

        String[] spliter = inputs.split("\\|");

        if(spliter[5].equals("-"))
            spliter[5] = String.valueOf(-1);

        AddStaffDto dto = new AddStaffDto(
                spliter[0] ,
                spliter[1],
                spliter[2],
                spliter[3],
                spliter[4],
                Integer.parseInt(spliter[5]),
                spliter[6]
        );

        if(!objectContainer.IsStaffExist(dto.Code))
            return Response.Not_Found;


        Staff staff = null;

        for (int i = 0; i < objectContainer.staffs.size(); i++) {

            if (dto.Code.equals(objectContainer.staffs.get(i).getCode())) {
                staff = objectContainer.staffs.get(i);
                break;
            }
        }

        staff.Update(dto);

        return Response.Success;
    }

    private String Remove_Staff(String inputs) {

        String[] spliter = inputs.split("\\|");

        String Code = spliter[0];


        if(!objectContainer.IsStaffExist(Code))
            return Response.Not_Found;

        for (int i = 0; i < objectContainer.staffs.size(); i++) {

            if (Code.equals(objectContainer.staffs.get(i).getCode())) {
                if(objectContainer.staffs.get(i).getLoanedBook().size() > 0 || objectContainer.staffs.get(i).getLoanedThesis().size() > 0)
                    return Response.Success;
                else {
                    objectContainer.staffs.remove(i);
                    return Response.Success;
                }
            }
        }
        return Response.Not_Found;
    }

    private String Edit_Thesis(String inputs) {

        String[] spliter = inputs.split("\\|");

        if(spliter[4].equals("-"))
            spliter[4] = String.valueOf(-1);

        AddThesisDto dto = new AddThesisDto(
                spliter[0] ,
                spliter[1] ,
                spliter[2] ,
                spliter[3] ,
                Integer.parseInt(spliter[4]) ,
                spliter[5] ,
                spliter[6]
        );


        if( !dto.CategoryId.equals("null") && !objectContainer.IsCateoryExist(dto.CategoryId))
            return Response.Not_Found;


        if(!objectContainer.IsLibraryExist(dto.LibId))
            return Response.Not_Found;


        Library lib = null;

        for (int i = 0; i < objectContainer.libraries.size(); i++) {

            if (dto.LibId.equals(objectContainer.libraries.get(i).getId())) {
                lib = objectContainer.libraries.get(i);
                break;
            }
        }

        Thesis thesis = null;
        for (int i = 0; i < lib.getThesis().size(); i++) {

            if (dto.Id.equals(lib.getThesis().get(i).getId())) {
                thesis = lib.getThesis().get(i);
                break;
            }
        }
        thesis.Update(dto);

        return Response.Success;
    }

    private String Remove_Thesis(String inputs) {

        String[] spliter = inputs.split("\\|");

        RemoveThesisDto dto = new RemoveThesisDto(
                spliter[0] ,
                spliter[1]
        );


        if(!objectContainer.IsLibraryExist(dto.LibId))
            return Response.Not_Found;


        Library lib = null;

        for (int i = 0; i < objectContainer.libraries.size(); i++) {

            if (dto.LibId.equals(objectContainer.libraries.get(i).getId())) {
                lib = objectContainer.libraries.get(i);
                break;
            }
        }

        if(lib == null)
            return Response.Not_Found;

        for (int i = 0; i < lib.getThesis().size(); i++) {

            if (dto.Id.equals(lib.getThesis().get(i).getId())) {
                lib.getThesis().remove(i);
                return Response.Success;
            }
        }

        return Response.Not_Found;
    }

}

