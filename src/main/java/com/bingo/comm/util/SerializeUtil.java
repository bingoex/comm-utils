package com.bingo.comm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
    public SerializeUtil() {
    }

    public static byte[] serialize(Object o) {
        if (o == null) {
            throw new NullPointerException("Can't serialize null");
        } else {
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(bos);
                os.writeObject(o);
                os.close();
                bos.close();
                return bos.toByteArray();
            } catch (IOException var3) {
                throw new IllegalArgumentException("Non-serializable object", var3);
            }
        }
    }

    public static Object deserialize(byte[] in) {
        Object rv = null;

        try {
            if (in != null) {
                ByteArrayInputStream bis = new ByteArrayInputStream(in);
                ObjectInputStream is = new ObjectInputStream(bis);
                rv = is.readObject();
                is.close();
                bis.close();
            }

            return rv;
        } catch (Exception var4) {
            throw new RuntimeException("deserialize failed", var4);
        }
    }

    public static void main(String[] args) {
        Long f = 33L;
        byte[] bytes = serialize(f);
        System.out.println(deserialize(bytes).getClass());
    }
}

/* JSON

//收包
String str = new String(bytes, charset);
return (T)JSON.parseObject(str, entityClass);
//JSON.parseObject(StringUtil.toEncodedString(bytes, Charsets.UTF_8), JobMessage.class);


//发送
//JSON.toJSONString(obj).getBytes(charset);

*/