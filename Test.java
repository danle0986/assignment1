package Assignment1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test {
    public static void main(String args[]) throws IOException {
        Date expiredDate = new Date(2022, 8, 2);
        InsuranceCard card = new InsuranceCard("1823675748", "Dan Pham", "Dan Pham", expiredDate);
        System.out.println(card.toString());

        PolicyHolder holder1 = new PolicyHolder("c12354379", "Dan Pham", card, null);
        System.out.println(holder1);

        Dependant dependant1 = new Dependant("c12354379", "Dan Pham", card, null);
        System.out.println(dependant1);
    }
}
