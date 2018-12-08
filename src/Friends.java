//Android第三次作业  自己运用上课讲的内容实现一些小玩意，要求体现面向对象的几大特性：封装、继承、多态。如果你实现得 好，会比Lv.4分更高！
public class Friends {
    private String name;
    public int age = 30;
    public int faceValue = 7;
    public int height;
    public String sex;

    public void setName(String name) {
        if (name.length() > 6 || name.length() < 2) {
            System.out.println("您设置的人名不符合要求");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public Friends(int height, String sex) {
        this.height = height;
        this.sex = sex;
    }

    public void ask() {
        System.out.println("父类被覆盖的方法");
    }

    public void Base()
    {
        System.out.println("父类的普通方法");
    }
}


class GirlFriendB extends Friends {
    public String name;
    public int age = 18;
    public int faceValue = 100;
    public String color;
    public void ask()
    {
        System.out.println("就是现在这个--子类的覆盖父类的方法");
    }

    public void sub()
    {
        System.out.println("子类的普通方法");
    }

    public GirlFriendB(int height , String sex , String color){
        super(height , sex);
        this.color = color;
    }

    public void accessFriends()
    {
        System.out.println(super.age);
        System.out.println(super.faceValue);
    }

    public void accessGirlFriend()
    {
        System.out.println(age);
        System.out.println(faceValue);
    }

    public static void main(String[] args)
    {
        Friends girl1 = new Friends(160,"女");
        System.out.println("封装--子类用方法访问pravite修饰下的 name");
        girl1.setName("紫佚");
        System.out.println(girl1.getName());
        GirlFriendB girl2 = new GirlFriendB(160,"女","红色");
        System.out.println();
        System.out.println("父类子类都有ask方法，默认输出覆盖父类ask方法的子类ask方法");
        girl2.ask();
        System.out.println();
        System.out.println("父类中的 朋友的年龄加+颜值");
        girl2.accessFriends();
        System.out.println();
        System.out.println("子类下 女朋友2的年龄+颜值");
        girl2.accessGirlFriend();
        System.out.println();
        System.out.println("子类调用父类的构造器");
        GirlFriendB girl3 = new GirlFriendB(160,"女","雪白色");
        System.out.println("第三个女朋友" + girl3.height +"--"+ girl3.sex + "--" + girl3.color);

        System.out.println();

        System.out.println("下面是多态的运行");
        Friends vv = new GirlFriendB(161,"女","紫色");

        System.out.println("访问父类的实例变量age");
        System.out.println(((Friends) vv).age);

        System.out.println();

        System.out.println("访问子类下的age");
        System.out.println(((GirlFriendB) vv).age);

        System.out.println();

        System.out.println("调用执行父类的继承的Base的普通方法");
        vv.Base();

        System.out.println();

        System.out.println("调用ask方法时，多态下为子类覆盖父类了的ask方法");
        vv.ask();

    }
}