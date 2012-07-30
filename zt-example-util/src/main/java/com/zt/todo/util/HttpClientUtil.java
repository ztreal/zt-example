package www.zt.com.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpClientUtil {
	private int timeOut = 5000;
	public HttpClientReturnCode getContentByPostMethod(String url,Map<String,String> params) throws HttpException, IOException{
		PostMethod postMethod=new PostMethod(url);
		String paramsStr = DigestUtil.mapToString(params);
		postMethod.addParameter("data", URLDecoder.decode(paramsStr, "UTF-8"));
		HttpClient httpClient=new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(this.timeOut);
		int statusCode=httpClient.executeMethod(postMethod);
		HttpClientReturnCode returnCode = new HttpClientReturnCode();
		returnCode.setStatusCode(statusCode);
		if(statusCode == HttpStatus.SC_OK){
			String content = postMethod.getResponseBodyAsString();
			returnCode.setContent(content);
		}
		return returnCode;
		/*HttpClientReturnCode returnCode = new HttpClientReturnCode();
		returnCode.setStatusCode(200);
		if(params.get("cmd").equals("015")){
			JSONObject content = new JSONObject();
			content.accumulate("code", "0");
			content.accumulate("desc", "success");
			JSONObject data = new JSONObject();
			data.accumulate("uid", "1001");
			data.accumulate("aid", "2001");
			content.accumulate("data", data.toString());
			returnCode.setContent(content.toString());
		}else if(params.get("cmd").equals("014")){
			JSONObject content = new JSONObject();
			content.accumulate("code", "0");
			content.accumulate("desc", "success");
			JSONObject data = new JSONObject();
			JSONArray safeinfo = new JSONArray();
			JSONObject s1 = new JSONObject();
			s1.accumulate("aid", "2001");
			s1.accumulate("typeid", "1");
			s1.accumulate("key", "1");
			s1.accumulate("value", "1");
			JSONObject s2 = new JSONObject();
			s2.accumulate("aid", "2002");
			s2.accumulate("typeid", "1");
			s2.accumulate("key", "1");
			s2.accumulate("value", "1");
			safeinfo.add(s1);
			safeinfo.add(s2);
			data.accumulate("safeinfo", safeinfo.toString());
			content.accumulate("data", data.toString());
			returnCode.setContent(content.toString());
		}else if(params.get("cmd").equals("020")){
			JSONObject content = new JSONObject();
			content.accumulate("code", "0");
			content.accumulate("desc", "success");
			returnCode.setContent(content.toString());
		}else if(params.get("cmd").equals("026")){
			JSONObject content = new JSONObject();
			content.accumulate("code", "0");
			content.accumulate("desc", "success");
			JSONObject data = new JSONObject();
			data.accumulate("uid", "1001");
			data.accumulate("aid", "2001");
			data.accumulate("wid", "2002");
			content.accumulate("data", data.toString());
			returnCode.setContent(content.toString());
		}else if(params.get("cmd").equals("036")){
			JSONObject content = new JSONObject();
			content.accumulate("code", "0");
			content.accumulate("desc", "success");
			JSONObject data = new JSONObject();
			JSONArray safeinfo = new JSONArray();
			JSONObject s1 = new JSONObject();
			s1.accumulate("wid", "2002");
			s1.accumulate("typeid", "1");
			s1.accumulate("key", "1");
			s1.accumulate("value", "1");
			JSONObject s2 = new JSONObject();
			s2.accumulate("wid", "2002");
			s2.accumulate("typeid", "1");
			s2.accumulate("key", "1");
			s2.accumulate("value", "1");
			safeinfo.add(s1);
			safeinfo.add(s2);
			data.accumulate("safeinfo", safeinfo.toString());
			content.accumulate("data", data.toString());
			returnCode.setContent(content.toString());
		}
		return returnCode;*/
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
}
