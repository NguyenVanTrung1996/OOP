/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import java.util.ArrayList;

/**
 *
 * @author trung
 */
public interface ISinhVienDAO {
    public ArrayList<SinhVien> getAll();
    public ArrayList<SinhVien> findByIDLop(String malop);
    public SinhVien addNew(SinhVien sv);
    public SinhVien updateByID(SinhVien sv);
    public ArrayList<SinhVien> CheckID(String masv);
}
