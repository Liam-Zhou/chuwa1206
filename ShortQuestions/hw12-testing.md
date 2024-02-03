2. **What is Selenium?**
   Selenium is a suite of tools for automating web browsers. It supports multiple browsers and programming languages, enabling automated web application testing.

3. **What is Cucumber?**
   Cucumber is a tool for running automated tests written in plain language. It bridges the gap between business and technical teams by using Gherkin language for test cases.

4. **What is JMeter?**
   JMeter is an open-source load testing tool for analyzing and measuring the performance of various services, with a focus on web and network applications.

5. **What is the lifecycle of JUnit?**
   The lifecycle includes annotated methods such as `@BeforeAll`, `@BeforeEach`, `@Test`, `@AfterEach`, and `@AfterAll`, defining setup, test execution, and teardown phases.

   - **@BeforeAll**: Executes once before all the test methods in the class.
   - **@BeforeEach**: Executes before each test method.
   - **@Test**: The test method where the actual testing occurs.
   - **@AfterEach**: Executes after each test method.
   - **@AfterAll**: Executes once after all the test methods have been executed.

6. **Is `@BeforeAll` method should be Class level (static)?**
   Yes, `@BeforeAll` is typically static as it runs once before all tests in the class, requiring class-level scope.

7. **What is Mockito? And what are its limitations?**
   Mockito is a mocking framework for unit tests in Java. Limitations include inability to mock private methods, final classes, or static methods directly. It's complemented by tools like PowerMock for such cases.

8. **What is `@Mock` and what is `@InjectMocks`?**
   `@Mock` creates mock instances of classes. `@InjectMocks` creates an instance of a class and injects mocks created with `@Mock` into it.

   ```java
   @ExtendWith(MockitoExtension.class)
   public class UserServiceTest {
   
       @Mock
       private UserRepository userRepository;
   
       @InjectMocks
       private UserService userService;
   
       @Test
       public void testFindUserByEmail() {
           // Setup our mock repository
           String email = "user@example.com";
           User mockUser = new User(email);
           when(userRepository.findByEmail(anyString())).thenReturn(mockUser);
   
           // Execute the service call
           User returnedUser = userService.findUserByEmail(email);
   
           // Assert the response
           assertNotNull(returnedUser);
           assertEquals(email, returnedUser.getEmail());
       }
   }
   
   ```

   

9. **What is stubbing (define behaviors)?**
   Stubbing defines the behavior of mocks, specifying return values or actions in response to method calls during tests.

10. **What is Mockito ArgumentMatchers?**
       ArgumentMatchers allow specifying flexible argument conditions when stubbing methods, enabling mocks to respond to a wider range of inputs.

11. **What is Hamcrest Matchers?**
       Hamcrest Matchers provide a library of matcher objects for asserting conditions in tests, offering readable and flexible testing assertions.

12. **Do you know `@Spy`? What is the difference between `@Spy` and `@Mock`?**
       `@Spy` partially mocks an object, spying on real methods unless overridden. `@Mock` creates a complete mock. `@Spy` is used for real objects with some overridden behavior.

13. **What is assertion?**
       Assertions are statements in test code used to check if the test's conditions meet the expected outcomes, validating correctness.

14. **If you have developed a new feature, how many types of tests for this feature?**
       Types include unit tests, integration tests, system tests, and acceptance tests, each serving different purposes from verifying small units to entire workflows.