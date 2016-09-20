/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-20  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.ssm.param.tb;

import cn.jshop.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 《用户表》 查询参数实体
 * @author 郭旭辉
 *
 */
public class UserParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户名
	*/
	public static final String F_User_name="user_name";
	/**
	*字段常量——密码
	*/
	public static final String F_Password="password";
	/**
	*字段常量——姓名
	*/
	public static final String F_Name="name";
	/**
	*字段常量——年龄
	*/
	public static final String F_Age="age";
	/**
	*字段常量——性别，1男性，2女性
	*/
	public static final String F_Sex="sex";
	/**
	*字段常量——出生日期
	*/
	public static final String F_Birthday="birthday";
	/**
	*字段常量——创建时间
	*/
	public static final String F_Created="created";
	/**
	*字段常量——更新时间
	*/
	public static final String F_Updated="updated";
	
	private String user_name; //用户名
	private String password; //密码
	private String name; //姓名
	private Integer age; //年龄
	private Boolean sex; //性别，1男性，2女性
	private Date birthday; //出生日期
	private Date created; //创建时间
	private Date updated; //更新时间
    
	/**
	 *默认空构造函数
	 */
	public UserParam() {
		super();
	}
	 
	/**
	 * @return user_name 用户名
	 */
	public String getUser_name(){
		return this.user_name;
	}
	/**
	 * @param user_name 用户名
	 */
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	/**
	 * @return password 密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * @return name 姓名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return age 年龄
	 */
	public Integer getAge(){
		return this.age;
	}
	/**
	 * @param age 年龄
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 * @return sex 性别，1男性，2女性
	 */
	public Boolean getSex(){
		return this.sex;
	}
	/**
	 * @param sex 性别，1男性，2女性
	 */
	public void setSex(Boolean sex){
		this.sex = sex;
	}
	/**
	 * @return birthday 出生日期
	 */
	public Date getBirthday(){
		return this.birthday;
	}
	/**
	 * @param birthday 出生日期
	 */
	public void setBirthday(Date birthday){
		this.birthday = birthday;
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
			.append("id",getId())
			.append("user_name",getUser_name())
			.append("password",getPassword())
			.append("name",getName())
			.append("age",getAge())
			.append("sex",getSex())
			.append("birthday",getBirthday())
			.append("created",getCreated())
			.append("updated",getUpdated())
			.toString();
	}
	
}
