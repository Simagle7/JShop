package cn.jshop.manager.domain.item;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by 郭旭辉 on 2016/12/2.
 * ftp 文件dto
 */
public class FtpFileDto implements Serializable {
    private static final long serialVersionUID = 9099985562293823380L;
    /**
     * 远程路径
     */
    private String remotePath;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 状态，0：正常，1：审核
     */
    private Integer status;

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("remotePath:" + getRemotePath())
                .append("filePayh:" + getFilePath())
                .append("fileName:" + getFileName())
                .append("status:" + getStatus())
                .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append("remotePath:" + getRemotePath())
                .append("filePayh:" + getFilePath())
                .append("fileName:" + getFileName())
                .append("status:" + getStatus())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FtpFileDto)) return false;
        if (this == obj) return true;
        FtpFileDto other = (FtpFileDto) obj;
        return new EqualsBuilder()
                .append(getFileName(), other.getFileName())
                .isEquals();
    }
}
