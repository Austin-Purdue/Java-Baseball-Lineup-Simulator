# Java Baseball Lineup Simulator

## Project Overview

A Java-based baseball lineup simulation developed to demonstrate the use of queue data structures in managing an ordered batting lineup.

The application models a baseball batting rotation, where players take turns batting in a predetermined order and return to the end of the queue after their turn.

This project focuses on implementing First In, First Out (FIFO) processing and applying fundamental data structure concepts to a practical simulation.

## Features

### Queue-Based Batting Lineup
- Organizes players into an ordered batting lineup.
- Uses a queue to manage player batting order.
- Processes players according to FIFO principles.
- Rotates players through the lineup as turns are completed.

### Player Rotation
- Removes the next player from the front of the queue.
- Returns players to the end of the queue after their turn.
- Maintains the batting rotation throughout the simulation.

### Console-Based Simulation
- Demonstrates lineup progression through console output.
- Illustrates how queue operations manage player order.

## Technologies Used

- **Java:** Core application logic.
- **Java Collections Framework:** Queue-based data management.
- **Console Output:** Displaying simulation results.

## How to Run

1. Install the Java Development Kit (JDK).
2. Download or clone the repository.
3. Open a terminal in the project directory.
4. Compile the source code:

   ```bash
   javac -d out src/Homework_4/BaseballLineupQueue.java
   ```

5. Run the application:

   ```bash
   java -cp out Homework_4.BaseballLineupQueue
   ```

The commands above assume the source file declares `package Homework_4;`.

## Concepts Demonstrated

- Queue data structures
- First In, First Out (FIFO) processing
- Java Collections Framework
- Iteration and loops
- Object-oriented programming fundamentals
- Data organization and sequential processing

## Project Status

**Status: Completed academic project**

This project was developed to practice queue operations and demonstrate how data structures can be applied to ordered, repeating processes.