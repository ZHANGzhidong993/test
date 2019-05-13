package serializer.serializer;

/**
 * @author zhangzhidong
 * @since 2019/5/13
 */
public interface ISerializer {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serialize(T obj);

    /**
     * 反序列化
     *
     * @param <T>
     * @return
     */
    <T> T deserialize(byte[] data, Class<T> clazz);
}
