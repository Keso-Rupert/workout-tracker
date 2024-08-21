package dev.kesorupert.workout;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WorkoutResourceTest {

    @Test
    @Order(1)
    public void testCreateWorkout() {
        String requestBody ="{\"title\":\"Upper Body\",\"startDate\":\"2023-08-19 21:00\",\"endDate\":\"2023-08-19 22:00\",\"notes\":\"Great session\"}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post("/workouts")
                .then()
                .statusCode(201)
                .body("startDate", is("2023-08-19 21:00"))
                .body("notes", is("Great session"));
    }

    @Test
    @Order(2)
    public void testGetAllWorkouts() {
        given()
                .when().get("/workouts")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)))
                .body("[0].endDate", is("2023-08-19 22:00"));
    }

    @Test
    @Order(3)
    public void testGetWorkout() {
        given()
                .when().get("/workouts/1")
                .then()
                .statusCode(200)
                .body("startDate", is("2023-08-19 21:00"))
                .body("notes", is("Great session"));
    }

    // This one doesn't work since there is no Exercise in the DB to add to this workout
//    @Test
//    @Order(4)
//    public void testAddExerciseToWorkout() {
//        given()
//                .queryParam("order", 1)
//                .when().post("/workouts/1/exercises/1")
//                .then()
//                .statusCode(201);
//    }

    @Test
    @Order(4)
    public void testUpdateWorkout() {
        String updateRequestBody = "{\"title\":\"Full Body\",\"startDate\":\"2023-08-20 18:00\",\"endDate\":\"2023-08-20 19:30\",\"notes\":\"Intense workout\"}";

        given()
                .contentType(ContentType.JSON)
                .body(updateRequestBody)
                .when().put("/workouts/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("title", is("Full Body"))
                .body("startDate", is("2023-08-20 18:00"))
                .body("endDate", is("2023-08-20 19:30"))
                .body("notes", is("Intense workout"));
    }

    @Test
    @Order(5)
    public void testDeleteWorkout() {
        given()
                .when().delete("/workouts/1")
                .then()
                .statusCode(204);
    }
}