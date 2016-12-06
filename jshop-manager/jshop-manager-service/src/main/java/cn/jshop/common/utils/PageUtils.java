package cn.jshop.common.utils;


import cn.jshop.common.domain.BizData4Page;

import java.util.List;

/**
 * Created by 郭旭辉 on 2016/4/16.
 * 分页工具类
 */
public class PageUtils {
    public static BizData4Page toBizData4Page(List data, int pageNo, int pageSize, int records) {
        BizData4Page bizData4Page = new BizData4Page();
        bizData4Page.setRows(data);
        bizData4Page.setPage(pageNo);
        bizData4Page.setRecords(records);
        int total = records / pageSize;
        int mod = records % pageSize;
        if (mod > 0) {
            total = total + 1;
        }
        bizData4Page.setTotal(total);
        bizData4Page.setOffset((pageNo - 1) * pageSize + 1);
        bizData4Page.setEndOffset( pageNo * pageSize);
        return bizData4Page;
    }
}
