/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  simagle
{  审查人：
{  模块：商品表
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

import cn.jshop.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《商品》 查询参数实体
 * @author simagle
 *
 */
public class ItemParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 *字段常量——商品标题
	 */
	public static final String F_Title="title";
	/**
	 *字段常量——商品卖点
	 */
	public static final String F_Sell_point="sell_point";
	/**
	 *字段常量——商品价格，单位为：分
	 */
	public static final String F_Price="price";
	/**
	 *字段常量——库存数量
	 */
	public static final String F_Num="num";
	/**
	 *字段常量——商品条形码
	 */
	public static final String F_Barcode="barcode";
	/**
	 *字段常量——商品图片
	 */
	public static final String F_Image="image";
	/**
	 *字段常量——所属类目，叶子类目
	 */
	public static final String F_Cid="cid";

	private String title; //商品标题
	private String sell_point; //商品卖点
	private Long price; //商品价格，单位为：分
	private Integer num; //库存数量
	private String barcode; //商品条形码
	private String image; //商品图片
	private Long cid; //所属类目，叶子类目

	/**
	 *默认空构造函数
	 */
	public ItemParam() {
		super();
	}

	/**
	 * @return title 商品标题
	 */
	public String getTitle(){
		return this.title;
	}
	/**
	 * @param title 商品标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * @return sell_point 商品卖点
	 */
	public String getSell_point(){
		return this.sell_point;
	}
	/**
	 * @param sell_point 商品卖点
	 */
	public void setSell_point(String sell_point){
		this.sell_point = sell_point;
	}
	/**
	 * @return price 商品价格，单位为：分
	 */
	public Long getPrice(){
		return this.price;
	}
	/**
	 * @param price 商品价格，单位为：分
	 */
	public void setPrice(Long price){
		this.price = price;
	}
	/**
	 * @return num 库存数量
	 */
	public Integer getNum(){
		return this.num;
	}
	/**
	 * @param num 库存数量
	 */
	public void setNum(Integer num){
		this.num = num;
	}
	/**
	 * @return barcode 商品条形码
	 */
	public String getBarcode(){
		return this.barcode;
	}
	/**
	 * @param barcode 商品条形码
	 */
	public void setBarcode(String barcode){
		this.barcode = barcode;
	}
	/**
	 * @return image 商品图片
	 */
	public String getImage(){
		return this.image;
	}
	/**
	 * @param image 商品图片
	 */
	public void setImage(String image){
		this.image = image;
	}
	/**
	 * @return cid 所属类目，叶子类目
	 */
	public Long getCid(){
		return this.cid;
	}
	/**
	 * @param cid 所属类目，叶子类目
	 */
	public void setCid(Long cid){
		this.cid = cid;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("title",getTitle())
				.append("sell_point",getSell_point())
				.append("price",getPrice())
				.append("num",getNum())
				.append("barcode",getBarcode())
				.append("image",getImage())
				.append("cid",getCid())
				.append("status",getStatus())
				.append("createDate",getCreateDate())
				.append("creator",getCreator())
				.append("lastModifier",getLastModifier())
				.append("lastModDate",getLastModDate())
				.toString();
	}

}