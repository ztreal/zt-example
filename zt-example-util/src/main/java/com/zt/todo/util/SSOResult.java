package www.zt.com.util;

import java.io.Serializable;

/**
 * SSO响应结果集
 * @author zhenghl
 *
 */
public class SSOResult implements Serializable {
	private static final long serialVersionUID = -7280325344349823866L;
	private int code;
	private String desc;
	private String responseType;// 响应字符串格式(支持json,xml,默认是json)

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String toJSON() {
		StringBuffer sbResult = new StringBuffer();
		sbResult.append("{");
		sbResult.append("\"code\":\"" + this.getCode() + "\",");
		if (this.getDesc() == null) {
			sbResult.append("\"desc\":\"" + "" + "\"");
		} else {
			sbResult.append("\"desc\":\"" + this.getDesc() + "\"");
		}
		sbResult.append("}");
		return sbResult.toString();
	}

	public String toXML() {
		return null;
	}

	public String toResponse() {
		if (responseType != null && SSOConstant.XML.equals(responseType)) {
			return toXML();
		} else {
			return toJSON();
		}
	}
}
