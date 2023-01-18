# Design Document for the Assignment Review App


## Synopsis
Bloom Coders, a small code camp has been struggling to keep track of their learners assignments, over time this has become a logistical nightmare. The managers have requested the engineering teams come up with some solutions and one part of the problem is that they do not have a good way for a learner to submit assignments and get them reviewed. If only there were an app or program that could facilitate this for the learners that need to submit assignments and some professionals who could review those assignments...

Enter **The Bloom Coder Assignment App** a solution to all their needs, *or at least their immidiate assignment review triage needs*. in this app we will need a few things to get it to do what we want. we have interviewed some learners and some reviewers and here are their Stories.

## User Stories

### Learner User Stories
#### Bob the learner
Meet Bob he is an ex rigger from the north sea and he wanted to persue a career in software engineering, he has aspirations of becomming a full stack web developer and later entering the realms of backend development as he progresses in his career. He came to `Bloom Code Camp` to get a step up on the cometition. Bob has some requests of the team.

- As a Learner i want to be able to log in to the app and be presented with a dashboard
- As a learner I want a dashboard that shows all of my currently working on, submitted, rejected, and completed assignments.

#### Jen the learner
Meet Jen she works 3 jobs to support her family and wants to gain a better work home life ballance, for her this means becoming a Data Engineer. For this she will need to learn backend development / Database Design and a some Data Science. She has enrolled at `Bloom Code Camp` with aspirations of becoming the best data engineer that she can be. Jen has some requests of the team.

- As a Learner I want to be able to click on a `Create Assignment` button on my dashboard and be presented with a form to allow me to submit an assignment with room for my github url and the branch i am working on.
- As a Learner I wantt to be able to click on an `Edit` button on one of the assignments on my dashboard to edit and resubmit it if it was returned unfinished.
- As a Learner I want to be able to click on a `View` button on a completed assignment on my dashboard and be able to view a review video for the given assignment.

### Reviewer User Stories

#### Carlos the Developer
Meet Carlos he works as a backend developer at a fortune 500 company and in his spare time he codes analytical engines to automate the winning of online strategy games, he aspires to help new engineers and developers evolve and grow in their abilities and has signed up to the `Bloom Code Camp` as a reviewer to help the learners progress in their career with strong reviews and guidence from professionals such as himself. Carlos has quite a few requests of the team.

- As a Reviewer I want to be able to login to the app and be presented with a dashboard.
- As a Reviewer I want to be able to see any submitted assignments on my dashboard ready to claim.
- As a Reviewer I want to be able to click on a `claim` button on an assignment in my dashboard to claim it ready for review
- As a Reviewer I want to be able to be able to click a `View` button on one of my claimed assignments and get a detail view of the assignment ready to review
- As a Reviewer I want to be able to click a `Reject Assignment` button in an assignment view to reject a learners assignment submission to be resubmitted by them.
- As a Reviewer I want to be able to click on a `Complet Assignment Review` button to mark it as complete.
- As a Reviewer I want to be able to see any resubmitted assignments that I have previously rejected.
- As a Reviewer I want to be able to click a `Reclaim` button on a resubmitted assignment that I previously rejected to do a follow up review.

## Technology Stack
- Frontend **React JS**
- Backend API **Spring Boot with Spring Data JPA with Hibernate and the Postgress Driver**
- Security and Auth **Spring Scurity using JWT for user persistence**
- Database **PostgreSQL server for a relational database**

## Domain Objects (Entities / DTO / ENUM)

### User
- id : Long
- cohortStartDate: Date
- username: String
- password: String
- authorities: List<Authority>

### Authority
- id: Long
- authority: String
- user: User

### Assignment
- id: Long
- status: String
- number: Integer
- githubUrl: String
- branch: String
- reviewVideoUrl: String
- user: User
- codeReviewer: User

### DTOs
- AssignemntResponseDto
- AuthCredentialRequest

### Enums
- AssignmentEnum
- AssignmentStatusEnum
- AuthorityEnum

## Database Tables

### users
- id : number
- cohort_start_date: date
- username: varchar
- password: varchar

### authorities
- id: number
- authority: varchar
- user_id: number

### assignments
- id: number
- branch: varchar
- code_review_video_url: varchar
- github_url: varchar
- number: number
- user_id: number
- code_reviewer_id: number

## Restful Endpoints

- **Login**                     `/api/auth/login`
- **Validate token**            `/api/auth/validate`
- **Get Assignments By User**   `/api/assignments`
- **Get Assignment By Id**      `/api/assignments/{id}`
- **Put Assignment by Id**      `/api/assignments/{id}`
- **Post Assignment**           `/api/assignments`



## Wireframes

### Home Page (Public)
![Home Page (Public)](./images/home_page_public.jpg)

### Home Page (Authenticated)
![Home Page (Authenticated)](./images/home_page_authenticated.jpg)

### Login Page
![Login Page](./images/login_page.jpg)

### Learner Dashboard
![Learner Dashboard](./images/learner_dashboard.jpg)

### Reviewer Dashboard
![Reviewer Dashboard](./images/reviewer_dashboard.jpg)

### Learner Assignment View
![Learner Assignment View](./images/learner_assignment_view.jpg)

### Reviewer Assignment View
![Reviewer Assignment View](./images/reviewer_assignment_view.jpg)
