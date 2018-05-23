package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class BookController {

    public BookController() {
        setupEndPoints();
    }

    public void setupEndPoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/books", (req, res) ->

                {
                    List<Book> books = DBHelper.getAll(Book.class);
                    HashMap<String, Object> model = new HashMap<>();
                    model.put("books", books);
                    model.put("template", "/templates/booksindex.vtl");
                    return new ModelAndView(model, "templates/layout.vtl");
                }, velocityTemplateEngine);
    }

}


