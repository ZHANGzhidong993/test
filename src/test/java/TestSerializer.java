import com.alibaba.fastjson.JSON;
import org.junit.Test;
import serializer.pojo.User;
import serializer.serializer.DefaultJavaSerializer;
import serializer.serializer.Xml2Serializer;
import serializer.serializer.XmlSerializer;

/**
 * @author zhangzhidong
 * @since 2019/5/13
 */
public class TestSerializer {

    @Test
    public void testDefaultJavaSerializer() {
        DefaultJavaSerializer javaSerializer = new DefaultJavaSerializer();
        User user = new User();
        user.setAge(28);
        byte[] serialize = javaSerializer.serialize(user);
        System.out.println("size: "+serialize.length);
        User deserialize = javaSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }

    @Test
    public void testXmlSerializer() {
        XmlSerializer xmlSerializer = new XmlSerializer();
        User user = new User();
        user.setAge(29);
        byte[] serialize = xmlSerializer.serialize(user);
        System.out.println("size: "+serialize.length);
        User deserialize = xmlSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }

    @Test
    public void testXml2Serializer() {
        Xml2Serializer xmlSerializer = new Xml2Serializer();
        User user = new User();
        user.setAge(30);
        byte[] serialize = xmlSerializer.serialize(user);
        System.out.println("size: "+serialize.length);
        User deserialize = xmlSerializer.deserialize(serialize, User.class);
        System.out.println(deserialize.getAge());
    }


}
