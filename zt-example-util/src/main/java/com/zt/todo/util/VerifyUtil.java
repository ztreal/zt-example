package www.zt.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.core.io.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 读取验证信息列表
 * 
 * @author zhenghl
 * 
 */
public class VerifyUtil {
	private static Log log = LogFactory.getLog(VerifyUtil.class);
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"classpath:applicationContext-sso.xml");
	private static List<VerifyInfo> listVerfiy = new ArrayList<VerifyInfo>();

	static {
		initialVarifyInfo();
	}

	/**
	 * 获取输入流
	 * 
	 * @return
	 * @throws IOException
	 */
	public static InputStream getInputStream() throws IOException {
		Resource resource = applicationContext.getResource("verify_config.xml");
		return resource.getInputStream();
	}

	/**
	 * 初始化校验信息列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public static void initialVarifyInfo() {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(getInputStream());
			Element root = doc.getRootElement();
			root.element("verifylist");
			Element verify = null;
			for (Iterator<?> it = root.elementIterator("verify"); it.hasNext();) {
				verify = (Element) it.next();
				log.info("cid:" + verify.elementText("cid"));
				log.info("key:" + verify.elementText("key"));
				log.info("status:" + verify.elementText("status"));

				String status = verify.elementText("status");
				if (status != null && status.equals(SSOConstant.ON)) {
					VerifyInfo verifyInfo = new VerifyInfo();
					verifyInfo.setCid(verify.elementText("cid"));
					verifyInfo.setKey(verify.elementText("key"));
					verifyInfo.setStatus(verify.elementText("status"));
					listVerfiy.add(verifyInfo);
				}
			}
		} catch (Exception e) {
			log.error("获取验证信息列表,错误信息为" + e.toString());
		}
	}

	/**
	 * 校验系统标示和key
	 * 
	 * @param cid
	 * @param key
	 * @return
	 */
	public static boolean isAccess(String cid, String key) {
		boolean result = false;
		if (listVerfiy != null && listVerfiy.size() > 0) {
			for (VerifyInfo verifyInfo : listVerfiy) {
				if (cid.equals(verifyInfo.getCid())
						&& key.equals(verifyInfo.getKey())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * 获取sid对应的key
	 * @param cid
	 * @return
	 */
	public static String getVerifyKey(String cid){
		String key=null;
		System.out.println("cid = " + cid);
		if (listVerfiy != null && listVerfiy.size() > 0) {
			for (VerifyInfo verifyInfo : listVerfiy) {
				if (cid.equals(verifyInfo.getCid())) {
					key=verifyInfo.getKey();
					break;
				}
			}
		}
		return key;
	}

}
