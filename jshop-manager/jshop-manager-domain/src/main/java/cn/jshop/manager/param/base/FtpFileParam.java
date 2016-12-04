/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：ftp文件状态											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-12-03  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.param.base;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 《ftp文件状态》 查询参数实体
 * @author 郭旭辉
 *
 */
public class FtpFileParam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——远程路径
	*/
	public static final String F_RemotePath="remotePath";
	/**
	*字段常量——文件路径
	*/
	public static final String F_FilePath="filePath";
	/**
	*字段常量——文件名
	*/
	public static final String F_FileName="fileName";

	public static final String F_Status="status";

	private String remotePath; //远程路径
	private String filePath; //文件路径
	private String fileName; //文件名
    private Integer status;		//状态，0：正常，1：审核
	/**
	 *默认空构造函数
	 */
	public FtpFileParam() {
		super();
	}
	 
	/**
	 * @return remotePath 远程路径
	 */
	public String getRemotePath(){
		return this.remotePath;
	}
	/**
	 * @param remotePath 远程路径
	 */
	public void setRemotePath(String remotePath){
		this.remotePath = remotePath;
	}
	/**
	 * @return filePath 文件路径
	 */
	public String getFilePath(){
		return this.filePath;
	}
	/**
	 * @param filePath 文件路径
	 */
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	/**
	 * @return fileName 文件名
	 */
	public String getFileName(){
		return this.fileName;
	}
	/**
	 * @param fileName 文件名
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("remotePath",getRemotePath())
			.append("filePath",getFilePath())
			.append("fileName",getFileName())
			.append("status",getStatus())
			.toString();
	}
	
}
