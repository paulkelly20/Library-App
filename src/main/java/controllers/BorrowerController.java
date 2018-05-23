package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class BorrowerController {

    public static void main(String[] args) {
        staticFileLocation("/public");
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/books", (req, res) -> {
            List<Book> books = DBHelper.getAll(Book.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", );
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);
    }
}
