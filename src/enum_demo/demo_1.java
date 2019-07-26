package enum_demo;

/**
 * @author yudong
 * @create 2019-07-23 16:42
 */
public enum  demo_1 {
    CESHI("测试",1),
    JIANCE("检测",2)
    ;

    private String value;
    private Integer id;

    demo_1(String value,Integer id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Integer getId() {
        return id;
    }


}
