package dev.kesorupert.exercise;

import dev.kesorupert.workout.Workout;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/exercises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExerciseResource {

    @Inject
    ExerciseService exerciseService;

    @GET
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GET
    @Path("/{id}")
    public Response getExercise(@PathParam("id") long exerciseId) {
        Exercise exercise = exerciseService.getExercise(exerciseId);
        if (exercise != null) {
            return Response.ok(exercise).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createExercise(Exercise exercise) {
        Exercise createdExercise = exerciseService.createExercise(exercise);
        return Response.status(Response.Status.CREATED).entity(createdExercise).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteExercise(@PathParam("id") long exerciseId) {
        try {
            exerciseService.deleteExercise(exerciseId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}
