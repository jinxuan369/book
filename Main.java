package TestBook.src;
import TestBook.src.book.BookList;
import TestBook.src.error.PasswordException;
import TestBook.src.error.UserNameException;
import TestBook.src.user.AdminUser;
import TestBook.src.user.NormalUser;
import TestBook.src.user.User;

import java.util.Scanner;

public class Main {
    String admin = "admin";
    String password = "123456";
    public void login(String admin,String password) throws UserNameException, PasswordException {
        if(!this.admin.equals(admin)) {
            System.out.println("用户名错了！");
            throw new UserNameException("用户名错了！");
        }
        if(!this.password.equals(password)) {
            System.out.println("密码错了！");
            throw new PasswordException("密码错了！");
        }
    }
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入你的身份：1-》管理员  0-》普通用户");
        int choice = scanner.nextInt();
        if(choice == 1) {
            return new AdminUser(name);
        } else if (choice == 0){
            return new NormalUser(name);
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String admin = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        try{
            main.login(admin,password);
            User user = login();
            BookList bookList = new BookList();

            while (true) {
                int choice = user.menu();
                //根据choice 和 user 来确定 调用哪个对象的方法
                user.doWork(choice,bookList);
            }
        } catch (UserNameException e) {
            e.printStackTrace();
            System.out.println("用户名异常！");
        } catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("密码异常！");
        }
    }
}
