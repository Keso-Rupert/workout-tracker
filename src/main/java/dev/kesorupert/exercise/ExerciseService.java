package dev.kesorupert.exercise;

import dev.kesorupert.workout.Workout;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ExerciseService {

// Won't be necessary if we don't have specific database transactions / logic going on
//    @Inject
//    ExerciseRepository exerciseRepository;

    public Exercise getExercise(Long id) {
        return Exercise.findById(id);
    }

    public List<Exercise> getAllExercises() {
        return Exercise.listAll();
    }

    @Transactional
    public Exercise createExercise(Exercise exercise) {
        Exercise.persist(exercise);
        return exercise;
    }

    @Transactional
    public void deleteExercise(Long id) {
        Exercise exercise = getExercise(id);
        if (exercise != null) {
            exercise.delete();
        } else {
            throw new IllegalArgumentException("Exercise not found");
        }
    }


}
