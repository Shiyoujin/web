//Andorid作业  数组遍历 54张 扑克牌
import java.util.LinkedList;

    // 扑克类
    class Poker {
        String color;// 花色
        String num;// 点数

        // 构造方法
        public Poker(String color, String num) {
            super();
            this.color = color;
            this.num = num;
        }

        // 重写toString()
        @Override
        public String toString() {
            return color + num;
        }
    }

    class Demo {

        public static void main(String[] args) {
            //实例化集合对象
            LinkedList pockers = createPoker();
            showPoker(pockers);//显示多少张牌1
        }

        //生成扑克牌的方法
        public static LinkedList createPoker() {
            //该集合用于存储扑克对象
            LinkedList list = new LinkedList();
            //定义数组存储所有的花色和点数
            String[] colors = {"黑色", "红桃", "梅花", "方块"};
            String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
            //添加集合中扑克牌
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < colors.length; j++) {
                    list.add(new Poker(colors[j], nums[i]));
                }
            }
            return list;
        }

        //显示扑克牌
        public static void showPoker(LinkedList pockers) {
            for (int i = 0; i < pockers.size(); i++) {
                System.out.print("  " + pockers.get(i));
                //换行
                if (i % 10 == 9) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println("king");
            System.out.println("kinglet");
            System.out.println();
            System.out.println("牌数:" + pockers.size());//显示多少张牌    不会输出54张牌了，大王小王。。

        }
    }

