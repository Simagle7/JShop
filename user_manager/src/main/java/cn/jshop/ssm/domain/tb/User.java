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

package cn.jshop.ssm.domain.tb;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.jshop.common.domain.BaseDomain;

import java.util.*;

/**
 * 《用户表》 实体
 * @author 郭旭辉
 *
 */
public class User extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
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
	public User() {
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
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getUser_name())
			.append(getPassword())
			.append(getName())
			.append(getAge())
			.append(getSex())
			.append(getBirthday())
			.append(getCreated())
			.append(getUpdated())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
