# 2. what is selenium?

Open-source framework for automating web application testing across browsers and platforms.
Simulates user interactions like clicking, typing, and navigation.
Used for functional testing, regression testing, and cross-browser compatibility testing.

# 3. what is cucumber?

Behavior-driven development (BDD) tool using a natural language syntax for test cases.
Encourages collaboration between developers, testers, and non-technical stakeholders.
Improves test readability and maintainability.

# 4. what is JMeter?

Open-source load testing tool to measure performance and analyze web application behavior under load.
Simulates multiple users accessing a website concurrently.
Helps identify performance bottlenecks and ensure scalability.

# 5. What is the life cycle of Junit?

@BeforeClass: Runs once before all test methods in the class (static).
@Before: Runs before each test method.
@Test: Marks a method as a test method.
@After: Runs after each test method.
@AfterClass: Runs once after all test methods in the class (static).

# 6. Is the @BeforeAll method should be Class level(static)?

Yes, it must be a static method at the class level to execute once before all tests in the class.

# 7. What is Mockito? and what are its limitations? what kind of tools can give help?

Mocking framework for creating and controlling mock objects in unit tests.
Limitations: Doesn't handle static methods or final classes well.
Complementary tools: PowerMock, JMockit, or EasyMock for advanced mocking.

# 8. What is @Mock and what is @InjectMocks?

@Mock: Creates a mock object.
@InjectMocks: Injects mock objects into the class under test.

# 9. What is the stubbing (define behaviors)?

Defining specific behaviors for mock objects to control their responses during tests.

# 10. what is Mockito ArgumentMatchers?

Allow flexible argument matching when defining mock behavior.

# 11. what is Hamcrest Matcher?

Library for creating flexible and expressive assertions in tests.

# 12. do you know @spy? what is the difference between @spy and @Mock?

Creates a partial mock that retains original behavior unless overridden.
Difference from @Mock: @Spy preserves original functionality for non-stubbed methods.

# 13. What is assertion?

A statement in a test verifying expected behavior or conditions.

# 14. If you have developed a new feature, how many types of tests for this feature? and what kind of tests are written by you? What is the purpose of each type of test?

Unit tests: Verify individual units of code (functions, classes).
Integration tests: Verify how units work together.
End-to-end tests: Verify complete user flows.

Unit tests: Catch bugs early, ensure code quality.
Integration tests: Ensure components interact correctly.
End-to-end tests: Validate overall user experience.
