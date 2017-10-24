package com.example.thjen.retrievedatafirebase;

public class PhuongTien {

    private String ten;
    private int banh;

    public PhuongTien() {
    }

    public PhuongTien(String ten, int banh) {
        this.ten = ten;
        this.banh = banh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getBanh() {
        return banh;
    }

    public void setBanh(int banh) {
        this.banh = banh;
    }
}
