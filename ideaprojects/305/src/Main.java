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
    public static double num=10.0;
    public static String[] cWords={"Very good!","Excellent!","Nice work!","Keep up the good work!"};
    public static String[] wWords={"No. Please try again.","Wrong. Try once more.","Don't give up!","No. Keep trying."};

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

    //给出随机鼓励
    public  static void great()
    {
        SecureRandom s=new SecureRandom();
        System.out.println(cWords[s.nextInt(4)]);
    }

    //答案出错时
    public  static void bad()
    {
        SecureRandom s=new SecureRandom();
        System.out.println(wWords[s.nextInt(4)]);
    }


    public static void main(String[] args) {
        int count=0;
        int q=0;
        while(true)
        {  q++;
            System.out.println("请第"+q+"位同学答题");
            for(int w=0;w<10;w++) {
                getMathQuestion();
                int a, b;
                Scanner s = new Scanner(System.in);
                a = s.nextInt();
                b = isCorrect(n, flag.get(operator[f]), m);
                if (a == b) {
                    great();

                    count++;

                }

                else
                {

                        bad();



                }

            }
            if(count/10.0>=0.75)
            {
                System.out.println("Congratulations, you are ready to go to the next level！");
            }
            else {
                System.out.println("Please ask your teacher for extra help.");
            }
//            System.out.println("So much for today!");
        }


    }
}