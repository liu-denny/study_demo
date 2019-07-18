package clone_demo;

/**
 * @author yudong
 * @create 2019-07-18 11:17
 */
public class Student implements Cloneable{
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student(String name, Integer age,Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
     public String toString() {
         return "学生： name=" + name + ", age=" + age + ",指导" + teacher;
      }
    //浅克隆
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
      //深克隆
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Student newStudent = (Student) super.clone();
//        newStudent.teacher = (Teacher) teacher.clone();
//        return newStudent;
//    }
}
