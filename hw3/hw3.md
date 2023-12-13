# 2. What is the checked exception and unchecked exception in Java, could you give one example?
    checked exception is checked at the compile time: like FileNotFoundException
    unchecked exception is checked at the run time: like ArithmeticException
    both exceptions are events that disrupt the normal flow of program. 
# 3. Can there be multiple finally blocks?
    No, only allow for a single 'try-catch' block, A try can be followed at most one 'finally' block
# 4. When both catch and finally return values, what will be the final result?
    finally block is executed regardless of whether an exceptoin occurred or not.
    '''
        public static int getResult() {
        try {
            // Code that may throw an exception
            throw new RuntimeException("Exception in try block");
        } catch (RuntimeException e) {
            System.out.println("Caught exception in catch block");
            return 1; // Value returned from catch block
        } finally {
            System.out.println("Finally block executed");
            return 2; // Value returned from finally block, overrides catch block
        }
        Caught exception in catch block
        Finally block executed
        Result: 2
    }
    '''
# 5. What is Runtime/unchecked exception? What is Compile/Checked Exception?
    uncheked excepton: under runtime excpetion class are unchecked exception
    checked excpetion: the method must be able to handle the exception or using throws keyword
# 6. what is the difference between throw and throws? 
    throw is a keyword which is used to explicitly thorw an excepton in the program, inside a function
    whereas throws is a keyword which isued with the method signature to declare an excpetoin
    using throw keyword, only unchecked exceptions are propagated, whereas using throws keyword both checked and unchecked exceptoins can be propagated

# 7. Why do we put the Null/Runtime exception before Exception ?
    Both exceptoin extends the Exception class and the exceptoin has a large scope. So, any exceptoin will be caught within the exceptoin block and will not reach to other exceptoin blocks.

# 8. What is Optional? Why do you use it? Write an optional example
    optional is used to handle the value might be absent. Provide a more safer way to dealing with potentially null values

# 9. Why finally always be executed?
    the finally block is designed to always be executed, regardless of whether an exception is thrown or not. This behavior is fundamental to the exception handling mechanism in Java
    Cleanup Operations: release memory 
# 10. see collection code practice in the CollecitonPractice folder
    see collection code practice in the CollecitonPractice folder
# 11. What are the types of design patterns in Java ?
    singleton, builder pattern, factory pattern, observer pattern

# 12. what are the SOLID Principles? 
    Single Responsibility Principle: 
        A class should only have one reason to change
    Open-Closed Principle:
        classes should be open for extension but closed for modification 
    Liskov Substition principle
         objects of a superclass should be able to be replaced with objects of a subclass 
    Interface segregation Principle 
        Don't put too much into an interface, split into a separate interface 
    Dependency Inversion
        High-level modules should not depend upon low-level ones
# 13. How can you achieve thread-safe singleton patterns in Java
    we need to use synchronized lock and double checking to achieve thread-safe singleton 
    '''
    static class A {
        private static volatile A instance;
        private A() {}
        public static A getInstance() {
            if (instance == null) {
                synchronized(A.class) {
                    if (instance == null) {
                        instance = new A();
                    }
                }
            }
            return instance;
        }
    }
    '''

    or we could do with nested static class to ahieve the thread-safe singleton 

# 14. What do you understand by the Open-Closed Principle (OCP)
    the behavior of module can be extendted without modifying the souce code
    by using polymorphism, we could supply different class which conform to the same interface to a class without modifying that class behavior
    
    //old
    class Bike {
    public void service() {
        System.out.println("Bike servicing strategy performed.");
    }
    }
    
    class Car {
    public void service() {
    System.out.println("Car servicing strategy performed.");
    }
    }
    
    class Garage {
    public void serviceBike(Bike bike) {
    bike.service();
    }
    
        public void serviceCar(Car car) {
            car.service();
        }
    }

    //adding interfaces 
    interface Vehicle {
    void service();
}
    
    class Bike implements Vehicle {
    @Override
    public void service() {
    System.out.println("Bike servicing strategy performed.");
    }
    }
    
    class Car implements Vehicle {
    @Override
    public void service() {
    System.out.println("Car servicing strategy performed.");
    }
    }
    
    class Garage {
    public void service(Vehicle vehicle) {
    vehicle.service();
    }
    }

# 14: 3

