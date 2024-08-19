package dev.kesorupert.workout;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/workouts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkoutResource {

    @Inject
    WorkoutService workoutService;

    @GET
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GET
    @Path("/{id}")
    public Response getWorkout(@PathParam("id") long id) {
        Workout workout = workoutService.getWorkout(id);
        if (workout != null) {
            return Response.ok(workout).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createWorkout(Workout workout) {
        Workout createdWorkout = workoutService.createWorkout(workout);
        return Response.status(Response.Status.CREATED).entity(createdWorkout).build();
    }

    @POST
    @Path("/{workoutId}/exercises/{exerciseId}")
    public Response addExerciseToWorkout(@PathParam("workoutId") long workoutId, @PathParam("exerciseId") long exerciseId, @QueryParam("order") int order) {
        try {
            workoutService.addExerciseToWorkout(workoutId, exerciseId, order);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteWorkout(@PathParam("id") long workoutId) {
        try {
            workoutService.deleteWorkout(workoutId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}
