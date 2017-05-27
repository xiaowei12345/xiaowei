package third.utils;
/**
 * �ļ�����
 */
public enum FileCategory {

	ICON("icon",0),
	NEWS("news", 1);
	
	private String description;
	private int functionValue;
	private FileCategory(String description, int functionValue) {
		this.description = description;
		this.functionValue = functionValue;
	}
	/**
	 * ��ȡ����
	 */
	public String getDescription()  {
		return description;
	}
	/**
	 * ��ȡintֵ
	 * @return
	 */
	public final int getFunctionValue() {
		return functionValue;
	}
	/**
	 * intתFileCategory
	 */
	public static FileCategory ToFileCategory(int i){
		for(FileCategory fileCategory : values()) {
			if(fileCategory.getFunctionValue() == i) {
				return fileCategory;
			}
		}
		return null;
	}
	/**
	 * int תFileCategory����
	 */
	public static String IntToDescription(int i){
		for(FileCategory fileCategory : values()) {
			if(fileCategory.getFunctionValue() == i) {
				return fileCategory.getDescription();
			}
		}
		return null;
	}
	/**
	 * FileCategoryתint
	 */
	public static int FileCategoryToInt(FileCategory category){
		return category.getFunctionValue();
	}
}
