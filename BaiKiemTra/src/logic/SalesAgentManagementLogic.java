package logic;

import constant.ItemsType;
import entity.SalesAgent;
import entity.SalesAgentManagement;
import entity.SalesAgentManagementDetail;

import javax.sound.midi.MidiFileFormat;
import java.util.Scanner;

public class SalesAgentManagementLogic {

    private SalesAgentManagement[] salesAgentManagements;

    private ItemsLogic itemsLogic;
    private SalesAgentLogic salesAgentLogic;

    public SalesAgentManagementLogic(SalesAgentManagement[] salesAgentManagements,
                                     ItemsLogic itemsLogic,
                                     SalesAgentLogic salesAgentLogic) {
        this.salesAgentManagements = salesAgentManagements;
        this.itemsLogic = itemsLogic;
        this.salesAgentLogic = salesAgentLogic;
    }

    public void phanCongMatHang() {
        System.out.print("Bạn muốn lập bảng danh sách bán hàng cho bao nhiêu nhân viên");
        int soLuongNhanVien;
        do {
            soLuongNhanVien = new Scanner(System.in).nextInt();
            if (soLuongNhanVien > 0 && soLuongNhanVien <= salesAgentLogic.getTotalSalesAgent()) {
                break;
            }
            System.out.println("Số lượng nhân viên phân công cần phải là số dương và nhỏ hơn số lượng nhân viên có trong công ty");
        } while (true);
        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.print("Nhân viên thứ " + (i + 1) + " muốn lập bảng danh sách là nhân viên nào, nhập ID nhân viên: ");
            SalesAgent nhanVien = nhapNhanVien();
            System.out.print("Bạn muốn lập bảng danh sách cho bao nhiêu loại mặt hàng: ");
            int soLuongMatHang;
            do {
                soLuongMatHang = new Scanner(System.in).nextInt();
                if (soLuongMatHang >= 1 && soLuongMatHang <= 5 && soLuongMatHang <= itemsLogic.getTotalItems()) {
                    break;
                }
                System.out.print("Số loại mặt hàng phải là số dương và nhỏ hơn số lượng công ty đang có, đồng thời phải nhỏ hơn hoặc bằng 5, vui lòng nhập lại ");
            } while (true);

            SalesAgentManagementDetail[] danhSachLoaiMatHang = nhapDanhSachLoaiMatHang(soLuongMatHang);

            SalesAgentManagement phanCong = new SalesAgentManagement(nhanVien, danhSachLoaiMatHang);
            saveSalesAgentManagement(phanCong);
        }
        showSalesAgentManagement();
    }
    public void tinhThuNhap() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        for (int i = 0; i < salesAgentManagements.length; i++) {
            double tongThuNhap = 0;
            SalesAgentManagement baoCaoMatHang = salesAgentManagements[i];
            SalesAgentManagementDetail[] danhSachMatHang = baoCaoMatHang.getSalesAgentManagementDetails();
            for (int j = 0; j < danhSachMatHang.length; j++) {
            }
            System.out.println("Tổng thu nhập của ông " + salesAgentManagements[i].getSalesAgent().getName() + " là " + tongThuNhap);
        }
    }

    private void showSalesAgentManagement() {
        for (int i = 0; i < salesAgentManagements.length; i++) {
            if (salesAgentManagements[i] != null) {
                System.out.println(salesAgentManagements[i]);
            }
        }
    }

    private void saveSalesAgentManagement(SalesAgentManagement phanCong) {
        for (int i = 0; i < salesAgentManagements.length; i++) {
            if (salesAgentManagements[i] == null) {
                salesAgentManagements[i] = phanCong;
                break;
            }
        }
    }

    private SalesAgentManagementDetail[] nhapDanhSachLoaiMatHang(int soLoaiMatHang) {
        SalesAgentManagementDetail[] danhsachLoaiMatHang = new SalesAgentManagementDetail[soLoaiMatHang];
        for (int i = 0; i < soLoaiMatHang; i++) {
            System.out.print("Nhập thông tin cho loại mặt hàng thứ " + (i + 1) + ", nhập ID loại mặt hàng: ");

            int idLoatMatHang;
            ItemsType loaiMatHang;
            do {
                idLoatMatHang = new Scanner(System.in).nextInt();
                loaiMatHang = itemsLogic.searchById(idLoatMatHang);
                if (loaiMatHang != null) {
                    break;
                }
                System.out.println("Không tìm thấy loại mặt hàng nào có mã " + idLoatMatHang + ", vui lòng nhập lại: ");
            } while (true);
        }
        return danhsachLoaiMatHang;
    }

    private SalesAgent nhapNhanVien() {
        int idNhanvien;
        SalesAgent nhanVien;
        do {
            idNhanvien = new Scanner(System.in).nextInt();
            nhanVien = salesAgentLogic.searchById(idNhanvien);
            if (nhanVien != null) {
                break;
            }
            System.out.println("Không tìm thấy nhân viên có mã " + idNhanvien + ", vui lòng nhập lại: ");
        } while (true);
        return nhanVien;
    }

    public void sortBySalesAgentName() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        for (int i = 0; i < salesAgentManagements.length - 1; i++) {
            if (salesAgentManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < salesAgentManagements.length; j++) {
                if (salesAgentManagements[j] == null) {
                    continue;
                }
                if (salesAgentManagements[i].getSalesAgent().getName().trim().compareToIgnoreCase(salesAgentManagements[j].getSalesAgent().getName().trim()) > 0) {
                    SalesAgentManagement temp = salesAgentManagements[i];
                    salesAgentManagements[i] = salesAgentManagements[j];
                    salesAgentManagements[j] = temp;
                }
            }
        }
        showSalesAgentManagement();
    }
    private boolean coDuLieuHayChua() {
        boolean coDuLieuNhanVien = false;
        for (int i = 0; i < salesAgentLogic.getSalesAgents().length; i++) {
            if (salesAgentLogic.getSalesAgents()[i] != null) {
                coDuLieuNhanVien = true;
                break;
            }
        }
        boolean coDuLieuMatHang = false;
        for (int i = 0; i < itemsLogic.getItems().length; i++) {
            if (itemsLogic.getItems()[i] != null) {
                coDuLieuMatHang = true;
                break;
            }
        }
        return coDuLieuNhanVien && coDuLieuMatHang;
    }
}
