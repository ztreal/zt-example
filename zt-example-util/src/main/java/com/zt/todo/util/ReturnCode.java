package www.zt.com.util;

public class ReturnCode {
	private String code;
	private String desc;
	public ReturnCode(){}
	public ReturnCode(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
