public class Bottle {
    private int id;
    private String name;
    private int capacity;
    private boolean isFilled;

    public Bottle(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.isFilled = true;
    }

    public String getName() {
        return name;
    }

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
}
