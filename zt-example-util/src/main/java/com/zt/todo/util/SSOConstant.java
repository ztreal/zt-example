package www.zt.com.util;

/**
 * SSO全局变量
 * @author zhenghl
 *
 */
public class SSOConstant {
	public static final String ON = "0";// 开
	public static final String OFF = "1";// 闭
	
	// 命令字
	public static final String CMD_CODE_05_SESSIONVALIDATE = "05";// Session验证
	public static final String CMD_CODE_01_ACCOUNTLOGIN = "01";// 账户登陆
	public static final String CMD_CODE_02_ACCOUNTLOGOUT = "02";// 账户登出
	public static final String CMD_CODE_03_USERLOGIN = "03";// 员工登陆
	public static final String CMD_CODE_06_HEATBEAT = "06";// 心跳
	public static final String CMD_CODE_07_CANCEL = "07";// 注销
	public static final String CMD_CODE_08_OTHERTERMINALLOGIN = "08";// 其他终端登陆
	
	public static final boolean DATAPATTERN=false;//支持2种格式(true:data=请求字符串 false:请求字符串)
	
	// 响应格式
	public static final String XML="xml";
	public static final String JSON="json";
	
	// 错误信息
	public static final int ERROR_CODE_10000 = 10000;
	public static final String ERROR_CODE_10000_DESC = "单点登录服务校验没有通过";
}
