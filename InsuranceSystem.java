package Assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceSystem {
    private List<PolicyHolder> policyHolderList;
    private List<Dependant> dependantList;
    private boolean exit = false;
    private Scanner sc = new Scanner(System.in);

    public InsuranceSystem() {
        this.policyHolderList = new ArrayList<>();
        this.dependantList = new ArrayList<>();
    }


    public void run() {
        while (!exit)
        {
            menu1();
            switch (getChoice()) {
                case 1:
                    runPolicyHolder();
                    break;
                case 2:
                    //menuDependant();
                    break;
                case 0:
                    this.exit();
                    break;
                default:
                    this.wrongUserInput();
            }
            this.askExit();
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
        System.out.println("Wrong User Input!!!");
    }

    public void exit() {
        this.exit = true;
    }

    public void menu1() {
        System.out.println("Login as: \n" +
                "1. Policy Holder\n" +
                "2. Dependant\n" +
                "0.Exit\n");
    }

    public int getChoice()
    {
        System.out.print("Your choice: ");
        return this.sc.nextInt();
    }

    public void menuPolicyHolder() {
        System.out.println("Menu for Policy Holder: \n" +
                "1. \n");
    }

    public void runPolicyHolder() {
        menuPolicyHolder();
    }
}


