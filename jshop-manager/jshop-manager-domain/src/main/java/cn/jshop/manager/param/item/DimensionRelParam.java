/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品规格和商品的关系表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-12-07  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.param.item;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.jshop.common.param.CreateBaseParam;

import java.util.*;

/**
 * 《商品规格和商品的关系》 查询参数实体
 * @author 郭旭辉
 *
 */
public class DimensionRelParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——商品ID
	*/
	public static final String F_ItemId="itemId";
	/**
	*字段常量——参数数据，格式为json格式
	*/
	public static final String F_Param_data="param_data";
	
	private Long itemId; //商品ID
	private String param_data; //参数数据，格式为json格式
    
	/**
	 *默认空构造函数
	 */
	public DimensionRelParam() {
		super();
	}
	 
	/**
	 * @return itemId 商品ID
	 */
	public Long getItemId(){
		return this.itemId;
	}
	/**
	 * @param itemId 商品ID
	 */
	public void setItemId(Long itemId){
		this.itemId = itemId;
	}
	/**
	 * @return param_data 参数数据，格式为json格式
	 */
	public String getParam_data(){
		return this.param_data;
	}
	/**
	 * @param param_data 参数数据，格式为json格式
	 */
	public void setParam_data(String param_data){
		this.param_data = param_data;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("itemId",getItemId())
			.append("param_data",getParam_data())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
