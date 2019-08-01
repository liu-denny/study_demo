package jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yudong
 * @create 2019-07-26 15:38
 */
public class test {
    public static void main(String[] args) throws SQLException {
        //加载驱动，创建连接
        Connection connection = SqlUtils.getConnection();
        //SQL语句
        String insert = "INSERT INTO `user` (id,username,password) VALUE (?,?,?);";
        String select = "SELECT * FROM `user`;";
        //将事务设置为手动提交
        connection.setAutoCommit(false);
        PreparedStatement statement1;
        PreparedStatement statement2;
        try {
            //根据sql语句，得到预编译语句对象
            statement1 = connection.prepareStatement(insert);
            statement2 = connection.prepareStatement(select);

            for (int i = 1; i <= 10; i++) {
                //按占位符设置参数值
                statement1.setInt(1, i);
                statement1.setString(2, "user_" + i);
                statement1.setString(3, "password" + i);
                //放入批处理队列
                statement1.addBatch();
            }
            //执行插入语句，批量插入，事务
            statement1.executeBatch();

            //执行查询语句，得到结果集
            ResultSet result = statement2.executeQuery();
            //遍历、打印结果
            while (result.next()) {
                System.out.println("username:" + result.getObject("username") + ";password:" + result.getObject("password"));
            }
            //提交事务
            connection.commit();

            //关闭连接，释放资源
            SqlUtils.release(connection, statement1, result);
            SqlUtils.release(connection, statement2, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
