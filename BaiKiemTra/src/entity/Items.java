package entity;

import constant.ItemsType;

import java.util.Scanner;

public class Items implements Inputable {

    private int id;
    private String name;
    private String itemsType;
    private double price;
    private int quantity;

    private static int AUTO_ID = 1000;

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

    public String getItemsType() {
        return itemsType;
    }

    public void setItemsType(String itemsType) {
        this.itemsType = itemsType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemsType='" + itemsType + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }


    @Override
    public void inputInfor() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập nhóm hàng là 1 trong các loại dưới đây");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.print("Xin mời chọn: ");

        int temp = 0;
        System.out.println("Xin mời nhập lựa chọn");
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >=1 && temp <=3) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại ");
        }while (true);
        switch (temp){
            case 1:
                this.itemsType = ItemsType.DIEN_TU.value;
                break;
            case 2:
                this.itemsType = ItemsType.DIEN_LANH.value;
                break;
            case 3:
                this.itemsType = ItemsType.MAY_TINH.value;
                break;
        }
        System.out.print("Nhập giá bán: ");
        this.price = new Scanner(System.in).nextDouble();
        System.out.print("Nhập số lượng: ");
        this.quantity = new Scanner(System.in).nextInt();
    }
}
