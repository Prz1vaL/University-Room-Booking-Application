# CS5001 Object-Oriented Modelling, Design and Programming
# Practical 4 – Room Booking System

Author : 220031985

Functionalities Implemented (Both GUI & CLI): 
                1.Add/Delete/View Users.
                2.Add/Delete/View Buildings.
                3.Add/Delete/View Rooms.
                4.Book or Delete a Room Reservation.
                5.View Your Reservations by Booking ID.
                6.View All Booked Rooms.
                7.View Your Reservations by Name(EMAIL ID).
                8.Save the Data.
                9.Load the Data.
                0.Exit.

Files in the application:

Main File : RBSystem.java

Service Layer: 
User Service
Building Service
Room Service
Reservation Service

Model Layer :
User 
Building
Room 
Reservation

Controller : 
BookingResource

View Layer :
CLI
GUI



Features implemented that are not part of the system:
• Implementing BookingID for making unqiue booking reference by a user to store multiple instances of reservations done by the user.
• User (email_ID) is an essential part of the system as the concept to implement Role-Based Control as Admin priviligies are open and therefore to create    a log that logs the creation/updation/deletion of any object can be accounted for.
• Viewing all objects  for User,buildings,rooms and reservations.

USER Functionalities :

• Add and remove people, rooms, buildings and bookings; (Addressed)
• Choose a time, and see all rooms that are available at that time; (Addressed by viewing all bookings at once Option 6.View All Booked Rooms)
• Choose a timeslot (start and end times) and see all rooms that are available for that whole period;(Addressed by viewing all bookings at once by 6.View All Booked Rooms)
• View the schedule for a given room, including bookings and free periods;(Addressed by viewing all bookings at once by 6.View All Booked Rooms)
• View all bookings made by a given person; (Addressed) 
• Save to a specified filename; (Addressed)
• Load from a specified file. (Addressed)




Compiling and running: 
1) Extract the *.zip file.
2) Navigate to the src folder of the Program.
3) Compile the .java files in terminal
4) Run the RBSystem.java
5) CommandLine and GUI runs together(Threading Implemented).

JUnit Tests: 
JUnit Test built for the application run on JUnit5 and were created using IntelliJ IDE.

Total No.of JUnit Test Files : 10
Total JUnit Test Written : 38
