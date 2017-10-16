/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializationTT;

import Serialization.SinhVien;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vutuancong
 */
public class QuanLySinhVienControl{

    SinhVienDAO svdao;

    public QuanLySinhVienControl(SinhVienDAO svdao) {
        this.svdao = svdao;
    }

    public QuanLySinhVienControl() {
        svdao = new SinhVienDAO();
    }

    public void themSinhVien() {
        SinhVien sv = new SinhVien();
        System.out.println("Moi ban nhap sinh vien");
        sv.nhapThongTin();
        boolean addSinhVien = svdao.addSinhVien(sv);
        if (addSinhVien) {
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Khong them duoc sinh vien");
        }
    }

    public void hienSinhVien() {
        ArrayList<SinhVien> allSinhVien = svdao.getAllSinhVien();
        for (SinhVien sv : allSinhVien) {
            System.out.println(sv);
        }
    }

    public void sapXepTheoTuoi() {
        ArrayList<SinhVien> sort = svdao.sortByAge();
        hienSinhVien(sort);
    }

    public void hienSinhVien(ArrayList<SinhVien> sort) {
        for (SinhVien sv : sort) {
            System.out.println(sv);
        }
    }
    public void xoaSinhVien(){
        System.out.println("Moi nhap ma sinh vien can xoa");
        int maXoa = new Scanner(System.in).nextInt();
        boolean removeByMaSV = svdao.removeByMaSV(maXoa);
        if(removeByMaSV){
            System.out.println("Xoa thanh cong");
        }else{
            System.out.println("Xoa that bai");
        }
    }

}
