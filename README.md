# PS-Allotment-System-Project

# Project Summary
This project aims to facilitate the student allotment process for Practice School. It provides a user interface where admistrators can register stations with specific branch preferences and total student space. Students can register themselves by giving a preference of stations and can view the available stations. The algorithm allots students to stations, giving preference to students with higher CGPA. Henceforth, students can view their allotments in the latest round; edit their preferences, accept allotment or exit from the process. Admins can manage student and station details and view latest allotments.


# Program Flow
Initial Setup: The program starts by requesting input for default station details and normal station details. The user interface guides the administrator through the input process for stations and students, using GUI pages and boolean flags to ensure correct input.

Student Allotment Process: The program uses multithreading to handle the allotment process. An ArrayList of student threads is created based on the number of students inputted. These threads are then passed to a studentsStart object, which waits until the allottedFlag is set to true by the admin after each round of allotment. The studentsStart object runs each student thread sequentially, allowing for student interaction through GUI pages.

# Program Flow: The program flow can be summarized as follows:

1.  Admin input default station details (ID, Company, Stipend, Location).
2. Admin input normal station details (ID, Capacity, Courses, Branches).
S  Students  input student details (ID, Name, CGPA, Branch, Courses, Preferences).
4. Admin can view/edit station and student details before allotment.
5. Admin initiates the first round of allotment.

# Allotment process:
1. Sort unallotted students by CGPA.
2. Iterate over each student:
  1.  Attempt to allot the student their first preference if criteria are met.
  2. If not, try subsequent preferences.
  3. If no preference can be allotted, assign the default allotment.
  4. Admin can view/edit station details and view student details after the first round of allotment.
  5. Admin decides whether to conduct more rounds or finalize the allotment.
  6. Students view their details and allotment.
  7. If more rounds are conducted, students can accept/reject the allotment or edit their preferences.
  8. The process continues with the Admin's homepage opening after each round, allowing for further rounds or finalization of the allotment.




