package serializer.serializer;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author zhangzhidong
 * @create: 2019-05-14 22:50
 */
public class SerializerEngine {

    public static final Map<SerializeType, ISerializer> SERIALIZER_MAP = Maps.newConcurrentMap();

    static {
        SERIALIZER_MAP.put(SerializeType.DefaultJavaSerializer, new DefaultJavaSerializer());
        SERIALIZER_MAP.put(SerializeType.HessianSerializer, new HessianSerializer());
        SERIALIZER_MAP.put(SerializeType.JSONSerializer, new JSONSerializer());
        SERIALIZER_MAP.put(SerializeType.XmlSerializer, new XmlSerializer());
        SERIALIZER_MAP.put(SerializeType.ProtoStuffSerializer, new ProtoStuffSerializer());

        SERIALIZER_MAP.put(SerializeType.ProtoBufferSerializer, new ProtoBufSerializer());
    }

    public static <T> byte[] serialize(T obj, String serializeType) {
        ISerializer serializer = getiSerializer(serializeType);
        try {
            return serializer.serialize(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(byte[] data, Class<T> clazz, String serializeType) {
        ISerializer serializer = getiSerializer(serializeType);
        try {
            return serializer.deserialize(data, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ISerializer getiSerializer(String serializeType) {
        SerializeType serialize = SerializeType.queryByType(serializeType);
        if (serialize == null) {
            throw new RuntimeException("serialize is null");
        }
        ISerializer serializer = SERIALIZER_MAP.get(serialize);
        if (serializer == null) {
            throw new RuntimeException("unsupported serializer");
        }
        return serializer;
    }
}
