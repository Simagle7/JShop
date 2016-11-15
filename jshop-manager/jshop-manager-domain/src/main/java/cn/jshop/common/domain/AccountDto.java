package cn.jshop.common.domain;

/**
 * Created by 郭旭辉 on 2016/6/24.
 */
public class AccountDto {
    private String username; //账号
    private String name; //姓名
    private String phone; //联系电话
    private String lineTel; //固定电话
    private Integer age; //年龄
    private Integer gender; //性别
    private String jobNumber; //工号
    private Integer positionId; //职位
    private Integer departmentId; //所属部门
    private String uid; //uuid

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLineTel() {
        return lineTel;
    }

    public void setLineTel(String lineTel) {
        this.lineTel = lineTel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
