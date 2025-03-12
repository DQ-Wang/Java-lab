public class Main {
    public static void getAward() {
        int[] randomNum = new int[6];
        for (int i = 0; i < 6; i++) {
            randomNum[i] =  1+(int) (Math.random() * 6); // 生成1到6之间的随机整数
        }

        System.out.println("投出的骰子点数：");
        for (int num : randomNum) {//输出投掷的6个骰子点数
            System.out.print(num + " ");
        }
        System.out.println();
        String award=determineAward(randomNum);
        System.out.println("获得："+award);
        System.out.println();

    }
    public static String determineAward(int[] num){
        int[] count=new int[7];
        for(int i:num)
        {
            count[i]++;//记录各个数字出现的次数
        }
//开始列举奖项
        if(count[1]==6) return "遍地锦";
        else if(count[2]==6||count[3]==6||count[5]==6||count[6]==6) return "六博黑";
        else if(count[4]==6) return "六博红";
        else if(count[4]==4&&count[1]==2) return "状元插金花";
        else if(count[4]==5) return "五王";
        else if(count[2]==5||count[3]==5||count[5]==5||count[6]==5) return "五子";
        else if(count[4]==4) return "四红";
        else if(count[1]==1&&count[2]==1&&count[3]==1&&count[4]==1&&count[5]==1&&count[6]==1) return "对堂";
        else if(count[4]==3) return "三红";
        else if(count[1]==4){
            if(count[4]==1) return "四进带一秀";
            else return "四进";
        }
        else if(count[4]==2) return "二举";
        else if(count[4]==1) return "一秀";
        else return "啥也不是";



    }
    public static void main(String[] args) {


        getAward();


    }
}