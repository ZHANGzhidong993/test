/**
 * @author zhangzhidong
 * @create: 2019-03-17 19:46
 */
public class TestClassLoadOrder {

    public static void main(String[] args) {
        staticFunction();
    }


    static {
        System.out.println("1");
    }
    static TestClassLoadOrder st = new TestClassLoadOrder();



    {
        System.out.println("2");
    }
    int a = 110;

    static int b = 112;

    /**
     * 1
     */



    public TestClassLoadOrder() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }


    private static void staticFunction() {
        System.out.println("4");
    }
}
