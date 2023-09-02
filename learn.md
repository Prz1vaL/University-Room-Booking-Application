# Room Booking System

## Description

This repository contains a Java-based Room Booking System that provides both a text-based Command Line Interface (CLI) and a Graphical User Interface (GUI) using Java Swing. The program follows the Model-View-Controller (MVC) architectural pattern for effective code organization and separation of concerns. To ensure reliability, JUnit 5 was used for comprehensive testing, and all test cases are included in the submission.

The Room Booking System offers a range of functionalities, including user management, building management, room management, reservation booking, reservation deletion, reservation viewing by Booking ID or email ID, displaying all booked rooms, and data persistence through file save and load operations.

This project was developed as part of the CS5001 Object-Oriented Modelling, Design and Programming course practical.

## Functionalities Implemented

The Room Booking System supports the following functionalities for both the GUI and CLI interfaces:

1. Add, Delete, and View Users.
2. Add, Delete, and View Buildings.
3. Add, Delete, and View Rooms.
4. Book or Delete a Room Reservation.
5. View Your Reservations by Booking ID.
6. View All Booked Rooms.
7. View Your Reservations by Email ID.
8. Save Data to a File.
9. Load Data from a File.
10. Exit the Application.

## Application Files

The Room Booking System comprises several files, each responsible for specific aspects of the application:

- `RBSystem.java` (Main File)
- User Service
- Building Service
- Room Service
- Reservation Service
- User Model
- Building Model
- Room Model
- Reservation Model
- BookingResource Controller
- CLI View
- GUI View

## Additional Features

In addition to the core system requirements, the Room Booking System incorporates the following additional features:

1. **BookingID:** Users can create a unique booking reference to store multiple instances of reservations, enhancing the booking experience.
2. **User Email_ID:** Essential for implementing Role-Based Control, as administrative privileges are available. This facilitates logging the creation, updating, and deletion of objects.
3. **Viewing All Objects:** Users can view all objects for Users, Buildings, Rooms, and Reservations.

## User Functionalities

The Room Booking System offers the following user functionalities:

- Add and remove people, rooms, buildings, and bookings.
- Select a specific time to view all available rooms at that time.
- Choose a time slot (start and end times) and view all rooms available for that entire period.
- View the schedule for a given room, including existing bookings and free periods.
- View all bookings made by a specific person.
- Save data to a specified filename.
- Load data from a specified file.

## Setup and Installation

### Terminal Usage or IDE Based

Follow these steps to set up and run the Room Booking System:

1. Extract the downloaded `*.zip` file.
2. Navigate to the `src` folder of the program.
3. Compile the `.java` files in the terminal:

    ```
    javac *.java
    ```

4. Run the `RBSystem.java` file:

    ```
    java RBSystem
    ```

**Note:** The command-line and GUI interfaces run together with threading implemented for a seamless user experience.

## Technologies Used

The Room Booking System is built using the following technologies:

- Java 17
- JUnit 5 (for testing)
- Git (for version control)

Feel free to explore and use this Room Booking System for your scheduling and reservation needs!
