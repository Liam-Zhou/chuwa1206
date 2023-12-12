/**
 * Demostrate the use of inheritance
 */
public class RolePlayGame extends VideoGame{
    public RolePlayGame(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Playing " + this.getName() + " as a role play game");
    }
}
