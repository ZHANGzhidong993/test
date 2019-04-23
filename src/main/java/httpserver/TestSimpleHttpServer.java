package httpserver;

/**
 * @author zhangzhidong
 * @since 2019/4/23
 */
public class TestSimpleHttpServer {

    public static void main(String[] args) throws Exception {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        simpleHttpServer.setBasePath("D:\\mygitworkspace\\mytest\\src\\main\\resources");
        simpleHttpServer.setPort(9999);
        simpleHttpServer.start();
    }
}
