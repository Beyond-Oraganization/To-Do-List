import java.time.LocalDate;

public class Task {
    int id;
    String name;
    String text;
    LocalDate date;
    TaskImportance importance;

    public Task(int id, String name, String text,
                LocalDate date, TaskImportance importance) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
        this.importance = importance;
    }


    //region Encapsulation methods
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TaskImportance getImportance() {
        return importance;
    }
    public void setImportance(TaskImportance importance) {
        this.importance = importance;
    }
    //endregion
}
