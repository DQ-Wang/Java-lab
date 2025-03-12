package mypackage;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Student[] s=new Student[3];//声明数组时必须初始化，否则会报错
        Course[]  c=new Course[3];

        //获取学生信息
        for(int i=1;i<=2;i++){
            System.out.println("请输入学生"+i+"信息(学号 姓名 班级)：");
            int sId=input.nextInt();
            input.nextLine();
            String sName=input.nextLine();
            int sBanJi=input.nextInt();
            input.nextLine();
             s[i]=new Student(sId,sName,sBanJi);//构造函数只能通过new方法使用
            System.out.print("学号："+s[i].getId()+" ");
            System.out.print("姓名："+s[i].getName()+" ");
            System.out.println("班级："+s[i].getBanJi());

        }
         //获取课程信息
        for(int i=1;i<=2;i++)
        {
            System.out.println("请输入course"+i+"信息：");
            int cId=input.nextInt();
            input.nextLine();
            String cName=input.nextLine();
             c[i]=new Course(cId,cName);
            System.out.print("课程号："+c[i].getcId()+" ");
            System.out.println("课程名称："+c[i].getcName());
        }

        s[1].selectCourse(01);

    }
}