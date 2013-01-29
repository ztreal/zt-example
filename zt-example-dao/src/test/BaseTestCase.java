//package dao;
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * User: zhangtan
// * Date: 2012-07-28
// * Time: 11：14
// */
//public  class BaseTestCase {
//    protected Log log = LogFactory.getLog(this.getClass());
//    protected static ApplicationContext appContext;
//
//
//    @BeforeClass
//    public static  void setUp() throws Exception {
//        try {
//            long start = System.currentTimeMillis();
//            System.out.println("开始加载配置文件");
//
//            appContext =  new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
//
//            System.out.println("配置文件加载结束" + (System.currentTimeMillis() - start));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    protected boolean setProtected() {
//        return false;
//    }
//
//    @Before
//    public void autoSetBean() {
//        appContext.getAutowireCapableBeanFactory().autowireBeanProperties(this, DefaultListableBeanFactory.AUTOWIRE_BY_NAME, false);
//    }
//
//    @AfterClass
//    public static  void tearDown() throws Exception {
//        System.out.printStackTrace("tet");
//    }
//}
