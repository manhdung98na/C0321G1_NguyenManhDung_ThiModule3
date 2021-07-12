package model.repository;

import model.bean.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepositoryImpl implements PhongTroRepository {
    private static final String SELECT_ALL =
            "select " +
                    "ma_phong_tro, ten_nguoi_thue, sdt, ngay_thue, pt.hinh_thuc_thanh_toan, httt.name_hinh_thuc, ghi_chu " +
                    "from phong_tro pt " +
                    "join hinh_thuc_thanh_toan httt on pt.hinh_thuc_thanh_toan = httt.id_hinh_thuc";
    private static final String SELECT_BY_PHONE =
            "select " +
                    "ma_phong_tro, ten_nguoi_thue, sdt, ngay_thue, pt.hinh_thuc_thanh_toan, httt.name_hinh_thuc, ghi_chu " +
                    "from phong_tro pt " +
                    "join hinh_thuc_thanh_toan httt on pt.hinh_thuc_thanh_toan = httt.id_hinh_thuc " +
                    "where sdt = ?";
    private static final String INSERT =
            "INSERT INTO phong_tro VALUES (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_BY_ID =
            "select " +
                    "ma_phong_tro, ten_nguoi_thue, sdt, ngay_thue, pt.hinh_thuc_thanh_toan, httt.name_hinh_thuc, ghi_chu " +
                    "from phong_tro pt " +
                    "join hinh_thuc_thanh_toan httt on pt.hinh_thuc_thanh_toan = httt.id_hinh_thuc " +
                    "where ma_phong_tro = ?";

    private static final String UPDATE =
            "update phong_tro set " +
            "ten_nguoi_thue = ?, sdt = ?, ngay_thue = ?, hinh_thuc_thanh_toan = ?, " +
                    "ghi_chu = ? where ma_phong_tro = ?;";
    private static final String DELETE =
            "delete from phong_tro where ma_phong_tro = ?;";

        private static final String SELECT_BY_NAME =
                "select " +
                        "ma_phong_tro, ten_nguoi_thue, sdt, ngay_thue, pt.hinh_thuc_thanh_toan, httt.name_hinh_thuc, ghi_chu " +
                        "from phong_tro pt " +
                        "join hinh_thuc_thanh_toan httt on pt.hinh_thuc_thanh_toan = httt.id_hinh_thuc" +
                        " where ten_nguoi_thue like ?";
    private static final String SELECT =
            "select " +
                    "ma_phong_tro, ten_nguoi_thue, sdt, ngay_thue, pt.hinh_thuc_thanh_toan, httt.name_hinh_thuc, ghi_chu " +
                    "from phong_tro pt " +
                    "join hinh_thuc_thanh_toan httt on pt.hinh_thuc_thanh_toan = httt.id_hinh_thuc" +
                    " where ten_nguoi_thue like ? OR ma_phong_tro like ? OR sdt like ?";


    @Override
    public List<PhongTro> selectAll() {
        System.out.println("re");
        List<PhongTro> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String maPhongTro = resultSet.getString("ma_phong_tro");
                    String tenNguoiThue = resultSet.getString("ten_nguoi_thue");
                    String sdt = resultSet.getString("sdt");
                    Date ngayThue = resultSet.getDate("ngay_thue");
                    int hinhThucThanhToan = resultSet.getInt("hinh_thuc_thanh_toan");
                    String tenHinhThucThanhToan = resultSet.getString("name_hinh_thuc");
                    String ghiChu = resultSet.getString("ghi_chu");
                    result.add(new PhongTro(maPhongTro, tenNguoiThue, sdt, ngayThue, hinhThucThanhToan, tenHinhThucThanhToan, ghiChu));
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return result;
    }

    @Override
    public PhongTro selectByPhone(String phone) {
        PhongTro phongTro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_PHONE);
                statement.setString(1, phone);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String maPhongTro = resultSet.getString("ma_phong_tro");
                    String tenNguoiThue = resultSet.getString("ten_nguoi_thue");
                    String sdt = resultSet.getString("sdt");
                    Date ngayThue = resultSet.getDate("ngay_thue");
                    int hinhThucThanhToan = resultSet.getInt("hinh_thuc_thanh_toan");
                    String tenHinhThucThanhToan = resultSet.getString("name_hinh_thuc");
                    String ghiChu = resultSet.getString("ghi_chu");
                    phongTro = new PhongTro(maPhongTro, tenNguoiThue, sdt, ngayThue, hinhThucThanhToan, tenHinhThucThanhToan, ghiChu);
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return phongTro;
    }

    //search
    @Override
    public PhongTro selectById(String id) {
        PhongTro phongTro = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String maPhongTro = resultSet.getString("ma_phong_tro");
                    String tenNguoiThue = resultSet.getString("ten_nguoi_thue");
                    String sdt = resultSet.getString("sdt");
                    Date ngayThue = resultSet.getDate("ngay_thue");
                    int hinhThucThanhToan = resultSet.getInt("hinh_thuc_thanh_toan");
                    String tenHinhThucThanhToan = resultSet.getString("name_hinh_thuc");
                    String ghiChu = resultSet.getString("ghi_chu");
                    phongTro = new PhongTro(maPhongTro, tenNguoiThue, sdt, ngayThue, hinhThucThanhToan, tenHinhThucThanhToan, ghiChu);
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return phongTro;
    }


        @Override
    public List<PhongTro> selectByName(String name) {
        List<PhongTro> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_NAME);
                String countryCondition = "%" + name + "%";
                statement.setString(1, countryCondition);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String maPhongTro = resultSet.getString("ma_phong_tro");
                    String tenNguoiThue = resultSet.getString("ten_nguoi_thue");
                    String sdt = resultSet.getString("sdt");
                    Date ngayThue = resultSet.getDate("ngay_thue");
                    int hinhThucThanhToan = resultSet.getInt("hinh_thuc_thanh_toan");
                    String tenHinhThucThanhToan = resultSet.getString("name_hinh_thuc");
                    String ghiChu = resultSet.getString("ghi_chu");
                    list.add(new PhongTro(maPhongTro, tenNguoiThue, sdt, ngayThue, hinhThucThanhToan, tenHinhThucThanhToan, ghiChu));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return list;
    }

    @Override
    public List<PhongTro> search(String string) {
        List<PhongTro> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT);
                String countryCondition = "%" + string + "%";
                statement.setString(1, countryCondition);
                statement.setString(2, countryCondition);
                statement.setString(3, countryCondition);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String maPhongTro = resultSet.getString("ma_phong_tro");
                    String tenNguoiThue = resultSet.getString("ten_nguoi_thue");
                    String sdt = resultSet.getString("sdt");
                    Date ngayThue = resultSet.getDate("ngay_thue");
                    int hinhThucThanhToan = resultSet.getInt("hinh_thuc_thanh_toan");
                    String tenHinhThucThanhToan = resultSet.getString("name_hinh_thuc");
                    String ghiChu = resultSet.getString("ghi_chu");
                    list.add(new PhongTro(maPhongTro, tenNguoiThue, sdt, ngayThue, hinhThucThanhToan, tenHinhThucThanhToan, ghiChu));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return list;
    }

    //    //validate
    @Override
    public boolean isPhoneExist(String phone) {
        return selectByPhone(phone) != null;
    }

    //add new
    @Override
    public boolean addPhongTro(PhongTro phongTro) {
        String id;
        List<PhongTro> list = selectAll();
        if (list.size() == 0) {
            id = "PT-1";
        } else {
            String stringID = list.get(list.size() - 1).getMaPhongTro();
            int numberId = Integer.parseInt(stringID.substring(3, stringID.length()));
            id = "PT-" + (numberId + 1);
        }
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT);
                statement.setString(1, id);
                statement.setString(2, phongTro.getTenNguoiThue());
                statement.setString(3, phongTro.getSdt());
                statement.setDate(4, phongTro.getNgayThue());
                statement.setInt(5, phongTro.getHinhThucThanhToan());
                statement.setString(6, phongTro.getGhiChu());
                statement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
                return false;
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
            return true;
        }
        return false;
    }
//
    //edit
    @Override
    public boolean updatePhongTro(PhongTro phongTro) {
        boolean rowUpdated;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE);
                statement.setString(1, phongTro.getTenNguoiThue());
                statement.setString(2, phongTro.getSdt());
                statement.setDate(3, phongTro.getNgayThue());
                statement.setInt(4, phongTro.getHinhThucThanhToan());
                statement.setString(5, phongTro.getGhiChu());
                statement.setString(6, phongTro.getMaPhongTro());
                rowUpdated = statement.executeUpdate() > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return rowUpdated;
        }
        return false;
    }

    //delete
    @Override
    public boolean deletePhongTro(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setString(1, id);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
            return true;
        }
        return false;
    }


    //print error
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
