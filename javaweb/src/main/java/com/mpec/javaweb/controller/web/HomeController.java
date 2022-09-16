package com.mpec.javaweb.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mpec.javaweb.service.ICategoryService;
import com.mpec.javaweb.service.INewService;

import javax.inject.Inject;

// import com.mpec.javaweb.model.UserModel;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        // UserModel userModel = new UserModel();
        // userModel.setFullName("Hello World");
        // req.setAttribute("model", userModel);
//        String code = "the-thao";
        Long categoryId = 1L;
        req.setAttribute("news", newService.findByCategoryId(categoryId));
        req.setAttribute("categories", categoryService.findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
}
