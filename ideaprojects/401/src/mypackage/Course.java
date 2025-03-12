package mypackage;


 enum CourseType {
    COMPULSORY, // 必修
    ELECTIVE    // 选修
}

public class Course {
    private int cno;
    private String cname;
    private int credit;
    private CourseType type;


    public Course(int cno, String cname, int credit, CourseType type) {
        this.cno = cno;
        this.cname = cname;
        this.credit = credit;
        this.type = type;
    }
    public int getCno() {
        return cno;
    }
    public String getCname() {
        return cname;
    }
    public int getCredit() {
        return credit;
    }
    public CourseType getType() {
        return type;
    }
    public void setCno(int cno)
    {
        this.cno=cno;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public void setType(CourseType type) {
        this.type = type;
    }

}
