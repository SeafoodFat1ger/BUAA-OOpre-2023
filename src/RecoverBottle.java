public class RecoverBottle extends Bottle {
    private double ratio;

    public RecoverBottle(int id, String name, int capacity, long price, double ratio) {
        super(id, name, capacity, price);
        this.ratio = ratio;
    }

    @Override
    public void usedBy(Adventure adventurer) {
        adventurer.setHitPoint(adventurer.getHitPoint()
                + (int) Math.floor(adventurer.getHitPoint() * ratio));
    }

    @Override
    public void printInfo() {
        System.out.println("Commodity whose id is " + super.getId() + " belongs to RecoverBottle");
    }
}
