//public class Practice {
    //-----------------------------------练习代码-----------------------------------------------------------
//打草稿的 练习代码
//public class Person{
//    private String name;
//    private int age;
//    public String setName(String name){      //注意我将此处的 原先 void换成了 String，那么后面返回 必须加 return，且要有 返回值 name；
//        if (name.length() > 6 || name.length() < 2)
//        {
//            System.out.println("你设置的人名不符合要求");
//            return name;
//        }
//        else
//        {
//            this.name=name;
//            return name;
//        }
//    }
//public String getName(){
//        return this.name;
//}
//public void setAge(int age){
//        if (age > 100 || age < 0)
//        {
//            System.out.println("你设置的年龄不符合");
//            return;   //此处的renturn可要可不要！！！！！
//        }
//        else
//        {
//            this.age = age;   //有void return都省略了的
//        }
//}
//public int getAge()
//    {
//        return this.age;
//    }
//}
//
//class Test{   //这是另一个类了，不可调用main（）方法直接更改实例变量name，age；只能通过各自的 setter和getter的方法来操作这两个变量的值！！
//    public static void main(String[] args) {
//        Person p = new Person();
////        p.age =1000;
//        p.setAge(1000);
//        System.out.println("未能设置年龄变量时" + p.getAge());
//        p.setAge(30);
//        System.out.println("成功设置年龄的变量" + p.getAge());
//        p.setName("李刚");
//        System.out.println("成功设置nam成员变量后:" + p.getName());
//    }
//}
//
//public class Person{
//     int weight;
//    public void infoo()
//    {
//        System.out.println("我是一个水果!重" + weight + "g!");
//    }
//}
//   class Apple extends Person{               //就算没有继承， 用 Person 创造对象也可以实现。
//public static void main(String[]args){
//        Apple a =new Apple();
//        a.weight = 56;
//        a.infoo();
//        }
//        }
//
//public  class Person {
//    private String name;
//
//    public Person(String name) {
//        this.name = name;
//    }
//
////public class PP{}    //此处不能再设置类了，前面name 有 private的限定！
//    public static void main(String[] args) {
//        Person p = new Person("孙悟空");
//        System.out.println(p.name);
//    }
//}


//public class Person{
//     final int age;
//    {
////        System.out.println(age);
//        age = 6;
//        System.out.println(age);
//    }
//
//    public static void main(String[] args) {
//        Person per =  new Person();
//        // 此处创建对象也可以直接  new Person();
//        }
//}

//  抽象类里的抽象方法，延迟到子类的运用

