package com.bingo.comm.cache;

import java.util.List;
import java.util.Map;

public interface CacheManager<T> {

    /**
     * 单条获取缓存
     */
    T get(String key);

    /**
     * 批量获取
     */
    Map<String, T> mGet(List<String> keys);

    /**
     * 失效key
     */
    boolean invalid(String key);

    /**
     * 删除key
     */
    boolean delete(String key);

    /**
     * 设置数据，如果数据已经存在，则覆盖，如果不存在，则新增<br>
     * 如果是新增，则有效时间为0，即不失效<br>
     * 如果是更新，则不检查版本，强制更新<br>
     */
    boolean put(String tairKey, Object obj);
}
