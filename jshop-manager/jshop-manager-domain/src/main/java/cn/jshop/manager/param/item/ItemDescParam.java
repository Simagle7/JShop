/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  simagle
{  审查人：
{  模块：商品描述表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-23  simagle        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.param.item;

import cn.jshop.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 《商品描述》 查询参数实体
 * @author simagle
 *
 */
public class ItemDescParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——商品ID
	*/
	public static final String F_Item_id="item_id";
	/**
	*字段常量——商品描述
	*/
	public static final String F_Item_desc="item_desc";
	/**
	*字段常量——创建时间
	*/
	public static final String F_Created="created";
	/**
	*字段常量——更新时间
	*/
	public static final String F_Updated="updated";
	
	private Long item_id; //商品ID
	private String item_desc; //商品描述
	private Date created; //创建时间
	private Date updated; //更新时间
    
	/**
	 *默认空构造函数
	 */
	public ItemDescParam() {
		super();
	}
	 
	/**
	 * @return item_id 商品ID
	 */
	public Long getItem_id(){
		return this.item_id;
	}
	/**
	 * @param item_id 商品ID
	 */
	public void setItem_id(Long item_id){
		this.item_id = item_id;
	}
	/**
	 * @return item_desc 商品描述
	 */
	public String getItem_desc(){
		return this.item_desc;
	}
	/**
	 * @param item_desc 商品描述
	 */
	public void setItem_desc(String item_desc){
		this.item_desc = item_desc;
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
	 * @return updated 更新时间
	 */
	public Date getUpdated(){
		return this.updated;
	}
	/**
	 * @param updated 更新时间
	 */
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("item_id",getItem_id())
			.append("item_desc",getItem_desc())
			.append("created",getCreated())
			.append("updated",getUpdated())
			.toString();
	}
	
}
