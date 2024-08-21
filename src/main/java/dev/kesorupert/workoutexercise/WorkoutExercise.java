package dev.kesorupert.workoutexercise;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.kesorupert.exercise.Exercise;
import dev.kesorupert.workoutset.WorkoutSet;
import dev.kesorupert.workout.Workout;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "workoutExercise", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<WorkoutSet> sets = new ArrayList<>();

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

    public List<WorkoutSet> getSets() {
        return sets;
    }

    public void setSets(List<WorkoutSet> sets) {
        this.sets = sets;
    }
}
