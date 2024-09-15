package src;

import spark.Route;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.get("/", (request, response) -> "comando spaaarlk");
    }
}