package logic;

import constant.ItemsType;
import entity.Items;

import java.util.Scanner;

public class ItemsLogic {

    private Items[] items;

    private int totalItems;

    public ItemsLogic(Items[] items) {
        this.items = items;
    }

    public ItemsLogic(int totalItems) {
        this.totalItems = totalItems;
    }

    public Items[] getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void addNewItems() {
        System.out.print("Nhập số lượng danh sách mặt hàng muốn thêm mới: ");
        int itemsnum = new Scanner(System.in).nextInt();
        for (int i = 0; i < itemsnum; i++) {
            System.out.println("Nhập thông tin cho danh sách mặt hàng thứ " + (i + 1));
            Items items1 = new Items();
            items1.inputInfor();
            saveItems(items1);
        }
    }

    private void saveItems(Items a) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = a;
                break;
            }
        }
    }
    public void showItems() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i]);
            }
        }
    }
    public ItemsType searchById(int id) {
        ItemsType ketQua = null;
        for (int k = 0; k < items.length; k++) {
            if (items[k] != null && items[k].getId() == id) {
                break;
            }
        }
        return ketQua;
    }
}
