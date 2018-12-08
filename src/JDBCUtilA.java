//布鲁西课件上的演示，就是 数据库链接（自己对中文乱码有补充）和普通的增删改查
import java.sql.*;


public class JDBCUtilA {

    //----------------------创建和关闭数据库的通用方法--------------------------------------
    static class JDBCUtil{
        static{
            try{
                String driverName = "com.mysql.cj.jdbc.Driver";  ////com.mysql.jdbc.Driver 是 mysqlconnector‐java 5中的，com.mysql.cj.jdbc.Driver 是 mysql‐connector‐java 6以上的
                Class.forName(driverName);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        public static Connection getConnection(){      //返回值为 (另一个包中的类）Connection的叫  getConnection的方法---创建数据库连接
            Connection con = null;                     //给一个空的对象  实例由getConnecton获得
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8","root","");  //3306端口以后最好加上localhost:3306
            } catch (Exception e) {
                e.printStackTrace();
            }
            return con;
        }

        public static void close(ResultSet rs, Statement statement, Connection con){  //关闭数据库连接

            try{
                if (rs != null)
                    rs.close();
            } catch (Exception e){
                e.printStackTrace();
            }

            try{
                if (con != null)
                    con.close();
            } catch (Exception e){
                e.printStackTrace();
            }

            try{
                if (statement != null)
                    statement.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    static class Main {
        Connection con;       //分别定义  引用类型 为 类 的变量--------------
        Statement statement;
        ResultSet rs;

        public Statement getStatement(){
            return statement; //这种 返回值类型 为类名的方法，基本上 返回值 return都是它的对象
        }

        public Connection getCon(){
            return con;
        }

        public ResultSet getRs(){
            return rs;
        }


        //-----用Connection对象 con调用createStatement（）方法来创建 statement对象，进而可使用statement对象来执行 DDL和DML语句---
        public Main(Connection con){
            this.con = con;
            try{
                statement = con.createStatement();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public void createTable() throws SQLException{
            String sql = "create table if not exists test(id int,name varchar(255))";
            statement.executeUpdate(sql);
        }

        public void insert() throws SQLException{
            String sql1 = "insert into test values(1,'tom')";
            String sql2 = "insert into test values(2,'张三')";
            String sql3 = "insert into test values(3,'999')";
            statement.addBatch(sql1);
            statement.addBatch((sql2));   //------------可以两层括号？
            statement.addBatch(sql3);
            int [] results = statement.executeBatch();
        }

        public void select() throws SQLException{
            String sql = "select id,name from test";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");//rs是一个对象？
                String name = rs.getString("name");
                System.out.println(id+"\t"+name);
            }
        }

        public static void main(String[] args) {
            Connection con = JDBCUtil.getConnection();  //固定写法，必须要和数据库连接，因此不能只  Main main = new Main();
            //然后用 main.  来调用Main类里面的方法
            //前面构造器 public Main(Connection con){}
            Main main =new Main(con);
            try{
                main.createTable();
                main.insert();
                main.select();
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                JDBCUtil.close(main.getRs(),main.getStatement(),main.getCon());
            }
        }
    }

}
