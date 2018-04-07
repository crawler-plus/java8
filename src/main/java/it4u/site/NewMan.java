package it4u.site;

import java.util.Optional;

public class NewMan {

    // 把女神包装在optional中
    private Optional<Godness> godness = Optional.empty();

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan() {
    }

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "godness=" + godness +
                '}';
    }
}
