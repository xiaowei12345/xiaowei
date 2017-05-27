
package third.servlet;

import java.io.File;

/**
 * json�ӿڳ���
 * @author xiaowei
 *
 */
public interface JsonFieldConstant {
	
	public final static String XK_VCODE="vcode";  //�ֻ���֤��
	public final static String XK_VCODE_NUM="1234";  //�ֻ���ʱ��֤��	
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
		
	public final static String XK_GRADE="";  //�꼶
	public final static String XK_CLASS="";  //��
	
	//user���
	public final static String XK_USER_USERNO="userNo"; // �û�ID
	public final static String XK_USER_OLDPASSWORD="oldpassword"; // ԭ����
	public final static String XK_USER_PASSWORD="password"; // ����
	public final static String XK_USER_SEX="sex"; // �Ա�
	public final static String XK_USER_PHONE="phone";  //�ֻ�
	public final static String XK_USER_EMAIL="email";  //email
	public final static String XK_USER_GRADE="grade";  //�꼶
	public final static String XK_USER_CLASSROOM="classRoom";  //�༶
	public final static String XK_USER_USERNAME="userName";  //�û���
	public final static String XK_USER_DIRECTSEDDING="directSeeding";  //ֱ��Ȩ��
	public final static String XK_USER_IMGHEAD="imgHead";  //ͷ��
	public final static String XK_USER_ISUPDATE="isUpdate";  //�Ƿ����
	public final static String XK_USER_STARTFLAG="startFlag";  //�Ƿ�����
	public final static String XK_USER_GUIDUSERS="guidUsers";  // �����û�id
	public final static String XK_USER_STUDENTNAME="studentName";  // ѧ������
	public final static String XK_USER_GUIDSCHOOL="guidSchool";  // ����ѧУ
	public final static String XK_USER_MEMO="memo";  // ��ע
	public final static String XK_USER_USERIDENTITY="userIdentity";  // �û����
	
	//�汾���Version
	public final static String XK_VERSION_VERSION="version";
	public final static String XK_VERSION_UPDATEURL="updateurl";
	
	//school ���
	public final static String XK_SCHOOL_LIST="schoolList"; // ѧУ�б�
	public final static String XK_SCHOOLTYPE_LIST="schoolTypeList"; // ѧУ����б�
	public final static String XK_SCHOOL_TYPENAME="typeName"; // ѧУ�������
	
	public final static String XK_SCHOOL_RECID="recid"; // ѧУRECID
	public final static String XK_SCHOOL_GUIDSCHOOL="guidSchool"; // ѧУRECID
	public final static String XK_SCHOOL_SCHOOLNAME="schoolName"; // ѧУ����
	public final static String XK_SCHOOL_SCHOOLNO="schoolNo"; // ѧУID
	public final static String XK_SCHOOL_IMGAPPFIRSTFOCUS="imgAppFirstFocus"; // ѧУͼƬ
	public final static String XK_SCHOOL_SCHOOLTYPE="schoolType"; // ѧУ����
	public final static String XK_SCHOOL_GUIDAREA="guidArea"; // ����id
	public final static String XK_SCHOOL_GRADELIST="gradeList";  // �꼶�б�
	public final static String XK_SCHOOL_CLASSLIST="classList"; // �༶�б�
	public final static String XK_SCHOOL_COURSELIST="courseList"; // �γ��б�
	public final static String XK_SCHOOL_TEACHERLIST="teacherList"; // ��ʦ�б�
		
	//�α����
	public final static String XK_SCHEDULE_GRADECLASS="gradeClass"; // �༶
	public final static String XK_SCHEDULE_STARTTIME="startTime"; // ��ʼʱ��
	public final static String XK_SCHEDULE_ENDTIME="endTime"; // ����ʱ��
	public final static String XK_SCHEDULE_TEACHERNAME="teacherName"; // ��ʦ
	public final static String XK_SCHEDULE_COURSE="course"; // �γ�
	public final static String XK_SCHEDULE_COURSEDATE="courseDate"; // �γ�����
	public final static String XK_SCHEDULE_CLASSTIME="classTime"; // ʱ���
	
	//device���
	public final static String XK_DEVICE_DEVICESERIAL="deviceSerial"; // �豸
	public final static String XK_DEVICE_VALIDATECODE="validateCode"; // �豸��
	public final static String XK_DEVICE_DEVICELIST="deviceList"; // �豸�б�
	public final static String XK_DEVICE_DEVICEPOSITION="devicePosition"; // ����ͷ��λ
	
	//label���
	public final static String XK_LABEL_LABELGUID="guidLabels"; // ��ǩid
	public final static String XK_LABEL_LABELNAME="labelName"; // ��ǩ��
	public final static String XK_LABEL_GUIDLABELS="guidLabels";  // ��ǩrecid
	public final static String XK_LABEL_LABELSLIST="labelsList";  // ��ǩ�б�
	public final static String XK_LABEL_TYPE="type";  // ��������
	public final static String XK_LABEL_GUIDGRADE="guidGrade";  // �꼶��ǩid
	public final static String XK_LABEL_GUIDCLASS="guidClass";  // �༶��ǩid

	public final static String XK_LABEL_FLAG = "flag"; // ���ܲ㼶��־1
	public final static String XK_LABEL_COURSELABELNAME="courseLabelName"; // �γ̱�ǩ����
	public final static String XK_LABEL_GRADELABELNAME="gradeLabelName"; // �꼶��ǩ����
	public final static String XK_LABEL_LABELTYPE="labelType";  // ��Ϣ����
	public final static String XK_LABEL_LABELNAMEONE="labelNameOne";  // 005-03��ǩ����1��
	public final static String XK_LABEL_LABELNAMETWO="labelNameTwo";  // 005-03��ǩ����2��
	
	//�������
	public final static String XK_AREA_AREALIST="areaList";//�����б�
	public final static String XK_AREA_AREANAME="areaName";//��������
	public final static String XK_AREA_GUIDAREA="guidArea";//��������
	//ͼƬ���
	public final static String XK_HEADIMAGE="headImage";
	
	//���ⷴ�����
	public final static String XK_FEEDBACK_FEEDBACKTITLE = "feedbackTitle";//��������
	public final static String XK_FEEDBACK_FEEDBACKINFO = "feedbackInfo";//������Ϣ

	
}