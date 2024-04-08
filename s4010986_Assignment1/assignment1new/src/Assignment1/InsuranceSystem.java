package Assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InsuranceSystem {
    private List<PolicyHolder> policyHolderList;
    private List<Dependant> dependantList;
    private boolean exit = false;
    private Scanner sc = new Scanner(System.in);
    private static final String POLICY_HOLDER_FILE = "policyHolder.dat";
    private static final String DEPENDANT_FILE = "dependant.dat";


    public InsuranceSystem() throws Exception {
        this.policyHolderList = new ArrayList<>();
        this.dependantList = new ArrayList<>();
        this.readData();
        for (PolicyHolder holder : policyHolderList) {
            System.out.println(holder);
        }
        for (Dependant dependant : dependantList) {
            System.out.println(dependant);
        }
    }


    public void run() throws Exception {
        while (!exit) {
            this.readData();
            menu1();
            switch (getChoice()) {
                case 1:
                    runPolicyHolder();
                    break;
                case 2:
                    runDependant();
                    break;
                case 0:
                    this.exit();
                    break;
                default:
                    this.wrongUserInput();
                    break;
            }
            this.saveData();
            if (!this.exit) {
                this.askExit();
            }
        }
    }


    public void askExit() {
        System.out.println("Do you want to Exit?\n" +
                "1. Yes\n" +
                "2. No\n");
        if (this.getChoice() == 1) {
            this.exit = true;
        }
    }

    public void wrongUserInput() {
        System.out.println("Wrong User Input!!!\n");
    }

    public void exit() {
        this.exit = true;
        System.out.println("Exiting...");
    }

    public void menu1() {
        System.out.println("Login as: \n" +
                "1. Policy Holder\n" +
                "2. Dependant\n" +
                "0. Exit\n");
    }

    public int getChoice() {
        System.out.print("Your choice: ");
        return Integer.parseInt(this.sc.nextLine());
    }

    public void menuPolicyHolder() {
        System.out.println("\nMenu for Policy Holder: \n" +
                "1. Display general information\n" +
                "2. Add a dependant\n" +
                "3. Manage Claims\n" +
                "0. Exit\n");
    }

    public void runPolicyHolder() {
        System.out.print("\nInput Policy Holder's ID (cXXXXXXX): ");
        String iD = this.sc.nextLine();
        PolicyHolder holder = findPolicyHolder(iD);
        if (holder != null) {
            System.out.format("Policy Holder %s: \n", iD);
            menuPolicyHolder();
            switch (getChoice()) {
                case 0://exit
                    this.exit();
                    break;
                case 1://display policyholder
                    holder.display();
                    break;
                case 2://add dependant
                    System.out.print("\nInput Derpendant's ID (cXXXXXXX): ");
                    String dependantId = this.sc.nextLine();
                    Dependant dependant = findDependant(dependantId);
                    if (dependant != null) {
                        if (holder.addDependant(dependant)) {
                            System.out.println("Dependant Added Successfully.\n");
                        } else {
                            System.out.println("Dependant Added Unsuccessfully");
                        }
                    }
                    break;
                case 3: //manage claim
                    manageClaimRun(holder);
                    break;
                default:
                    wrongUserInput();
            }
        } else {
            System.out.format("There is no Policy Holder with the ID %s.\n\n", iD);
        }
    }

    public PolicyHolder findPolicyHolder(String iD) {
        for (PolicyHolder holder : policyHolderList) {
            if (holder.compareID(iD)) {
                return holder;
            }
        }
        return null;
    }

    public Dependant findDependant(String iD) {
        for (Dependant dependant : dependantList) {
            if (dependant.compareID(iD)) {
                return dependant;
            }
        }
        return null;
    }


    public void manageClaimRun(Customer customer) {
        manageClaimMenu();
        switch (getChoice())
        {
            case 1:
                displayAllClaim(customer);
                break;
            case 2:
                displayOneClaim(customer);
                break;
            case 3:
                updateClaim(customer);
                break;
            case 4:
                deleteClaim(customer);
                break;
            case 5:
                addClaim(customer);
                break;
            case 0:
                this.exit();
                break;
            default:
                wrongUserInput();
        }
    }

    public void displayAllClaim(Customer customer) {
        List<Claim> claimList = customer.getAll();
        if (!claimList.isEmpty()) {
            System.out.println("These are all the claims: ");
            for (Claim claim: claimList) {
                claim.display();
            }
        } else System.out.println("There is no claim yet.");
    }

    public void updateClaim(Customer customer)
    {
        updateClaimMenu();
        switch (getChoice()) {
            case 1: {
                System.out.print("Input Claim's ID (fXXXXXXXXXX): ");
                String claimID = this.sc.nextLine();
                Claim claim = customer.getOne(claimID);
                claim.updateStatus();
                System.out.println("Status updated.");
                break;
            }
            case 2: {
                System.out.print("Input Claim's ID (fXXXXXXXXXX): ");
                String claimID = this.sc.nextLine();
                Claim claim = customer.getOne(claimID);
                System.out.print("Input Document name: ");
                String document = this.sc.nextLine();
                claim.addDocument(document);
            }
            case 0:
                this.exit();
                break;
            default:
                wrongUserInput();
        }
    }

    public void updateClaimMenu() {
        System.out.println("Update Claim Menu:\n" +
                "1. Update status.\n" +
                "2. Add document.\n" +
                "0. Exit.\n");
    }

    public void displayOneClaim(Customer customer) {
        System.out.print("Input Claim's ID (fXXXXXXXXXX): ");
        String claimID = this.sc.nextLine();
        Claim claim = customer.getOne(claimID);
        if (claim != null) {
            System.out.println("Claim Founded: ");
            claim.display();
        }
    }

    public void deleteClaim(Customer customer) {
        System.out.println("Input Claim's ID (fXXXXXXXXXX): ");
        String claimID = this.sc.nextLine();
        if (customer.delete(claimID)) {
            System.out.println("Successfully deleted a claim.\n");
        } else System.out.println("Unsuccessfully deleted a claim.\n");
    }

    public void addClaim(Customer customer)
    {
        Claim claim = createClaim();
        if (customer.add(claim))
        {
            System.out.println("Successfully Added a Claim.\n");
        } else System.out.println("Unsuccessfully Added a Claim.\n");
    }

    public Claim createClaim() {
        System.out.print("Input Claim's ID (fXXXXXXXXXX): ");
        String claimID = this.sc.nextLine();
        System.out.print("Input Claim Date's Year: ");
        Integer claimYear = Integer.parseInt(this.sc.nextLine());
        System.out.print("Input Claim Date's Month: ");
        Integer claimMonth = Integer.parseInt(this.sc.nextLine());
        System.out.print("Input Claim Date's Day: ");
        Integer claimDay = Integer.parseInt(this.sc.nextLine());
        Date claimDate = new Date(claimYear, claimMonth, claimDay);
        System.out.print("Input Insured Person: ");
        String insuredPerson = this.sc.nextLine();
        System.out.print("Input Card Number (10 digit): ");
        String cardNum = this.sc.nextLine();
        System.out.print("Input Claim Amount: ");
        Double claimAmount = Double.parseDouble(this.sc.nextLine());
        System.out.print("Input Receiver Bank Infomation: ");
        String receiverBankInfo = this.sc.nextLine();
        Claim claim = new Claim(claimID, claimDate, insuredPerson, cardNum, claimAmount, receiverBankInfo);
        return claim;
    }


    public void manageClaimMenu() {
        System.out.println("Manage Claim Menu: \n" +
                "1. See all claims\n" +
                "2. Find a claim\n" +
                "3. Update a claim\n" +
                "4. Delete a claim\n" +
                "5. Add a Claim\n" +
                "0. Exit\n");
    }

    public void runDependant() {
        System.out.print("\nInput Dependant's ID (cXXXXXXX): ");
        String iD = this.sc.nextLine();
        Dependant dependant = findDependant(iD);
        if (dependant != null)
        {
            System.out.format("Dependant %s: \n", iD);
            menuDependant();
            switch (getChoice())
            {
                default:
                    wrongUserInput();
                case 0:
                    this.exit();
                    break;
                case 1:
                    dependant.display();
                    break;
                case 2:
                    manageClaimRun(dependant);
                    break;
            }
        } else System.out.format("There is no Dependant with the ID %s.\n\n", iD);
    }

    public void menuDependant(){
        System.out.println("\nMenu for Policy Holder: \n" +
                "1. Display general information\n" +
                "2. Manage Claims\n" +
                "0. Exit\n");
    }

    public void readData() throws Exception {
        ObjectInputStream inPolicy = new ObjectInputStream(new FileInputStream(POLICY_HOLDER_FILE));
        this.policyHolderList = (List<PolicyHolder>) inPolicy.readObject();
        inPolicy.close();

        ObjectInputStream inDependant = new ObjectInputStream(new FileInputStream(DEPENDANT_FILE));
        this.dependantList = (List<Dependant>) inDependant.readObject();
        inDependant.close();
    }

    public void saveData() throws Exception {
        ObjectOutputStream outPolicyHolder = new ObjectOutputStream(new FileOutputStream(POLICY_HOLDER_FILE));
        outPolicyHolder.writeObject(this.policyHolderList);
        outPolicyHolder.close();

        ObjectOutputStream outDependant = new ObjectOutputStream(new FileOutputStream(DEPENDANT_FILE));
        outDependant.writeObject(this.dependantList);
        outDependant.close();
    }

}

