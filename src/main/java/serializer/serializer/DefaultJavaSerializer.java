package serializer.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java 自带序列化机制
 * <p>
 * 优点：
 * <p>
 * 1.无需第三方依赖
 * 2.与Java语言有天然的最好的易用性与亲和性
 * <p>
 * 缺点：
 * <p>
 * 1.只支持Java，不支持跨语言
 * 2.Java默认的序列化性能欠佳，序列化后产生的码流过大，对于引用过深的对象，序列化易发生内存OOM异常
 *
 * @author zhangzhidong
 * @since 2019/5/13
 */
public class DefaultJavaSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
