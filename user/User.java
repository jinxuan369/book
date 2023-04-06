package TestBook.src.user;

import TestBook.src.book.BookList;
import TestBook.src.opera.*;


public abstract class User {
    protected String name;
    protected Operation[] operations;
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doWork(int choice, BookList bookList) {
        this.operations[choice].work(bookList);
    }
}
