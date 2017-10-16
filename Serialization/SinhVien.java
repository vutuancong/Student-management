/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author vutuancong
 */
public class SinhVien implements Serializable{
    private int ma;
    private String ten;
    private int tuoi;

    public SinhVien(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public SinhVien() {
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi(){
       return this.tuoi;
   }

    public void nhapThongTin() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma: ");
        this.ma = in.nextInt();
        in.nextLine();
        System.out.println("Nhap ten: ");
        this.ten = in.nextLine();
        System.out.println("Nhap tuoi: ");
        this.tuoi = in.nextInt();
    }

    @Override
    public String toString() {
        return ma+" "+ ten+" "+tuoi;
    }
    
}
