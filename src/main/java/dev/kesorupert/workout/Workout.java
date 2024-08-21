package dev.kesorupert.workout;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.kesorupert.user.User;
import dev.kesorupert.workoutexercise.WorkoutExercise;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workout {
    @Id
    @GeneratedValue
    @Column(name = "WorkoutID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    public User user;

    public String title;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    public LocalDateTime endDate;

    public String notes;

    @OneToMany(mappedBy = "workout", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<WorkoutExercise> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(List<WorkoutExercise> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }
}
