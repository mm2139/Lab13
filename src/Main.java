import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<String>();

        Scanner scan = new Scanner(System.in);

        String userChoice = "";

        boolean quit = false;
        boolean saved = false;

        Print(list);

        do {
            System.out.println("Options: \n" +
                    "A – Add an item to the list \n" +
                    "D – Delete an item from the list \n" +
                    "V - View the list\n" +
                    "Q – Quit this program\n" +
                    "O – Open a list file from PC \n" +
                    "S – Save the current list file to PC \n" +
                    "C – Clears all the elements from the current list \n");

            userChoice = InputHelper.getRegEx(scan, "Choose an option from the menu.", "[AaDdVvQqOoSsCc]");

            if (userChoice.equalsIgnoreCase("A")) {
                Add(scan, list);
                Print(list);
                saved = false;
            }
            if (userChoice.equalsIgnoreCase("D")) {
                Delete(scan, list);
                Print(list);
                saved = false;
            }
            if (userChoice.equalsIgnoreCase("V")) {
                Print(list);
            }
            if (userChoice.equalsIgnoreCase("Q")) {
                quit = Quit(scan);
            }
            if (userChoice.equalsIgnoreCase("O")) {
                if (saved == false) {
                    boolean temp = InputHelper.getYNConfirm("Save current list? [Y/N]", scan);
                    if (temp == true) {
                        saved = Save(list, scan);
                    }
                }
                list.clear();
                IOHelper.openFile(list);
                }
            if (userChoice.equalsIgnoreCase("S")) {
                saved = Save(list, scan);
            }
            if (userChoice.equalsIgnoreCase("C")) {
                list.clear();
                saved = false;
            }
        }
        while (!quit);


    }

    public static void Add(Scanner scan, ArrayList list) {
        String item = InputHelper.getNonZeroLenString("Input the item you would like to add to the list.", scan);
        list.add(item);
    }

    public static void Delete(Scanner scan, ArrayList list) {
        int index = InputHelper.getRangedInt(scan, "Input the index of the item you would like to remove in the list.", 0, list.size()-1);
        list.remove(index);
    }

    public static void Print(ArrayList list) {
        System.out.printf("%5s | %2s", "Index", "Item\n");
        for (int i = 0; i<list.size(); i++)
            System.out.printf("%5s | %2s", i, list.get(i) + "\n");
    }

    public static boolean Save(ArrayList list, Scanner scan) throws IOException {
        String name = InputHelper.getNonZeroLenString("Input the title you would like to name your file.", scan);
        IOHelper.writeFile(list, name);
        return true;
    }

    public static boolean Quit(Scanner scan) {

        boolean confirm = false;

        do {
            System.out.println("Are you sure you would like to quit? [Y/N]");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("Thank you.");
                    System.exit(0);
                } else {
                    return false;
                }
            } else {
                System.out.println("Invalid input.");
            }
        } while (!false);
    }

}