public class Main {
    public static void main(String[] args) {
        VideoGame videoGame = new VideoGame("Call of Duty", 59.99);
        VideoGame fireEmblem = new RolePlayGame("Fire Emblem", 59.99);
        videoGame.play();
        fireEmblem.play();
    }
}
