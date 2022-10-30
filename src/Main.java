import java.util.Scanner;

public class Main {
    //Вариант 4
    public static double a = 0, b = 5, h = Math.pow(10, -3);
    public static double result = 0;

    public static void main(String[] args) {
        //System.out.println("Result = " + (Math.exp(b) - Math.exp(a)));
        Runnable r = new Runnable() {
            @Override
            public void run() {
                long tmpStart = System.currentTimeMillis();
                while (a < ((b - a) / h)) {
                    try {
                        result += h * ( 0.5 * (Math.exp(a) + Math.exp(a + h)));
                        a += h;
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("result = " + result);
                }
                System.out.println(" Delay: " + (System.currentTimeMillis() - tmpStart));
            }
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of threads : ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Thread f = new Thread(r, ("thread : " + i));
            System.out.println(f.getName());
            f.start();

        }
    }
}
