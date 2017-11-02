package com.bingo.comm.demo;

import org.apache.commons.lang3.EnumUtils;


public enum RuleResultCode {

    PUBLISH_NOT_ALLOW("当前发布不允许"),
    STR_HAS_SPECIAL("内容含有特殊字符"),
    OBJECT_NOT_EQUAL("传入数据不相等"),
    TITLE_NO_UPDATE("标题禁止更新"),
    TABS_INVALID("Tabs数据无效"),
    TEXT_TOO_SHOT("亲，请多输几个字呢"),
    TEXT_TOO_LONG("文本超出长度限制"),
    HAS_KFC_WORD("内容含有违禁词"),
    CAT_BLACK_LIST("该类目暂不开放"),
    ITEM_ID_INVALID("宝贝ID无效"),
    RULE_RETURN_NULL("规则返回结果为空"),
    RULE_EXECUTE_EXCEPTION("规则执行异常"),
    TAOQI_NOT_MATCH("淘气值不符合要求"),
    USER_ID_INVALID("内容作者ID无效"),
    USER_NOT_EXISTS("内容作者不存在"),
    USER_NOT_VDAREN("当前用户不是加V达人"),
    USER_NOT_SHOP("当前用户不是店铺"),
    USER_NOT_IN_WHITELIST("当前用户不在白名单中"),
    USER_NOT_INVITED("当前用户不是受邀用户"),
    USER_NOT_EXPERT("当前用户不是嘉宾"),
    USER_IN_BLACK_LIST("当前用户是黑名单用户"),
    USER_RANK_NUM_ZERO("当前用户信用等级双0"),
    USER_MOBILE_PHONE_EMPTY("当前用户手机号为空"),
    USER_NOT_LEIFENG("当前用户非雷锋侠"),
    POST_PRE_CHECK_NOT_PASS("当前用户非雷锋侠或淘气值小于500分"),
    POST_SYNC_CHECK_NOT_PASS("当前帖子内容kfc不通过"),;

    RuleResultCode(String message) {
        this.message = message;
    }

    public String message;

    public String getMessage() {
        return message;
    }

    public static String getMessage(String code) {
        RuleResultCode error = EnumUtils.getEnum(RuleResultCode.class, code);
        if (error != null) {
            return error.getMessage();
        } else {
            return null;
        }
    }

    public String toString() {
        return this.name() + ":" + this.message;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String s = EnumUtils.getEnum(RuleResultCode.class, "FEATURE_TOO_LONG").getMessage();
        System.out.println(s);
    }

}