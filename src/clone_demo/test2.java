package clone_demo;

/**
 * @author yudong
 * @create 2019-07-18 11:20
 */
public class test2 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("刘老师", 18);
        Student student1 = new Student("小明", 10, teacher);
        Student student2 = null;
        try {
            student2 = (Student) student1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Teacher t1 = student2.getTeacher();
        t1.setName("张老师");
        t1.setAge(30);
        student2.setName("小红");
        student2.setAge(9);
        student2.setTeacher(t1);
        System.out.println(student1);
        System.out.println(student2);
    }
}
