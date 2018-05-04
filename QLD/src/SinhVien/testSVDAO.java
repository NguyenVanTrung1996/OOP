/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;

import ConnectDatabase.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung
 */
public class testSVDAO implements ISinhVienDAO{
    @Override
    public ArrayList<SinhVien> getAll() {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblSinhVien");
                rs = ps.executeQuery();

                list = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString("masv"));
                    sv.setTensv(rs.getString("tensv"));
                    sv.setMalop(rs.getString("malop"));
                    System.out.println(rs.getString("masv") + "," +rs.getString("tensv") );
                    list.add(sv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ArrayList<SinhVien> findByIDLop(String maLop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SinhVien addNew(SinhVien sv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SinhVien updateByID(SinhVien sv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SinhVien> CheckID(String masv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        ArrayList<SinhVien> list = null;
        list = new testSVDAO().getAll();
    }
}
