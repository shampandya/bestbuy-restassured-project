package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {

    static ValidatableResponse response;

    @Test
    public static void productsExtraction() {
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

        // Print Starting Test Statement
        System.out.println("------------------StartingTest---------------------------");
        // 21. Extract the limit
        int limit = response.extract().path("limit");
        System.out.println("The value of limit is : " + limit);

        // 22. Extract the total
        int total = response.extract().path("total");
        System.out.println("The value of total is : " + total);

        // 23. Extract the name of 5th product
        String nameOf5thProduct = response.extract().path("data[4].name");
        System.out.println("The value of all storename is : " + nameOf5thProduct);

        // 24. Extract the names of all the products
        List<String> allProducts = response.extract().path("data.name");
        System.out.println("The value of all store name are : " + allProducts);

        // 25. Extract the productId of all the products
        List<Integer> allProductsId = response.extract().path("data.id");
        System.out.println("The value of all store name are : " + allProductsId);

        // 26. Print the size of the data list
        List<Integer> dataList = response.extract().path("data.findAll{it}.list");
        System.out.println("Print the size of all data list =" + dataList.size());

        // 27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("The values for product name 'Energizer - MAX Batteries AA (4-Pack)' are: " + values);

        // 28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
        List<String> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        System.out.println("Get the model of the product =" + model);

        // 29. Get all the categories of 8th products
        List<String> categories = response.extract().path("data[7].categories");
        System.out.println("Get all the services of 8 store " + categories);

        // 30. Get categories of the store where product id = 150115
        List<String> productId = response.extract().path("data[3].categories");
        System.out.println("Get categories of the store where product id = 150115 " + productId);

        // 31. Get all the descriptions of all the products
        List<String> description = response.extract().path("data.description");
        System.out.println("Get the all description of the product =" + description);

        // 32. Get id of all the all categories of all the products
        List<String> productIds = response.extract().path("data.id");
        System.out.println("Get all the productId of all the store " + productIds);

        // 33. Find the product names Where type = HardGood
        List<String> productName = response.extract().path("data.findAll{it.type== 'HardGood'}.name");
        System.out.println("Find the product names Where type = HardGood " + productName);

        // 34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
        List<Integer> allCategories = response.extract().path("data.findAll{it.categories.name== 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}");
        System.out.println("Find the categories for the productname Duracell - AA 1.5V CopperTop Batteries (4-Pack) : " + categories.size());

        // 35. Find the createdAt for all products whose price < 5.49
        List<Integer> createdAtProduct = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("Find the createdAt for all products " + createdAtProduct);

        // 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
        List<HashMap<String, ?>> nameOfAllCategories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack) " + nameOfAllCategories);

        // 37. Find the manufacturer of all the products
        List<String>manufacturer = response.extract().path("data.manufacturer");
        System.out.println("The manufacturer of all the products : " + manufacturer);

        // 38. Find the image of products whose manufacturer is = Energizer
        List<String> imagesOfProduct = response.extract().path("data.findAll{it.manufacturer== 'Energizer'}.image");
        System.out.println("Find the image of products whose manufacturer is = Energizer : " + imagesOfProduct);

        // 39. Find the createdAt for all categories products whose price > 5.99
        List<Integer> createdAtProducts = response.extract().path("data.findAll{it.categories.'price > 5.99'}.createdAt");
        System.out.println("Find the createdAt for all products " + createdAtProducts);

        // 40. Find the url of all the products
        List<String> url = response.extract().path("data.url");
        System.out.println("Find the url of all the products " + url);

        // Print End Of Test Statement
        System.out.println("------------------End of Test---------------------------");
    }

}
