import java.util.Scanner;
import java.io.File;

public class GradeHistogram {
    public static void main(String[] args) throws Exception {

        Scanner fileScanner = new Scanner(new File(args[0]));

        System.out.println("Grades loaded!");
        System.out.println("What bucket size would you like?");

        System.out.print(">>> ");
        Scanner keyboard = new Scanner(System.in);
        int bucketSize = keyboard.nextInt();

        System.out.printf("%n");

        int counter = 0;
        while (fileScanner.hasNext()) {
            counter++;
            fileScanner.nextLine();
        }

        Scanner lineReader = new Scanner(new File(args[0]));

        int[] grades = new int[counter];
        int i = 0;
        while (lineReader.hasNext()) {
            int grade = Integer.parseInt(lineReader.nextLine());
            grades[i] = grade;
            i++;
        }

        StringBuffer bracketsNumber = new StringBuffer();

        for (int x = 100; x > 0; x = x - bucketSize) {
            int start = x;
            int end = x - bucketSize + 1;

            if (end < 0) {
                end = 0;
            }

            for (int grade: grades) {
                if ((grade <= start) && (grade >= end)) {
                    bracketsNumber.append("[]");
                }
            }

            System.out.printf("%3d - %3d | ", start, end);
            System.out.printf(bracketsNumber.toString() + "%n");
            bracketsNumber.delete(0, bracketsNumber.length());
        }

        if (100 % bucketSize == 0) {
            System.out.printf("  0 -   0 | ");
            StringBuffer zeroBracketsNumber = new StringBuffer();
                for (int zeroGrade:grades) {
                    if (zeroGrade == 0) {
                        zeroBracketsNumber.append("[]");
                    }
                }
            System.out.printf(zeroBracketsNumber.toString() + "%n");
        }
    }
}