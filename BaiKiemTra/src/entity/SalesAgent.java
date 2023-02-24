package entity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SalesAgent extends Person {

    private int id;
    private String date;

    private static int AUTO_ID = 1000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesAgent{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        this.id=AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập ngày kí hợp đồng: ");
        this.date = new Scanner(System.in).nextLine();
    }
}