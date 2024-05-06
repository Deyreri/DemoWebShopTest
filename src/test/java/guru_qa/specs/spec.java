package guru_qa.specs;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class spec {

    public static RequestSpecification requestSpec = with()
            .baseUri("https://demowebshop.tricentis.com/")
            .contentType("application/x-www-form-urlencoded")
            .log().all();

    public static ResponseSpecification loginSpecs = new ResponseSpecBuilder()
            .expectStatusCode(302)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification addCardSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("success",notNullValue())
            .expectBody("message",notNullValue())
            .build();
}


