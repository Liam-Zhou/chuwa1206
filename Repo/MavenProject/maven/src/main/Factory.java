
public abstract class Meal {
    public abstract String getName();

    public void addCondiment() {
        System.out.println("Adding condiments");
    }
}

public class Burger extends Meal {
    @Override
    public String getName() {
        return "Burger";
    }
}

public class Pizza extends Meal {
    @Override
    public String getName() {
        return "Pizza";
    }
}

public class Restaurant {
    public Meal orderMeal(String type) {
        SimpleMealFactory factory = new SimpleMealFactory();

        Meal meal = factory.createMeal(type);

        meal.addCondiment();
        return meal;
    }
}

public class SimpleMealFactory {

    public Meal createMeal(String type) {
        Meal meal = null;
        if (type.equals("burger")) {
            meal = new Burger();
        } else if (type.equals("pizza")) {
            meal = new Pizza();
        } else {
            throw new RuntimeException("Meal type not available!");
        }
        return meal;
    }
}

public class Client {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Meal meal = restaurant.orderMeal("burger");

        System.out.println(meal.getName());
    }
}