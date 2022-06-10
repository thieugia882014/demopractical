package aptech.demopractical.controller;



import aptech.demopractical.entity.Product;
import aptech.demopractical.retrolfit.RetrofitServiceGenerator;
import aptech.demopractical.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

@WebServlet(name = "productServlet", value = "/products/create")
public class ProductServlet extends HttpServlet {
    ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        BigDecimal price = new BigDecimal(0);
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        try {
            price = new BigDecimal( req.getParameter("price"));
        } catch (Exception e) {
            System.err.println(e);
        }
        Product food = new Product();
        food.setName(name);

        food.setSalary(price);
        HashMap<String, String> errors;


        if (productService.save(food).execute().isSuccessful()) {
            req.setAttribute("success", "Create success");
        }else {
            req.setAttribute("createFail", "Create fail");
        }

        req.getRequestDispatcher("/create.jsp").forward(req, resp);    }
}
