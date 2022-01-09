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
                laptop.add(new Laptop(Integer.parseInt(a[0]),a[1], a[2], a[3], a[4], a[5], a[6], a[7], Integer.parseInt(a[8]),Integer.parseInt(a[9])));
            }
            bills.add(new Bill(Integer.parseInt(a[0]), Integer.parseInt(a[1]),laptop, Double.parseDouble(a[3])));

        }
        fileController.CloseFileAfterRead(filename);

        return bills;
    }
    public void writeBillToFile(List<Bill> bills, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Bill bill : bills) {
            fileController.getPrintWriter().println(bill.getIdBill() + "|" + bill.getIdPerson() + "|" + bill.getLaptop() + "|" + bill.getPromotion() );
        }

        fileController.CloseFileAfterWrite();
    }
}
