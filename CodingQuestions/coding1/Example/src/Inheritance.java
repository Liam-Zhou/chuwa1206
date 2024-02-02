public class Inheritance {
    public static void main(String[] args) {
        /*
            Inheritance means that we can extend or implement the parent class or interface

            One class can only extend one parent class

            One interface can extend one or more interface

            one class can implements one or more interface
         */
    }
    interface Window{}
    interface Door{}
    // One interface can extend one or more interface
    interface Car extends Window, Door{
        void print();
    }
    class Car1 implements Car, Door{
        @Override
        public void print() {
            System.out.print("This implements one or more interface");
        }
    }
    class Audi extends Car1 {
        @Override
        public void print() {
            System.out.println("Audi only extend one class");
        }
    }



}
