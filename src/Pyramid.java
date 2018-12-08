public class Pyramid{
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 2 * i + 1; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}