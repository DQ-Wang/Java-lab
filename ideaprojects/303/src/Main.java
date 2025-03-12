import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static public String[] operator={"plus","minus","times","divided"};//映射单词和索引
    static public Map<String,Character> flag=new HashMap<>();//映射单词和符号的键值对
    public static int m;  //m,n,f用于联系getMathQuestion和isCorrect
    public static int n;
    public static int f;
    static{

        flag.put("plus",'+');
        flag.put("minus",'-');
        flag.put("times",'*');
        flag.put("divided",'/');

    }


    //生成问题
    public static void getMathQuestion()
    {
        SecureRandom s=new SecureRandom();
         n=s.nextInt(10);
         m=s.nextInt(9)+1;
         f=s.nextInt(4);
         System.out.println("How much is"+" "+n+" "+operator[f]+" "+m);


    }

    //判断答案正确与否
    public static int isCorrect(int a,char c,int b)
    {
       int as= switch (c)    //增强型switch,从 Java 12 开始，switch 语句被增强为可以返回值的表达式（称为“switch 表达式”）。
        {
            case '+' -> a+b;

            case '-' -> a - b;

            case '*' -> a * b;

            case '/' -> a / b;

            default-> 0;

        };
        return as;
    }

    public static void main(String[] args) {
        System.out.println("练习开始逻！");
        getMathQuestion();
        int a,b;
        Scanner s=new Scanner(System.in);
        a=s.nextInt();
        b=isCorrect(n, flag.get(operator[f]), m);
        while(a==b)
        {
            System.out.println("Very good！");
            getMathQuestion();
            b=isCorrect(n, flag.get(operator[f]), m);
            a=s.nextInt();

        }

        do
        {
            System.out.println("No. Please try again.");
            a=s.nextInt();
        }while(a!=b);
        System.out.println("Very good！");
        System.out.println("So much for today!");



    }
}