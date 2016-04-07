package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;
import com.epam.pizza.dao.ProductDAO;
import com.epam.pizza.entity.Product;
import org.joda.money.Money;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class UpdateProductAction implements Action {
    private ActionResult result;

    public UpdateProductAction(String page) {
        result = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String titleRu = req.getParameter("title_ru_RU");
            String titleEn = req.getParameter("title_en_US");
            String descriptionRu = req.getParameter("description_ru_RU");
            String descriptionUs = req.getParameter("description_en_US");
            String type = req.getParameter("type");
            String price = req.getParameter("price");

            Product product = new Product();
            product.setId(id);
            product.setTitle(titleRu + " <<<>>> " + titleEn);
            product.setDescription(descriptionRu + " <<<>>> " + descriptionUs);
            product.setType(Product.Type.valueOf(type));
            product.setPrice(Money.parse("KZT " + price));

            Part img = req.getPart("img");
            InputStream is = img.getInputStream();
            ProductDAO productDAO  = new ProductDAO(is);
            productDAO.updateEntity(product);

            productDAO.close();

        } catch (IOException e) {
            throw new RuntimeException("Error closing connection: " + e);
        } catch (ServletException e) {
            throw new RuntimeException("Servlet error: " + e);
        }
        return result;
    }
}
