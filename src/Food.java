public class Food {
    private int id;
    private String name;
    private int energy;

    public Food(int id, String name, int energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getEnergy() {
        return energy;
    }
}
