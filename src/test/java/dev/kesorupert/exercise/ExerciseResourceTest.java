package dev.kesorupert.exercise;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExerciseResourceTest {

    @Test
    @Order(1)
    public void testCreateExercise() {
        String requestBody = "{\"name\":\"Push-ups\",\"category\":\"Strength\",\"targetMuscleGroup\":\"Chest\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post("/exercises")
                .then()
                .statusCode(201)
                .body("name", is("Push-ups"))
                .body("category", is("Strength"))
                .body("targetMuscleGroup", is("Chest"));
    }

    @Test
    @Order(2)
    public void testGetAllExercises() {
        given()
                .when().get("/exercises")
                .then()
                .statusCode(200)
                .body("$", hasSize(1))
                .body("[0].name", is("Push-ups"));
    }

    @Test
    @Order(3)
    public void testGetExercise() {
        given()
                .when().get("/exercises/1")
                .then()
                .statusCode(200)
                .body("name", is(notNullValue()));
    }

    @Test
    @Order(4)
    public void testUpdateExercise() {
        String requestBody = "{\"name\":\"Modified Push-ups\",\"category\":\"Strength\",\"targetMuscleGroup\":\"Chest\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().put("/exercises/1")
                .then()
                .statusCode(200)
                .body("name", is("Modified Push-ups"));
    }

    @Test
    @Order(5)
    public void testDeleteExercise() {
        given()
                .when().delete("/exercises/1")
                .then()
                .statusCode(204);
    }
}