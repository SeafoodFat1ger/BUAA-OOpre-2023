public class RegularEquipment extends Equipment {
    public RegularEquipment(int id, String name, int star, long price) {
        super(id, name, star, price);
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Commodity whose id is " + super.getId() + " belongs to RegularEquipment"
        );
    }

}
