package www.zt.com.util;

public class HttpClientReturnCode {
	private int statusCode;
	private String content;
	public HttpClientReturnCode(){
		
	}
	public HttpClientReturnCode(int statusCode, String content) {
		super();
		this.statusCode = statusCode;
		this.content = content;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
