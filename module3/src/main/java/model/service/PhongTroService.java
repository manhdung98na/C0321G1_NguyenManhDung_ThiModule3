package model.service;

import model.bean.PhongTro;

import java.util.List;
import java.util.Map;

public interface PhongTroService {
    //search
    public List<PhongTro> selectAll();

    public PhongTro selectById(String id);

//    public List<Customer> selectByName(String name);

    //validate

    public String validateName(String id);

    public String validateDate(String id);

    public String validatePhone(String id);
    public String validateNote(String note);

    //add
    public boolean addPhongTro(PhongTro phongTro);

    //update
//    public Map<String, String> updatePhongTro(PhongTro phongTro);
    public boolean updatePhongTro(PhongTro phongTro);

    //delete
    public boolean deletePhongTro(String id);

    public List<PhongTro> search(String str);
}
