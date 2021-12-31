package Controller;

import Basic.Bill;
import Basic.Laptop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillController {
    private Bill bill = new Bill();
    private FileController fileController = new FileController();

    public BillController() {
    }

    public BillController(Bill bill, FileController fileController) {
        this.bill = bill;
        this.fileController = fileController;
    }
    public List<Bill> readBillFromFile(String filename) throws IOException{
        fileController.OpenFileToRead(filename);
        List<Bill> bills = new ArrayList<>();

        while(fileController.getScanner().hasNext()){
            String data = fileController.getScanner().nextLine();
            String[] a = data.split("\\|");
            ArrayList<Laptop> laptop = new ArrayList<>();
            for(int i=0;i<a.length;i++){
                laptop.add(new Laptop())
            }
            bills.add(new Bill())

        }
    }
}
