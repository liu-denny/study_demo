package clone_demo;

/**
 * @author yudong
 * @create 2019-07-18 11:01
 */
public class People2 implements Cloneable {
    private String name;
    private Integer age;

    public People2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
