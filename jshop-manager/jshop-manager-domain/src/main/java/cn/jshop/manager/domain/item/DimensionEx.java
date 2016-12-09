/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品规则参数											
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

package cn.jshop.manager.domain.item;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 《商品规则参数》扩展实体
 * @author 郭旭辉
 *
 */
public class DimensionEx extends Dimension {
	private static final long serialVersionUID = 1L;
	
	//针对Dimension实体在这里增加额外的属性和对应的get和set方法
	private String category;	//分类名称

	private JSONObject contentJson; // 参数内容的json实例

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public JSONObject getContentJson() {
		return JSON.parseObject(super.getParam_data());
	}

	public void setContentJson(JSONObject contentJson) {
		this.contentJson = contentJson;
	}
}
