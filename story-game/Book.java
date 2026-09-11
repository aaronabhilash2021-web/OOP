package com.library.model;
public class Book {
    int id;
    String title;
    String author;
    String category;

    public Book(int id,String title, String author,String category){
        this.id=id;
        this.title=title;
        this.author=author;
        this.category = category;

    }

    public void displayDetails(){
        System.out.println("Book Id"+id);
        System.out.println("Title:"+title);
        System.out.println("Author:"+author);
        System.out.println("category:"+category);
    }
    
}
