package controllers;

import db.DBHelper;
import models.Book;
import models.Borrower;
import models.Library;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class BorrowerController {

    public BorrowerController() {
        setUpEndPoints();
    }
    public void setUpEndPoints()
    {

        LibraryController libraryController = new LibraryController();

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/borrowers", (req, res) -> {
            List<Borrower> borrowers = DBHelper.getAll(Borrower.class);
            HashMap<String, Object> model = new HashMap<>();
            model.put("borrowers", borrowers);
            model.put("template", "templates/borrowers/index.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);
    }
}
