package websocket_demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author yudong
 * @create 2019-07-31 11:02
 */
public class ServerManager {
    //ArrayList本身不是线程安全的，所以通过集合Collections.synchronizedList将其转换为一个线程安全的类
    private static Collection<BitCoinServer> servers = Collections.synchronizedCollection(new ArrayList<BitCoinServer>());

    public static void broadCast(String msg) {
        for (BitCoinServer bitCoinServer : servers) {
            try {
                System.out.println(msg);
                bitCoinServer.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getTotal() {
        return servers.size();
    }

    public static void add(BitCoinServer server) {
        servers.add(server);
        System.out.println("有新连接加入！ 当前总连接数是：" + servers.size());
    }

    public static void remove(BitCoinServer server) {
        servers.remove(server);
        System.out.println("有连接退出！ 当前总连接数是：" + servers.size());
    }
}
