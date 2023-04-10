package TestBook.src.opera;

import TestBook.src.book.Book;
import TestBook.src.book.BookList;

import java.util.Scanner;


public class BorrowOperation implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书！");
        System.out.println("你要借阅的图书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name) && !book.isBorrowed()) {
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }
        System.out.println("没有这本书或已被借出！");
    }
}
