import java.util.Scanner;

public class PrimeNum {
    public static boolean isPrimeNum(int n) {
        if (n == 1) return false;
        else {
            for (int i = 2; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {


//        Scanner scanner=new Scanner(System.in);
//
//        System.out.println("请输入数字：");
//        int n= scanner.nextInt();
        System.out.println("10000以内的素数有：");
        int count=0;
        for (int i = 2; i < 10000; i++) {

            if (isPrimeNum(i)) {
                System.out.print(i + " ");
                count++;
                if(count==25) {
                    System.out.println();
                    count=0;
                }
            }
        }
    }
}

// 定义学生基类
class Student {
    protected String id;
    protected String name;
    protected String className;

    public Student(String id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public void printInfo() {
        System.out.println("学号: " + id + ", 姓名: " + name + ", 班级: " + className);
    }
}

// 本科生类，继承自Student
class Undergraduate extends Student {
    public Undergraduate(String id, String name, String className) {
        super(id, name, className);
    }
}

// 研究生类，继承自Student，增加导师信息
class Graduate extends Student {
    private String advisor;

    public Graduate(String id, String name, String className, String advisor) {
        super(id, name, className);
        this.advisor = advisor;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(", 导师: " + advisor);
    }
}






