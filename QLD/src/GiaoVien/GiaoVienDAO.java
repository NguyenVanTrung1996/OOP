/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoVien;

import ConnectDatabase.DBConnect;
import MonHoc.MonHoc;
import MonHoc.MonHocDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anonymous
 */
public class GiaoVienDAO implements IGiaoVienDAO {

    @Override
    public ArrayList<GiaoVien> getAll() {
        // throw new UnsupportedOperationException("Not supported yet.");
        ArrayList<GiaoVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblGiangVien");
                rs = ps.executeQuery();
                list = new ArrayList<GiaoVien>();
                while (rs.next()) {
                    GiaoVien gv = new GiaoVien();
                    gv.setMagv(rs.getString("magv"));
                    gv.setHotengv(rs.getString("hotengv"));
                    gv.setMamh(rs.getString("mamh"));
                    gv.setNgaysinh(new Date(rs.getDate("ngaysinh").getTime()));
                    gv.setGioitinh(rs.getBoolean("gioitinh"));
                    gv.setEmail(rs.getString("email"));
                    gv.setDiachi(rs.getString("diachi"));
                    gv.setSdt(rs.getString("sdt"));

                    list.add(gv);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<GiaoVien> findByIDMonHoc(String mamh) {
        ArrayList<GiaoVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select  * from tblGiangVien where mamh = ?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<GiaoVien>();
                while (rs.next()) {
                    GiaoVien gv = new GiaoVien();
                    gv.setMagv(rs.getString("magv"));
                    gv.setHotengv(rs.getString("hotengv"));
                    gv.setMamh(rs.getString("mamh"));
                    gv.setNgaysinh(new Date(rs.getDate("ngaysinh").getTime()));
                    gv.setGioitinh(rs.getBoolean("gioitinh"));
                    gv.setEmail(rs.getString("email"));
                    gv.setDiachi(rs.getString("diachi"));
                    gv.setSdt(rs.getString("sdt"));
                    list.add(gv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public GiaoVien addNew(GiaoVien gv) {
        PreparedStatement ps = null;

        if (DBConnect.open()) {
            try {
                //   ps = DBConnect.cnn.prepareStatement("insert into tblGiangVien.fldMaGV, tblGiangVien.fldHoTenGV,tblGVMH.fldMaMH, tblGiangVien.fldNgaySinh, tblGiangVien.fldGioiTinh, tblGiangVien.fldEmail, tblGiangVien.fldDiaChi, tblGiangVien.fldSDT from tblGiangVien inner join tblGVMH on tblGiangVien.fldMaGV=tblGVMH.fldMaGV values (?,?,?,?,?,?,?,?)");
                ps = DBConnect.cnn.prepareStatement("INSERT INTO tblGiangVien values (?,?,?,?,?,?,?,?)");
                ps.setString(1, gv.getMagv());
                ps.setString(2, gv.getHotengv());
                ps.setString(3, gv.getMamh());
                ps.setDate(4, new java.sql.Date(gv.getNgaysinh().getTime()));
                ps.setBoolean(5, gv.isGioitinh());
                ps.setString(6, gv.getEmail());
                ps.setString(7, gv.getDiachi());
                ps.setString(8, gv.getSdt());

                int row = ps.executeUpdate();
                if (row < 1) {
                    gv = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return gv;
    }

    @Override
    public GiaoVien updateByID(GiaoVien gv) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update tblGiangVien set hotengv =?,"
                        + "mamh= ?,ngaysinh=?,"
                        + "gioitinh=?, email = ?, diachi = ?, "
                        + "sdt = ? where magv = ?");

                ps.setString(1, gv.getHotengv());
                ps.setString(2, gv.getMamh());
                //ps.setDate(3, new java.sql.Date(new Date().getTime()));
                ps.setDate(3, new java.sql.Date(gv.getNgaysinh().getTime()));

                ps.setBoolean(4, gv.isGioitinh());
                ps.setString(5, gv.getEmail());
                ps.setString(6, gv.getDiachi());
                ps.setString(7, gv.getSdt());
                ps.setString(8, gv.getMagv());

                int row = ps.executeUpdate();
                if (row < 1) {
                    gv = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            } finally {
                DBConnect.close();
            }
        }
        return gv;
    }

    public void deleteIDGV(String GiaoVienID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblGiangVien where magv= ?");
            ps.setString(1, GiaoVienID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<GiaoVien> CheckID(String magv) {
        ArrayList<GiaoVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblGiangVien where magv=?");
                psCheck.setString(1, magv);
                rs = psCheck.executeQuery();
                list = new ArrayList<GiaoVien>();
                while (rs.next()) {
                    GiaoVien giaoVien = new GiaoVien();
                    giaoVien.setMagv(rs.getString(1));
                    list.add(giaoVien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return list;
    }

//    public static void main(String[] args) {
//        System.out.println(new GiaoVienDAO().findByIDMonHoc("cntt1").get(0).getMamh());
//        
//        ArrayList<GiaoVien> list = null;
//        list = new GiaoVienDAO().getAll();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getMagv());
//        }
////        SinhVienDAO sv = new SinhVienDAO();
////        sv.deleteIDSinhVien("20144739");
//    }
}
