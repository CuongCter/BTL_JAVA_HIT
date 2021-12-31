package Controller;

import Basic.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private Person person = new Person();
    private FileController fileController = new FileController();

    public PersonController() {
    }

    public PersonController(Person person, FileController fileController) {
        this.person = person;
        this.fileController = fileController;
    }

    public List<Person> readPersonsFromFile(String filename) throws IOException{
        fileController.OpenFileToRead(filename);
        List<Person> persons = new ArrayList<>();

        while(fileController.getScanner().hasNext()) {
            String data = fileController.getScanner().nextLine();
            String[] a = data.split("\\|");
            persons.add(new Person(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], a[6]));
        }

        fileController.CloseFileAfterRead(filename);

        return persons;
    }
    public List<Person> writeUsersToFile(List<Person> persons, String filename) throws IOException {
        fileController.OpenFileToWrite(filename);
        for(Person person : persons) {
            fileController.getPrintWriter().println(person.getIdPerson() + "|" + person.getUserName() + "|" + person.getPassWord()+ "|" + person.getNamePerson() + "|" + person.getEmail() + "|" + person.getPhoneNumber() + "|" + person.getPermission());
        }

        fileController.CloseFileAfterWrite();
        return persons;
    }
    public void closeUsersAfterRead(String file){
        fileController.CloseFileAfterWrite();
    }
}
