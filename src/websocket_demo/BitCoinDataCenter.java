package websocket_demo;

/**
 * @author yudong
 * @create 2019-07-31 11:03
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Random;

/**
 * 创建BitCoinDataCenter，使其继承HttpServlet.
 * 标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动，因为可以通过loadOnStartup一起就启动了
 * 这个类实现了Runnable，可以在初始化方法里创建一个线程并调用之。
 * run 方法： 每个1-3秒就创建一个新价格，然后根据当前有多少人链接过来，进行调整价格，接着通过ServerManager广播出去
 */
@WebServlet(name = "BitCoinDataCenter", urlPatterns = "/BitCoinDataCenter", loadOnStartup = 1)
//标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
public class BitCoinDataCenter extends HttpServlet implements Runnable {

    public void init() {
        startup();
    }

    public void startup() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        int bitPrice = 10000;
        while (true) {
            int time = 1000 + new Random().nextInt(2000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            float random = 1 + (float) (Math.random() - 0.5);
            int newPrice = (int) (bitPrice * random);

            int total = ServerManager.getTotal();
            newPrice = newPrice * total;

            String messageFormat = "{\"price\":\"%d\",\"total\":%d}";
            String message = String.format(messageFormat, newPrice, total);

            ServerManager.broadCast(message);
        }
    }

}
