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
                this.ResponseOutPut = this.Add_Book(inputs);
                break;
            
            case Actions.Add_Thesis:
                this.ResponseOutPut = this.Add_Thesis(inputs);
                break;

            default:
                this.ResponseOutPut = "Invalid-Input" ;
                break;
        }

        System.out.println(ResponseOutPut);

    }

    private boolean ShouldExit()
    {
        if(this.Input.equals(this.FinishStateMent))
            this.Exit = true ;

        return this.Exit ;
    }

    private String Add_Library(String inputs)
    {
        String[] spliter = inputs.split("\\|");

        AddLibraryDto dto = new AddLibraryDto(
                spliter[0] ,
                spliter[1] ,
                Integer.parseInt(spliter[2]) ,
                Integer.parseInt(spliter[3]) ,
                spliter[4]
        );

        if(this.objectContainer.IsLibraryExist(dto.Id))
            return Response.dublicate_id;

        Library lib = new Library(dto.Id ,dto.Name , dto.StablishYear ,dto.DeskNumber , dto.Address);
        this.objectContainer.libraries.add(lib);

        return Response.Success;

    }

    private String Add_Category(String inputs)
    {
        String[] spliter = inputs.split("\\|");

        AddCategoryDto dto = new AddCategoryDto(
                spliter[0] ,
                spliter[1]
        );

        if(this.objectContainer.IsCateoryExist(dto.Id))
            return Response.dublicate_id;

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
            return Response.dublicate_id;

        return Response.Success;
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
                return Response.dublicate_id ;

            if(dto.LibId.equals(objectContainer.libraries.get(i).getId()))
            {
                lib = objectContainer.libraries.get(i);               
            }

        }
        
        Thesis thesis = new Thesis(dto.Id , dto.Title , dto.StudentName , dto.ProfessorName , dto.DefenceDate , dto.CategoryId , lib.getId() );

        Boolean result = lib.AddThesis(thesis);

        if(result.equals(false))
            return Response.dublicate_id;

        return Response.Success;
    }
}

