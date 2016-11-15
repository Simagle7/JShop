/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品表											
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

package cn.jshop.manager.param.item;

/**
 * 《商品》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ItemParamEx extends ItemParam {
	private static final long serialVersionUID = 1L;
	
	//针对ItemParam实体在这里增加额外的属性和对应的get和set方法
	private String description;
	private double priceView;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPriceView() {
		return priceView;
	}

	public void setPriceView(double priceView) {
		this.priceView = priceView;
	}
}