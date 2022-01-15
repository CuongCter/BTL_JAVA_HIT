package Controller;

import Basic.Laptop;
import Basic.Person;
import Data.DataStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreController {
    private Laptop laptop = new Laptop();
    private FileController fileController = new FileController();

    public StoreController() {
    }

    public StoreController(Laptop laptop, FileController fileController) {
        this.laptop = laptop;
        this.fileController = fileController;
    }
    public List<Laptop> readStoreFromFile(String filename) throws IOException{
        fileController.OpenFileToRead(filename);
        List<Laptop> laptops = new ArrayList<>();
        while (fileController.getScanner().hasNext()){
            String data = fileController.getScanner().nextLine();
            String[] a = data.split("\\|");
            laptops.add(new Laptop(Integer.parseInt(a[0]),a[1], a[2], a[3], a[4], a[5], a[6], a[7], Integer.parseInt(a[8]),Integer.parseInt(a[9])));
        }
        fileController.CloseFileAfterRead(filename);

        return laptops;
    }
    public List<Laptop> writeStoreToFile(List<Laptop> laptops, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Laptop laptop : laptops) {
            fileController.getPrintWriter().println(laptop.getId() + "|" + laptop.getName()+ "|" + laptop.getBranch() +  "|" + laptop.getMaterial() + "|" + laptop.getCPU()+ "|" + laptop.getRAM()+ "|" + laptop.getDisplay()+ "|"+ laptop.getGeneration()+ "|"+ laptop.getPrice()+ "|"+ laptop.getInventory());
        }

        fileController.CloseFileAfterWrite();
        return laptops;
    }
    public Laptop getlaptopBuy(int a) throws IOException {
        List<Laptop> laptops = readStoreFromFile(DataStore.FILE_STORE);
        for(int i=0;i<laptops.size();i++){
            if(a == laptops.get(i).getId()){
                return laptops.get(i);
            }
        }
        return null;
    }


}
