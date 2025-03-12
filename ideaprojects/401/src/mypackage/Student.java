package mypackage;
public class Student {
    private String name;
    private int banji;
    private int id;
    private boolean[] selset=new boolean[100];

    public Student(String name, int id, int banji) {
        this.id = id;
        this.banji = banji;
        this.name = name;
    }

    public int getBanji() {
        return banji;
    }
    public void setBanji(int banji) {
        this.banji = banji;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean selset(int cno) {
        if (cno < 0) {
            System.out.println("课程编号不能小于0");
            return false;
        }
        else {
            selset[cno] = true;
            System.out.println(this.name+"选课成功,课程号为：" + cno);
        }
        return  true;

    }
    public void print() {
        System.out.println("学生姓名：" + this.name + "，学号：" + this.id + "，班级：" + this.banji);
        System.out.println("已选课程：");
        for(int i=0;i<4;i++)
        {
            if(selset[i]){
              System.out.println(Main.courses[i].getCname());
            }
        }
    }
}

