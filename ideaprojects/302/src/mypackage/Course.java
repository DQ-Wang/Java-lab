package mypackage;

public class Course {
    private int cId;
    private String cName;

    public Course(int id,String name){
        this.cId=id;
        this.cName=name;
    }

    public int getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }
}
