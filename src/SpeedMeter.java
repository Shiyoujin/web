//java 书  抽象一部分
public abstract class SpeedMeter {
    private double turnRate;
//    public SpeedMeter(){}   可以不用弄一个构造器，后面没有用到 ！

    public abstract double getRadius();       //抽象方法不需 {}
    public void setTurnRate(double turnRate)
    {
        this.turnRate=turnRate;
    }
    public double getSpeed()
    {
        return java.lang.Math.PI * 2 *getRadius() * turnRate;
    }
}

class CarSpeedMeter extends SpeedMeter{
    public double getRadius()  //方法传参
    {
        return 0.28;
    }

    public static void main(String[] args) {
        CarSpeedMeter csm = new CarSpeedMeter();
        csm.setTurnRate(15);    //创建实例后传参
        System.out.println(csm.getSpeed());
    }
}
