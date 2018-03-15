package ru.ivmiit.servlets.Servlets;

import ru.ivmiit.servlets.Models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Me on 14.03.2018.
 */
public class ProductsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ArrayList<Product> products  = new ArrayList<Product>();
        Product stul = new Product("stul",5);
        products.add(stul);

        PrintWriter writer = resp.getWriter();
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>Product</th>");
        writer.write("<th>Weight</th>");
        writer.write("</tr>");
        for (Product product : products) {
            writer.write("<tr>");
            writer.write("<td>" + product.getName() + "</td>");
            writer.write("<td>" + product.getWeight() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

