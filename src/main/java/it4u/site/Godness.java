package it4u.site;

public class Godness {

    private String name;

    public Godness(String name) {
        this.name = name;
    }

    public Godness() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }
}
