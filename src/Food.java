public class Food implements Commodity {
    private int id;
    private String name;
    private int energy;
    private long price;

    public Food(int id, String name, int energy, long price) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + id + " belongs to Food"
        );
    }

    public int getId() {
        return id;
    }

    @Override
    public long getPrice() {
        return price;
    }

    public int getEnergy() {
        return energy;
    }
}
