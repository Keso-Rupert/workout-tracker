package dev.kesorupert.workout;

import dev.kesorupert.exercise.Exercise;
import dev.kesorupert.workoutexercise.WorkoutExercise;
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
    public Workout updateWorkout(Long workoutId, Workout newWorkout) {
        Workout existingWorkout = getWorkout(workoutId);
        if (existingWorkout != null) {
            existingWorkout.setTitle(newWorkout.getTitle());
            existingWorkout.setStartDate(newWorkout.getStartDate());
            existingWorkout.setEndDate(newWorkout.getEndDate());
            existingWorkout.setNotes(newWorkout.getNotes());

//            existingWorkout.setWorkoutExercises(newWorkout.getWorkoutExercises());
//            existingWorkout.setUser(newWorkout.getUser());
//
//            for (WorkoutExercise exercise : newWorkout.getWorkoutExercises()) {
//                exercise.workout = newWorkout;
//            }

//            newWorkout.setId(existingWorkout.getId());
            workoutRepository.persist(existingWorkout);
            return existingWorkout;
        }
        return null;
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
