public class CritEquipment extends Equipment {
    private int critical;

    public CritEquipment(int id, String name, int star, long price, int critical) {
        super(id, name, star, price);
        this.critical = critical;

    }

    @Override
    public void usedBy(Adventure a1, Adventure a2) {
        a2.setHitPoint(a2.getHitPoint() - super.getStar() * a1.getLevel() - critical);
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + super.getId() + " belongs to CritEquipment"
        );
    }
}
