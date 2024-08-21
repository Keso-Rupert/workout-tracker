package dev.kesorupert.workoutset;

import dev.kesorupert.workoutexercise.WorkoutExercise;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class WorkoutSet extends PanacheEntityBase {

    @Id
    @GeneratedValue
    @Column(name = "SetID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "workoutExerciseID")
    private WorkoutExercise workoutExercise;

    public Integer numberOfReps;

    public Double weight;

    public String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(Integer numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
