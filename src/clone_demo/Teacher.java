package clone_demo;

/**
 * @author yudong
 * @create 2019-07-18 11:18
 */
public class Teacher implements Cloneable {
    private String name;
    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "老师：name=" + name + ", age=" + age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
