package TestBook.src.opera;

import TestBook.src.book.Book;
import TestBook.src.book.BookList;

import java.util.Scanner;

public class FindOperation implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书！");
        System.out.println("请输入书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println("找到了这本书：");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有这本书！");
    }
}
