Room Booking System

This project was completed as part of the CS5001 Object-Oriented Modelling, Design and Programming course. The Room Booking System is a Java-based application that enables users to book and manage room reservations in various buildings. The system includes functionalities for adding, deleting, and viewing users, buildings, rooms, and reservations.

Functionalities Implemented

The following functionalities have been implemented for both GUI and CLI interfaces:

Add/Delete/View Users.
Add/Delete/View Buildings.
Add/Delete/View Rooms.
Book or Delete a Room Reservation.
View Your Reservations by Booking ID.
View All Booked Rooms.
View Your Reservations by Name (EMAIL ID).
Save the Data.
Load the Data.
Exit.
Application Files

The Room Booking System consists of the following files:

RBSystem.java (Main File)
User Service
Building Service
Room Service
Reservation Service
User Model
Building Model
Room Model
Reservation Model
BookingResource Controller
CLI View
GUI View
Additional Features

The following features have been implemented, which are not part of the system requirements:

BookingID for creating a unique booking reference by a user to store multiple instances of reservations.
User email_ID is an essential part of the system to implement Role-Based Control as Admin privileges are open. This allows for creating a log that logs the creation/updation/deletion of any object can be accounted for.
Viewing all objects for Users, Buildings, Rooms, and Reservations.
User Functionalities

The Room Booking System provides the following user functionalities:

Add and remove people, rooms, buildings, and bookings.
Choose a time and view all rooms available at that time.
Choose a timeslot (start and end times) and view all rooms available for that whole period.
View the schedule for a given room, including bookings and free periods.
View all bookings made by a given person.
Save to a specified filename.
Load from a specified file.
Compiling and Running

To compile and run the Room Booking System, please follow these steps:

Extract the *.zip file.
Navigate to the src folder of the program.
Compile the .java files in the terminal.
Run the RBSystem.java file.
The command-line and GUI interfaces run together with threading implemented.
JUnit Tests

JUnit tests for the Room Booking System were created using the JUnit5 framework and IntelliJ IDE. The system consists of 10 test files with a total of 38 JUnit tests written.
