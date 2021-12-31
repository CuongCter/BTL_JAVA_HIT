package Basic;

import java.util.ArrayList;

public class Store {
    private ArrayList<Laptop> laptops = new ArrayList<>();

    public Store() {
    }

    public Store(ArrayList<Laptop> laptops) {
        this.laptops = laptops;
    }

    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(ArrayList<Laptop> laptops) {
        this.laptops = laptops;
    }
}
