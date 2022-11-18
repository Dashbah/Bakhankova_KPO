import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Journal {
    static Student[] STUDENTS = {new Student("A", "a"),
            new Student("B", "b"),
            new Student("C", "c")
    };

    public static void chooseRandomStudent() {
        int numberOfStudent = ThreadLocalRandom.current().nextInt(STUDENTS.length);
        STUDENTS[numberOfStudent].printStudentName();
        System.out.println();
        System.out.print("Grade: ");
        Scanner myInput = new Scanner(System.in);
        try {
            int grade = myInput.nextInt();
            STUDENTS[numberOfStudent].addGrade(grade);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printGroupList() {
        for (var student : STUDENTS) {
            student.printStudentName();
            System.out.print(' ');
            if (student.getAverage() != -1) {
                System.out.print(student.getAverage());
            } else {
                System.out.print('-');
            }
            System.out.println();
        }
    }

    public static class Student {
        String name;
        String surname;
        // для нашей задачи можно хранить среднее и количество оценок, но
        // для лучшей поддерживаемости (вдруг потом надо будет найти минимум)
        // лучше хранить массив оценок
        int average = 0;
        int numOfGrades = 0;
        Vector<Integer> grades = new Vector<>();

        public Student(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getAverage() {
            if (numOfGrades != 0) {
                return average;
            }
            return -1;
        }

        public void addGrade(int grade) throws Exception {
            if (grade < 0) {
                throw new Exception("not enough for happy life :(");
            }
            if (grade > 12) {
                throw new Exception("to smart");
            }
            grades.add(grade);
            average = (average * numOfGrades + grade) / (numOfGrades + 1);
            ++numOfGrades;
        }

        public void printStudentName() {
            // это нормальный вывод или есть красивее?
            // System.out.print(name + " " surname) это boxing/unboxing по идее
            System.out.print(name);
            System.out.print(' ');
            System.out.print(surname);
        }
    }
}
