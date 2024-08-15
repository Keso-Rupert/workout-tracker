package dev.kesorupert.workout;

import dev.kesorupert.exercise.Exercise;
import dev.kesorupert.workoutexercise.WorkoutExercise;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class WorkoutRepository implements PanacheRepository<Workout> {

    @Transactional
    public void addExerciseToWorkout(Workout workout, Exercise exercise, int order) {
        WorkoutExercise workoutExercise = new WorkoutExercise();
        workoutExercise.setWorkout(workout);
        workoutExercise.setExercise(exercise);
        workoutExercise.setOrderInWorkout(order);
        workout.getWorkoutExercises().add(workoutExercise);
        persist(workout);
    }

}
