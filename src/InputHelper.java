import java.util.Scanner;

public class InputHelper {

    public static int getInt(Scanner scan, String prompt) {
        int num = 0;
        boolean done = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                done = true;
            } else {
                System.out.println("Invalid num. " + prompt);
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    public static double getDouble(Scanner scan, String prompt) {
        double num = 0;
        boolean done = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                done = true;
            } else {
                System.out.println("Invalid num. " + prompt);
            }
            scan.nextLine();
        } while (!done);
        return num;
    }


    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        int num = 0;
        boolean done = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0) {
                    done = true;
                } else {
                    System.out.println("Invalid num. " + prompt);
                }
            } else {
                System.out.println("Invalid num. " + prompt);
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    public static int getRangedInt(Scanner scan, String prompt, int lowerBound, int upperBound) {
        int num = 0;
        boolean done = false;

        System.out.println(prompt + " [" + lowerBound + "-" + upperBound + "]");
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num <= upperBound && num >= lowerBound) {
                    done = true;
                } else {
                    System.out.println("Invalid num. " + prompt + " [" + lowerBound + "-" + upperBound + "]");
                }
            } else {
                System.out.println("Invalid num. " + prompt + " [" + lowerBound + "-" + upperBound + "]");
            }
            scan.nextLine();
        } while (!done);
        return num;
    }

    public static double getRangedDouble(Scanner scan, String prompt, double lowerBound, double upperBound) {
        double num = 0;
        boolean done = false;

        System.out.println(prompt + "[" + lowerBound + "-" + upperBound + "].");
        do {
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                if (num <= upperBound && num >= lowerBound) {
                    scan.nextLine();
                    done = true;
                } else {
                    System.out.println("Invalid num. " + prompt + " [" + lowerBound + "-" + upperBound + "]");
                    scan.nextLine();
                }
            } else {
                System.out.println("Invalid num. " + prompt + " [" + lowerBound + "-" + upperBound + "]");
                scan.nextLine();
            }
        } while (!done);
        return num;
    }

    public static String getRegEx(Scanner scan, String prompt, String regExPattern) {

        String input;
        boolean done = false;

        System.out.println(prompt);

        do {
            input = scan.nextLine();
            if (input.matches(regExPattern)) {
                done = true;
            } else {
                System.out.println("Invalid input. " + prompt);
            }
        } while (!done);
        return input;

    }

    public static String getNonZeroLenString(String prompt, Scanner scan) {
        String input;
        boolean done = false;

        System.out.println(prompt);

        do {
            input = scan.nextLine();
            if (input.length() <= 0) {
                System.out.println("Invalid input. " + prompt);
            } else {
                done = true;

            }
        } while (!done);

        return input;
    }

    public static boolean getYNConfirm(String prompt, Scanner scan) {

        boolean done = false;
        boolean confirm = false;

        System.out.println(prompt);

        do {
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                if (input.equalsIgnoreCase("y")) {
                    confirm = true;
                    done = true;
                } else {
                    confirm = false;
                    done = true;
                }

            } else {
                System.out.println("Invalid input. " + prompt);
            }
        } while (!done);
        return confirm;
    }

    public static void prettyHeader(String msg) {

        int buffer = (54-msg.length())/2;
        for (int i=0; i<20; i++) {
            System.out.print("***");
        }
        System.out.print("\n***");
        for (int j = 0; j<buffer; j++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int j = 0; j<buffer; j++) {
            System.out.print(" ");
        }
        System.out.print("***");
        for (int i = 0; i<20; i++) {
            System.out.print("***");
        }
        System.out.println();
    }

}