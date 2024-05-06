package guru_qa.Tests;

import guru_qa.Models.LoginLombokModels;

import org.junit.jupiter.api.Test;

import static guru_qa.specs.spec.*;
import static io.restassured.RestAssured.*;

public class DemoWebShopTest {

    @Test
    public void addNewToCard() {
        LoginLombokModels model = new LoginLombokModels();
        model.setEmail("a.terikbaev16@mail.ru");
        model.setPassword("asdASD777");

        String body = "product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";

               String response =  given()
                       .spec(requestSpec)
                       .body(model.toString())
                       .when()
                       .post("https://demowebshop.tricentis.com/login")
                       .then()
                       .spec(loginSpecs)
                       .extract()
                       .cookie("NOPCOMMERCE.AUTH");

        given()
                .cookie("NOPCOMMERCE.AUTH",response)
                .body(body)
                .spec(requestSpec)
                .when()
                .post("https://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .spec(addCardSpec);
    }
}


//
