package logic;

import entity.Items;
import entity.SalesAgent;

import java.util.Scanner;

public class MenuManagement {

    private ItemsLogic itemsLogic;
    private SalesAgentLogic salesAgentLogic;

    public MenuManagement() {
        SalesAgent[] salesAgents = new SalesAgent[1000];
        salesAgentLogic = new SalesAgentLogic(salesAgents);

        Items[] items = new Items[1000];
        itemsLogic = new ItemsLogic(items);
    }

    public void menu() {
        while (true) {
            showmenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    itemsLogic.addNewItems();
                    break;
                case 2:
                    itemsLogic.showItems();
                    break;
                case 3:
                    salesAgentLogic.addNewSalesAgent();
                    break;
                case 4:
                    salesAgentLogic.showSalesAgent();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    return;
            }
        }
    }

    private int chooseFunction() {
        int choice = 0;
        System.out.print("Xin mời nhập lựa chọn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.print("Chức năng không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    private void showmenu() {
        System.out.println("==========Danh sách bán hàng của nhân viên==========");
        System.out.println("1. Thêm danh sách bán hàng mới");
        System.out.println("2. In ra danh sách bán hàng");
        System.out.println("3. Thêm danh sách nhân viên mới");
        System.out.println("4. In ra danh sách nhân viên");
        System.out.println("5. Lập bảng danh sách bán hàng cho từng nhân viên");
        System.out.println("6. Sắp xếp bảng danh sách bán hàng");
        System.out.println("7. Lập bảng kê doanh thu cho từng nhân viên");
        System.out.println("8. Thoát");

    }

}
