package com.hendisantika.customer;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-customer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/10/21
 * Time: 06.42
 */
@QuarkusTest
class CustomerResourceTest {
    @Test
    public void getAll() {
        given()
                .when().get("/api/customers")
                .then()
                .statusCode(200);
    }
}
