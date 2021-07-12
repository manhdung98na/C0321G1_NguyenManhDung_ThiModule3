package controller;

import model.bean.PhongTro;
import model.service.PhongTroServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "PhongTroServlet", urlPatterns = "/phongtro")
public class PhongTroServlet extends HttpServlet {
    private PhongTroServiceImpl services;

    @Override
    public void init() throws ServletException {
        services = new PhongTroServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addPhongTro(request, response);
                break;
            case "delete":
                deletePhongTro(request,response);
                break;
            case "edit":
                editPhongTro(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void addPhongTro(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("phongtro-name");
        String phone = request.getParameter("phongtro-phone");
        Date date = Date.valueOf(request.getParameter("phongtro-rent-date"));
        int typePurchase = Integer.parseInt(request.getParameter("phongtro-purchase"));
        String note = request.getParameter("phongtro-ghi-chu");
        PhongTro newPhongTro = new PhongTro(name, phone, date, typePurchase, note);
        boolean isSuccess = services.addPhongTro(newPhongTro);
        if (isSuccess) {
            request.setAttribute("status", "<b>" + name + "</b> đã được tạo mới thành công");
            request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            showList(request, response);
        } else {
            request.setAttribute("status", "Tạo mới thất bại");
            request.setAttribute("colorHeader", "#d50005");
            request.setAttribute("customer", newPhongTro);
            RequestDispatcher rd = request.getRequestDispatcher("view/phongtro/add.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void editPhongTro(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("phongtro-name");
        String phone = request.getParameter("phongtro-phone");
        Date date = Date.valueOf(request.getParameter("phongtro-rent-date"));
        int typePurchase = Integer.parseInt(request.getParameter("phongtro-purchase"));
        String note = request.getParameter("phongtro-ghi-chu");
        PhongTro eidtPhongTro = new PhongTro(id, name, phone, date, typePurchase, note);
        boolean isSuccess = services.updatePhongTro(eidtPhongTro);
        if (isSuccess) {
            request.setAttribute("status", "<b>" + name + "</b> đã được cập nhật thành công");
            request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
            showList(request, response);
        } else {
            request.setAttribute("status", "Cập nhật thất bại");
            request.setAttribute("colorHeader", "d50005");
            request.setAttribute("customer", eidtPhongTro);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/phongtro/edit.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        if (services.deletePhongTro(id)) {
            request.setAttribute("status", "Xoá khách hàng <b>" + id + "</b> thành công");
            request.setAttribute("colorHeader", "rgba(52,213,108,0.81)");
        } else {
            request.setAttribute("status", "Xoá khách hàng thất bại");
            request.setAttribute("colorHeader", "#d50005");
        }
        showList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "check_name":
                checkName(request, response);
                break;
            case "check_date":
                checkDate(request, response);
                break;
            case "check_phone":
                checkPhone(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void checkName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name_check");
        response.setContentType("text/plain");
        try {
            response.getWriter().write(services.validateName(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkDate(HttpServletRequest request, HttpServletResponse response) {
        Date rentDate = Date.valueOf((request.getParameter("date_check")));
        System.out.println(rentDate);
        response.setContentType("text/plain");
        try {
            response.getWriter().write(services.validateDate(rentDate.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkPhone(HttpServletRequest request, HttpServletResponse response) {
        String phone = request.getParameter("phone_check");
        response.setContentType("text/plain");
        try {
            response.getWriter().write(services.validatePhone(phone));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> list = services.selectAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/phongtro/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("view/phongtro/add.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        PhongTro customerEdit = services.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/phongtro/edit.jsp");
        request.setAttribute("phongtro", customerEdit);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("search_string");
        System.out.println(str);
        List<PhongTro> list = services.search(str);
        RequestDispatcher rd = request.getRequestDispatcher("view/phongtro/list.jsp");
        request.setAttribute("list", list);
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
