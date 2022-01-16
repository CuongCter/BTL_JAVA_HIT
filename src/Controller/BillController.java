package Controller;

import Basic.Bill;
import Basic.Laptop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
        StoreController storeController = new StoreController();
        while(fileController.getScanner().hasNext()){
            String data = fileController.getScanner().nextLine();
            String[] a = data.split("\\|");
            ArrayList<Laptop> laptop = new ArrayList<>();
            for(int i=2;i<a.length-2;i++){
                laptop.add(storeController.getlaptopBuy(Integer.parseInt(a[i])));
            }
            bills.add(new Bill(Integer.parseInt(a[0]), Integer.parseInt(a[1]),laptop, Double.parseDouble(a[a.length-2]),a[a.length-1]));

        }
        fileController.CloseFileAfterRead(filename);

        return bills;
    }
    public void writeBillToFile(List<Bill> bills, String filename) throws IOException {

        fileController.OpenFileToWrite(filename);
        for(Bill bill : bills) {
            String s = "";
            for (int j=0;j<bill.getLaptop().size();j++){
                s += bill.getLaptop().get(j).getId();
            }
            fileController.getPrintWriter().println(bill.getIdBill() + "|" + bill.getIdPerson() + "|" + s +  "|" + bill.getDate()) ;
        }

        fileController.CloseFileAfterWrite();
    }

    public String Date(){
        Calendar cal = Calendar.getInstance();
        String date = "";
        date = cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
        return date;

    }
}
