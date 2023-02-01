# Build Sprint 1

To begin work on this ticket, make sure you have finished: 
1. Getting locally setup. 
2. Completed the onboarding module on Canvas. 
3. Review the [composition document](documents/composition_document.md). 

### Objective

Deliver the following Domain Objects (Entities / DTO / ENUM):

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

### Guidance

Your job is to begin work on the LMS by setting up the domain objects shown above. 

You must: 

1. Follow the guidelines set out by the [composition document](documents/composition_document.md). 

2. Use the tech stack given in that same document.  

## Deliverables 

Submit the following on Canvas: 

- Link to your forked repo with the added code for the landing page
- Link to a Loom video answering the prompt in the Canvas assignment