package com.hendisantika.customer;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    public void getById() {
        Customer customer = createCustomer();
        Customer saved = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(customer)
                .post("/api/customers")
                .then()
                .statusCode(201)
                .extract().as(Customer.class);
        Customer got = given()
                .when().get("/api/customers/{customerId}", saved.getCustomerId())
                .then()
                .statusCode(200)
                .extract().as(Customer.class);
        assertThat(saved).isEqualTo(got);
    }

    @Test
    public void post() {
        Customer customer = createCustomer();
        Customer saved = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(customer)
                .post("/api/customers")
                .then()
                .statusCode(201)
                .extract().as(Customer.class);
        assertThat(saved.getCustomerId()).isNotNull();
    }

    @Test
    public void postFailNoFirstName() {
        Customer customer = createCustomer();
        customer.setFirstName(null);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(customer)
                .post("/api/customers")
                .then()
                .statusCode(400);
    }

    @Test
    public void put() {
        Customer customer = createCustomer();
        Customer saved = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(customer)
                .post("/api/customers")
                .then()
                .statusCode(201)
                .extract().as(Customer.class);
        saved.setFirstName("Updated");
        Customer updated = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(saved)
                .put("/api/customers")
                .then()
                .statusCode(200)
                .extract().as(Customer.class);
        assertThat(updated.getFirstName()).isEqualTo("Updated");
    }

    @Test
    public void putFailNoLastName() {
        Customer customer = createCustomer();
        Customer saved = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(customer)
                .post("/api/customers")
                .then()
                .statusCode(201)
                .extract().as(Customer.class);
        saved.setLastName(null);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(saved)
                .put("/api/customers")
                .then()
                .statusCode(400);
    }
}
