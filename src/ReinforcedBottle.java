public class ReinforcedBottle extends Bottle {
    private double ratio;

    public ReinforcedBottle(int id, String name, int capacity, long price, double ratio) {
        super(id, name, capacity, price);
        this.ratio = ratio;
    }

    @Override
    public void usedBy(Adventure adventurer) {
        adventurer.setHitPoint(adventurer.getHitPoint()
                + (int) Math.floor(super.getCapacity() * (1 + ratio)));
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + super.getId() + " belongs to ReinforcedBottle"
        );
    }
}
