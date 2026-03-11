import java.util.*;

public class NearStitch{

    // CO3: Queue for storing bookings
    static Queue<String> bookings = new LinkedList<>();

    // CO4: HashMap for storing customer records
    static HashMap<String,String> customers = new HashMap<>();

    // CO2: LinkedList storing tailor details
    static LinkedList<String> tailorNames = new LinkedList<>();
    static LinkedList<String> tailorRatings = new LinkedList<>();
    static LinkedList<String> tailorAddress = new LinkedList<>();
    static LinkedList<String> tailorContact = new LinkedList<>();


    // CO1: Linear Search Tailor
    static void searchTailor(String name){

        for(int i=0;i<tailorNames.size();i++){

            if(tailorNames.get(i).equalsIgnoreCase(name)){

                System.out.println("\nTailor Found");

                System.out.println("Name    : " + tailorNames.get(i));
                System.out.println("Rating  : " + tailorRatings.get(i));
                System.out.println("Address : " + tailorAddress.get(i));
                System.out.println("Contact : " + tailorContact.get(i));

                return;
            }
        }

        System.out.println("Tailor not found");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int locationChoice;
        int cityChoice;
        int tailorChoice;
        int dressChoice;

        String city = "";
        String tailor = "";
        String dress = "";
        int cost = 0;

        String pickupDate = "";
        String pickupTime = "";
        int stitchingDays = 0;

        // AUTO ORDER ID
        Random rand = new Random();
        int orderNumber = 1000 + rand.nextInt(9000);
        String orderID = "NST" + orderNumber;


        // ADD TAILOR DETAILS (LinkedList)

        tailorNames.add("Perfect Fit Tailor");
        tailorRatings.add("4.8 ⭐");
        tailorAddress.add("MG Road");
        tailorContact.add("9876543210");

        tailorNames.add("Fashion Stitch Tailor");
        tailorRatings.add("4.5 ⭐");
        tailorAddress.add("Main Market");
        tailorContact.add("9123456780");

        tailorNames.add("Smart Style Tailor");
        tailorRatings.add("4.7 ⭐");
        tailorAddress.add("City Center");
        tailorContact.add("9012345678");


        System.out.println("====== Welcome to NearStitch ======");

        // LOCATION
        System.out.println("\nSelect Location");
        System.out.println("1 Telangana");
        System.out.println("2 Andhra Pradesh");

        locationChoice = sc.nextInt();

        // CITY
        if(locationChoice == 1){

            System.out.println("\nCities Available");
            System.out.println("1 Hyderabad");
            System.out.println("2 Warangal");

            cityChoice = sc.nextInt();

            if(cityChoice == 1)
                city = "Hyderabad";
            else
                city = "Warangal";

        }
        else{

            System.out.println("\nCities Available");
            System.out.println("1 Vijayawada");
            System.out.println("2 Guntur");

            cityChoice = sc.nextInt();

            if(cityChoice == 1)
                city = "Vijayawada";
            else
                city = "Guntur";
        }

        // DISPLAY TAILORS
        System.out.println("\nTailor Shops in " + city);

        for(int i=0;i<tailorNames.size();i++){

            System.out.println("\n"+(i+1)+" "+tailorNames.get(i));
            System.out.println("Rating  : "+tailorRatings.get(i));
            System.out.println("Address : "+tailorAddress.get(i));
            System.out.println("Contact : "+tailorContact.get(i));
        }

        System.out.println("\nEnter Tailor Choice:");
        tailorChoice = sc.nextInt();

        tailor = tailorNames.get(tailorChoice-1);

        sc.nextLine();

        // SEARCH OPTION
        System.out.println("\nEnter tailor shop name to search:");
        String searchName = sc.nextLine();

        searchTailor(searchName);


        // DRESS MODELS
        System.out.println("\nDress Models Available");

        System.out.println("1 Blouse Stitching - 500");
        System.out.println("2 Chudidar Stitching - 800");
        System.out.println("3 Lehenga Stitching - 1500");
        System.out.println("4 Kids Dress - 400");

        dressChoice = sc.nextInt();

        switch(dressChoice){

            case 1:
                dress = "Blouse";
                cost = 500;
                break;

            case 2:
                dress = "Chudidar";
                cost = 800;
                break;

            case 3:
                dress = "Lehenga";
                cost = 1500;
                break;

            case 4:
                dress = "Kids Dress";
                cost = 400;
                break;
        }

        sc.nextLine();

        // CUSTOMER DETAILS
        System.out.println("\nEnter Customer Name:");
        String name = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phone = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        // PICKUP DETAILS
        System.out.println("\nEnter Pickup Date (dd/mm/yyyy):");
        pickupDate = sc.nextLine();

        System.out.println("Enter Pickup Time:");
        pickupTime = sc.nextLine();

        System.out.println("Enter Stitching Days:");
        stitchingDays = sc.nextInt();

        // GST
        double gst = cost * 0.05;
        double totalCost = cost + gst;

        // STORE DATA
        customers.put(phone,name);
        bookings.add(name);

        // FINAL BILL
        System.out.println("\n=====================================");
        System.out.println("            NEARSTITCH BILL          ");
        System.out.println("=====================================");

        System.out.println("\nOrder ID       : " + orderID);

        System.out.println("\nCustomer Name  : " + name);
        System.out.println("Phone Number   : " + phone);
        System.out.println("Address        : " + address);

        System.out.println("\nCity           : " + city);

        System.out.println("\nTailor Shop    : " + tailor);

        System.out.println("\nDress Model    : " + dress);

        System.out.println("Stitching Cost : " + cost);
        System.out.println("GST (5%)       : " + gst);
        System.out.println("Total Cost     : " + totalCost);

        System.out.println("\nPickup Date    : " + pickupDate);
        System.out.println("Pickup Time    : " + pickupTime);

        System.out.println("\nDelivery Info  :");
        System.out.println("Delivery person will collect your cloth.");
        System.out.println("Estimated stitching time : " + stitchingDays + " days");

        System.out.println("\n=====================================");
        System.out.println("       Thank you for using NearStitch");
        System.out.println("=====================================");

        sc.close();
    }
}