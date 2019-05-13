package serializer.serializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * XML序列化 XStream
 * <p>
 * 优点：
 * 1.可读性好
 * 2.易于调试
 * <p>
 * 缺点：
 * 1.码流太大
 *
 * @author zhangzhidong
 * @since 2019/5/13
 */
public class XmlSerializer implements ISerializer {

    private static final XStream X_STREAM = new XStream(new DomDriver());

    @Override
    public <T> byte[] serialize(T obj) {
        return X_STREAM.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String xml = new String(data);
        return (T) X_STREAM.fromXML(xml);
    }
}
