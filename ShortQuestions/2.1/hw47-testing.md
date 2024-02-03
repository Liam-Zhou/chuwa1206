# 1
Done

# 2
Selenium is an open-source automation testing framework primarily used for automating web applications for testing purposes, but it can also be used for automating web-based administrative tasks. It provides a set of tools and a domain-specific language (DSL) to write test scripts in various programming languages, including Java, C#, Python, Ruby, and JavaScript.

# 3
Cucumber is an open-source software testing tool that supports Behavior-Driven Development (BDD). It allows software development teams to describe how software should behave in plain text. The text is written using Gherkin, a business-readable domain-specific language (DSL). This approach allows the documentation of software behavior to be easily understood by all stakeholders, including non-technical participants.

# 4
Apache JMeter is an open-source software application designed primarily for performance testing and measuring the functional behavior and performance of web applications.

# 5
- @BeforeAll: Execute the annotated method once before all the test methods.
- @AfterAll: Execute the annotated method once after all the test methods.
- @BeforeEach: Execute the annotated method before each test method.
- @AfterEach: Execute the annotated method after each test method.
- @TestInstance(TestInstance.Lifecycle.PER_CLASS): create just one instance of the test class and reuse it for all tests, which allows for non-static @BeforeAll and @AfterAll.

# 6
In JUnit5, when TestInstance.Lifecycle.PER_METHOD, then @BeforeAll should be class level. When TestInstance.Lifecycle.PER_CLASS, then @BeforeAll can be non-static.

# 7
## What is Mockito
Mockito is a popular open-source Java mocking framework used in unit testing. It allows developers to create and configure mock objects that simulate the behavior of real-world objects in a controlled way. Mockito is particularly used for testing classes in isolation by mocking their dependencies. 

## Limitation
- Cannot mock private, final, or static methods. Cannot mock constructors or final classes
- Limitations in real object testing
- Overuse can lead to poor design

## Complementary tools
- PowerMock: extends the capabilities of Mockito and allows mocking of static and private methods, final classes, and more.
- JUnit
- AssertJ
- Spring Test

# 8
- @Mock creates a mock instance of the class or interface.
- @InjectMocks inject mock or spy objects into the tested class.

# 9
Define custom behavior for methods on mock objects.

# 10
It allows you to specify flexible rules for the arguments passed to methods when you are stubbing or verifying method calls.

# 11
Hamcrest Matchers are a framework for writing matcher objects in Java, allowing for more expressive and readable code, especially in the context of writing assertions in tests. They are commonly used in conjunction with unit testing frameworks like JUnit and TestNG. Hamcrest provides a rich set of predefined matchers and the ability to create custom matchers, enhancing the readability and maintainability of test code.

# 12
@Spy creates a spy instance of the class that follow the real implementation in the class being spied upon. The primary purpose of a spy is to allow you to stub only certain methods of an object while keeping the rest of the original behavior. This is in contrast to a standard mock (@Mock), where all methods are stubbed and don't perform any real operations unless explicitly defined.

# 13
In testing, Assertion is a statement that checks whether a condition is true.

# 14
- Unit Test: By Dev
- Integration Test: By Dev
- Regression Test: By Dev 
- Performance Test: By QA
- Stress Test: By QA
- User Acceptance Test: By users

# 15
check `CodingQuestions/2.1/CommentServiceImplTest.java`

# 16
check `CodingQuestions/2.1/PostControllerTest.java`

