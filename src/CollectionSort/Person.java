package CollectionSort;

public class Person {
    private String name;
    private int handsome;

    public Person(String name, int handsome) {
        this.name = name;
        this.handsome = handsome;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHandsome() {
        return handsome;
    }

    public void setHandsome(int handsome) {
        this.handsome = handsome;
    }

    @Override
    public String toString() {
        return "姓名" + this.name + " 指数" + this.handsome;
    }
}
