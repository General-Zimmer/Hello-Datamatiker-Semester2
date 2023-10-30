package opgaver.opg1;

public class City {
    private final String name;
    private final int inhabitants;

    public City(String name, int inhabitants) {
        this.name = name;
        this.inhabitants = inhabitants;
    }

    @Override
    public String toString() {
        return String.format("%s:%,d", name, inhabitants);
    }
}
