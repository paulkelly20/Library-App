package controllers;

import static spark.SparkBase.staticFileLocation;

public class LibraryController {

public static void main(String[] args){
    staticFileLocation("/public");

}
}
