package controllers;

import models.Book;

import static spark.SparkBase.staticFileLocation;

public class LibraryController {

public static void main(String[] args){
    staticFileLocation("/public");

    BorrowerController borrowerController = new BorrowerController();
    BookController bookController = new BookController();

}
}
