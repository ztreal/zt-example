package com.zt.example.util.mina.example;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.net.InetSocketAddress;

/**
 * User: zhangtan
 * Date: 13-3-3
 * Time: 下午12:50
 * mina 服务端测试代码
 */
public class MinaServerTest {
    /**
     * Choose your favorite port number.
     */
    private static final int PORT = 1111;


    public static void main(String[] args) throws Exception {
        IoAcceptor acceptor = new NioSocketAcceptor();
        IoFilter filter = new ProtocolCodecFilter(new TextLineCodecFactory());
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        chain.addLast("text", filter);
        addLogger(chain);
        acceptor.setHandler(new ServerHandler());
        acceptor.bind(new InetSocketAddress(PORT));
    }

    private static void addLogger(DefaultIoFilterChainBuilder chain)
               throws Exception {
           chain.addLast("logger", new LoggingFilter());
           System.out.println("Logging ON");
       }
}

 class ServerHandler extends IoHandlerAdapter {
    public void messageReceived(IoSession session, Object message) {
        System.out.println("get client meassage：" + message.toString());
    }

    public void exceptionCaught(IoSession session, Throwable cause) {
        System.out.println("service exception\n" + cause);
    }
}