# Build Sprint 2

To begin work on this ticket, make sure you have: 
1. Finished getting locally setup. 
2. Finished the onboarding module on Canvas. 
3. Reviewed the [composition document](documents/composition_document.md). 
4. Completed Build Sprint 1. 

# Objective

Build the following database tables and endpoints: 

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


# Guidance

Your job is to continue work on the LMS by setting up tables and endpoints. 

You must: 

1. Follow the guidelines set out by the [composition document](documents/composition_document.md). 

2. Use the tech stack given in that same document.  

## Deliverables 

Submit the following on Canvas: 

- Link to your forked repo with the added code for the landing page
- Link to a Loom video answering the prompt in the Canvas assignment