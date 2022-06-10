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
import java.util.List;

@WebServlet(name = "listProduct", value = "/products")
public class ListProduct extends HttpServlet {

    ProductService productService;

    public ListProduct() {
        productService = RetrofitServiceGenerator.createService(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts().execute().body();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);

    }
}
