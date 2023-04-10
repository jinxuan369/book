package TestBook.src.opera;

import TestBook.src.book.Book;
import TestBook.src.book.BookList;

import java.util.Scanner;


public class DelOperation implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书！");
        System.out.println("请输入你要删除的图书的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBook(i);
            if(tmp.getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("没有这本书！");
        }else {
            for (int j = index; j < currentSize-1; j++) {
                Book book = bookList.getBook(j+1);
                bookList.setBook(j,book);
            }

            bookList.setUsedSize(currentSize-1);
            //因为删除的是对象，所有最后置为null
            bookList.setBook(currentSize-1,null);

            System.out.println("删除成功！");
        }

    }
}
