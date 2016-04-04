package com.epam.pizza.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProductAction implements Action {

    private String page;
    public AddProductAction(String page) {
        this.page = page;
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String titleRu = req.getParameter("title_ru_RU");
        String titleEn = req.getParameter("title_en_US");
        String descriptionRu = req.getParameter("description_ru_RU");
        String descriptionUs = req.getParameter("description_en_US");
        String type = req.getParameter("type");


        System.out.println(titleEn);




        return new ActionResult(page);
    }
}
