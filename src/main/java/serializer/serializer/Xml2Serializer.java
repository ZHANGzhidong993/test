package serializer.serializer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author zhangzhidong
 * @since 2019/5/13
 */
public class Xml2Serializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLEncoder xe = new XMLEncoder(out, "utf-8", true, 0);
        xe.writeObject(obj);
        xe.close();
        return out.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(data));
        Object o = xmlDecoder.readObject();
        xmlDecoder.close();
        return (T) o;
    }
}
