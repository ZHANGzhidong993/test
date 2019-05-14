import org.junit.Test;
import serializer.pojo.User;
import serializer.serializer.*;

/**
 * @author zhangzhidong
 * @since 2019/5/13
 */
public class TestSerializer {

    private User user;

    {
        User user = new User();
        user.setTel("18668158627");
        user.setPassword("heheada");
        user.setUsername("nihaohhh");
        user.setAge(18);
        this.user = user;
    }

    /**
     * 247
     */
    @Test
    public void testDefaultJavaSerializer() {
        DefaultJavaSerializer javaSerializer = new DefaultJavaSerializer();
        byte[] serialize = javaSerializer.serialize(user);
        System.out.println("size: " + serialize.length);
        User deserialize = javaSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }

    /**
     * 287
     */
    @Test
    public void testXmlSerializer() {
        XmlSerializer xmlSerializer = new XmlSerializer();
        byte[] serialize = xmlSerializer.serialize(user);
        System.out.println("size: " + serialize.length);
        User deserialize = xmlSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }

    /**
     * 205
     */
    @Test
    public void testXml2Serializer() {
        Xml2Serializer xmlSerializer = new Xml2Serializer();
        byte[] serialize = xmlSerializer.serialize(user);
        System.out.println("size: " + serialize.length);
        User deserialize = xmlSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }

    /**
     * 406
     */
    @Test
    public void testJSONSerializer() {
        JSONSerializer jsonSerializer = new JSONSerializer();
        byte[] serialize = jsonSerializer.serialize(user);
        System.out.println("size: " + serialize.length);
        User deserialize = jsonSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }

    /**
     * 99
     */
    @Test
    public void testHessianSerializer() {
        HessianSerializer hessianSerializer = new HessianSerializer();
        byte[] serialize = hessianSerializer.serialize(user);
        System.out.println("size: " + serialize.length);
        User deserialize = hessianSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }


}
