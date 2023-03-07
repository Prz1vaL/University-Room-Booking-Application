## Application Name
<strong> Room Booking System </strong>
---

## Description :
* This is a Java program for a room-booking system that includes both a text-based user interface and a graphical user interface using Java Swing. The program was built using the Model-View-Controller (MVC).

* To ensure the program functions correctly, JUnit was used to test the model and all tests are included in the submission.

* The program allows users to add, delete, and view users, buildings, and rooms. Users can also book and delete room reservations and view their reservations by either booking ID or email ID. Additionally, users can view all booked rooms and save/load data to/from a specified file.

* This project was developed as part of the CS5001 Object-Oriented Modelling, Design and Programming course practical.

---

## Functionalities Implemented

The following functionalities have been implemented for both GUI and CLI interfaces:
<ol>
<li>Add/Delete/View Users.
<li>Add/Delete/View Buildings.
<li>Add/Delete/View Rooms.
<li>Book or Delete a Room Reservation.
<li>View Your Reservations by Booking ID.
<li>View All Booked Rooms.
<li>View Your Reservations by Name (EMAIL ID).
<li>Save the Data.
<li>Load the Data.
<li>Exit.
</ol>

---

### Application Files :

The Room Booking System consists of the following files:

* RBSystem.java (Main File)
* User Service
* Building Service
* Room Service
* Reservation Service
* User Model
* Building Model
* Room Model
* Reservation Model
* BookingResource Controller
* CLI View
* GUI View

---

## Additional Features

The following features have been implemented, which are not part of the system requirements:

BookingID for creating a unique booking reference by a user to store multiple instances of reservations.
User email_ID is an essential part of the system to implement Role-Based Control as Admin privileges are open. This allows for creating a log that logs the creation/updation/deletion of any object can be accounted for.
Viewing all objects for Users, Buildings, Rooms, and Reservations.


---

## User Functionalities

The Room Booking System provides the following user functionalities:
<ol>
<li> Add and remove people, rooms, buildings, and bookings.
<li> Choose a time and view all rooms available at that time.
<li> Choose a timeslot (start and end times) and view all rooms available for that whole period.
<li> View the schedule for a given room, including bookings and free periods.
<li> View all bookings made by a given person.
<li> Save to a specified filename.
<li> Load from a specified file.
</ol>


---

## SETUP AND INSTALLATION

<strong> Terminal Usage or IDE Based</strong>
<ol>
<li> Extract the *.zip file.
<li> Navigate to the src folder of the program.
<li> Compile the .java files in the terminal. <code> javac *.java </code>
<li> Run the RBSystem.java file. <code> java RBSystem </code>
<li> Note : The command-line and GUI interfaces run together with threading implemented.
</ol>

--- 

### Technologies Used

* Java 17 
* JUnit 5
* Git

---

### JUNIT Tests : 

* Total No.of JUnit Test Files : 10 
* Total JUnit Test Written : 38

---

### CONTRIBUTION GUIDELINES : 
- Clone the repository from the Github server.
- Create a new branch for your feature or bug fix.
- Write unit tests for your code.
- Implement your feature or bug fix.
- Ensure all tests pass.
- Commit your changes and push to your branch on the Github server.
- Submit a merge request to merge your changes into the main branch.

--- 
### License
This project is done part of coursework of <strong> CS5001 - Object Oriented Programming</strong> of the <strong> Computer Science Dept of University of St.Andrews.</strong> </br>

This project is licensed under the <code> MIT License. </code>See the <code>LICENSE</code> file for more information.



JUnit tests for the Room Booking System were created using the JUnit5 framework and IntelliJ IDE. The system consists of 10 test files with a total of 38 JUnit tests written.
