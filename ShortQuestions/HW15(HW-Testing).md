### What is Selenium?
Selenium is an open-source automated testing framework used for web applications across different browsers and platforms. It allows testers to write tests in several programming languages, including Java, C#, Python, etc. Selenium supports automation of web browser actions, enabling developers to create robust, browser-based regression automation suites and tests.

### What is Cucumber?

Cucumber is a software tool for testing other software. It runs automated acceptance tests written in a behavior-driven development (BDD) style. Cucumber allows the execution of feature documentation written in business-facing text.

### What is JMeter?

Apache JMeter is an open-source, Java-based software designed to load test functional behavior and measure performance. Originally designed for testing Web Applications, JMeter has expanded to other test functions. It's widely used for analyzing and measuring the performance of a variety of services.

### What is the lifecycle of JUnit?

JUnit is a popular Java testing framework that provides annotations to identify test methods. The lifecycle of a JUnit test includes:

- @BeforeClass (runs once before all tests)
- @Before (runs before each test)
- @Test (runs the test case)
- @After (runs after each test)
- @AfterClass (runs once after all tests are completed)

### Is @BeforeAll method should be Class level (static)?

Yes, the @BeforeAll annotation in JUnit 5 requires the method it annotates to be static because it runs before all test methods in the class and without an instance of the class being created.

### What is Mockito? And what are its limitations?

Mockito is a popular mocking framework for unit tests in Java. Limitations of Mockito include the inability to mock private methods, final classes, or static methods directly. It focuses on interactions between objects by returning mock responses from calls to methods of dependencies. Tools like PowerMock can help overcome some of Mockito’s limitations by allowing the mocking of static and private methods.

### What is @Mock and what is @InjectMocks?

- @Mock is used to create and inject mocked instances without having to manually instantiate them.
- @InjectMocks is used to create instances of a class and injects mocks that are created with the @Mock (or @Spy) annotations into this instance

### What is stubbing (define behaviors)?

Stubbing is a feature provided by mocking frameworks like Mockito that allows the user to define the behavior of a mock or spy object for a particular method call. It specifies return values or exceptions to throw when the methods of the mock objects are invoked.

### What is Mockito ArgumentMatchers?

ArgumentMatchers allow specifying flexible argument matching in Mockito when stubbing methods or verifying method calls. They can match any argument of a given type, specific argument values, or even complex conditions.

### What is Hamcrest Matchers?

Hamcrest is a framework for writing matcher objects, allowing 'match' rules to be defined declaratively. Used extensively for writing assertions in tests, Hamcrest matchers provide a more readable and fluent way to write assertions compared to traditional assertion mechanisms.

### Do you know @Spy? What is the difference between @Spy and @Mock?

- @Spy is used to create a spy instance. Spies are copies of the real object and retain the original behavior but allow overriding some behaviors.
- The difference between @Spy and @Mock is that @Mock creates a complete mock or dummy object, while @Spy wraps a real object and allows calling all the normal methods of the object while still being able to track interactions with it.

### What is assertion?

Assertions are statements in test code that test whether a condition is true. They are used to verify that the system under test behaves as expected. If an assertion evaluates to false, the test method will fail.


### If you have developed a new feature, how many types of tests for this feature?

For a new feature, several types of tests can be written, including:

- Unit tests to test individual components or functions.
- Integration tests to ensure that different parts of the application work together correctly.
- Functional tests to test the feature from an end-user perspective.
- Performance tests to verify the feature performs well under load.
- Security tests to ensure the feature does not introduce security vulnerabilities.