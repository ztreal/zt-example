package www.zt.com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * MD5工具类
 * @author zhenghl
 *
 */
public class DigestUtil {
	private static Log log = LogFactory.getLog(DigestUtil.class);
	
	/**
	 * map转化为对应的字符串(用于构造字符串)
	 * @param map
	 * @return
	 */
	public static String mapToString(Map<String, String> map){
		if (map == null || map.isEmpty()) {
			return null;
		}

		Object[] key = map.keySet().toArray();
		Arrays.sort(key);

		StringBuffer res = new StringBuffer(128);
		for (int i = 0; i < key.length; i++) {
			res.append(key[i] + "=" + map.get(key[i]) + "&");
		}

		return res.substring(0, res.length() - 1);
	}
	
	/**
	 * 字符转化为对应map
	 * @param digest
	 * @return
	 */
	public static Map<String, String> stringToMap(String digest){
		Map<String, String> resultMap = new HashMap<String, String>();
		if (digest == null) {
			return null;
		}
		String[] split = digest.split("&");
		for (int i = 0; i < split.length; i++) {
			String[] temp = split[i].split("=");
			if (temp.length == 1) {
				resultMap.put(temp[0], "");
			}
			if (temp.length > 1) {
				resultMap.put(temp[0], temp[1]);
				log.info(temp[0]+"="+temp[1]);
			}
		}
		return resultMap;
	}
	
	/**
	 * 构造请求字符串
	 * @param map
	 * @param appInitKey
	 * @return
	 */
	public static String createParam(Map<String, String> map, String appInitKey) {
		try {
			String rStr = mapToString(map);
			if (appInitKey == null) {
				return rStr + "&verify=" + getKeyedDigest(rStr, "");
			}

			log.info("verify="+getKeyedDigest(rStr, appInitKey));
			return rStr + "&verify=" + getKeyedDigest(rStr, appInitKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String getKeyedDigest(Map<String, String> map, String appInitKey){
		String rStr = mapToString(map);
		if (appInitKey != null) {
			return getKeyedDigest(rStr, appInitKey);
		}
		return getKeyedDigest(rStr, "");
	}
	
	/**
	 * 验证参数的正确性
	 * @param parametersMap : 参数的map
	 * @param appInitKey : 密匙
	 * @param verify ：传过来的加密后的串
	 * @return
	 */
	public static boolean validateParameters(Map<String, String> parametersMap, String appInitKey,String verify){
		boolean validateResult = false;
		String paramStr = mapToString(parametersMap);
		String newVerifyStr=DigestUtil.getKeyedDigest(paramStr, appInitKey);
		if(verify.equals(newVerifyStr)){
			validateResult = true;
		}
		return validateResult;
	}
	
	/**
	 * MD5加密
	 * @param strSrc
	 * @param key
	 * @return
	 */
	public static String getKeyedDigest(String strSrc, String key) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(strSrc.getBytes("UTF-8"));

			String result = "";
			byte[] temp;
			temp = md5.digest(key.getBytes("UTF-8"));
			for (int i = 0; i < temp.length; i++) {
				result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
			}

			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	 /**
     * 提交Post请求
     * @param paramMap
     * @param url
     * @param appInitKey
     * @return
     */
    public static String submitPost(Map<String, String> paramMap, String url,
			String appInitKey) {
		String result = null;
		try {
			int statusCode;
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(8000);// 设置连接超时时间
			client.getHttpConnectionManager().getParams().setSoTimeout(8000);// 设置读取数据超时时间
			PostMethod method = new PostMethod(url);
			String strRequst = DigestUtil.createParam(paramMap, appInitKey);
			String encodeRequest = URLEncoder.encode(strRequst, "UTF-8");
			log.info("Encode:" + URLEncoder.encode(strRequst, "UTF-8"));
			method.addParameter("data", encodeRequest);

			statusCode = client.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {
				result = method.getResponseBodyAsString();
				log.info("提交成功");
				log.info("返回信息显示"+result);
			} else {
				log.info("提交失败!");
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return result;
	}
    
	 /**
     * 提交Post请求
     * @param paramMap
     * @param url
     * @param appInitKey
     * @return
     */
    public static String submitPost(String strRequst, String url,
			String appInitKey) {
		String result = null;
		try {
			int statusCode;
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(8000);// 设置连接超时时间
			client.getHttpConnectionManager().getParams().setSoTimeout(8000);// 设置读取数据超时时间
			PostMethod method = new PostMethod(url);
			String encodeRequest = URLEncoder.encode(strRequst, "UTF-8");
			log.info("Encode:" + URLEncoder.encode(strRequst, "UTF-8"));
			method.addParameter("data", encodeRequest);

			statusCode = client.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {
				result = method.getResponseBodyAsString();
				log.info("提交成功");
				log.info("返回信息显示"+result);
			} else {
				log.info("提交失败!");
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return result;
	}
    
    /**
     * 提交Post请求(用于云端平台)
     * @param paramMap
     * @param url
     * @param 
     * @return
     */
    public static String submitPostForClour(Map<String, String> paramMap, String url) {
		String result = null;
		try {
			int statusCode;
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(8000);// 设置连接超时时间
			client.getHttpConnectionManager().getParams().setSoTimeout(8000);// 设置读取数据超时时间
			PostMethod method = new PostMethod(url);
			
			Iterator<String> iterator=paramMap.keySet().iterator();
			while(iterator.hasNext()){
				String key=iterator.next();
				String value=paramMap.get(key);
				log.info("key:"+key+",value:"+value);
				method.addParameter(key, value);
			}

			statusCode = client.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK) {
				result = method.getResponseBodyAsString();
				log.info("提交成功");
				log.info("返回信息显示"+result);
			} else {
				log.info("提交失败!");
			}
		} catch (Exception e) {
			log.error(e.toString());
		}
		return result;
	}
}
