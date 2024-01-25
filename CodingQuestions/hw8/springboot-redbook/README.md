# Spring Boot Redbook Project

This project serves as a step-by-step guide to writing a Spring Boot CRUD API, with specific focus on completing the coding assignments detailed in "hw40.2-springboot-post.pdf" and "hw41-springboot-RUD.pdf". The code is structured across different branches, named sequentially from `01_`, `02_`, `03_`, etc., to enable a progressive learning experience and systematic implementation of the project requirements.

## Features

### Posts
* **CRUD Operations**: Implement CRUD (Create, Read, Update, Delete) operations in the service layer and controller layer for posts.
* **Mapping Methods**: In `PostServiceImpl`, define two private methods:
  * `mapToEntity(PostDto postDto)`: Converts a `PostDto` to a `Post` entity.
  * `mapToDTO(Post post)`: Converts a `Post` entity to a `PostDto`.
* **Pagination**: Add support for paginated retrieval of posts in the `PostService` and `PostController` using query parameters to specify page number, page size, sort by, and sort direction.
* **Postman Testing**: Use Postman to call each API endpoint and check the response.

### Authors
* **CRUD Operations with GraphQL**: In addition to RESTful APIs, implement GraphQL query and mutation resolvers for authors.
* **Service Layer**: Include RUD operations for authors in the service layer.
* **Exception Handling**: Add a package named `exception` containing a `ResourceNotFoundException` for handling cases where a resource does not exist.

### Comments
* CRUD Operations: Implement Create, Read, Update, Delete operations for comments on posts.
* ManyToOne Relationship: Each Comment is associated with a Post, showcasing a ManyToOne relationship.
* Postman Testing: Test comment-related endpoints using Postman.

### Pagination for getAllPosts
* **Endpoint**: `GET /api/v1/posts`
* **Query Parameters**:
  * `pageNo`: The number of the page to retrieve.
  * `pageSize`: The number of records per page.
  * `sortBy`: The attribute by which records are sorted.
  * `sortDir`: The direction of sorting, either `asc` or `desc`.

### Testing Endpoints with Postman
* For testing CRUD operations on posts and authors, use the corresponding HTTP methods (GET, POST, PUT, DELETE) with the appropriate endpoint.
* When testing GraphQL resolvers, use the POST method to `http://localhost:8080/graphql` with a GraphQL query or mutation in the request body.

## Development Sequence
Follow the branch sequence `01_`, `02_`, `03_`, etc., to incrementally add features and learn the development of a Spring Boot application.
