package Program;


import Basic.Bill;
import Basic.Customer;
import Basic.Laptop;
import Basic.Person;
import Controller.BillController;
import Controller.PersonController;
import Controller.StoreController;
import Data.DataStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
////        FileWriter fileWriter = new FileWriter("Bill.DAT", true);
        List<Bill> bill = billController.readBillFromFile("Bill.DAT");

        Check();
  }


    private static void Check() throws IOException {

        int x;
        do{
            System.out.println("-----CHAO MUNG BAN DEN VOI LAPTOP CTER ------");
            System.out.println("-----Hay chon chuc nang ban muon--------");
            System.out.println("| 1. Dang nhap Admin/Customer ");
            System.out.println("| 2. Dang ki ");
            System.out.println("| 3. EXIT ");
            x=sc.nextInt();
            switch (x){
                case 1:
                    Login();
                    System.out.println();
                    break;
                case 2:
                    SignUp();
                    System.out.println();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong co lua chon phu hop  ");
                    break;
            }
        }while(x!=1 && x!=2);
    }

    private static void SignUp() throws IOException{
        List<Person> people = personController.readPersonsFromFile(DataStore.FILE_PERSON);
        sc.nextLine();
        String newTK, newMK, newMK2;
        System.out.println("Nhap tai khoan moi: ");
        newTK = sc.nextLine();
        boolean check = true;
        for(int i=0;i<people.size();i++){
            if(people.get(i).getUserName().compareTo(newTK)==0){
                System.out.println("!!! Tai khong khoan hop le");
                check = false;
            }
        }
        if (check==true){
            System.out.println("---Tai khoan hop le --- : ");
            System.out.println("Tao mat khau: ");;
            newMK = sc.nextLine();
            System.out.println("Xac nhan mat khau: ");
            newMK2 = sc.nextLine();
           if(newMK.equals(newMK2)==true){
               System.out.println("Mat khau duoc xac nhan");
               String hoTen,email,phone;
               System.out.println("Nhap ho ten: "); hoTen = sc.nextLine();
               System.out.println("Nhap email: "); email = sc.nextLine();
               System.out.println("Nhap sdt: "); phone = sc.nextLine();
               System.out.println("---Ban da dang ki thanh cong---");
               people.add(new Person(people.size()+1, newTK, newMK, email , hoTen, phone, "customer" ));
               personController.writeUsersToFile(people,DataStore.FILE_PERSON);

           }else{
               System.out.println("Xac nhan mat khau sai");
           }

        }
        Check();
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
                System.out.println("Ban da dang nhap thanh cong! Chao mung " + persons.get(i).getPermission());
                List<Person> person1 = new ArrayList<>();
                person1.add(persons.get(i));
                personController.writeUsersToFile(person1,"User.DAT");

                if(persons.get(i).getPermission().compareTo("admin")==0){
                    AdminDo();
                }else {
                    CustomerDo();
                }

            }
        }
        if (check == false) {
            System.out.println("Ban da nhap sai hay dang nhap lai");
            Login();
        }
    }

    private static void CustomerDo() throws IOException{
        System.out.println("----------------CUSTOMER--------------");
        System.out.println("| 1. Xem cac toan bo laptop. | ");
        System.out.println("| 2. Tim kiem.               | ");
        System.out.println("| 3. Mua hang.               |");
        System.out.println("| 4. Xem hoa don             |");
        System.out.println("| 5. Sua tai khoan           |");
        System.out.println("| 0. Thoat                   |");
        System.out.println("-------------------------------");
        List<Laptop> laptops = new ArrayList<>();
        List<Bill> bills = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        int x;
        do{
            System.out.println("Nhap lua chon cua ban");
            x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Show laptop");
                    ShowLaptopCus(laptops);
                    break;
                case 2:
                    FindLaptop(laptops);
                    break;
                case 3:
                    BuyLaptop(laptops);
                    break;
                case 4:
                    ShowBill(bills);
                    break;
                default:
                    System.out.println("Lua chon khong phu hop");
            }
        }while(x<0||x>4);
    }

    private static void ShowLaptopCus(List<Laptop> laptops) throws IOException{
        laptops = storeController.readStoreFromFile("LaptopStore.DAT");
        for(int i=0;i<laptops.size();i++){
            System.out.println(laptops.get(i));
        }
        CustomerDo();
    }
    private static void BuyLaptop(List<Laptop> laptops) throws IOException {
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        List<Bill> bills = billController.readBillFromFile(DataStore.FILE_BILL);
        List<Person> user = personController.readPersonsFromFile("User.DAT");
        ShowLaptop(laptops);
        List<Laptop> laptopBuy = new ArrayList<>();
        sc.nextLine();
        int id;
        System.out.println("Nhap ID san pham can mua: "); id = sc.nextInt();
        int x;
        boolean check = false;
        for(int i=0 ; i<laptops.size();i++){
            if(laptops.get(i).getId()== id ){
                check = true;
                do {
                    System.out.println("Nhap so luong mua "); x = sc.nextInt();
                    if(x>0 && x<laptops.get(i).getInventory()){
                        System.out.println("Du so luong de ban mua");
                        laptopBuy.add(laptops.get(i));
                        laptops.get(i).setInventory(laptops.get(i).getInventory()-x);
                        storeController.writeStoreToFile(laptops,DataStore.FILE_STORE);
                    }else{
                        System.out.println("Kho khong du hang");
                    }
                }while(x>laptops.get(i).getInventory());
                break;
            }
        }
        if(check == false){
            System.out.println("San pham ban can mua khong hop le ");
        }else{
            Bill bill = new Bill(
                    bills.size()+1,
                    user.get(0).getIdPerson(),
                    laptopBuy,
                    0.05,
                    billController.Date()
            );
            bills.add(bill);
            billController.writeBillToFile(bills,DataStore.FILE_BILL);
        }

    }

    private static void ShowBill(List<Bill> bills) throws IOException{
        bills = billController.readBillFromFile("Bill.DAT");
        for(int i=0;i<bills.size();i++){
            System.out.println(bills.get(i));
        }
    }

    private static void AdminDo() throws IOException {
        System.out.println("-------------------ADMIN----------------");
        System.out.println("| 1. Xem cac toan bo laptop cua cua hang.|");
        System.out.println("| 2. Xem thong tin hoa don.              |");
        System.out.println("| 3. Xem thong tin cac tai khoan.        |");
        System.out.println("| 4. Sap xep san pham theo Ten/gia tien   |");
        System.out.println("| 5. Tim kiem san pham .                 |");
        System.out.println("| 6. Them san pham vao cua hang shop.    |");
        System.out.println("| 7. Xoa san pham khoi cua hang.         |");
        System.out.println("| 8. Xem doanh thu cua hang.             |");
        System.out.println("| 0. Thoat                               |");
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
                    System.out.println("Show Information Accout: ");
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



    private static void ShowTurnover(List<Bill> bills) throws  IOException{

    }

    private static void DeleteLaptop(List<Laptop> laptops) throws IOException{
        ShowLaptop(laptops);
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        List<Laptop> laptops1 = new ArrayList<>();
        sc.nextLine();
        int id;
        System.out.println("Nhap id san pham can xoa"); id =sc.nextInt();
        for(int i=0 ; i<laptops.size();i++){
            if(id != laptops.get(i).getId()){
                laptops1.add(laptops.get(i));
            }
        }
        storeController.writeStoreToFile(laptops1,DataStore.FILE_STORE);
        ShowLaptop(laptops1);
    }

    private static void AddLaptop(List<Laptop> laptops) throws  IOException{
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        int id=laptops.size()+1;
        String name, branch , material, CPU, RAM, display, gen ;
        int price, inventory;
        sc.nextLine();
        System.out.println("Them san pham vao danh sach ");
        System.out.println("Nhap ten mat hang: "); name = sc.nextLine();
        System.out.println("Nhap ten hang san xuat: "); branch = sc.nextLine();
        System.out.println("Nhap chat lieu: "); material = sc.nextLine();
        System.out.println("Nhap CPU: "); CPU = sc.nextLine();
        System.out.println("Nhap RAM: "); RAM = sc.nextLine();
        System.out.println("Nhap thong tin o dia: "); display = sc.nextLine();
        System.out.println("Nhap the he may: "); gen = sc.nextLine();
        System.out.println("Nhap gia tien: "); price =sc.nextInt();
        System.out.println("Nhap so luong: "); inventory = sc.nextInt();
        laptops.add(new Laptop(id, name, branch, material, CPU, RAM, display ,gen, price, inventory));
        storeController.writeStoreToFile(laptops,DataStore.FILE_STORE);
        ShowLaptop(laptops);

    }

    private static void FindLaptop(List<Laptop> laptops) throws IOException{
        System.out.println("Cac loai hinh tim kiem laptop");
        int x;
        do {
            System.out.println("Moi ban lua chon hinh thuc: ");
            System.out.println("1. Theo theo hang");
            System.out.println("2. Theo ten");
            x= sc.nextInt();

            switch (x){

                case 1:
                    System.out.println("Tim kiem theo hang");
                    FindBranch(laptops);
                    break;
                case 2:
                    System.out.println("Tim kiem theo ten");
                    FindName(laptops);
                    break;
                default:
                    System.out.println("Lua chon khong phu hop");

            }
        }while(x<1||x>3);
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
        System.out.println("Ban co muon lam gi nua khong");
        AdminDo();
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
        System.out.println("Ban co muon lam gi nua khong");
        AdminDo();
    }


    private static void ShowLaptop(List<Laptop> laptops) throws IOException{
        laptops = storeController.readStoreFromFile("LaptopStore.DAT");
        for(int i=0;i<laptops.size();i++){
            System.out.println(laptops.get(i));
        }
        System.out.println("Ban co muon lam them gi khong ?: Y/N");
        sc.nextLine();
        String s;
        s = sc.nextLine();
        if(s.equals("Y")==true){
            AdminDo();
        }

    }

    private static void ShowInfo(List<Person> people) throws IOException{
        people = personController.readPersonsFromFile("Person.DAT");
        for(int i=0;i<people.size();i++){
            System.out.println(people.get(i));
        }
        sc.nextLine();
        String s;
        s = sc.nextLine();
        if(s.equals("Y")==true){
            AdminDo();
        }
    }
    private static void SortLaptop(List<Laptop> laptops) throws IOException{
        System.out.println("Ban muon sap xep theo kieu nao");
        int x;
        do {
            System.out.println("Moi lua chon loai hinh sap xep: ");
            System.out.println("1. Theo ten");
            System.out.println("2. Theo gia tien");
            x= sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("Sap xep theo ten");
                    SortName(laptops);
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
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        System.out.println("Sap xep mat hang theo tien: ");
        Collections.sort(laptops, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        storeController.writeStoreToFile(laptops,"LaptopStore.DAT");
        ShowLaptop(laptops);

    }

    private static void SortName(List<Laptop> laptops) throws IOException{
        laptops = storeController.readStoreFromFile(DataStore.FILE_STORE);
        System.out.println("Sap xep mat hang theo ten A - Z: ");
        Collections.sort(laptops, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        storeController.writeStoreToFile(laptops,"LaptopStore.DAT");
        ShowLaptop(laptops);

    }

}


