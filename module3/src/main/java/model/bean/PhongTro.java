package model.bean;

import java.sql.Date;

public class PhongTro {
    private String maPhongTro;
    private String tenNguoiThue;
    private String sdt;
    private Date ngayThue;
    private int hinhThucThanhToan;
    private String tenHinhThucThanhToan;
    private String ghiChu;

    public PhongTro(String tenNguoiThue, String sdt, Date ngayThue, int hinhThucThanhToan, String ghiChu) {
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String maPhongTro, String tenNguoiThue, String sdt, Date ngayThue, int hinhThucThanhToan, String ghiChu) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String maPhongTro, String tenNguoiThue, String sdt, Date ngayThue, int hinhThucThanhToan, String tenHinhThucThanhToan, String ghiChu) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String maPhongTro, String tenNguoiThue, String sdt, Date ngayThue, int hinhThucThanhToan) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThue = tenNguoiThue;
        this.sdt = sdt;
        this.ngayThue = ngayThue;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(String maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getTenHinhThucThanhToan() {
        return tenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String tenHinhThucThanhToan) {
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
