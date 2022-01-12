package Program;


import Basic.Bill;
import Basic.Laptop;
import Basic.Person;
import Controller.BillController;
import Controller.PersonController;
import Controller.StoreController;
import Data.DataStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {

    private static Person person ;
    private static StoreController storeController = new StoreController();
    private static PersonController personController = new PersonController();
    private static BillController billController = new BillController();
    private static Scanner sc = new Scanner(System.in);



    //    private static List<Person> persons = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        StoreController storeController = new StoreController();
        List<Laptop> laptop = storeController.readStoreFromFile("LaptopStore.DAT");
//        laptop.add(new Laptop(1,"Dell G3","Dell", "Nhua" , "I7" , "8G" , "SDD 512G", "10th" , 26000000 , 10 ));
//        laptop.add(new Laptop(2,"Acer Trion 300","Acer", "Nhua" , "I7" , "16G" , "SDD 512G", "11th" , 39000000 , 10 ));
//        laptop.add(new Laptop(3,"Acer Nitro 5","Acer", "Nhua" , "I7" , "8G" , "SDD 512G", "11th" , 28000000 , 10 ));
//        laptop.add(new Laptop(4,"Asus TUF Gaming","Asus", "Nhua" , "I5" , "8G" , "SDD 256G", "10th" , 20990000 , 10 ));
//        laptop.add(new Laptop(5,"Acer Aspire 7","Acer", "Nhom" , "Ryzen 5" , "8G" , "SDD 256G", "10th" , 21490000 , 10 ));
//        laptop.add(new Laptop(6,"HP 240 G8","HP", "Nhom" , "I5" , "8G" , "SDD 256G", "11th" , 17290000 , 10 ));
//        storeController.writeStoreToFile(laptop, "LaptopStore.DAT");

        PersonController personController = new PersonController();
//        FileWriter fileWriter = new FileWriter("Person.DAT", true);
        List<Person> person = personController.readPersonsFromFile("Person.DAT");
//        person.add(new Person(1, "vancuong442002", "vancuong", "vancuong442002@gmail.com", "Van Cuong", "0123456789", "admin"));
//        person.add(new Person(2, "vancuong442001", "vancuong1", "vancuong442001@gmail.com", "Van Cuong 1", "0123456780", "customer"));
//        person.add(new Person(3, "vancuong442003", "vancuong2", "vancuong442003@gmail.com", "Van Cuong 2", "0123456781", "customer"));
//        person.add(new Person(4, "vancuong442004", "vancuong3", "vancuong442004@gmail.com", "Van Cuong 3", "0123456782", "customer"));
//        personController.writeUsersToFile(person, "Person.DAT");

//        FileWriter fileWriter = new FileWriter("Admin.DAT", true);
//        List<Person> person = personController.readPersonsFromFile("Admin.DAT");
//        person.add(new Person(1, "vancuong442002", "vancuong", "vancuong442002@gmail.com", "Van Cuong", "0123456789", "admin"));
//        personController.writeUsersToFile(person, "Admin.DAT");

        BillController billController = new BillController();
//        FileWriter fileWriter = new FileWriter("Bill.DAT", true);
        List<Bill> bill = billController.readBillFromFile("Bill.DAT");

        Check();
    }


    private static void Check() throws IOException {
        int x;
        do{
            System.out.println("1. Dang nhap ");
            System.out.println("2. EXIT ");
            x=sc.nextInt();
            switch (x){
                case 1:
                    Login();
                    System.out.println();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong co lua chon phu hop  ");
                    break;
            }
        }while(x!=1 && x!=2);
    }

    private static void Login() throws IOException {
        List<Person> persons = personController.readPersonsFromFile(DataStore.FILE_PERSON);
        String TK, MK;
        sc.nextLine();
        System.out.println("Nhap tai khoan ");
        TK = sc.nextLine();
        System.out.println("Nhap mat khau  ");
        MK = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getUserName().compareTo(TK) == 0 && persons.get(i).getPassWord().compareTo(MK) == 0) {
                check = true;
                System.out.println("Ban da dang nhap thanh cong, Ban dang la " + persons.get(i).getPermission());
                if(persons.get(i).getPermission().compareTo("admin")==0){
                    AdminDo();
                }else {
                    CustomerDo();
                }
                if (check == false) {
                    System.out.println("Ban da nhap sai hay dang nhap lai");
                }
            }


        }

    }

    private static void CustomerDo() throws IOException{
        System.out.println("------------CUSTOMER--------------");
        System.out.println("1. Xem cac toan bo laptop cua cua hang.");
        System.out.println("2. Tim kiem.");
        System.out.println("3. Mua hang.");
        System.out.println("4. Xem hóa don");
        System.out.println("0. Thoat");
        int x;
        do{
            System.out.println("Nhap lua chon cua ban");
            x = sc.nextInt();
            switch (x) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lua chon khong phu hop");
            }
        }while(x<0||x>4);
    }


    private static void AdminDo() throws IOException {
        System.out.println("------------ADMIN--------------");
        System.out.println("1. Xem cac toan bo laptop cua cua hang.");
        System.out.println("2. Xem thong tin hoa don.");
        System.out.println("3. Xem thong tin khach hang.");
        System.out.println("4. Sap xep san pham theo ID hoac gia tien");
        System.out.println("5. Tim kiem san pham.");
        System.out.println("6. Them san pham vao cua hang shop.");
        System.out.println("7. Xoa san pham khoi cua hang.");
        System.out.println("8. Xem doanh thu cua hang.");
        System.out.println("0. Thoat");
        int x;
        List<Laptop> laptops = new ArrayList<>();
        List<Bill> bills = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        do{
            System.out.println("Nhap lua chon cua ban");
            x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("Show Laptop: ");
                    ShowLaptop(laptops);
                    break;
                case 2:
                    System.out.println("Show Bill: ");
                    ShowBill(bills);
                    break;
                case 3:
                    System.out.println("Show Information Customer: ");
                    ShowInfo(people);
                    break;
                case 4:
                    System.out.println("Sap xep san pham: ");
                    SortLaptop(laptops);
                    break;
                case 5:
                    System.out.println("Tim kiem: ");
                    FindLaptop(laptops);
                    break;
                case 6:
                    System.out.println("Them mat hang: ");
                    AddLaptop(laptops);
                    break;
                case 7:
                    System.out.println("Xoa mat hang: ");
                    DeleteLaptop(laptops);
                    break;
                case 8:
                    System.out.println("Xem doanh thu: ");
                    ShowTurnover(bills);
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong phu hop");
            }
        }while(x<0||x>9);


    }

    private static void ShowTurnover(List<Bill> bills) {
    }

    private static void DeleteLaptop(List<Laptop> laptops) {
    }

    private static void AddLaptop(List<Laptop> laptops) {

    }

    private static void FindLaptop(List<Laptop> laptops) throws IOException{
        System.out.println("Cac loai hinh tim kiem laptop");
        int x;
        do {
            System.out.println("Moi ban lua chon hinh thuc: ");
            System.out.println("1. Theo ID");
            System.out.println("2. Theo theo hang");
            System.out.println("3. Theo ten");
            x= sc.nextInt();

            switch (x){
                case 1:
                    System.out.println("Tim kiem theo ID");
                    FindID(laptops);
                    break;
                case 2:
                    System.out.println("Tim kiem theo hang");
                    FindBranch(laptops);
                    break;
                case 3:
                    System.out.println("Tim kiem theo ten");
                    FindName(laptops);
                    break;
                default:
                    System.out.println("Lua chon khong phu hop");

            }
        }while(x<1||x>3);
    }

    private static void FindID(List<Laptop> laptops) {
    }

    private static void FindName(List<Laptop> laptops) throws IOException {
        sc.nextLine();
        System.out.println("Nhap ten can tim: ");
        String x;
        x = sc.nextLine();
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        System.out.println("San pham can tim: ");
        int cnt=0;
        for (int i=0;i<laptops.size();i++) {
            if (laptops.get(i).getBranch().compareTo(x) == 0) {
                System.out.println(laptops.get(i));
                cnt++;
            }
            if (cnt == 0) {
                System.out.println("Khong tim thay san pham ");
            }
        }

    }

    private static void FindBranch(List<Laptop> laptops) throws IOException {
            sc.nextLine();
        System.out.println("Nhap hang can tim: ");
        String x;
        x = sc.nextLine();
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        System.out.println("San pham can tim: ");
        int cnt = 0;
        for (int i=0;i<laptops.size();i++){
            if (laptops.get(i).getBranch().compareTo(x)==0){
                cnt++;
                System.out.println(laptops.get(i));
            }
            if(cnt==0){
                System.out.println("Khong tim thay san pham nao");
            }
        }
    }

  
    private static void ShowLaptop(List<Laptop> laptops) throws IOException{
        laptops = storeController.readStoreFromFile("LaptopStore.DAT");
        for(int i=0;i<laptops.size();i++){
            System.out.println(laptops.get(i));
        }
    }
    private static void ShowBill(List<Bill> bills) throws IOException{
        bills = billController.readBillFromFile("Bill.DAT");
        for(int i=0;i<bills.size();i++){
            System.out.println(bills.get(i));
        }
    }
    private static void ShowInfo(List<Person> people) throws IOException{
        people = personController.readPersonsFromFile("Person.DAT");
        for(int i=0;i<people.size();i++){
            System.out.println(people.get(i));
        }
    }
    private static void SortLaptop(List<Laptop> laptops) throws IOException{
        System.out.println("Ban muon sap xep theo kieu nao");
        int x;
        do {
            System.out.println("Moi lua chon loai hinh sap xep: ");
            System.out.println("1. Theo ID");
            System.out.println("2. Theo gia tien");
            x= sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("Sap xep theo ID");
                    SortID(laptops);
                    break;
                case 2:
                    System.out.println("Sap xep theo gia tien");
                    SortPrice(laptops);
                    break;
                default:
                    System.out.println("Lua chon khong phu hop");
                    
            }
        }while(x<1||x>2);



    }

    private static void SortPrice(List<Laptop> laptops) throws IOException{
        System.out.println("Sap xep mat hang theo tien: ");
        for(int i=0;i<laptops.size();i++){
            for(int j=i+1;j<laptops.size();j++){
                if(laptops.get(i).getPrice() > laptops.get(j).getPrice()){
                    Laptop temp = laptops.get(i);
                    laptops.set(i,laptops.get(j));
                    laptops.set(j,temp);
                }
            }
        }
        storeController.writeStoreToFile(laptops,"LaptopStore.DAT");
        ShowLaptop(laptops);
    }

    private static void SortID(List<Laptop> laptops) throws IOException{
        System.out.println("Sap xep mat hang theo ID: ");
        for(int i=0;i<laptops.size();i++){
            for(int j=i+1;j<laptops.size();j++){
                if(laptops.get(i).getId() > laptops.get(j).getId()){
                    Laptop temp = laptops.get(i);
                    laptops.set(i,laptops.get(j));
                    laptops.set(j,temp);
                }
            }
        }
        storeController.writeStoreToFile(laptops,"LaptopStore.DAT");
        ShowLaptop(laptops);
    }

}


