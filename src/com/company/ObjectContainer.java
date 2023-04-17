package com.company;

import java.util.ArrayList;
import java.util.List;

class ObjectContainer {

    List<Library> libraries = new ArrayList<>();
    List<Category>  categories  = new ArrayList<>();


    public Boolean IsLibraryExist(String id) {
        Boolean isLibExist = false;
        for (int i = 0; i < this.libraries.size(); i++) {
            if (this.libraries.get(i).getId().equals(id))
                isLibExist = true;
        }

        return isLibExist;
    }
    public Boolean IsCateoryExist(String id) {
        Boolean isLibExist = false;
        for (int i = 0; i < this.categories.size(); i++) {
            if (this.categories.get(i).getId().equals(id))
                isLibExist = true;
        }

        return isLibExist;
    }



}
