package cn.test;


/**
 * @author answer
 *         2018/4/12
 */
public class ClassReflex {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> obj=Class.forName("cn.test.Demo");
        Demo demo= (Demo) obj.newInstance();
        demo.demo("123");
    }
}
