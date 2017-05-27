
package third.servlet;

import java.io.File;

/**
 * json接口常量
 * @author xiaowei
 *
 */
public interface JsonFieldConstant {
	
	public final static String XK_VCODE="vcode";  //手机验证码
	public final static String XK_VCODE_NUM="1234";  //手机临时验证码	
	public final static String ROOT_PATH = "C:"+File.separator+"third"+File.separator+"newsImg";
	public final static String XK_TESTIP = "http://localhost:9797";
	
	//token
	public final static String XK_TOKEN = "token";
	public final static String EZ_ACCESSTOKEN = "accessToken";
	//UTF-8
	public final static String CHARSET_UTF8 = "UTF-8";
	public final static String CHARSET_IMAGE = "image/jpeg";
	//json content-type
	public final static String CONTENT_TYPE_JSON = "text/json";
		
	public final static String XK_GRADE="";  //年级
	public final static String XK_CLASS="";  //班
	
	//user相关
	public final static String XK_USER_USERNO="userNo"; // 用户ID
	public final static String XK_USER_OLDPASSWORD="oldpassword"; // 原密码
	public final static String XK_USER_PASSWORD="password"; // 密码
	public final static String XK_USER_SEX="sex"; // 性别
	public final static String XK_USER_PHONE="phone";  //手机
	public final static String XK_USER_EMAIL="email";  //email
	public final static String XK_USER_GRADE="grade";  //年级
	public final static String XK_USER_CLASSROOM="classRoom";  //班级
	public final static String XK_USER_USERNAME="userName";  //用户名
	public final static String XK_USER_DIRECTSEDDING="directSeeding";  //直播权限
	public final static String XK_USER_IMGHEAD="imgHead";  //头像
	public final static String XK_USER_ISUPDATE="isUpdate";  //是否更新
	public final static String XK_USER_STARTFLAG="startFlag";  //是否启用
	public final static String XK_USER_GUIDUSERS="guidUsers";  // 关联用户id
	public final static String XK_USER_STUDENTNAME="studentName";  // 学生姓名
	public final static String XK_USER_GUIDSCHOOL="guidSchool";  // 关联学校
	public final static String XK_USER_MEMO="memo";  // 备注
	public final static String XK_USER_USERIDENTITY="userIdentity";  // 用户身份
	
	//版本相关Version
	public final static String XK_VERSION_VERSION="version";
	public final static String XK_VERSION_UPDATEURL="updateurl";
	
	//school 相关
	public final static String XK_SCHOOL_LIST="schoolList"; // 学校列表
	public final static String XK_SCHOOLTYPE_LIST="schoolTypeList"; // 学校类别列表
	public final static String XK_SCHOOL_TYPENAME="typeName"; // 学校类别名称
	
	public final static String XK_SCHOOL_RECID="recid"; // 学校RECID
	public final static String XK_SCHOOL_GUIDSCHOOL="guidSchool"; // 学校RECID
	public final static String XK_SCHOOL_SCHOOLNAME="schoolName"; // 学校名称
	public final static String XK_SCHOOL_SCHOOLNO="schoolNo"; // 学校ID
	public final static String XK_SCHOOL_IMGAPPFIRSTFOCUS="imgAppFirstFocus"; // 学校图片
	public final static String XK_SCHOOL_SCHOOLTYPE="schoolType"; // 学校类型
	public final static String XK_SCHOOL_GUIDAREA="guidArea"; // 地区id
	public final static String XK_SCHOOL_GRADELIST="gradeList";  // 年级列表
	public final static String XK_SCHOOL_CLASSLIST="classList"; // 班级列表
	public final static String XK_SCHOOL_COURSELIST="courseList"; // 课程列表
	public final static String XK_SCHOOL_TEACHERLIST="teacherList"; // 教师列表
		
	//课表相关
	public final static String XK_SCHEDULE_GRADECLASS="gradeClass"; // 班级
	public final static String XK_SCHEDULE_STARTTIME="startTime"; // 开始时间
	public final static String XK_SCHEDULE_ENDTIME="endTime"; // 结束时间
	public final static String XK_SCHEDULE_TEACHERNAME="teacherName"; // 教师
	public final static String XK_SCHEDULE_COURSE="course"; // 课程
	public final static String XK_SCHEDULE_COURSEDATE="courseDate"; // 课程日期
	public final static String XK_SCHEDULE_CLASSTIME="classTime"; // 时间段
	
	//device相关
	public final static String XK_DEVICE_DEVICESERIAL="deviceSerial"; // 设备
	public final static String XK_DEVICE_VALIDATECODE="validateCode"; // 设备码
	public final static String XK_DEVICE_DEVICELIST="deviceList"; // 设备列表
	public final static String XK_DEVICE_DEVICEPOSITION="devicePosition"; // 摄像头方位
	
	//label相关
	public final static String XK_LABEL_LABELGUID="guidLabels"; // 标签id
	public final static String XK_LABEL_LABELNAME="labelName"; // 标签名
	public final static String XK_LABEL_GUIDLABELS="guidLabels";  // 标签recid
	public final static String XK_LABEL_LABELSLIST="labelsList";  // 标签列表
	public final static String XK_LABEL_TYPE="type";  // 数据类型
	public final static String XK_LABEL_GUIDGRADE="guidGrade";  // 年级标签id
	public final static String XK_LABEL_GUIDCLASS="guidClass";  // 班级标签id

	public final static String XK_LABEL_FLAG = "flag"; // 功能层级标志1
	public final static String XK_LABEL_COURSELABELNAME="courseLabelName"; // 课程标签名称
	public final static String XK_LABEL_GRADELABELNAME="gradeLabelName"; // 年级标签名称
	public final static String XK_LABEL_LABELTYPE="labelType";  // 消息类型
	public final static String XK_LABEL_LABELNAMEONE="labelNameOne";  // 005-03标签名称1层
	public final static String XK_LABEL_LABELNAMETWO="labelNameTwo";  // 005-03标签名称2层
	
	//地区相关
	public final static String XK_AREA_AREALIST="areaList";//地区列表
	public final static String XK_AREA_AREANAME="areaName";//地区名称
	public final static String XK_AREA_GUIDAREA="guidArea";//地区名称
	//图片相关
	public final static String XK_HEADIMAGE="headImage";
	
	//问题反馈相关
	public final static String XK_FEEDBACK_FEEDBACKTITLE = "feedbackTitle";//反馈标题
	public final static String XK_FEEDBACK_FEEDBACKINFO = "feedbackInfo";//反馈信息

	
}