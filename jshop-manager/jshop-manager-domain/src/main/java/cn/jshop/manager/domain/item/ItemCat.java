/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品类目											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-20  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.domain.item;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.jshop.common.domain.BaseDomain;

import java.util.*;

/**
 * 《商品类目》 实体
 * @author 郭旭辉
 *
 */
public class ItemCat extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Long parent_id; //父类目ID=0时，代表的是一级的类目
	private String name; //类目名称
	private Integer sort_order; //排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	private Boolean is_parent; //该类目是否为父类目，1为true，0为false
	private Date created; //创建时间
	private Date updated; //创建时间
	private Integer status;//状态。可选值:1(正常),2(删除)
    
	/**
	 *默认空构造函数
	 */
	public ItemCat() {
		super();
	}
	 
	/**
	 * @return parent_id 父类目ID=0时，代表的是一级的类目
	 */
	public Long getParent_id(){
		return this.parent_id;
	}
	/**
	 * @param parent_id 父类目ID=0时，代表的是一级的类目
	 */
	public void setParent_id(Long parent_id){
		this.parent_id = parent_id;
	}
	/**
	 * @return name 类目名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 类目名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return sort_order 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 */
	public Integer getSort_order(){
		return this.sort_order;
	}
	/**
	 * @param sort_order 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 */
	public void setSort_order(Integer sort_order){
		this.sort_order = sort_order;
	}
	/**
	 * @return is_parent 该类目是否为父类目，1为true，0为false
	 */
	public Boolean getIs_parent(){
		return this.is_parent;
	}
	/**
	 * @param is_parent 该类目是否为父类目，1为true，0为false
	 */
	public void setIs_parent(Boolean is_parent){
		this.is_parent = is_parent;
	}
	/**
	 * @return created 创建时间
	 */
	public Date getCreated(){
		return this.created;
	}
	/**
	 * @param created 创建时间
	 */
	public void setCreated(Date created){
		this.created = created;
	}
	/**
	 * @return updated 创建时间
	 */
	public Date getUpdated(){
		return this.updated;
	}
	/**
	 * @param updated 创建时间
	 */
	public void setUpdated(Date updated){
		this.updated = updated;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("parent_id",getParent_id())
			.append("name",getName())
			.append("status",getStatus())
			.append("sort_order",getSort_order())
			.append("is_parent",getIs_parent())
			.append("created",getCreated())
			.append("updated",getUpdated())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getParent_id())
			.append(getName())
			.append(getStatus())
			.append(getSort_order())
			.append(getIs_parent())
			.append(getCreated())
			.append(getUpdated())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ItemCat == false) return false;
		if(this == obj) return true;
		ItemCat other = (ItemCat)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
