package Basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Bill {
    private int idBill;
    private int idPerson;
    private List<Laptop> laptop = new ArrayList<>();
    private double promotion ;
//    Calendar cal = Calendar.getInstance();
//    Date date = cal.getTime();

    public Bill() {
    }

    public Bill(int idBill, int idPerson, List<Laptop> laptop, double promotion, int totalMoney, Date date) {
        this.idBill = idBill;
        this.idPerson = idPerson;
        this.laptop = laptop;
        this.promotion = promotion;

//        this.date = date;
    }

    public Bill(int parseInt, int parseInt1, ArrayList<Laptop> laptop, double parseDouble) {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptops) {
        this.laptop = laptop;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }


//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", idPerson=" + idPerson +
                ", laptop=" + laptop +
                ", promotion=" + promotion +
//                ", date=" + date +
                '}';
    }
}
