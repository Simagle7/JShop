package cn.jshop.common.domain;

import java.util.Date;

/**
 * Created by 郭旭辉 on 2016/3/10.
 */
public class CreateBaseDomain<T>  extends BaseDomain<T> {
    private Object creator;
    private Long createDate;
    private Object lastModifier;
    private Long lastModDate = Long.valueOf(System.currentTimeMillis());
    private Integer status;

    public CreateBaseDomain() {
    }

    public Object getCreator() {
        return this.creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Long getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Object getLastModifier() {
        return this.lastModifier;
    }

    public void setLastModifier(Object lastModifier) {
        this.lastModifier = lastModifier;
    }

    public Long getLastModDate() {
        return this.lastModDate;
    }

    public void setLastModDate(Long lastModDate) {
        this.lastModDate = lastModDate;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDateAsDate() {
        return this.createDate == null?new Date():(this.createDate.longValue() > 0L?new Date(this.createDate.longValue()):null);
    }

    public Date getLastModDateAsDate() {
        return this.lastModDate == null?new Date():(this.lastModDate.longValue() > 0L?new Date(this.lastModDate.longValue()):null);
    }
}
