package com.mpec.javaweb.controller.admin;

import com.mpec.javaweb.constant.SystemConstant;
import com.mpec.javaweb.model.NewsModel;
import com.mpec.javaweb.service.INewService;
import com.mpec.javaweb.service.impl.NewService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

    @Inject
    private INewService newService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        NewsModel model = new NewsModel();
        model.setListResult(newService.findAll());

        req.setAttribute(SystemConstant.MODEL, model);
        // New controller trả về danh sách qua list.jsp
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
//        Controller luôn trả về biến là model
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
