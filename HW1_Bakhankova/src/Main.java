public class Main {
    public static void main(String[] args) {
        Funcs.printFizzBuzz();
        System.out.println();
        fibonacci(11);
        System.out.println();
        System.out.println(factorial(4));
        int[] arr = {4, 5, 1, 3, 5, 2, 6};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        String str = "r(frAfffo -oyeuZaz)";
        countVowelsAndConsonant(str);
    }

    static void fibonacci(int num) {
        int left = 0;
        System.out.print(left);
        if (num == 1) {
            return;
        }
        int right = 1;
        System.out.print(' ');
        System.out.print(right);
        System.out.print(' ');
        for (int i = 2; i < num; ++i) {
            int newNum = left + right;
            left = right;
            right = newNum;
            System.out.print(newNum);
            System.out.print(' ');
        }
    }

    static int factorial(int num) {
        if (num <= 1)
            return 1;
        return num * factorial(num - 1);
    }

    static void bubbleSort(int[] arr) {
        for (int i = arr.length; i > 0; --i) {
            for (int j = 0; j < i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // vowels находится в классе, чтобы массив не создавался при каждом вызове
    static char[] vowels = {'a', 'u', 'o', 'e', 'i', 'A',
            'U', 'O', 'E', 'I'};

    static boolean isVowel(char letter) {
        for (char vowel : vowels) {
            if (letter == vowel) {
                return true;
            }
        }
        return false;
    }

    static void countVowelsAndConsonant(String str) {
        int numOfVowels = 0;
        int numOfConsonant = 0;
        for (int i = 0; i < str.length(); ++i) {
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') ||
                    (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
                if (isVowel(str.charAt(i))) {
                    ++numOfVowels;
                } else {
                    ++numOfConsonant;
                }
            }
        }
        System.out.println("vowels: " + numOfVowels);
        System.out.println("Consonants: " + numOfConsonant);
    }
}