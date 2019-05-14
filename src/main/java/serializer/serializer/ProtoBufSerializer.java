package serializer.serializer;

import com.google.protobuf.GeneratedMessageV3;
import org.apache.commons.lang3.reflect.MethodUtils;

/**
 * @author zhangzhidong
 * @since 2019/5/14
 */
public class ProtoBufSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        try {
            if (!(obj instanceof GeneratedMessageV3)) {
                throw new UnsupportedOperationException("not supported obj type");
            }
            return (byte[]) MethodUtils.invokeMethod(obj, "toByteArray");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        try {
            if (!GeneratedMessageV3.class.isAssignableFrom(clazz)) {
                throw new UnsupportedOperationException();
            }
            Object o = MethodUtils.invokeStaticMethod(clazz, "getDefaultInstance");
            return (T) MethodUtils.invokeMethod(o, "parseFrom", new Object[]{data});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
