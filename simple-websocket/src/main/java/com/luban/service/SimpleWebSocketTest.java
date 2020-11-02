package com.luban.service;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author 小贱
 * @create 2020-10-20 22:15
 */
@ServerEndpoint("/simpleWebSocket")
public class SimpleWebSocketTest {

    /** 静态变量，用来记录当前在线连接数。应该把他设置成线程安全的。 */
    private static int onlineCount = 0;

    /** concurrent 包的线程安全 Set，用来存放每个客户端对应的 MyWebSocket 对象。 */
    private static CopyOnWriteArraySet<SimpleWebSocketTest> webSocketSet = new CopyOnWriteArraySet<>();

    /** 与某个客户端的连接会话，需要通过他来给客户端发送数据 */
    private Session session;


    /**
     * 连接建立成功调用的方法
     * @param session 可选参数，session 为与某个客户端的连接会话，需要
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        // 加入到 Set
        webSocketSet.add(this);
        // 在线人数 + 1
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为：" + getOnlineCunt());
    }

    private int getOnlineCunt() {
        return onlineCount;
    }

    private void addOnlineCount() {
        onlineCount++;
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一个连接关闭！当前在线人数为：" + getOnlineCunt());
    }

    private void subOnlineCount() {
        onlineCount--;
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息： " + message);
        // 群发消息
        for (SimpleWebSocketTest item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     * @param session 可选参数
     * @param error 错误异常
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message 发送的内容
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);

    }
}
