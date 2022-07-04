package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();
    
    static{
        list.add(new Book(12,"Java complete Reference","Rahul"));
        list.add(new Book(34,"C++ complete Reference","Akash"));
        list.add(new Book(45,"PYTHON complete Reference","Rekha"));
    }

    //get all books
    public List<Book> getAllBooks(){
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try{
            book=list.stream().filter(e->e.getId()==id).findFirst().get();
        }catch( Exception e){
            e.printStackTrace();
        }
        return book;
    }
    
    //add book
    public void addBook(Book book){
        list.add(book);
    }

    //delete book
    public void deleteBook(int bookId){
        list=list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
    }

    //update book
    public void updateBook(Book book,int bookId){
        list=list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
    
}
