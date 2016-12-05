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

package cn.jshop.manager.domain.item;

/**
 * 《商品》扩展实体
 * @author 郭旭辉
 *
 */
public class ItemEx extends Item {
	private static final long serialVersionUID = 1L;
	
	//针对Item实体在这里增加额外的属性和对应的get和set方法
	private String priceF;	//格式化后的价格
	private String category; //所属分类
	private String[] images;

	public String getPriceF() {
		return priceF;
	}

	public void setPriceF(String priceF) {
		this.priceF = priceF;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = this.getImage().split(",");
	}
}
