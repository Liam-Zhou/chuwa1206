# 2. What is a Wrapper Class in Java and Why Do We Need Wrapper Classes?
    A wrapper class in java is a class whose object are used to represent a primitive data type as objects. like int, char, 
# 3. what is difference between HashMap and HashTable?
    both of them are used to store key, value pair
    1. synchronized 
        hashmap is not thread-safe
        hashtable is thread-safe and use single lock

    2. hashtable has lower performance compared with hashamp 
    3. hashtable dones't allow to store null values 
       hashmap allow to store one null key and multiple null values

# 4.What is String Pool in Java and Why Do We Need String Pool?
    string pool is a special memory area in heap to store the value of string. It could conserve memory of usage to reuse string objects from string pool.

# 5.What is java garbage collection? 
    It is a mechinism run by daemon thread in background to destory unreacheable objects. 
    By using GC root to tests the reachability and diving the heap into several areas, jvm could effciently manage its memory usage.

# 6. what is Access Modifiers and Their Scopes in Java?
    it is used to control the visibility or accessbility of classes.
    default: it is visible within packages 
    private: only accessible within the class
    Protected: within packates or all subclasses
    public: accessible from everywhere 

# 7. What is the final Keyword?
    It is a modifier that applies to field, method, class.
    field: value cannot be changed
    method: cannot be overridden by subclasses 
    class: make the class immutable, cannot be inherited 

# 8. what is static keyword? (field, method, class). When do we use it?
    A static member is a member of class that isn't associated with an instance of a class. 
    Static variable only initalized once and shared by all instances.
    static method can be called directly using class name 
    static class: java allow creation of nested classes, a nested class can be declared as static
    It is usally been used in utlity class. 
    
# 9. What is differences between overriding and overloading? 
    overload happens at compile time and override happens at runtime 
    private and final can be overloaded and private and final cannot be overridden 
    It is done in the same class, base and derived classes 

# 10. What is the differences between super and this?
    super: used to refer to the immediate parent class object,
    this: used to refer to the current instance of the class 
    
# 11. What is the Java load sequence?
    refers to the order in which various components of a java program are loaded and initialized. 
    jvm goes throug several steps to load and execute a java program. 
    Loading: load class into the memory
    Linking: ensure class are property formated
             allocate enought memory and initalizeds them with deafult values
             replace symbolic referece with direct reference
    initialization: static variables are initalized, static block is executed 
    main method execution: the class being executed is the entry point of program
    deinitalization: when finish executing program, jvm will destory the class object 

# 12. What is Polymorphism ? And how Java implements it ?
    objects can exhibit different forms and behaviors
    refer to the Q1 class for code example

# 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
    Integrate variables and methods into a single unit within a class 
    refer to the Q1 class for code example 

# 14. What is Interface and what is abstract class? What are the differences between them?
    abstract classes are used when there is some common behavior that all subclasses must share
    Interfaces are used when there is a set of behaviors that all subclasses must support, but the implementation details can vary
    class can implment multiple interfaces but only extend one abstract class 
    all methods in interface are abstract but could be non-abstract within abstract class 
    Members of a Java interface are public by default. A member of an abstract class can either be private, protected or public


# 16. What are Queue interface implementations and what are the differences and when to use what?
    the Queue interface in Java represents a collection designed for holding elements
    follow the First-In-First-Out (FIFO) principle
    enqueued: add the element at the end 
    dequeued: remoe the lement from the front
    Linkedlist: the memoery allocation of elements in the linkedlist is not continuous. Each is connected by pointer
    ArrayList: the memory allocation is continuous. We could randomly access element by using index.
    PriorityQueue: element are sorted on a priority heap 
    If you perform lots of modification, use linkedlist.
    If you want to search element, use array for fast access.