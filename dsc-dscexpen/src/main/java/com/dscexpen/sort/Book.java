package com.dscexpen.sort;

/**
 * Description:
 * Program Name:
 * author :dujianjun
 * Date:2018-07-11  14:27  星期三
 * version 1.0
 */
public class Book {

    private Long id;//书本编号
    private String name;//书本名称
    private double price;//书本价格
    private String author;//作者
    private Integer weight;//权重

    public Book(Long Id, String Name, double Price, String Author, Integer Weight) {
        this.id=Id;
        this.name=Name;
        this.price=Price;
        this.author=Author;
        this.weight=Weight;
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }




    public Integer getWeight() {
        return weight;
    }




    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}