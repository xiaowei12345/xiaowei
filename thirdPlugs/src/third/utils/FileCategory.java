package third.utils;
/**
 * 文件类型
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
	 * 获取描述
	 */
	public String getDescription()  {
		return description;
	}
	/**
	 * 获取int值
	 * @return
	 */
	public final int getFunctionValue() {
		return functionValue;
	}
	/**
	 * int转FileCategory
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
	 * int 转FileCategory描述
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
	 * FileCategory转int
	 */
	public static int FileCategoryToInt(FileCategory category){
		return category.getFunctionValue();
	}
}
