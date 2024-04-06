package test;

import Assignment1.*;

import java.io.*;
import java.util.Date;

public class testSerialization {
    static public void main(String args[]) throws Exception
    {
        Date expiredDate = new Date(2022,8,2);

        InsuranceCard card = new InsuranceCard("1823675748", "Dan Pham", "Dan Pham", expiredDate);
        System.out.println(card.toString());


        PolicyHolder holder1 = new PolicyHolder("c12354379", "Dan Pham", card, null);
        System.out.println(holder1);


        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("policyHolder.dat"));
        out.writeObject(holder1);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("policyHolder.dat"));
        PolicyHolder holderDuplicate = (PolicyHolder) in.readObject();
        in.close();

        System.out.println(holderDuplicate);
    }
}
