package Basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Bill {
    private int idBill;
    private int idPerson;
    private List<Laptop> laptops = new ArrayList<>();
    private double promotion;
    private int totalMoney;
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();

    public Bill() {
    }

    public Bill(int idBill, int idPerson, List<Laptop> laptops, double promotion, int totalMoney, Date date) {
        this.idBill = idBill;
        this.idPerson = idPerson;
        this.laptops = laptops;
        this.promotion = promotion;
        this.totalMoney = totalMoney;
        this.cal = cal;
        this.date = date;
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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public double getPromotion() {
        return promotion;
    }

    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", idPerson=" + idPerson +
                ", laptops=" + laptops +
                ", promotion=" + promotion +
                ", totalMoney=" + totalMoney +
                ", date=" + date +
                '}';
    }
}
