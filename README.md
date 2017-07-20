### README

为了提高工作效率在通过mybatis-generator插件生成实体类时就自动生成swagger需要的注解信息，同时解决在接收和返回日期格式的数据时需要手动对每个日期格式的字段添加相应注解的问题，修改了org.mybatis.generator.core-1.3.5的源码。

具体的修改过程[查看博客](https://xiachengwei5.github.io/2017/07/19/mybatis%20generator%E6%8F%92%E4%BB%B6%E8%87%AA%E5%AE%9A%E4%B9%89%E4%BF%AE%E6%94%B9/) 

主要修改内容如下：
* 屏蔽mybatis-generator生成的实体类中默认的注释；
* 添加swagger API文档需要的字段注解（@ApiModel(value ="")和@ApiModelProperty(value = "")）；
* 添加接收日期参数和将返回日期数据格式化所需的注解（@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")和@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")）；

生成实体类的效果如下：
``` java
/**
 * 实体类对应的数据表为： user_info
 * @author Jeff
 * @date 2017-07-19 13:58:22
 */
@ApiModel(value = "人员信息表")
public class UserInfo {
	@ApiModelProperty(value = "ID")
	private Integer id;

	@ApiModelProperty(value = "用户登录账号")
	private String userNo;

	@ApiModelProperty(value = "姓名")
	private String userName;

	@ApiModelProperty(value = "姓名拼音")
	private String spellName;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "手机号")
	private String userPhone;

	@ApiModelProperty(value = "性别")
	private Integer userGender;

	@ApiModelProperty(value = "头像地址")
	private String userImg;

	@ApiModelProperty(value = "职务")
	private String userDuty;

	@ApiModelProperty(value = "排序号")
	private Integer sortCode;

	@ApiModelProperty(value = "记录创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	@ApiModelProperty(value = "记录修改时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getSpellName() {
		return spellName;
	}

	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg == null ? null : userImg.trim();
	}

	public String getUserDuty() {
		return userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty == null ? null : userDuty.trim();
	}

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userNo=").append(userNo);
		sb.append(", userName=").append(userName);
		sb.append(", spellName=").append(spellName);
		sb.append(", password=").append(password);
		sb.append(", userPhone=").append(userPhone);
		sb.append(", userGender=").append(userGender);
		sb.append(", userImg=").append(userImg);
		sb.append(", userDuty=").append(userDuty);
		sb.append(", sortCode=").append(sortCode);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append("]");
		return sb.toString();
	}
}
```

