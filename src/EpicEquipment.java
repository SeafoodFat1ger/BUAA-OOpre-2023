public class EpicEquipment extends Equipment {
    private double ratio;

    public EpicEquipment(int id, String name, int star, long price,double ratio) {
        super(id, name, star, price);
        this.ratio = ratio;

    }

    @Override
    public void usedBy(Adventure a1, Adventure a2) {
        a2.setHitPoint(a2.getHitPoint() - (int) Math.floor(a2.getHitPoint() * ratio));
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + super.getId() + " belongs to EpicEquipment"
        );
    }
}
