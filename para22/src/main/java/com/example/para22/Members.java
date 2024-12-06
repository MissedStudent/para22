package com.example.para22;

public class Members {
    private int id; // id записи в таблице
    private String fullname; // полное имя автора, как будет отображаться в ComboBox

    public Members(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    // получение id из списка, необходимо для добавления новой записи в таблицу
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return fullname; // Это то, что будет отображаться в ComboBox
    }
}
