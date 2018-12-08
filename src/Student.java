//集合的升序，降序排列，以及 五种遍历方法
import java.util.*;

public class Student implements Comparable<Student> {
    private int classname;
    private String name;
    private int id;
    private int age;
    private String sex;

    //实现Comparable接口 并重写compareTo方法,实现升序排序
    public int compareTo(Student stu) {
        if (this.id > stu.getId()) {
            return 1;
        } else {
            return -1;
        }
    }


    public int getClassname() {
        return classname;
    }

    public void setClassname(int classname) {
        this.classname = classname;
    }

    public String getName() {
        return name;   //也可以  return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int setid(int id) {
        this.id = id;
        return id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student() {
        super();
    }

    public Student(int classname, String name, int id, int age, String sex) {
        super();  //虽无继承，此处是调用 objec类的属性和方法
        this.classname = classname;
        this.name = name;
        this.id = id;
        this.age = age;
        this.sex = sex;
    }


    public String toString() {
        return "Student [classname=" + classname + ", name=" + name + ", id=" + id + " ,age=" + age + ", sex=" + sex + " ]";
    }
}

//    public String getAge() {
//
//    }
//}

class play {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<Student>();  //后面student可以省略!
        //存储5个小可爱！

        list.add(new Student(1, "王大大", 5002311, 18, "男"));
        list.add(new Student(2, "丁二二", 5002312, 18, "女"));
        list.add(new Student(3, "张三三", 5002313, 18, "男"));
        list.add(new Student(4, "李思思", 5002314, 18, "女"));
        list.add(new Student(5, "兮兮五", 5002315, 18, "男"));

        System.out.println("学号升序排序*******************************************************");
        System.out.println("******************************************************************");
        Collections.sort(list);  //只有一个参数参数为List

        for (Student stu : list) {
            System.out.println(stu);
        }

        //通过list.get(index)方式获取元素  第一种遍历法
        System.out.println("存储学生信息完成后的第一种遍历方式-----通过list.get(index)方式获取元素");
        System.out.println("******************************************************************");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        //新添加的童鞋！
        list.add(3, new Student(1, "新添加的小可爱", 5002316, 17, "女"));

        //Lambda表达式遍历集合             第二种遍历法
        System.out.println("添加后的第二种遍历方式-----Lambda表达式遍历集合");
        System.out.println("******************************************************************");
        list.forEach(h -> System.out.println(h));


        //开除一个不听话的!
        list.remove(4);

        //使用Lambda 表达式遍历 Iterator   第三种遍历法
        System.out.println("开除一个不听话的童鞋后的第三种遍历方式----使用Lambda 表达式遍历 Iterator");
        System.out.println("******************************************************************");
        Iterator<Student> itss = list.iterator();
        itss.forEachRemaining(j -> System.out.println(j));


        //使用佚代器遍历list               第四种遍历法
        System.out.println("再写一种遍历的第四种遍历方式-----使用佚代器遍历list ");
        System.out.println("******************************************************************");
        Iterator<Student> its = list.iterator();
        while (its.hasNext()) {
            Student s = its.next();
            System.out.println(s);
        }

        //最后一次添加一个小仙女
        list.add(5, new Student(1, "又一个小仙女", 50023117, 17, "女"));

        //通过增强型for循环获取student对象信息
        System.out.println("最后添加一个小仙女的第五种遍历方式-----通过增强型for循环获取student对象信息");
        System.out.println("******************************************************************");
        for (Student s : list) {          //第五种遍历法
            System.out.println(s);  //可以改成s.toString!!!
        }


        System.out.println("学号降序排序*****************************");
        System.out.println("******************************************************************");


        TreeSet ts = new TreeSet<Student>((o1, o2) -> {
            Student m1 = (Student) o1;
            Student m2 = (Student) o2;
            return m1.getId() > m2.getId() ? -1
                    : m1.getId() < m2.getId() ? 1 : 0;
        });

        ts.add(new Student(1, "王大大", 5002311, 18, "男"));
        ts.add(new Student(2, "丁二二", 5002312, 18, "女"));
        ts.add(new Student(3, "张三三", 5002313, 18, "男"));
        ts.add(new Student(4, "李思思", 5002314, 18, "女"));
        ts.add(new Student(5, "兮兮五", 5002315, 18, "男"));
        for (Student s : list) {
            System.out.println(s);  //可以改成s.toString!!!,并且 s 自己想怎么命名就怎么命名！
        }

    }
}


