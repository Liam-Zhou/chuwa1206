### Three types of annotations:

- General purpose annotation 
    - `@Override`: used to indicate the method override the method in its parent class.
    - `@Deprecated`: used to indicated the method is not recommended to be used.
    - `@SuppressWarnings`: used to ignore all warnings comes from compiler. 
    - `@FunctionalInterface`: indicate the interface can only have one abstract method. Used to implement lambda function.
    

- Meta Annotation (used to annotate custom annotation)
https://blog.csdn.net/Mrs_chens/article/details/90899885
    - `@Target`:
        - `ElementType.TYPE`：能修饰类、接口或枚举类型
        - `ElementType.FIELD`：能修饰成员变量
        - `ElementType.METHOD`：能修饰方法
        - `ElementType.PARAMETER`：能修饰参数
        - `ElementType.CONSTRUCTOR`：能修饰构造器
        - `ElementType.LOCAL_VARIABLE`：能修饰局部变量
        - `ElementType.ANNOTATION_TYPE`：能修饰注解
        - `ElementType.PACKAGE`：能修饰包
    - `@Retention`:
        - `RetentionPolicy.SOURCE`： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
        - `RetentionPolicy.CLASS`： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
        - `RetentionPolicy.RUNTIME`： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解通常用这种方式
    - `@Inherited`: 
        ```java
        public class DBUtilChild extends DBUtil {}
        JDBCConfig config = DBUtilChild.class.getAnnotation(JDBCConfig.class);
        ```
    - `@Documented`: Allow javadoc to auto generate documentation for the annotated class
    - `@Repeatable`: indicate that an annotation can be used more than once.
        ```java
        @Target(  METHOD )
        @Retention( RetentionPolicy.RUNTIME )
        @Repeatable( FileTypes.class )
        public @interface FileType {
            String value();
        };
    
        @FileType( ".java" )
        @FileType( ".html" )
        public void work(){}
        ```
    
    
- Custom annotation (third party annotation)


```markdown
For all annotations, there can be

- Marker Annotations  - without any member: @Overrride
- Single-Valued Annotations - with single member: @SuppressWarnings(”Unchecked”)
- Multi-Valued Annotations - with more than one member
```
