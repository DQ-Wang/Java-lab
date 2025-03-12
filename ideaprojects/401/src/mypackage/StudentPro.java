package mypackage;

public class StudentPro extends Student {
    private String teacher;

    public StudentPro(String name, int id, int banji, String teacher) {
        super(name, id, banji);
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public void print() {
        // 调用父类的 print 方法
        super.print();
        // 打印 StudentPro 类特有的信息
        System.out.println("指导教师：" + this.teacher);
    }
}

