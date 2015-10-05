Friendsurance code assignment
=============================

- [LICENSE](#license)
- [Introduction](#introduction)
- [Batch Mails Processing Engine](#batch-mails-processing-engine)
  - [Context](#context)
  - [Description](#description)
  - [Acceptance Criteria](#acceptance-criteria)
  - [Notes from IT](#notes-from-it)
- [How to submit a solution](#how-to-submit-a-solution)

LICENSE
=============================

Copyright (C) Alecto GmbH - All Rights Reserved

Unauthorized copying of any content of this project via any medium is strictly prohibited.
Proprietary and confidential.

Introduction
=============================

Hello and welcome fellow Coder!

As part of our interview process we would like you to complete a programming assignment. It presents a hypothetical situation which resembles how you could be solving problems at Friendsurance. Please read the whole description thoroughly
then create a program to solve the problem at hand.

For the solution, we request that you use Java as a programming language. The application must run and your solution should provide sufficient evidence that it is complete.

Batch Mails Processing Engine
=============================

Context
-------

As part of our efforts to have more and more engaged users, we decided to start sending emails every night at 3 AM.
These emails relate to the current situation of each user. For example:

* If a user has registered more than 7 days ago and has no friends in our platform right now, we would like to send an
email encouraging them to be more active. The mail could contain something like "Hey, do you remember us? Give us a try
and be social with your insurances!"
* Another user which registered more than 7 days ago and has friends in our platform but no contract, does not need to be
reactivated. But it could be interesting for them if we offer some price attractive tariff so they could save money together
with their friends.

And so on. What follows is the problem we would like you to solve.

Description
-----------

Write an application which will get all users, calculate their situation and send them the email which fits best to
their situation.

Acceptance Criteria
-------------------

* Send emails to users. The specific type of email that must be sent will be determined by the following rules:

| Has Contract | # Friends | # Invitations |    | Type of Email |
| -------------|-----------|---------------|----|---------------|
|     no       |     0     |       0       | -> |  MAIL_TYPE_2  |
|     no       |     >1    |       0       | -> |  MAIL_TYPE_3  |
|     no       |     >3    |       >1      | -> |  MAIL_TYPE_1  |
|     no       |     <3    |       >1      | -> |  MAIL_TYPE_2  |
|     no       |     <3    |       >6      | -> |  MAIL_TYPE_3  |
|     yes      |     0     |       0       | -> |  MAIL_TYPE_3  |
|     yes      |     0     |       >3      | -> |  MAIL_TYPE_3  |
|     yes      |     >1    |       -       | -> |  MAIL_TYPE_4  |
|     yes      |     >4    |       >3      | -> |  MAIL_TYPE_5  |

* Users should get only one email in case their situation matches more than one of the above conditions.
* The priority to choose which type of email to send is defined by the number in the type name (i.e. MAIL_TYPE_3 has
 a priority of 3 and MAIL_TYPE_5 has a priority of 5). The higher the number, the higher the priority will be.

Notes from IT
-------------

Our engineers have already decided how this mail processing engine will be used by other parts of our system. That's
why they provided an abstract class, *ItemProcessing*, which defines the API that will be exposed externally plus a
basic processing logic. They want you to provide a working subclass of this abstract class. This class needs two
objects to operate normally, defined by the interfaces *ItemReader* and *ItemWriter*, which you should implement too.

They have also decided what you can get from outside this subsystem. As a result, they defined the class *User* as
the best abstraction to hold all the information you may need. You can decide how you would like to use this
information. But you cannot change the class User.

As a last resource, they have defined an interface to send emails (_EmailService_). It is mandatory to use this
interface for the email sending.

Finally, due to restrictions in the production environment the code will run on, you may not use any external libraries
to solve this problem - but you may use external libraries or tools for building or testing purposes (you are given a
Maven project as a start point). For the same restrictions, your code must be Java 7 compliant.

How to submit a solution
=============================

By now you should have read access to this repository. Assignment should be completed in your own private fork in separate branch.

Once everything is done and you are happy with results, please create a new pull request from your branch into master branch of *your private fork*. Please do not use original Friendsurance/batch repository as target for pull request.

When pull request is ready, please, assign it to a person, who granted you access to Friendsurance/batch repository. Or simply send us an email with link to pull request.
<br><br><br>
Please, feel free to contact us with any questions regarding assignment or submission process. We would be happy to help!

Good luck!  
Friendsurance Dev Team
