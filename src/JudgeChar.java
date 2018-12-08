public class JudgeChar {
    //1、简单判断字符串 是否和 全为小写或者大写字母 配
    public static void main(String[] args) {
        String str = "DKKD";
        if (str.matches("[a-z]*"))  //"[A-Z]*"
            System.out.println("Yse,");
        else ;
        System.out.println("NO");
    }


    public static class dsad {
        //2、  将字符串 拆分成 字符数组，判断 1、是否全为纯数字 2、是否全为 大写字母 3、是否全为小写字母
        public static void main(String[] args) {
            String str = "acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";//，或者空格与下的""内容对齐
            String result[] = str.split(",");//字符串全拆分字符数组


            for (int x = 0; x < result.length; x++)
                if (isNumber(result[x])) {
                    System.out.println("this number");
                } else if (isCapital(result[x])) {
                    System.out.println("this capital");
                } else if (isLowcase(result[x])) {
                    System.out.println("this lowcase");
                } else {
                    System.out.println("all not");
                }
        }

        //该方法主要是判断字符串是否由数字所组成！
        public static boolean isNumber(String result) { //此result看作  竖着的字符串
            char baby[] = result.toCharArray();//将字符串变为字符数组
            for (int x = 0; x < baby.length; x++) {
                if (baby[x] < '0' || baby[x] > '9') {   //  ||表示或者
                    return false;
                }
            }
            return true;
        }

        public static boolean isCapital(String result) {
            char babb[] = result.toCharArray();
            for (int x = 0; x < babb.length; x++) {
                if (result.matches("[A-Z]*")) {   //"[A-Z]*"
                    return true;
                }
            }
            return false;
        }

        public static boolean isLowcase(String result) {
            char baab[] = result.toCharArray();
            for (int x = 0; x < baab.length; x++) {
                if (result.matches("[a-z]*")) {
                    return true;
                }
            }
            return false;
        }
    }

    //3、 将字母字符串 变为 字符数组，再可 循环节约时间转化 成 大小写
    public static class c {
        public static void main(String[] args) {
            String str = "helloworld";
            char[] arr = str.toCharArray();//将字符串变为字符数组
            for (int x = 0; x < arr.length; x++) {
                arr[x] -= 32;  //编码减少32，即转变为大写字母，只有变为数组才能做加减法
            }
            //将处理后的字符数组交给String变为字符串
            String newStr = new String(arr);
            System.out.println(newStr);
        }
    }
}


