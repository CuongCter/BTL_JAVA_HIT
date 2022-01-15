package Basic;

public class Laptop {
    private int id;
    private String name;
    private String branch;
    private String material;
    private String CPU;
    private String RAM;
    private String display;
    private String generation;
    private int price;
    private int inventory;

    public Laptop() {
    }

    public Laptop(int id, String name, String branch, String material, String CPU, String RAM, String display, String generation, int price, int inventory) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.material = material;
        this.CPU = CPU;
        this.RAM = RAM;
        this.display = display;
        this.generation = generation;
        this.price = price;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", material='" + material + '\'' +
                ", CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", dispaly='" + display + '\'' +
                ", generation='" + generation + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                '}';
    }
}
