//package features.lambda;
//
//@FunctionalInterface
//interface Foo {
//    String aMethod(String string);
//
//    default String defaultBar() {
//        String s = "default Bar method";
//        System.out.println(s);
//        return s;
//    }
//
//    default String defaultCommon() {
//        String s = "defaultCommon from Bar";
//        System.out.println(s);
//        return s;
//    }
//}
//
//
//
//
//
//class LambdaLearn {
//    @Test
//    public void overrideFoo() {
//        Foo fooByIC = new Foo() {
//            @Override
//            public String aMethod(String string) {
//                return string + " from Foo";
//            }
//        };
//
//        String hello = fooByIC.aMethod("hello");
//        System.out.println(hello);
//    }
//
//    @Test
//    public void lambdaFoo() {
//        Foo foo = parameter -> parameter + " from Foo";
//
//        String hello = foo.aMethod("hello");
//        System.out.println(hello);
//    }
//
//    @Test
//    public void lambdaFoo2() {
//        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";
//
//        String hello = foo.aMethod("hello");
//        System.out.println(hello);
//    }
//
//    @Test
//    public void testFinal() {
//        final String localVariable = "Local";
//        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
//        };
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    @Test
//    public void testEffectivelyFinal() {
//        String localVariable = "Local";
//        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
//        };
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    @Test
//    public void testFinal21() {
//        String localVariable = "Local";
//        localVariable = "LOCAL";
//
//        Foo foo = parameter -> {
////            return parameter + " " + localVariable;
//            return parameter;
//        };
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    @Test
//    public void testFinal22() {
//        String localVariable = "Local";
//
//        Foo foo = parameter -> {
////            return parameter + " " + localVariable;
//            return parameter;
//        };
//
//        localVariable = "LOCAL";
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    @Test
//    public void testFinal3() {
//        List<Employee> employees = EmployeeData.getEmployees();
//
//        Employee employee = employees.get(0);
//        employee.setAge(55);
//        Foo foo = parameter -> {
//            return parameter + " " + employee;
//        };
//
//        System.out.println(foo.aMethod("hello"));
//    }
//}
