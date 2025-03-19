package edu.xmu.java.test;
import java.util.*;

public class Main {
//初始化菜单
    public static void menu(){
        System.out.println("请输入对应数字进行相应菜单操作：");
        System.out.println("1. 车辆信息录入");
        System.out.println("2. 车辆信息查询");
        System.out.println("3. 列出所有车辆信息");
        System.out.println("4. 结束程序");
    }
// 车辆信息录入函数
    public static void addVehicle(String[] parts,List<Vehicle> list){
        if(parts[0].equals("Car")){
            Vehicle v=new Car(parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]));
            list.add(v);
            System.out.println("车辆信息录入成功！");
            System.out.println(v.toString());

        }
        else if(parts[0].equals("Truck")){
            Vehicle v=new Truck(parts[1],parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
            list.add(v);
            System.out.println("车辆信息录入成功！");
            System.out.println(v.toString());

        }
        else {
            System.out.println("车型应该为小汽车或卡车！");
            System.out.println("\u001B[31m创建失败\u001B[0m");
        }
    }
//    车辆查询函数
    public static void findVehicle(String[] parts,List<Vehicle> list){
        int count=0;
        for(Vehicle v:list){
                if (parts[0].equals("null") ||
                        (parts[0].equals("Car") && v instanceof Car) ||
                        (parts[0].equals("Truck") && v instanceof Truck)) {
                    Vehicle v1 = new Vehicle(parts[1], parts[2], Integer.parseInt(parts[3]));
                    if (v.equals(v1)) {
                        count++;
                        v.setFlag(true);
                    }
                }

        }
        if(count==0){
            System.out.println("没有符合条件的车辆！");
        }
        else{
            System.out.println("符合条件的车辆有"+count+"辆：");
            for(Vehicle v:list){
                if(v.getFlag()){
                    System.out.println(v.toString());
                }
                v.setFlag(false);
            }
        }
    }
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (true) {
            menu();
            int n = s.nextInt();
            s.nextLine(); // 读取换行符

            switch (n) {
                case 1:
                    System.out.println("请输入车辆信息：（类型 品牌 颜色 出厂年）");
                    while (true) {
                        String input = s.nextLine();
                        if (input.equals("End")) break;
                        addVehicle(input.split(" "), list);
                    }
                    break;
                case 2:
                    System.out.println("请输入查询条件：（类型 品牌 颜色 出厂年），若条件为空输入 ‘null’");
                    while (true) {
                        String input = s.nextLine();
                        if (input.equals("End")) break;
                        findVehicle(input.split(" "), list);
                    }
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("当前无车辆信息。");
                    } else {
                        int i = 1;
                        for (Vehicle v : list) {
                            System.out.println(i + ". " + v.toString());
                            i++;
                        }
                    }
                    break;
                case 4:
                    System.out.println("程序结束！");
                    return;
                default:
                    System.out.println("\u001B[31m输入错误，请输入 1-4\u001B[0m");
            }
        }
    }

    }