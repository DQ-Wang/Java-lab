package mypackage;

import java.security.SecureRandom;

public class Main {
//静态课程数组
     public static Course[] courses=new Course[100];
    static
    {
        courses[0]= new Course(0, "Java", 3, CourseType.COMPULSORY);
        courses[1]=new Course(1, "C++", 4, CourseType.COMPULSORY);
        courses[2]=new Course(2, "Python", 2, CourseType.ELECTIVE);
        courses[3]=new Course(3, "Unity", 2, CourseType.ELECTIVE);
    }


//    自动选课
    public static void autoSelect(Student[] s) {
        for(int i=0;i<4;i++)
        {
            for (int j = 0; j < 4; j++) {
                if (courses[j].getType() == CourseType.COMPULSORY) {
                    s[i].selset(courses[j].getCno());
                }
            }
        }
    }
    //手动选课
    public static void manualSelect(Student[] s) {
        SecureRandom random = new SecureRandom();
        for(int i=0;i<4;i++)
        {
            for (int j = 0; j < 4; j++) {
                if (courses[j].getType() == CourseType.ELECTIVE) {
                    if(random.nextBoolean()) { //好用的Securerandom,随机产生对错
                        s[i].selset(courses[j].getCno());
                    }
                }
            }
        }
    }
    public static void main(String[] args) {

        Student a=new Student("本01",101,01);
        Student b=new Student("本02",102,01);
        StudentPro c=new StudentPro("研01",501,02,"张老师");
        StudentPro d=new StudentPro("研02",502,02,"张老师");
        Student[] students={a,b,c,d};


        autoSelect(students);
        manualSelect(students);
        System.out.println();
        for(Student s:students)
        {
            s.print();
            System.out.println();
        }

    }
}