package com.bingo.comm.demo;

import org.apache.commons.lang3.BooleanUtils;

/**
 *  demo for ThreadLocal
 */
public class RuleContext {

    /**
     * 执行规则序号
     */
    static final ThreadLocal<Integer> order = new ThreadLocal<>();

    /**
     * 执行场景ID
     */
    static final ThreadLocal<String> scene = new ThreadLocal<>();

    /**
     * 是否结束规则执行，直接返回结果
     */
    static final ThreadLocal<Boolean> end = new ThreadLocal<>();

    /**
     * feedId
     */
    static final ThreadLocal<Long> id = new ThreadLocal<>();

    /**
     * 使用init必须在任务完成后调用clear
     */
    public static void init(String sceneId, long feedId) {
        scene.set(sceneId);
        order.set(0);
        end.set(false);
        id.set(feedId);
    }

    public static Long getId() {
        return id.get();
    }

    public static void incOrder() { order.set(order.get() + 1);
    }

    public static int getOrder() {
        return order.get();
    }

    public static String getScene() {
        return scene.get();
    }

    public static void end() {
        end.set(true);
    }

    public static boolean isEnd() {
        return BooleanUtils.isTrue(end.get());
    }


    public static void clear() {
        scene.remove();
        order.remove();
        end.remove();
        id.remove();
    }
}
