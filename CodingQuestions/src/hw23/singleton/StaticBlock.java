package hw23.singleton;

public class StaticBlock {
    private static final StaticBlock instance;

    static{
        try{
            instance=new StaticBlock();
        }catch (Exception e){
            throw new RuntimeException("error when creating singleton");
        }
    }

    private StaticBlock(){}

    public static StaticBlock getInstance(){
        return instance;
    }

}
