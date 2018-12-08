public class Cat {
    public void jump()
    {
        System.out.println("执行jump的方法");
    }
    public  void run()
    {
        this.jump();
        System.out.println("执行run的方法");
    }
}


class DataWrap {
    int a;
    int b;
    //     class Test {  // 不必新建一个类也可以！！！,方法包含在类中即可！
    public static void swap(DataWrap dw) {
        int temp = dw.a;                               // 上下 a,b 均交换了！
        dw.a = dw.b;
        dw.b = temp;
        System.out.println("swap的方法里,a成员的变量值是" + dw.a + "swap方法里,成员的变量值是" + dw.b);
    }

    public static void main(String[] args) {
        DataWrap dw = new DataWrap();
        dw.a = 6;
        dw.b = 9;
        swap(dw);
        System.out.println("交换结束后,a成员变量值是" + dw.a + "b成员的变量值是" + dw.b);
    }
}




class Personn {
    public String name;    //无 static 修饰，下文的"方法"无法访问,故 为null;
    public static int eyenum;   //此为静态变量可由下文  eyenum 引用
}



class PersonTest{
    public static void main(String[] args) {
        System.out.println("Personn的eyesum类变量值" + Personn.eyenum);
        Personn p = new Personn();
        System.out.println("P变量name变量值是" + p.name + "p对象的eyenum的变量值是" + p.eyenum);
        p.name = "孙悟空";
        p.eyenum = 10;
        System.out.println("P变量name变量值是" + p.name + "p对象的eyenum的变量值是" + p.eyenum);
        System.out.println("Personn的eyesum类变量值" + Personn.eyenum );     //这里不可以 写 Personn.name,,因为 静态方法 main无法访问 实例变量即非 类变量！！！
        Personn p2 = new Personn();
        p2.name ="无敌";
        p2.eyenum = 20;
        System.out.println("p2对象的eyenum变量值：" + p2.eyenum + p2.name);  //注意此处 name为 null
        System.out.println(  Personn.eyenum);     //这里的Personn.eyenum 变量的值以最新传入参数为准！！！
    }
}