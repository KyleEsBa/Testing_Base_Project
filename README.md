OLD VERSION:
This project implements a login method that have to be called to stay into the application. After this you can execute your step scenarios.
 IMPORTANT: The method parameter is a String with value of 'student' or 'librarian'
  e.g.  LoginPage loginPage=new LoginPage();
        loginPage.login("student");

UPDATED VERSION:
To be inside the LibraryCT application just is needed to include the following step in .feature file:

#The argument passed can be "student" or "librarian"
Given user is logged as "librarian"

It replaces the direct calling to the login method.
IMPORTANT: In the "features" folder was added a "template.feature" as a template to the scenarios.
