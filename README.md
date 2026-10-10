# Implementation notes

Suggested Spring Boot packages:
- controller/ServiceRequestController.java
- dto/CreateRequestDto.java and RequestResponse.java
- model/ServiceRequest.java and RequestStatus.java
- repository/ServiceRequestRepository.java
- service/ServiceRequestService.java
- security/SecurityConfiguration.java

Development sequence:
1. Create a Spring Boot project with Spring Web, Validation, Spring Data JPA, Spring Security, PostgreSQL Driver, and Spring Boot Test.
2. Define the entity, status enum, DTOs, and repository.
3. Implement creation and allowed status transitions.
4. Derive citizen ID from the authenticated principal.
5. Add a database uniqueness constraint and migration.
6. Add JUnit/Mockito unit tests and MockMvc integration tests.
7. Run the tests and document results.

The snippets in the report are illustrative and require imports, mappings, and configuration before compilation.
