import GUI.Menu;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu projectGUI = new Menu();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            var command = scanner.nextLine();
            DatabaseController databaseController = new DatabaseController();

            switch (command) {
                case "help" -> {
                    System.out.println("help: shows the manual of all available commands");
                    System.out.println("sstask: shows scheduled tasks");
                    System.out.println("ctask: creates task");
                    System.out.println("dtask: deletes task");
                    System.out.println("comtask: completes task");
                }

                case "sstask" -> {
                    //Shows the sstasks from the database
                    databaseController.ShowScheduledTasks();
                }

                case "ctask" -> {
                    //Adds task to the database
                    System.out.println("Write a name for your task: ");
                    var name = scanner.nextLine();

                    System.out.println("Write the task: ");
                    var text = scanner.nextLine();

                    //Sets value of importance to the task
                    System.out.println("Write an importance level for this task (low/l, middle/m, high/h): ");
                    var importanceText = scanner.nextLine();
                    TaskImportance importance;
                    if(importanceText.equalsIgnoreCase("low") || importanceText.equalsIgnoreCase("l")) {
                        importance = TaskImportance.LOW;
                    } else if(importanceText.equalsIgnoreCase("middle") || importanceText.equalsIgnoreCase("m")) {
                        importance = TaskImportance.MEDIUM;
                    } else if(importanceText.equalsIgnoreCase("high") || importanceText.equalsIgnoreCase("h")) {
                        importance = TaskImportance.HIGH;
                    } else {
                        System.out.println("Invalid importance format. Write either low/m, middle/m, high/h");
                        break;
                    }

                    System.out.println("Write the date for your task: ");
                    var dateText = scanner.nextLine();
                    var date =  LocalDate.parse(dateText);

                    databaseController.AddTask(name, text, date, importance);
                }

                case "comtask" -> {
                    System.out.println("Write a name of the task that has to be completed: ");

                    var name = scanner.nextLine();

                    databaseController.CompleteTask(name);
                }

                case "dtask" -> {
                    //Deletes task from the database
                    System.out.println("Write a name for task that has to be deleted: ");
                    var name = scanner.nextLine();

                    databaseController.DeleteTask(name);
                }

                default -> System.out.println("Write help to see info about available commands");
            }
        }
    }

    public static void ShowMessage(String message) {
        System.out.println(message);
    }
}