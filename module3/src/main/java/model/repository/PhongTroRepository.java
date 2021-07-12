package model.repository;

import model.bean.PhongTro;

import java.util.List;

public interface PhongTroRepository {
    //show list
    public List<PhongTro> selectAll();

    PhongTro selectByPhone(String phone);

    public PhongTro selectById(String id);

    public List<PhongTro> selectByName(String name);

    public List<PhongTro> search(String id);

    //validate
    boolean isPhoneExist(String phone);

    //add
    public boolean addPhongTro(PhongTro phongTro);

    //edit
    public boolean updatePhongTro(PhongTro phongTro);

    //delete
    public boolean deletePhongTro(String id);
}
