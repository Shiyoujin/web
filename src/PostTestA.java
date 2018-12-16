//这里面有 用 JSONObject和JSONArry  解析时的思路，很值得怀念。。。

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
////用post发送http的网络请求,本来打算 post，但不会用，估计这个本质上是 get吧
//public class PostTest {
//    //设置 不传参的sendPost 方法
//    public static String sendPost() {//传入参数Sting url  返回值对应可以匹配成void
////        public static String sendPost(String url, String param)   param 里面是 "key=123&v=456"
//        PrintWriter out = null;
//        BufferedReader in = null;
//
//        // 设置 result变量为空，存储网页爬取的 json字符串，该 sendPost最后返回 result
//        String result = "";
//        try {
//
//            // 1.URL类封装了大量复杂的实现细节，这里将一个字符串构造成一个URL对象
//            //这里直接  传入了 所要爬取的网址 json， 也可在前面设置一个 String，再传入设置的变量
//            URL url= new URL("http://jwzx.cqupt.edu.cn/data/json_StudentSearch.php?searchKey=07121804");
//            // 打开和URL之间的连接，并 转成 HttpURLConnection 对象
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//
//            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 发送POST请求必须设置如下两行
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            //调用connect方法连接远程资源,且此方法应于设置后
//            conn.connect();
//            // 获取HttpURLConnection对象对应的输出流
//            out = new PrintWriter(conn.getOutputStream());
//            //发送请求参数
//            //out.print(Param)
////          // flush输出流的缓冲
//            out.flush();
//            // 定义BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));   //一定要有 URF-8，
//            // 还有下面数据库的链接也要注意
//            // 发送请求参数
////            out.print(param);
//            //对数据进行访问
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("[POST请求]向地址：" + "url" + " 发送数据：" + "param" + " 发生错误!"); //若 sendPost()  括号里有变量，这样  url,param 就可以 不加""，而是 某一变量
//        } finally {// 使用finally块来关闭输出流、输入流
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            } catch (IOException ex) {
//                System.out.println("关闭流异常");
//            }
//        }
//        return result;
////        System.out.println(result);
//    }
//}
//
//
////class  test{
////    public static void main(String[] args) {
////        JSONObject jsonObject = JSONObject.fromObject(PostTest.sendPost());   //类对象static修饰，后面主函数 是 静态
////        String two = jsonObject.getString("returnData");
////        JSONArray jsonArray = JSONArray.fromObject(two);//fromobject()里面的参数均是 字符串就行
////        for (int i =0;i < jsonArray.size();i++){
////            JSONObject jso = JSONObject.fromObject(jsonArray.get(i));
////            //JDBCOperation.insert(new Student(jso.getString("xm"),jso.getString("xb"),"14"));
////        }
//
////         JSONObject jsonObject2 = JSONObject.fromObject(jsonArray.get(4));
//////         JSONObject json = jsonObject2.getString("");
////         System.out.println(jsonObject);
////         System.out.println(jsonObject.getString("returnData"));
////         System.out.println(jsonArray);  //------------------------和 JSONObject  输出一致
////         System.out.println(jsonObject2);
////         System.out.println(jsonArray.get(3));
////         jsonArray.get(3);
////     }
////}
////         for (int i =0;i < jsonArray.length();i++){
////
////         }
////     }
//
////
//class JDBCOperation {
//    static class Studenta {
//        private String Csrq;
//        private String Xz;
//        private String XmEn;
//        private String Bj;
//        private String Zyh;
//        private String Yxh;
//        private String Xb;
//        private String Mz;
//        private String Zym;
//        private String Yxm;
//        private String Xh;
//        private String Rxrq;
//        private String Xjzt;
//        private String Xm;
//        private String Yxmen;
//        private String ZymEn;
//        private String Nj;
//
//        //这一个好像不是 必需的,但是这是布鲁西 添加的,某一个地方可能有了吧
////        public Studenta(Connection con) {
////        }
//
//        public Studenta(String csrq,String xz, String xmEn, String bj, String zyh, String yxh, String xb, String mz, String zym, String yxm, String xh, String rxrq, String xjzt, String xm, String yxmen, String zymEn, String nj) {
//            this.Csrq = csrq;
//            this.Xz = xz;
//            this.XmEn = xmEn;
//            this.Bj = bj;
//            this.Zyh = zyh;
//            this.Yxh = yxh;
//            this.Xb = xb;
//            this.Mz = mz;
//            this.Zym = zym;
//            this.Yxm = yxm;
//            this.Xh = xh;
//            this.Rxrq = rxrq;
//            this.Xjzt = xjzt;
//            this.Xm = xm;
//            this.Yxmen = yxmen;
//            this.ZymEn = zymEn;
//            this.Nj = nj;
//        }
//
//
//        public String getCsrq() {
//            return Csrq;
//        }
//
//        public void setCsrq(String csrq) {
//            Csrq = csrq;
//        }
//
//        public String getXz() {
//            return Xz;
//        }
//
//        public void setXz(String xz) {
//            Xz = xz;
//        }
//
//        public String getXmEn() {
//            return XmEn;
//        }
//
//        public void setXmEn(String xmEn) {
//            XmEn = xmEn;
//        }
//
//        public String getBj() {
//            return Bj;
//        }
//
//        public void setBj(String bj) {
//            Bj = bj;
//        }
//
//        public String getZyh() {
//            return Zyh;
//        }
//
//        public void setZyh(String zyh) {
//            Zyh = zyh;
//        }
//
//        public String getYxh() {
//            return Yxh;
//        }
//
//        public void setYxh(String yxh) {
//            Yxh = yxh;
//        }
//
//        public String getXb() {
//            return Xb;
//        }
//
//        public void setXb(String xb) {
//            Xb = xb;
//        }
//
//        public String getMz() {
//            return Mz;
//        }
//
//        public void setMz(String mz) {
//            Mz = mz;
//        }
//
//        public String getZym() {
//            return Zym;
//        }
//
//        public void setZym(String zym) {
//            Zym = zym;
//        }
//
//        public String getYxm() {
//            return Yxm;
//        }
//
//        public void setYxm(String yxm) {
//            Yxm = yxm;
//        }
//
//        public String getXh() {
//            return Xh;
//        }
//
//        public void setXh(String xh) {
//            Xh = xh;
//        }
//
//        public String getRxrq() {
//            return Rxrq;
//        }
//
//        public void setRxrq(String rxrq) {
//            Rxrq = rxrq;
//        }
//
//        public String getXjzt() {
//            return Xjzt;
//        }
//
//        public void setXjzt(String xjzt) {
//            Xjzt = xjzt;
//        }
//
//        public String getXm() {
//            return Xm;
//        }
//
//        public void setXm(String xm) {
//            Xm = xm;
//        }
//
//        public String getYxmen() {
//            return Yxmen;
//        }
//
//        public void setYxmen(String yxmen) {
//            Yxmen = yxmen;
//        }
//
//        public String getZymEn() {
//            return ZymEn;
//        }
//
//        public void setZymEn(String zymEn) {
//            ZymEn = zymEn;
//        }
//
//        public String getNj() {
//            return Nj;
//        }
//
//        public void setNj(String nj) {
//            Nj = nj;
//        }
//    }
//
//    //创建数据库的链接
//    private static Connection getConn() {
//
//        Connection conn = null;
//        try {
//            //加载 JDBC 的驱动
//            String driverName = "com.mysql.cj.jdbc.Driver";
//            Class.forName(driverName); //classLoader,加载对应驱动
//
//            //创建数据库的链接, student 为库名，其后为数据库设置了  UTF-8和 时区，不然 中文会乱码
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    //设置 prepareStatement对象 insert
//    public static int insert(JDBCOperation.Studenta studenta) {
//        Connection conn = getConn();
//        int i = 0;
//        String sql = "insert into class (Csrq,Xz,XmEn,Bj,Zyh,Yxh,Xb,Mz,Zym,Yxm,Xh,Rxrq,Xjzt,Xm,Yxmen,ZymEn,Nj)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement pstmt;
//        try {
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,studenta.getCsrq());
//            pstmt.setString(2,studenta.getXz());
//            pstmt.setString(3,studenta.getXmEn());
//            pstmt.setString(4,studenta.getBj());
//            pstmt.setString(5,studenta.getZyh());
//            pstmt.setString(6,studenta.getYxh());
//            pstmt.setString(7,studenta.getXb());
//            pstmt.setString(8,studenta.getMz());
//            pstmt.setString(9,studenta.getZym());
//            pstmt.setString(10,studenta.getYxm());
//            pstmt.setString(11,studenta.getXh());
//            pstmt.setString(12,studenta.getRxrq());
//            pstmt.setString(13,studenta.getXjzt());
//            pstmt.setString(14,studenta.getXm());
//            pstmt.setString(15,studenta.getYxmen());
//            pstmt.setString(16,studenta.getZymEn());
//            pstmt.setString(17,studenta.getNj());
//            i = pstmt.executeUpdate();
//            pstmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
//
//    //主函数， 用 JSONObject和JSONArray 解析复杂 json
//    public static void main(String[] args) {
//        Connection con = JDBCOperation.getConn();
////            Studenta s = new Studenta(con);
//
//        //层层 对象 键对+数组解析
//        JSONObject jsonObject = JSONObject.fromObject(PostTest.sendPost());
//        String two = jsonObject.getString("returnData");
//        JSONArray jsonArray = JSONArray.fromObject(two);//fromobject()里面的参数均是 字符串就行
//
//        //使用 遍历得到每个学生的对象，
//        for (int i =0;i < jsonArray.size();i++){
//            //数组 取出对象 { } ，传入jso
//            JSONObject jso = JSONObject.fromObject(jsonArray.get(i));
//            //getString () 要有 双引号""才能取值为字符串，这时候 不需要getString 外面再包"",不然就当成字符串了
//            //jso 根据键取相应值，用insert 存入数据库
//            JDBCOperation.insert(new Studenta(jso.getString("csrq"), jso.getString("xz"),jso.getString("xmEn"),
//                    jso.getString("bj"),jso.getString("zyh"),jso.getString("yxh"),jso.getString("xb"),jso.getString("mz"),
//                    jso.getString("zym"),jso.getString("yxm"),jso.getString("xh"),jso.getString("rxrq"),jso.getString("xjzt"),
//                    jso.getString("xm"),jso.getString("yxmen"),jso.getString("zymEn"),jso.getString("nj")));
//        }
//        System.out.println("爬取成功");
//    }
//}