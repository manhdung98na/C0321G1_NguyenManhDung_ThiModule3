package model.service;

import model.bean.PhongTro;
import model.repository.PhongTroRepositoryImpl;
import model.service.common.ValidatePhongTro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhongTroServiceImpl implements PhongTroService {
    PhongTroRepositoryImpl repository = new PhongTroRepositoryImpl();

    @Override
    public List<PhongTro> selectAll() {
        List<PhongTro> list = repository.selectAll();
        for (PhongTro o : list) {
            System.out.println(o);
        }
        return list;
    }

    @Override
    public PhongTro selectById(String id) {
        return repository.selectById(id);
    }
//
//    @Override
//    public List<Customer> selectByName(String name) {
//        return repository.selectByName(name);
//    }

    @Override
    public String validateName(String name) {
        return ValidatePhongTro.validateName(name) != null ? ValidatePhongTro.validateName(name) : "";
    }

    @Override
    public String validateDate(String date) {
        return ValidatePhongTro.validateDate(date) != null ? ValidatePhongTro.validateDate(date) : "";
    }

    @Override
    public String validatePhone(String phone) {
        if (ValidatePhongTro.validatePhoneNumber(phone) != null) {
            return ValidatePhongTro.validatePhoneNumber(phone);
        } else {
            if (repository.isPhoneExist(phone)) {
                return "Phone number existed!";
            } else {
                return "";
            }
        }
    }

    @Override
    public String validateNote(String note) {
        System.out.println();
        return ValidatePhongTro.validateNote(note) != null ? ValidatePhongTro.validateDate(note) : "";
    }

    @Override
    public boolean addPhongTro(PhongTro phongTro) {
        return repository.addPhongTro(phongTro);
    }

    @Override
    public boolean updatePhongTro(PhongTro phongTro) {
        return repository.updatePhongTro(phongTro);
    }

//    @Override
//    public Map<String, String> updatePhongTro(PhongTro phongTro) {
//        Map<String, String> map = new HashMap<>();
//        if (validateName(phongTro.getTenNguoiThue()) != null) {
//            map.put("nameError", validateName(phongTro.getTenNguoiThue()));
//        }
//        if (validatePhone(phongTro.getSdt()) != null) {
//            map.put("phoneError", validatePhone(phongTro.getSdt()));
//        }
//        if (validateDate(phongTro.getNgayThue().toString()) != null) {
//            map.put("dateError", validateDate(phongTro.getNgayThue().toString()));
//        }
//        if (validateNote(phongTro.getGhiChu()) != null) {
//            map.put("noteError", validateNote(phongTro.getGhiChu()));
//        }
//        if (map.get("nameError") == null
//                && map.get("phoneError") == null
//                && map.get("dateError") == null
//                && map.get("noteError") == null) {
//            boolean isSuccess = repository.updatePhongTro(phongTro);
//            if (!isSuccess){
//                map.put("sqlError", "Lỗi cập nhật tại CSDL");
//            }else {
//                map.put("sqlError", null);
//            }
//        }
//        return map;
//    }

    //
    @Override
    public boolean deletePhongTro(String id) {
        return repository.deletePhongTro(id);
    }

    @Override
    public List<PhongTro> search(String str){
        List<PhongTro> list = new ArrayList<>();
        list.addAll(repository.search(str));
        return list;
    }

}
