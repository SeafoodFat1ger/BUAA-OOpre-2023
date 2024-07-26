public class RegularBottle extends Bottle {
    public RegularBottle(int id, String name, int capacity, long price) {
        super(id, name, capacity, price);
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + super.getId() + " belongs to RegularBottle"
        );
    }
}
