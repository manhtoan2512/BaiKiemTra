package logic;

import entity.SalesAgent;

import java.util.Scanner;

public class SalesAgentLogic {

    private SalesAgent[] salesAgents;

    private int totalSalesAgent;

    public SalesAgent[] getSalesAgents() {
        return salesAgents;
    }

    public int getTotalSalesAgent() {
        return totalSalesAgent;
    }

    public SalesAgentLogic(SalesAgent[] salesAgents) {
        this.salesAgents = salesAgents;
    }

    public void addNewSalesAgent() {
        System.out.print("Nhập số lượng nhân viên muốn thêm mới: ");
        int num = new Scanner(System.in).nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1));
            SalesAgent salesAgent = new SalesAgent();
            salesAgent.inputInfor();
            saveSalesAgent(salesAgent);
        }
    }

    private void saveSalesAgent(SalesAgent b) {
        for (int i = 0; i < salesAgents.length; i++) {
            if (salesAgents[i] == null) {
                salesAgents[i] = b;
                break;
            }
        }
    }
    public void showSalesAgent() {
        for (int i = 0; i < salesAgents.length; i++) {
            if (salesAgents[i] != null) {
                System.out.println(salesAgents[i]);
            }
        }
    }
    public SalesAgent searchById(int id) {
        SalesAgent ketQua = null;
        for (int j = 0; j < salesAgents.length; j++) {
            if (salesAgents[j] != null && salesAgents[j].getId() == id) {
                ketQua = salesAgents[j];
                break;
            }
        }
        return ketQua;
    }
}
