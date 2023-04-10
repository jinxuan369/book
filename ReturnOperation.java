package TestBook.src.opera;

import TestBook.src.book.Book;
import TestBook.src.book.BookList;

import java.util.Scanner;

public class ReturnOperation implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书！");
        System.out.println("你要归还的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name) && book.isBorrowed()) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
        System.out.println("没有这本书或已被归还！");
    }
}
