public class Singleton {
    private static Singleton instance;
    public String name;
    private Singleton(){
        name="Single";
        System.out.println("Constructed a Singleton.");
    }
    public static Singleton getSingleton(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
