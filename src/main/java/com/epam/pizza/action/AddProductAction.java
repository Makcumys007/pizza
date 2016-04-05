package com.epam.pizza.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AddProductAction implements Action {

    private String page;
    private final String PATH = "/makc/";
    public AddProductAction(String page) {
        this.page = page;
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Part img = req.getPart("img");
            String fileName = getFileName(img);
            FileOutputStream fos = new FileOutputStream("webapp" + PATH + fileName);
            InputStream inputStream = img.getInputStream();
            while (inputStream.available() > 0) {
                int read = inputStream.read();
               fos.write(read);
            }

            inputStream.close();
            fos.close();
        } catch (IOException e) {
// TODO обработчик исключения повешай!!!
        } catch (ServletException e) {
// TODO обработчик исключения повешай!!!
        }

        String titleRu = req.getParameter("title_ru_RU");


        String titleEn = req.getParameter("title_en_US");
        String descriptionRu = req.getParameter("description_ru_RU");
        String descriptionUs = req.getParameter("description_en_US");
        String type = req.getParameter("type");





        return new ActionResult(page);
    }

    private String getFileName(Part img) {
        String header = img.getHeader("content-disposition");
        for (String content : header.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=')+1).trim().replace("\"", "");
            }
        }
        return null;
    }
}



















