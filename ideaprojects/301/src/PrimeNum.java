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





