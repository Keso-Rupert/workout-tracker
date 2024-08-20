package dev.kesorupert.workoutexercise;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.kesorupert.exercise.Exercise;
import dev.kesorupert.workout.Workout;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class WorkoutExercise extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Column(name = "WorkoutExerciseID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "WorkoutID")
    @JsonBackReference
    public Workout workout;

    @ManyToOne
    @JoinColumn(name = "ExerciseID")
    public Exercise exercise;

    private Integer orderInWorkout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Integer getOrderInWorkout() {
        return orderInWorkout;
    }

    public void setOrderInWorkout(Integer orderInWorkout) {
        this.orderInWorkout = orderInWorkout;
    }
}
