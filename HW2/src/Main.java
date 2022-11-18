// import java.util.concurrent.ThreadLocalRandom;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        String command;
        while (true) {
            command = myInput.nextLine();
            switch (command) {
                case "/r" -> {
                    Journal.chooseRandomStudent();
                }
                case "/p" -> {
                    Journal.printGroupList();
                }
                case "/q" -> {
                    return;
                }
                default -> {
                    System.out.println("Incorrect command");
                }
            }
        }
    }
}