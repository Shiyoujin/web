//PrepareStatement 执行数据库 增删改查 (包含数据库 时区和UTF-8的设置和链接)
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PrepareStatement {
     static class JDBCOperation {
        static class Student {
            private String Id;   //删掉 Id
            private String Name;
            private String Sex;
            private String Age;

            Student(String Name, String Sex, String Age) {
                this.Id = null; //default  删除Id相关
                this.Name = Name;
                this.Sex = Sex;
                this.Age = Age;
            }

            public Student (Connection con ){

            }


            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getSex() {
                return Sex;
            }

            public void setSex(String Sex) {
                this.Sex = Sex;
            }

            public String getAge() {
                return Age;
            }

            public void setAge(String Age) {
                this.Age = Age;
            }
        }

        private static  Connection getConn() {
//        String url = "jdbc:mysql://localhost:3306/student";   直接写localhost也可以
//        String username = "root";
//        String password = "";  重复了
            Connection conn = null;
            try {
                String driverName= "com.mysql.cj.jdbc.Driver";
                Class.forName(driverName); //classLoader,加载对应驱动
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8","root","");
//              conn = (Connection) DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        public static int insert(JDBCOperation.Student student) {
            Connection conn = getConn();
            int i = 0;
            String sql = "insert into students (Name,Sex,Age) values(?,?,?)";
            PreparedStatement pstmt;
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getSex());
                pstmt.setString(3, student.getAge()); //
                i = pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }

        private static int update(JDBCOperation.Student student) {
            Connection conn = getConn();
            int i = 0;
            String sql = "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                i = pstmt.executeUpdate();
                System.out.println("result: " + i);
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }

        private static int delete(String name) {
            Connection conn = getConn();
            int i = 0;
            String sql = "delete from students where Name='" + name + "'";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                i = pstmt.executeUpdate();
                System.out.println("resutl: " + i);
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }


        private static Integer getAll() {
            Connection conn = getConn();
            String sql = "select * from students";
            PreparedStatement pstmt;
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                int col = rs.getMetaData().getColumnCount();
                System.out.println("--------------------------------------------------------------------");
                while (rs.next()) {
                    for (int i = 1; i <= col; i++) {
                        System.out.println(rs.getString(i) + "\t" );
                        if ((i == 2) && (rs.getString(i).length() < 8)) {
                            System.out.println("\t");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("==================");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void main(String args[]) {
            Connection con = JDBCOperation.getConn();
//         Student s = new Student(con);
            JDBCOperation.getAll();
            JDBCOperation.insert(new Student("奶思","Male","14"));
            JDBCOperation.getAll();
            JDBCOperation.update(new Student("Bean","","7"));
            JDBCOperation.delete("Achilles");
            JDBCOperation.getAll();
        }
    }
}
