package mypackage;

public class Student {
    private String name;
    private int id;
    private int banJi;
    private  String telep;
    private boolean[] isSelect={false,false};

    public Student(int id,String name, int banJi){
        this.name=name;
        this.id=id;
        this.banJi=banJi;

    }

    public Student(String name,int id, int banJi,String telep){
        this.name=name;
        this.id=id;
        this.banJi=banJi;
        this.telep=telep;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getBanJi() {
        return banJi;
    }

    public String getTelep() {
        return telep;
    }

    public void  selectCourse(int n){
        if(n==1||n==2){
            isSelect[n]=true;
            System.out.println(name+"已选"+n+"号课程");
            System.out.println("这门课的成绩为"+(int)(Math.random()+100));
        }
    }
}
