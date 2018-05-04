/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import java.util.Date;

/**
 *
 * @author trung
 */
public class SinhVien {
    private String masv;
    private String tensv;
    private String malop;
    private String diachi;
    private String hedaotao;
    private Date ngaysinh;
    private boolean gioitinh;
    private String sodt;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHedaotao() {
        return hedaotao;
    }

    public void setHedaotao(String hedaotao) {
        this.hedaotao = hedaotao;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public SinhVien(String masv, String tensv, String malop, String diachi, String hedaotao, Date ngaysinh, boolean gioitinh, String sodt) {
        this.masv = masv;
        this.tensv = tensv;
        this.malop = malop;
        this.diachi = diachi;
        this.hedaotao = hedaotao;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sodt = sodt;
    }

    public SinhVien() {
    }
    
    public static void main(String[] args) {
//        SinhVien v1;
//        v1 = new SinhVien("20144739","Trung","VN-B","Bac Giang","Chinh Quy",ngay,,"1","0984010950");
//        System.out.println("Trung");
    }
}
