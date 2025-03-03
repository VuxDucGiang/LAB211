package Week7.ManageTheGeographic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ManageEastAsiaCountries {

    private ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addCountry() {
        String countryCode;
        while (true) {
            System.out.println("Enter Country Code: ");
            countryCode = sc.nextLine();
            boolean exist = false;
            for (EastAsiaCountries eac : countryList) {
                if (eac.getCountryCode().equalsIgnoreCase(countryCode)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                break;
            } else {
                System.out.println("Country with Code: " + countryCode + " is already exist!");
                System.out.println("Please input another choice.");
            }
        }

        System.out.println("Enter Country Name: ");
        String countryName = sc.nextLine();

        float totalArea;
        while (true) {
            System.out.println("Enter Country Total Area: ");
            totalArea = sc.nextFloat();
            sc.nextLine();
            if (totalArea > 0) {
                break;
            } else {
                System.out.println("Total area must be greater than 0.");
            }
        }
        System.out.println("Enter Country Terrain: ");
        String countryTerrain = sc.nextLine();
        countryList.add(new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain));
    }

    public void displayAll() {
        for (EastAsiaCountries eac : countryList) {
            eac.display();
        }
    }

    public void searchCountry() {
        System.out.print("Enter Country Name to search: ");
        String name = sc.nextLine();
        for (EastAsiaCountries eac : countryList) {
            if (eac.getCountryName().equalsIgnoreCase(name)) {
                eac.display();
                break;
            } else {
                System.out.println("Country not found!");
            }
        }

    }

    public void displaySortedCountry() {
        ArrayList<EastAsiaCountries> sorted = new ArrayList<>(countryList);
        sorted.sort(Comparator.comparing(EastAsiaCountries::getCountryName));
        for (EastAsiaCountries eac : sorted) {
            eac.display();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've been input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of countries sorted name in ascending order");
            System.out.println("5.Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    searchCountry();
                    break;
                case 4:
                    displaySortedCountry();
                    break;
                case 5:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice. Please input again!");
            }
        }
    }
}
