package edu.xmu.java.test;
import java.util.*;

public class Vehicle {
    private String brand;
    private String color;
    private int date;
    private boolean flag=false;

    public Vehicle(String brand,String color,int date)
    {
        this.brand=brand;
        this.color=color;
        this.date=date;
    }
    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
    public int getDate() {
        return date;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setColor(String collor){
        this.color=color;
    }
    public void setDate(int date){
        this.date=date;
    }
    public boolean getFlag(){
        return flag;
    }
    public boolean setFlag(boolean a){
        this.flag=a;
        return flag;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        else if(obj!=null&&this.getClass()==obj.getClass())
        {
            Vehicle other=(Vehicle)obj;
            return this.brand.equals(other.brand)&&this.color.equals(other.color)&&this.date==other.date;
        }
        else
            return false;

    }
    @Override
    public String toString(){
        return "品牌:"+brand+",颜色:"+color+",出厂年份:"+date;
    }
}

class Car extends Vehicle{
    private int  pNum;
    private int  cNum;


    public Car(String brand,String color,int date,int pNum,int cNum){
        super(brand,color,date);
        this.pNum=pNum;
        this.cNum=cNum;
    }
    public int getpNum() {
        return pNum;
    }
    public int getcNum() {
        return cNum;
    }
    public void setpNum(int pNum) {
        this.pNum = pNum;
    }
    public void setcNum(int cNum) {
        this.cNum = cNum;
    }
    @Override
    public String toString(){
        return super.toString()+",载客量:"+pNum+",厢数："+cNum;
    }
}

class Truck extends Vehicle{
    private int  weight;
    public Truck(String brand,String color,int date,int weight){
        super(brand,color,date);
        this.weight=weight;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString()
    {
        return super.toString()+",载重量："+weight;
    }
}