package dev.kesorupert.workout;

import dev.kesorupert.exercise.Exercise;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class WorkoutService {

    @Inject
    WorkoutRepository workoutRepository;

    public Workout getWorkout(Long id) {
        return workoutRepository.findById(id);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.listAll();
    }

    @Transactional
    public Workout createWorkout(Workout workout) {
        workoutRepository.persist(workout);
        return workout;
    }

    @Transactional
    public void addExerciseToWorkout(Long workoutId, Long exerciseId, int order) {
        Workout workout = getWorkout(workoutId);
        Exercise exercise = Exercise.findById(exerciseId); // refactor to use ExerciseRepository

        if (workout != null && exercise != null) {
            workoutRepository.addExerciseToWorkout(workout, exercise, order);
        } else {
            throw new IllegalArgumentException("Workout or exercise not found");
        }
    }

    @Transactional
    public void deleteWorkout(Long workoutId) {
        Workout workout = getWorkout(workoutId);
        if (workout != null) {
            workoutRepository.delete(workout);
        } else {
            throw new IllegalArgumentException("Workout not found");
        }
    }

}
