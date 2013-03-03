package com.zt.example.util.mina.example;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * User: zhangtan
 * Date: 13-3-3
 * Time: 下午1:05
 * mina客户端例子.
 */
public class MinaClientTest extends IoHandlerAdapter {

    /**
     * The connector
     */
    private IoConnector connector;

    /**
     * The session
     */
    private static IoSession session;

    private boolean received = false;

    public static final int MAX_RECEIVED = 10;

    public MinaClientTest() {
        connector = new NioSocketConnector();
        connector.setHandler(this);
        SocketSessionConfig dcfg = (SocketSessionConfig) connector.getSessionConfig();
        ConnectFuture connFuture = connector.connect(new InetSocketAddress("127.0.0.1", MinaServerTest.PORT));
        connFuture.awaitUninterruptibly();
        session = connFuture.getSession();
    }

    public static void main(String[] args) throws Exception {
        MinaClientTest client = new MinaClientTest();

        long t0 = System.currentTimeMillis();

        for (int i = 1; i <= MinaClientTest.MAX_RECEIVED; i++) {
            //if (i % 2 == 0) {
            //Thread.sleep(1);
            //}

            IoBuffer buffer = IoBuffer.allocate(4);
            buffer.putInt(i);
            buffer.flip();
            WriteFuture future = session.write(buffer);

            if (!client.received) {
                System.out.println("client receive fails");
                Thread.sleep(1);
            }

            client.received = false;

            if (i % 10000 == 0) {
                System.out.println("Sent " + i + " messages");
            }
        }

        long t1 = System.currentTimeMillis();

        System.out.println("Sent messages delay : " + (t1 - t0));

        Thread.sleep(100000);

        client.connector.dispose(true);
    }


    public void messageReceived(IoSession session, Object message) {
        System.out.println("我是客户端，收到响应：" + message.toString());
    }

    @Override
    public void messageSent(IoSession session, Object message) {
        System.out.println("我是客户端，我发送的消息：" + message);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        System.out.println("我是客户端，系统出现异常\n" + cause);
        session.close(true);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("session is open");
    }

}

