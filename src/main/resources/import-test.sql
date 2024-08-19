-- Insert sample exercises
INSERT INTO Exercises (id, name, category, targetMuscleGroup, description) VALUES (1, 'Push-ups', 'Strength', 'Chest', 'Classic upper body exercise');
INSERT INTO Exercises (id, name, category, targetMuscleGroup, description) VALUES (2, 'Squats', 'Strength', 'Legs', 'Fundamental lower body exercise');
INSERT INTO Exercises (id, name, category, targetMuscleGroup, description) VALUES (3, 'Plank', 'Core', 'Abs', 'Isometric core strengthening exercise');
INSERT INTO Exercises (id, name, category, targetMuscleGroup, description) VALUES (4, 'Lunges', 'Strength', 'Legs', 'Unilateral lower body exercise');
INSERT INTO Exercises (id, name, category, targetMuscleGroup, description) VALUES (5, 'Pull-ups', 'Strength', 'Back', 'Upper body pulling exercise');

-- Insert sample workouts
INSERT INTO Workouts (id, workoutDate, duration, notes) VALUES (1, '2023-08-18', 45, 'Morning workout - felt great!');
INSERT INTO Workouts (id, workoutDate, duration, notes) VALUES (2, '2023-08-19', 60, 'Evening session - focused on legs');
INSERT INTO Workouts (id, workoutDate, duration, notes) VALUES (3, '2023-08-20', 30, 'Quick core workout');

-- Insert sample workout exercises
INSERT INTO WorkoutExercises (id, workoutId, exerciseId, orderInWorkout) VALUES (1, 1, 1, 1);
INSERT INTO WorkoutExercises (id, workoutId, exerciseId, orderInWorkout) VALUES (2, 1, 3, 2);
INSERT INTO WorkoutExercises (id, workoutId, exerciseId, orderInWorkout) VALUES (3, 1, 5, 3);
INSERT INTO WorkoutExercises (id, workoutId, exerciseId, orderInWorkout) VALUES (4, 2, 2, 1);
INSERT INTO WorkoutExercises (id, workoutId, exerciseId, orderInWorkout) VALUES (5, 2, 4, 2);
INSERT INTO WorkoutExercises (id, workoutId, exerciseId, orderInWorkout) VALUES (6, 3, 3, 1);