package cn.jshop.common.utils;

/**
 * Created by 郭旭辉 on 2016/3/12.
 * 查询匹配类型枚举
 */
public enum MatchTypeEnum {
    /**
     * 精确匹配 content
     */
    EXACT,
    /**
     * 左匹配 模糊查询 %content
     */
    LEFT_FUZZY,
    /**
     * 右匹配 模糊查询 content%
     */
    RIGHT_FUZZY,
    /**
     * 模糊查询 %content%
     */
    ALL_FUZZY;
}
