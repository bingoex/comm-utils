package com.bingo.comm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtil {

    /**
     * 深克隆一个对象，防止同一个对象，有dbItem/inputItem两个holder，防止inputItem.setProv()变了数据，dbItem.prov也变了数据
     *
     * @param src
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T deepCloneBySerialize(T src) {
        T o = null;
        try {
            if (src != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(src);
                oos.close();
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                o = (T) ois.readObject();
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * 字节数组转换为对象
     *
     * @param objBytes
     * @return
     */
    public static Object getObjectFromBytes(byte[] objBytes) {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = null;
        Object obj = null;
        try {
            oi = new ObjectInputStream(bi);
            obj = oi.readObject();
        } catch (Exception e) {
            throw new RuntimeException("反序列化异常", e);
        } finally {
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException e) {
                }
            }
        }
        return obj;
    }

    /**
     * 对象转换为字节数组
     *
     * @param obj
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static byte[] getBytesFromObject(Serializable obj) throws IOException {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }
}
