package www.zt.com.util;

public class SessionIdGenerator {
	private RandomStringGenerator randomStringGenerator;
	private LongNumericGenerator longNumericGenerator;
	//帐户前缀
	private String accountPrefix;
	//用户前缀
	private String userPrefix;
	public SessionIdGenerator(){
		randomStringGenerator = new RandomStringGenerator();
		longNumericGenerator = new LongNumericGenerator(1);
		this.accountPrefix = "_account";
		this.userPrefix = "_user";
	}
	public synchronized String getAccountNewSessionId(){
		StringBuffer sessionIdBuf = new StringBuffer();
		sessionIdBuf.append(this.accountPrefix);
		sessionIdBuf.append("-");
		sessionIdBuf.append(longNumericGenerator.getNextNumberAsString());
		sessionIdBuf.append("-");
		sessionIdBuf.append(randomStringGenerator.getNewString());
		return sessionIdBuf.toString();
	}
	public synchronized String getUserNewSessionId(){
		StringBuffer sessionIdBuf = new StringBuffer();
		sessionIdBuf.append(this.userPrefix);
		sessionIdBuf.append("-");
		sessionIdBuf.append(longNumericGenerator.getNextNumberAsString());
		sessionIdBuf.append("-");
		sessionIdBuf.append(randomStringGenerator.getNewString());
		return sessionIdBuf.toString();
	}
	public String getAccountPrefix() {
		return accountPrefix;
	}
	public String getUserPrefix() {
		return userPrefix;
	}
}
