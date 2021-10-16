package com.hendisantika;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-customer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/10/21
 * Time: 07.07
 */
@QuarkusTest
public class HealthCheckTest {
    @Test
    public void getHealth() {
        given()
                .when().get("/health")
                .then()
                .statusCode(200)
                .body("status", Matchers.equalTo("UP"));
    }
}
