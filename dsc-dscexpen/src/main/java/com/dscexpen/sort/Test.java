package com.dscexpen.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-07-11  14:27  星期三
 * version 1.0
 */
public class Test {
    public static List<Book> getBookList() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book(1L, "first", 10.00, "zhangsan", 19);
        Book book2 = new Book(2L, "first", 9.00, "zhangsan", 24);
        Book book3 = new Book(3L, "first", 15.00, "zhangsan", 29);
        Book book4 = new Book(4L, "first", 13.00, "zhangsan", 13);
        Book book5 = new Book(5L, "first", 6.00, "zhangsan", 14);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        return books;
    }

    public static void printf(List<Book> lisbk) {
        if (lisbk.isEmpty() || lisbk == null) {
            System.out.println("没有数据");
            return;
        }
        for (Book book : lisbk) {
            System.out.println("Id: " + book.getId() + "   price: " + book.getPrice() + "  weight:" + book.getWeight());
        }
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        List<Book> bks = getBookList();
        System.out.println("原先的顺序：");
        printf(bks);

        System.out.println("根据价格排序：");
        Collections.sort(bks, new SortList<Book>("Price",false));
        printf(bks);

      /*  System.out.println("根据Id排序：");
        Collections.sort(bks, new SortList<Book>("Id",true));
        printf(bks);

        System.out.println("根据weight排序：");
        Collections.sort(bks, new SortList<Book>("Weight",true));
        printf(bks);*/

    }

}

