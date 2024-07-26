class Bottle implements Commodity {
    private int id;
    private String name;
    private int capacity;
    private long price;
    private boolean isFilled;

    public Bottle(int id, String name, int capacity, long price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.isFilled = true;
        this.price = price;
    }

    public void usedBy(Adventure adventurer) {
        adventurer.setHitPoint(adventurer.getHitPoint() + capacity);
    }

    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setFilled(boolean filled) {
        this.isFilled = filled;
    }

    @Override
    public void printInfo() {
    }

    @Override
    public long getPrice() {
        return price;
    }
}
