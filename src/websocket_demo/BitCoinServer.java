package websocket_demo;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author yudong
 * @create 2019-07-31 11:00
 */

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
//注解@ServerEndpoint("/ws/websocketServer")把它标记为一个WebSocket Server
@ServerEndpoint("/ws/websocketServer")
public class BitCoinServer {

    /**
     * OnOpen 表示有浏览器链接过来的时候被调用
     * OnClose 表示浏览器发出关闭请求的时候被调用
     * OnMessage 表示浏览器发消息的时候被调用
     * OnError 表示有错误发生，比如网络断开了等等
     * <p>
     * sendMessage 用于向浏览器回发消息
     */
//与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        ServerManager.add(this);
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onClose() {
        ServerManager.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
    }

    @OnError
    public void OneError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
}

