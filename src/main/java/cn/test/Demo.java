package cn.test;

/**
 * @author answer
 *         2018/4/12
 */
public class Demo {
    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void demo(String message){
        System.out.println("print:"+message);
    }
}
