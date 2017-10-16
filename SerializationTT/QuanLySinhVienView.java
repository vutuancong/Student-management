/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializationTT;

import java.util.Scanner;

/**
 *
 * @author vutuancong
 */
public class QuanLySinhVienView {
    public static void main(String[] args) {
        QuanLySinhVienControl qlsvc =  new QuanLySinhVienControl();
        Scanner in = new Scanner(System.in);
        do {
            int choice;
            System.out.println("Quan ly sinh vien:");
            System.out.println("1.Them sinh vien");
            System.out.println("2.Hien sinh vien");
            System.out.println("3.Sap xep theo tuoi");
            System.out.println("4.Xoa sinh vien");
            System.out.println("5.Thoat");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    qlsvc.themSinhVien();
                    break;
                case 2:
                    qlsvc.hienSinhVien();
                    break;
                case 3:
                    qlsvc.sapXepTheoTuoi();
                    break;
                case 4:
                    qlsvc.xoaSinhVien();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);

    }
}
