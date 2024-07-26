class Equipment implements Commodity {
    private int id;
    private String name;
    private int star;
    private long price;

    public Equipment(int id, String name, int star, long price) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void usedBy(Adventure a1, Adventure a2) {
        a2.setHitPoint(a2.getHitPoint() - star * a1.getLevel());
    }

    @Override
    public void printInfo() {
    }

    @Override
    public long getPrice() {
        return price;
    }
}
