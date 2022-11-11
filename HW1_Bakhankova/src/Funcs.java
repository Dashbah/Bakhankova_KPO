public class Funcs {
    public static void printFizzBuzz() {
        for (int i = 1; i <= 100; ++i) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
                continue;
            }
            if (i % 3 == 0) {
                System.out.print("Fizz ");
                continue;
            }
            if (i % 5 == 0) {
                System.out.print("Buzz ");
                continue;
            }
            System.out.print(i);
            System.out.print(' ');
        }
    }
}
