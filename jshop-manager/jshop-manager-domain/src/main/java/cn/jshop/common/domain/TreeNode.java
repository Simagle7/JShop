package cn.jshop.common.domain;

/**
 * Created by 郭旭辉 on 2016/10/23.
 * 树节点
 */
public class TreeNode {
    /**
     * 节点 id
     */
    private Integer id;

    /**
     * 父节点 id
     */
    private  Integer pId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 是否是父节点 ，true: 是，false： 否
     */
    private boolean isParent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }


}
