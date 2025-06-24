import java.sql.*;
import java.time.LocalDate;

public class DatabaseController {
    String jdbcUrl = "jdbc:oracle:thin:@//192.168.0.144:1521/XEPDB1";
    String username = "TODOLIST";
    String password = "ToDoList_31012007";

    public void AddTask(String name, String text, LocalDate date, TaskImportance importance) {
        try {
            //Add task to the database

            String command = "INSERT INTO TASKS " +
                    "(id, name, text, taskDate, importance, isCompleted) VALUES " +
                    "(" + GetFreeID() + ", " +
                    "'" + name + "', " +
                    "'" + text + "', " +
                    "TO_DATE('" + date + "', 'YYYY-MM-DD'), " +
                    "" + importance.GetCode() + ", " +
                    "0)";

            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            Statement stmt = conn.createStatement();

            stmt.executeQuery(command);

            Main.ShowMessage("Successfully added task");
        } catch (Exception e) {
            Main.ShowMessage("Database add exception: " + e.getMessage()
                    + "\n Stack trace: " + e.getStackTrace().toString());
        }
    }

    int GetFreeID() {
        int lastID = 0;

        //Gets last ID from database and adds to it 1
        try {
            String command = "SELECT MAX(ID) FROM TASKS";
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(command);

            boolean doesRSExist = rs.next();

            if (!doesRSExist) {
                lastID = 0;
            } else {
                lastID = rs.getInt(1);
            }
        }catch(Exception e) {
            Main.ShowMessage("Database get free id exception: " + e.getMessage());
        }

        return (lastID + 1);
    }

    public void CompleteTask(String name) {
        try {
            String command = "UPDATE TASKS SET isCompleted = 1 WHERE (NAME = '" + name + "' AND ISCOMPLETED = 0)";
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(command);

            if(!rs.next()) {
                Main.ShowMessage("There is no incomplete task like this");
            } else {
                Main.ShowMessage("The task is completed");
            }
        } catch (Exception e) {
            Main.ShowMessage("Database complete task exception: " + e.getMessage());
        }
    }

    public void DeleteTask(String name) {
        try {
            //Deletes task from the database
            String command = "DELETE FROM TASKS WHERE NAME = '" + name + "'";

            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(command);

            if(!rs.next()) {
                Main.ShowMessage("There is no task like this");
            } else {
                Main.ShowMessage("Task has been deleted");
            }
        } catch (Exception e) {
            Main.ShowMessage("Database delete exception: " + e.getMessage());
        }
    }

    public void ShowScheduledTasks() {
        try {
            //Show scheduled tasks from database

            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TASKS");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String text = rs.getString("text");
                Date date = rs.getDate("taskDate");
                int importanceNumber = rs.getInt("importance");
                int isComplitedNumber = rs.getInt("iscompleted");
                System.out.println("ID: " + id + ", Name: " + name + ", Date: " + date +  ", Importance: " + TaskImportance.FromCode(importanceNumber) + ", IsComplited: " + (isComplitedNumber == 1)
                        + "\nText: " + text);
            }
        } catch (Exception e) {
            Main.ShowMessage("Database show exception: " + e.getMessage());
        }
    }
}
