# Build Sprint 1

To begin work on this ticket, make sure you have: 
1. Finished getting locally setup. 
2. Completed the `Onboarding Module` in your course. 
3. Reviewed the [composition document](../documents/composition_document.md). 

# Objective

Deliver the following Domain Objects (Entities / DTO / ENUM):

## User
- id : Long
- cohortStartDate: Date
- username: String
- password: String
- authorities: List<Authority>

## Authority
- id: Long
- authority: String
- user: User

## Assignment
- id: Long
- status: String
- number: Integer
- githubUrl: String
- branch: String
- reviewVideoUrl: String
- user: User
- codeReviewer: User

## DTOs
- AssignemntResponseDto
- AuthCredentialRequest

## Enums
- AssignmentEnum
- AssignmentStatusEnum
- AuthorityEnum

# Guidance

Your job is to begin work on the LMS by setting up the domain objects shown above. 

## Subtasks

### Add User and Assignment Entities

#### Assignment - Stage 1
- id: Long
- status: String
- number: Integer
- githubUrl: String
- branch: String
- reviewVideoUrl: String
- user: User
 create a no args constructor and an all args except id constructor.

#### User - Stage 1
- id : Long
- cohortStartDate: LocalDate
- username: String
- password: String
  create a no args constructor and an all args except id constructor.

### Add Spring Security and create a Security Config

#### Uncomment the spring security dependencies inside the build.gradle file

#### Uncomment the Jwt Utils, CustomPasswordEncoder and the UserDetailsServiceImpl

- UserDetaiServiceImpl phase 1
```Java
package com.hcc.services;

import com.hcc.entities.User;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    CustomPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.getPasswordEncoder().encode("asdfasdf"));
        return user;
    }
}
```

#### Create a config package and a file inside the package called SecurityConfig.java

- SecurityConfig  phase 1
```java
package com.hcc.config;

import com.hcc.services.UserDetailServiceImpl;
import com.hcc.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

}
```

#### Create the Authority Entity and Update the User Entity to implement UserDetails adding some overrides

##### Authority - Phase 1
- id: Long
- authority: String
- user: User (Many to one annotation)

##### User
Overrides
```Java
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new Authority("role_student"));
        return roles;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
            return password;
            }
```



You must: 

1. Follow the guidelines set out by the [composition document](../documents/composition_document.md). 

2. Use the tech stack given in that same document.  

# Deliverables 

Submit the following in your course: 

- Link to your forked repo with the added code for the landing page
- Link to a Loom video answering the prompt in the `Submit Your Deliverables` assignment in your course
