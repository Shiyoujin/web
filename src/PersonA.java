public class PersonA {
    public String name;
    public int age;  //成员变量
    public void say(String content)  //方法
    {
        System.out.println(content);
    }
    public static void main(String[] args) {
        PersonA p = new PersonA();  //构造器 实例化对象
        p.name="李刚";
        p.say("java语言很简单，学习很容易！");  //参数传给上面类的 content，然后输出
        System.out.println(p.name);
    }
}

