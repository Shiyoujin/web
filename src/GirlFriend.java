public class GirlFriend {//进行类的定义
    String name;
    int age;
    char gender;
    int faceValue;
    int height;
    public void tell() {
        System.out.println("姓名: " + name + ", 年龄："+ age + ",性别：" + gender + ",颜值:" + faceValue + ",身高:" + height);
    }
    public static void main(String[] args) {
        GirlFriend per = new GirlFriend()  ;//实例化对象
        per.name = "佚";  //传参
        per.age = 17;
        per.gender = '女';
        per.faceValue = 6;
        per.height = 158;
        per.tell();//无参

    }
}
