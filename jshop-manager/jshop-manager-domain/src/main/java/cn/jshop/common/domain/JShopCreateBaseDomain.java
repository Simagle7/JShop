package cn.jshop.common.domain;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
public class JShopCreateBaseDomain<T> extends BaseDomain<T> {
    private Object creator;
    private Long createDate = System.currentTimeMillis();
    private Object lastModifier;
    private Long lastModDate = System.currentTimeMillis();
    private Integer status;

    public JShopCreateBaseDomain(){}

    public Object getCreator() {
        return creator;
    }

    public void setCreator(Object creator) {
        this.creator = creator;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Object getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(Object lastModifier) {
        this.lastModifier = lastModifier;
    }

    public Long getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(Long lastModDate) {
        this.lastModDate = lastModDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
