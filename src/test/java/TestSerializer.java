import org.junit.Test;
import serializer.pojo.AddressBookProtos;
import serializer.pojo.User;
import serializer.serializer.*;

/**
 * @author zhangzhidong
 * @since 2019/5/13
 */
public class TestSerializer {

    private User user;

    private AddressBookProtos.Person person;

    {
        User user = new User();
        user.setTel("18668158627");
        user.setPassword("heheada");
        user.setUsername("nihaohhh");
        user.setAge(18);
        this.user = user;


        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder().setEmail("zzd@163.com").setId(10000).setName("zzd").addPhone
                (AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("13300000000").setType(AddressBookProtos
                        .Person.PhoneType.HOME).build()).build();

        this.person = person;
    }

    /**
     * 235
     */
    @Test
    public void testDefaultJavaSerializer() {
        DefaultJavaSerializer javaSerializer = new DefaultJavaSerializer();
        byte[] serialize = javaSerializer.serialize(person);
        System.out.println("size: " + serialize.length);
        AddressBookProtos.Person deserialize = javaSerializer.deserialize(serialize, AddressBookProtos.Person.class);
        System.out.println(deserialize.getName());
    }

    /**
     * 312
     */
    @Test
    public void testXmlSerializer() {
        XmlSerializer xmlSerializer = new XmlSerializer();
        byte[] serialize = xmlSerializer.serialize(person);
        System.out.println("size: " + serialize.length);
        AddressBookProtos.Person deserialize = xmlSerializer.deserialize(serialize, AddressBookProtos.Person.class);
        System.out.println(deserialize.getName());
    }

    /**
     * 104
     */
    @Test
    public void testXml2Serializer() {
        Xml2Serializer xmlSerializer = new Xml2Serializer();
        byte[] serialize = xmlSerializer.serialize(person);
        System.out.println("size: " + serialize.length);
        AddressBookProtos.Person deserialize = xmlSerializer.deserialize(serialize, AddressBookProtos.Person.class);
        System.out.println(deserialize.getName());
    }

    /**
     * 406
     */
    @Test
    public void testJSONSerializer() {
        JSONSerializer jsonSerializer = new JSONSerializer();
        byte[] serialize = jsonSerializer.serialize(person);
        System.out.println("size: " + serialize.length);
        AddressBookProtos.Person deserialize = jsonSerializer.deserialize(serialize, AddressBookProtos.Person.class);
        System.out.println(deserialize.getName());
    }

    /**
     * 173
     */
    @Test
    public void testHessianSerializer() {
        HessianSerializer hessianSerializer = new HessianSerializer();
        byte[] serialize = hessianSerializer.serialize(person);
        System.out.println("size: " + serialize.length);
        AddressBookProtos.Person deserialize = hessianSerializer.deserialize(serialize, AddressBookProtos.Person.class);
        System.out.println(deserialize.getName());
    }

    /**
     * 38
     */
    @Test
    public void testProtoBufSerializer() {
        ProtoBufSerializer serializer = new ProtoBufSerializer();
        byte[] data = serializer.serialize(person);
        System.out.println("size: " + data.length);
        AddressBookProtos.Person personCopy = serializer.deserialize(data, AddressBookProtos.Person.class);
        System.out.println(personCopy.getName());
    }

    /**
     * 34
     */
    @Test
    public void testProtoStuffSerializer() {
        ProtoStuffSerializer serializer = new ProtoStuffSerializer();
        byte[] data = serializer.serialize(user);
        System.out.println("size: " + data.length);
        User user = serializer.deserialize(data, User.class);
        System.out.println(user.getAge());
    }

}
