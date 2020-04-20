package service;

import model.Category;

import java.util.List;

public interface CategoryInt {
    List<Category> listTwoCategory();

    Category getCategory(int id);
    
    Category getCategoryByName(String name);

    List<Category> listAll();

    void delete(int id);

    Integer insert(Category category);
}
