
import java.util.*;
import java.lang.*;
import javax.rmi.ssl.SslRMIClientSocketFactory;





class Main
{
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        String name, gender, date1, time;
        double totalCost=0;
        int choice = 0, i = 0;

        System.out.println("\n\n------UAE Smart Tourism-----\n");
        System.out.println("\nWelcome\n");

        System.out.println("Pls enter your name: ");
        name = sc.nextLine();

        System.out.println("Pls enter your gender (M/F): ");
        gender = sc.nextLine();


        while (choice != 5) {
            System.out.println("\nMENU\n\n");

            System.out.println("1. Hungry?? Let's select a restaurant");
            System.out.println("2. Let's explore UAE");
            System.out.println("3. Tired for the day? Book a hotel");
            System.out.println("4. Plan your commute");
            System.out.println("5. Exit");
            System.out.println("\nEnter choice: ");
            choice = Integer.parseInt(sc.nextLine());


            if (choice == 1)
            {
                //Scanner input = new Scanner(System.in);
                System.out.println("\nPls enter the date: ");
                date1 = sc.nextLine();

                System.out.println("Pls enter the time: ");
                time = sc.nextLine();



                Restaurant r = new Restaurant();
                r.check();
                r.choose();

                totalCost = totalCost + r.totalCost();

                if(gender.equalsIgnoreCase("M"))
                {
                    System.out.println("\nReservation has been made at the restaurant for Mr."+name+" on "+ date1+" at "+time);
                }

                else if (gender.equalsIgnoreCase("F"))
                {
                    System.out.println("\nRreservation has been made at the restaurant for Mrs."+name+ " on "+ date1+" at "+time);
                }

                else
                {
                    System.out.println("\nReservation has been made at the restaurant for user :"+name+ " on "+ date1+" at "+time);
                }






            }

            else if (choice == 2)
            {
                System.out.println("\nPls enter the date of your visit: ");
                date1 = sc.nextLine();

                Tourist_Hotspot t = new Tourist_Hotspot();
                t.Display();
                totalCost = totalCost + t.location();

                if(gender.equalsIgnoreCase("M"))
                {
                    System.out.println("\nReservation has been made for Mr."+name+" on "+ date1);
                }

                else if (gender.equalsIgnoreCase("F"))
                {
                    System.out.println("\nRreservation has been made for Mrs."+name+ " on "+ date1);
                }

                else
                {
                    System.out.println("\nReservation has been made for user :"+name+ " on "+ date1);
                }

                //System.out.println("\n Total charges = "+ totalCost);


            }

            else if (choice == 3)
            {

                System.out.println("\nPls enter the first date of your stay: ");
                date1 = sc.nextLine();


                Lodging a = new Lodging();
                Scanner scan = new Scanner(System.in);
                int check = 1;
                do {
                    System.out.println("Which are you going to stay in");
                    System.out.println("1) Dubai ( code:-DXB)");
                    System.out.println("2) Abu-Dhabi ( code:-ABU)");
                    System.out.println("3) Fujairah ( code:-FUJ)");
                    System.out.println("4) Ras-Al-Khaimah ( code:-RAK)");
                    System.out.println("\nEnter Emirate code : ");
                    String city = scan.nextLine();
                    if (city.equalsIgnoreCase("DXB")) {

                        a.dubai();
                    } else if (city.equalsIgnoreCase("ABU")) {

                        a.abudhabi();
                    } else if (city.equalsIgnoreCase("FUJ")) {

                        a.fujairah();
                    } else if (city.equalsIgnoreCase("RAK")) {

                        a.rak();
                    } else {
                        System.out.println("Wrong input Pls restart");
                        continue;

                    }
                    System.out.println("Want to book more(1/0)");
                    check = scan.nextInt();
                } while(check == 1);

                totalCost = totalCost + a.final_cost;

                if(gender.equalsIgnoreCase("M"))
                {
                    System.out.println("\nHotel reservation has been made for Mr."+name+" from "+ date1+" for "+a.noOfNights+" nights");
                }

                else if (gender.equalsIgnoreCase("F"))
                {
                    System.out.println("\nHotel reservation has been made for Mrs."+name+ " from "+ date1+" for "+a.noOfNights+" nights");
                }

                else
                {
                    System.out.println("\nHotel reservation has been made for user :"+name+ " from "+ date1+" for "+a.noOfNights+" nights");
                }


            }

            else if (choice == 4)
            {
                TransportChoice tChoice =  new TransportChoice();
                tChoice.Choice();
                tChoice.display();
            }

            else
            {
                System.out.println("\n Total charges = AED "+ totalCost);
                choice = 5;
            }


        }
    }
}

// ---------------------------------------------------------------------------------------------------------------

class Restaurant {
    public String name, email_id, ph_no, location, description, emirate;
    public int star, option;
    public double avg_cost=0;
    public static double total=0;
    public double  peps;

    //Scanner input = new Scanner(System.in); //not required

    ArrayList<Restaurant> Dubai= new ArrayList <Restaurant>();
    ArrayList <Restaurant> AbuDhabi= new ArrayList <Restaurant>();
    ArrayList <Restaurant> Fujairah= new ArrayList <Restaurant>();
    ArrayList <Restaurant> RasAlKhaimah= new ArrayList <Restaurant>();
    ArrayList <Restaurant> Emirate;
    ArrayList <Restaurant> Star;

    public Restaurant(){
        // empty constructor
    }

    public Restaurant(String name, String email_id, String ph_no, String location, String description,
                      String emirate, int star, int option, double avg_cost){
        this.name = name;
        this.email_id = email_id;
        this.ph_no = ph_no;
        this.location = location;
        this.description = description;
        this.emirate = emirate;
        this.star = star;
        this.option = option;
        this.avg_cost = avg_cost;
    }

    public void check(){

        // for dubai
        Restaurant RodaGrillDining = new Restaurant("Roda Grill Dining", "rodagrilldining@gmail.com",
                "5043412345", "Downtown", "Popular Dishes\n" +
                "Chocolate Souffle, Jumbo Prawns, Grilled Salmon, Lobster, Sea Food, Wine\n " + "People Say This Place Is Known For\n" +
                "Cozy Setting, Modern Vibe, Sophisticated, Worth the Price, Fancy Crowd, Waitress", "Dubai",
                3, 1, 250.0);
        Dubai.add(RodaGrillDining);

        Restaurant TheCheesecakeFactory = new Restaurant("The Cheesecake Factory", "thecheesecakefactory@gmail.com",
                "5087792526", "Jumeirah", "Popular Dishes\n" +
                "Cheescakes, Steak Diane, Chicken Madeira, Godiva Chocolate Cheesecake, " + "Bang Bang Chicken, Salted Caramel Cake\n" +
                "\n" + "People Say This Place Is Known For\n" + "Free Refills, Family Favorite, Big Serving, Huge Place, Large Portions, " +
                "Efficient Service", "Dubai", 3, 2, 275.0);
        Dubai.add(TheCheesecakeFactory);

        Restaurant CALIPOKECaliforniaSeafoodHouse = new Restaurant("CALI-POKE California Seafood House", "calipoke@gmail.com",
                "5056826985", "Zaabeel", "Popular Dishes\n" +
                "Sushi Taco, Coconut Drink, Seaweed Salad, Tempura Shrimp, Acai Smoothie, " + "California Roll\n" + "\n" +
                "People Say This Place Is Known For\n" + "Super Fast Delivery, Spill Proof Packaging, Vegan, Bowls, Cute Packaging, " +
                "Perfect Presentation", "Dubai", 3, 3, 180.0);
        Dubai.add(CALIPOKECaliforniaSeafoodHouse);

        Restaurant DinTaiFung = new Restaurant("Din Tai Fung", "dintaifung@gmail.com",
                "508788752", "Downtown", "Popular Dishes\n" +
                "Spicy Dumpling, Truffle Dim Sum, Xiaolongbao, Beef Noodle, Fried Rice Chicken, Crispy " + "Beef\n" + "\n" +
                "People Say This Place Is Known For\n" + "Everything was very Good, Service and Quality of Food, " +
                "Gastronomical Experience, Staff " + "Service, Comfortable Seating Area, Young Crowd",
                "Dubai", 4, 1, 360.0);
        Dubai.add(DinTaiFung);

        Restaurant Kamat = new Restaurant("Kamat", "kamat@gmail.com",
                "507659294", "Jumeirah", "Known For\n" +
                "An extensive array of vegetarian delicacies from North Indian, South Indian and " +
                "Indo-Chinese cuisines\n Popular Dishes\n" +
                "Andhra Masala Dosa, Dal Kichadi, Sambar, Dosa, Pav Bhaji, Thali\n" + "\n" + "People Say This Place Is Known For\n" +
                "Themed Decor, Relaxed Atmosphere, Courteous Staff, Good Ambience, Tasty Food, " +
                "Breakfast", "Dubai", 4, 2, 400.0);
        Dubai.add(Kamat);

        Restaurant NandostheDubaiMall = new Restaurant("Nando's - the Dubai Mall", "nandos@gmail.com",
                "502587732", "Zaabeel", "Popular Dishes\n" +
                "Espetada Carnival, Garlic Bread, Cheesecake, Chicken, Drink\n" + "\n" + "People Say This Place Is Known For\n" +
                "The Service, Excellent View, Good Service Good Quality, Served Us Perfectly, " +
                "Service is Great and Fast, Sitting Area", "Dubai", 4, 3, 300.0);
        Dubai.add(NandostheDubaiMall);

        Restaurant SocialHouse = new Restaurant("Social House", "socialhouse@gmail.com",
                "50258792", "Downtown", "Popular Dishes\n" +
                "Basil Cooler, Nacho Pizza, Eggs Benny, Mie Goreng, Chilli Garlic Prawns, Nasi " +
                "Goreng Chicken\n"  + "People Say This Place Is Known For\n" +
                "Wooden Interiors, Location of the Restaurant, Burj Khalifa View, Cozy Ambience, " +
                "Perfect View, Best View", "Dubai", 5, 1, 475.0);
        Dubai.add(SocialHouse);

        Restaurant Markette = new Restaurant("Markette", "markette@gmail.com",
                "508729732", "Jumeirah", "Popular Dishes\n" +
                "Mama Mia Burger, Sweet Crepe, Chilli Cheese Fries, Healthy Breakfast, Meatballs, " + "Club Sandwich\n" +
                "People Say This Place Is Known For\n" + "Great Food Great Service, Ample Seating Area, Good View, " +
                "Family Place, Nice View, " + "Friendly Service", "Dubai", 5, 2, 500.0);
        Dubai.add(Markette);

        Restaurant ShakespeareandCotheDubaiMall = new Restaurant("Shakespeare and Co. - the Dubai Mall", "rodagrilldining@gmail.com",
                "5043412345", "Zaabeel", "Popular Dishes\n" + "Chocolate Souffle, Jumbo Prawns, " +
                "Grilled Salmon, Lobster, Sea Food, Wine\n " + "People Say This Place Is Known For\n" +
                "Cozy Setting, Modern Vibe, Sophisticated, Worth the Price, Fancy Crowd, Waitress", "Dubai",
                5, 3, 600.0);
        Dubai.add(ShakespeareandCotheDubaiMall);

        // for abu dhabi

        Restaurant AlloBeirut = new Restaurant("Allo Beirut", "allobeirut@gmail.com",
                "504628756", "Yas", "Popular Dishes\n" +
                "Chocolate Souffle, Jumbo Prawns, Grilled Salmon, Lobster, Sea Food, Wine\n " + "People Say This Place Is Known For\n" +
                "Cozy Setting, Modern Vibe, Sophisticated, Worth the Price, Fancy Crowd, Waitress", "Abu Dhabi",
                3, 1, 250.0);
        AbuDhabi.add(AlloBeirut);

        Restaurant ClintonStreetBakingCompany = new Restaurant("Clinton Street Baking Company", "clintonstreet@gmail.com",
                "5028579223", "Markaziya", "Popular Dishes\n" + "Bottomless Coffee, Country Breakfast, " +
                "Eggs Florentine, Crab Cake, Egg Benedict," + " Pancake\n" + "People Say This Place Is Known For\n" +
                "Good Quality Food, Breakfasts, Ample Seating Area, Relaxed Atmosphere, " + "Good for Large Groups, Big Portions",
                "Abu Dhabi", 3, 2, 190.0);
        AbuDhabi.add(ClintonStreetBakingCompany);

        Restaurant Mmmbox = new Restaurant("Mmmbox", "mmmbox@gmail.com",
                "503562995", "Khalidiya", "Popular Dishes\n" +
                "Wasabi Sushi, Asparagus Sushi, Curry Crab, Spicy Salmon, Dimsum, Dumplings\n" +
                "People Say This Place Is Known For\n" +
                "Everything is Perfect, Wonderful Presentation, Cute Packaging, Comfortable " +
                "Seating Area, Food Presentation, Extensive Menu", "Abu Dhabi", 3, 3, 130.0);
        AbuDhabi.add(Mmmbox);

        Restaurant LadsBurger = new Restaurant("Lads Burger", "ladsburger@gmail.com",
                "505862909", "Yas", "Popular Dishes\n" +
                "Wagyu Beef Burger, Coleslaw Salad, Chicken Escalope, Classic Burger, Nutella " +
                "Crepe, Wagyu\n" +
                "People Say This Place Is Known For\n" +
                "Elegantly Decorated, Inexpensive, Value for Money, Prompt Service, Great " +
                "Recommendations, Polite Staff",
                "Abu Dhabi", 4, 1, 360.0);
        AbuDhabi.add(LadsBurger);

        Restaurant BrunchCake = new Restaurant("Brunch & Cake", "brunch@gmail.com",
                "505692879", "Markaziya", "Popular Dishes\n" +
                "Acai Bowl, Cheesecake, Desserts, Cake, Pizza\n" +
                "People Say This Place Is Known For\n" +
                "Instagramable, Variety of Pizza, Great Presentation, Weekend Brunch, Service " +
                "is Great, Beautiful Interiors", "Abu Dhabi", 4, 2, 450.0);
        AbuDhabi.add(BrunchCake);

        Restaurant BottegaCafe = new Restaurant("Bottega Cafe", "bottega@gmail.com",
                "535782862", "Khalidiya", "People Say This Place Is Known For\n" +
                "Seaview, Good Pricing, Amazing Location, Brilliant Service, Wonderful Staff, " +
                "Best Staff", "Abu Dhabi", 4, 3, 300.0);
        AbuDhabi.add(BottegaCafe);

        Restaurant ItalianSalsa = new Restaurant("Italian Salsa", "salsa@gmail.com",
                "535699128", "Yas", "People Say This Place Is Known For\n" +
                "Prices, Menu, Taste, Experience, Food", "Abu Dhabi", 5, 1, 500.0);
        AbuDhabi.add(ItalianSalsa);

        Restaurant NamasteCuisine = new Restaurant("Namaste Cuisine", "namaste@gmail.com",
                "53679252", "Markaziya", "People Say This Place Is Known For\n" +
                "Friendly Staff, Ambiance, Quality, Service, Food", "Abu Dhabi", 5, 2, 600.0);
        AbuDhabi.add(NamasteCuisine);

        Restaurant AlAbra = new Restaurant("Al Abra", "alabra@gmail.com",
                "534768167", "Khalidiya", "Arabian cuisine\n" + "People Say This Place Is Known For\n" +
                "Comfortable Seating Area, Quick Service, Waiter, Location, Ambience, Food", "Abu Dhabi",
                5, 3, 650.0);
        AbuDhabi.add(AlAbra);


        // for ras al khaimah

        Restaurant PestoRistorante = new Restaurant("Pesto Ristorante", "pesto@gmail.com",
                "5365241411", "Nakheel", "Italian cuisine" + "People Say This Place Is Known For\n" +
                "Appetizers, Nice Ambience, Great Food, View, Ambiance, Quality", "Ras Al Khaimah",
                3, 1, 180.0);
        RasAlKhaimah.add(PestoRistorante);

        Restaurant Marjan = new Restaurant("Marjan", "marjan@gmail.com",
                "535762540", "Sidroh", "Moroccan cuisine" + "People Say This Place Is Known For\n" +
                "Meals, Menu, Food, Staff", "Ras Al Khaimah", 3, 2, 250.0);
        RasAlKhaimah.add(Marjan);

        Restaurant BelgianCafe = new Restaurant("Belgian Cafe", "belgiancafe@gmail.com",
                "535621499", "Hamra", "People Say This Place Is Known For\n" +
                "Good Atmosphere, Happy Hour, Great Location, Cafe, Nice Place, Good Place", "Ras Al Khaimah", 3, 3, 300.0);
        RasAlKhaimah.add(BelgianCafe);

        Restaurant Umi = new Restaurant("Umi", "umi@gmail.com",
                "535471694", "Nakheel", "People Say This Place Is Known For\n" +
                "Chef, Great Food, Ambience, Staff, Service","Ras Al Khaimah", 4, 1, 400.0);
        RasAlKhaimah.add(Umi);

        Restaurant LexingtonGrill = new Restaurant("Lexington Grill", "lexingtongrill@gmail.com",
                "535707328", "Sidroh", "Popular Dishes\n" +
                "Chocolate Souffle, Oysters, Steak, Cake\n" +
                "\n" +
                "People Say This Place Is Known For\n" +
                "Decor, Chef, Portions, Customer Service, Server, Friendly Staff", "Ras Al Khaimah", 4, 2, 910.0);
        RasAlKhaimah.add(LexingtonGrill);

        Restaurant Piaceri = new Restaurant("Piaceri", "piaceri@gmail.com",
                "537468447", "Hamra", "Italian cuisine" +"People Say This Place Is Known For\n" +
                "Customizable Food, Good Quality, Fresh Food, Elaborate Menu, Taste, Staff", "Ras Al Khaimah", 4, 3, 250.0);
        RasAlKhaimah.add(Piaceri);

        Restaurant AlMaeda = new Restaurant("Al Maeda", "almaeda@gmail.com",
                "534756885", "Nakheel", "Known For\n" +
                "Make your way to the newest and one of Ras Al Khaimah's most outstanding " +
                "contemporary Lebanese inspired restaurant - Al Maeda. Be entranced by the taste," +
                " color and aroma of the Levant. Gather family and friends to sample delicious " +
                "dishes including the smoked lamb Frikih and Fish Saiyadiah", "Ras Al Khaimah", 5, 1, 475.0);
        RasAlKhaimah.add(AlMaeda);

        Restaurant BellaVenezia = new Restaurant("Bella Venezia", "bellavenezia@gmail.com",
                "53845728", "Sidroh", "Italian cuisine\n" + "People Say This Place Is Known For\n" +
                "Good Wifi, Customizable Food, Elaborate Menu, Fresh Food, Worth the Money, Good Quality", "Ras Al Khaimah", 5, 2, 700.0);
        RasAlKhaimah.add(BellaVenezia);

        Restaurant Podium = new Restaurant("Podium", "podium@gmail.com",
                "535878442", "Hamra", "American cuisine\n" +"People Say This Place Is Known For\n" +
                "Student Crowd, Friendly Service, Vibe, Breakfast, Bread, Nice Place", "Ras Al Khaimah",
                5, 3, 600.0);
        RasAlKhaimah.add(Podium);


        // for fujairah

        Restaurant Sharkeys = new Restaurant("Sharkeys", "sharkeys@gmail.com",
                "52792521", "City", "European cuisine\n"+ "People Say This Place Is Known For\n" +
                "Great Food and Service, Ambience was Super Cool, Customizable Dishes, Clean, " +
                "Good Wifi, Weekend Brunch", "Fujairah",
                3, 1, 250.0);
        Fujairah.add(Sharkeys);

        Restaurant Mammone = new Restaurant("Mammone", "mammone@gmail.com",
                "524768232", "Aqah", "Italian cuisine\n"+ "People Say This Place Is Known For\n" +
                "Great Food and Service, Ambience was Super Cool, Customizable Dishes, Clean, " +
                "Good Wifi, Weekend Brunch", "Fujairah", 3, 2, 275.0);
        Fujairah.add(Mammone);

        Restaurant Breeze = new Restaurant("Breeze", "breeze@gmail.com",
                "525764312", "Dibba", "People Say This Place Is Known For\n" +
                "View, Breakfast, Experience, Staff, Food, Service", "Fujairah", 3, 3, 200.0);
        Fujairah.add(Breeze);

        Restaurant AlNokhada = new Restaurant("Al Nokhada", "alnokhada@gmail.com",
                "52562423", "City", "People Say This Place Is Known For\n" +
                "Cutlery, Live Music, Interior, Decor, Taste, Service",
                "Fujairah", 4, 1, 360.0);
        Fujairah.add(AlNokhada);

        Restaurant TheLounge = new Restaurant("TheLounge", "lounge@gmail.com",
                "52572323", "Aqah", "Continental cuisine\n" + "People Say This Place Is Known For\n" +
                "Efficient Service, Amazing Hospitality, " + "Lovely Food, Warm Service", "Fujairah", 4, 2, 400.0);
        Fujairah.add(TheLounge);

        Restaurant Canvas = new Restaurant("Canvas", "canvas@gmail.com",
                "525471466", "Dibba", "Indian, European cuisine\n" + "People Say This Place Is Known For\n" +
                "Friendly Staff, Ambience, Food, Service", "Fujairah", 4, 3, 450.0);
        Fujairah.add(Canvas);

        Restaurant Marina = new Restaurant("Marina", "marina@gmail.com",
                "525707342", "City", "Italian cuisine\n" + "People Say This Place Is Known For\n" +
                "Friendly Staff, Ambience, Food, Service", "Fujairah", 5, 1, 525.0);
        Fujairah.add(Marina);

        Restaurant GrandBleu = new Restaurant("Grand Bleu", "grandbleu@gmail.com",
                "527946123", "Aqah", "People Say This Place Is Known For\n" +
                "Main Course, Presentation, View, Atmosphere, Delicious Food, Taste", "Fujairah", 5, 2, 600.0);
        Fujairah.add(GrandBleu);

        Restaurant LavaDining = new Restaurant("Lava Dining", "lavadining@gmail.com",
                "5257223", "Dibba", "European cuisine\n" + "People Say This Place Is Known For\n" +
                "Friendly Staff, Ambience, Food, Service", "Fujairah", 5, 3, 700.0);
        Fujairah.add(LavaDining);
    }

    public void choose(){
        Scanner input = new Scanner(System.in);
        int ch=0, emi=0, st=0, t1=0, t2=0;

        do {

            do {
                System.out.println("\nIn which emirate are you staying?\n\n1-Dubai\n2-Abu Dhabi\n3-Ras Al Khaimah\n4-Fujairah\n\nEnter option number: ");
                emi = Integer.parseInt(input.nextLine());
                //emi = input.nextInt();

                if(emi == 1 || emi==2 || emi==3 || emi==4)
                {
                    t1=1;
                }

                else
                {
                    System.out.println("Invalid choice. Pls enter a valid option number.\n");
                    t1=0;
                }
            }while(t1==0);

            t1=0;

            do {
                System.out.println("In what class restaurant would you like to eat? (Stars from 3-5): ");
                st = Integer.parseInt(input.nextLine());
                //st = input.nextInt();

                if (st == 3 | st == 4 | st == 5) {
                    t2 = 1;
                } else {
                    System.out.println("Invalid choice. Pls enter a valid option number.\n");
                    t2 = 0;

                }
            }while(t2==0);

            t2=0;


            Restaurant res = new Restaurant();

            switch (emi){
                case 1: Emirate = Dubai;
                    emirate="Dubai";
                    switch(st){
                        case 3: star = 3;
                            for(int i=0; i<3; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            int c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 4: star = 4;
                            for(int i=3; i<6; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 5: star = 5;
                            for(int i=6; i<9; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        default:
                            System.out.println("invalid star");
                    }
                    break;
                case 2: Emirate = AbuDhabi;
                    switch(st){
                        case 3: star = 3;
                            for(int i=0; i<3; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            int c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 4: star = 4;
                            for(int i=0; i<4; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 5: star = 5;
                            for(int i=6; i<9; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        default:
                            System.out.println("invalid star");
                    }
                    break;
                case 3: Emirate = RasAlKhaimah;
                    switch(st){
                        case 3: star = 3;
                            for(int i=0; i<3; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            int c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 4: star = 4;
                            for(int i=3; i<6; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 5: star = 5;
                            for(int i=6; i<9; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        default:
                            System.out.println("invalid star");
                    }
                    break;
                case 4: Emirate = Fujairah;
                    switch(st){
                        case 3: star = 3;
                            for(int i=0; i<3; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            int c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 4: star = 4;
                            for(int i=3; i<6; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        case 5: star = 5;
                            for(int i=6; i<9; i++)
                                Emirate.get(i).display();
                            System.out.println("enter choice(1-3): ");
                            c = Integer.parseInt(input.nextLine());
                            if(c==1) {
                                Emirate.get(0).display();
                                Emirate.get(0).display2();
                            }
                            else if(c==2) {
                                Emirate.get(1).display();
                                Emirate.get(1).display2();
                            }
                            else if(c==3) {
                                Emirate.get(2).display();
                                Emirate.get(2).display2();
                            }
                            else
                                System.out.println("invalid choice");
                            break;
                        default:
                            System.out.println("invalid star");
                    }

            }

            System.out.println("Would you like to see the restaurant options?(1-yes, 2-no): ");
            ch = Integer.parseInt(input.nextLine());

        } while(ch==1);
    }

    public void display(){

        //avg_cost = avg_cost*peps;

        System.out.println("name: " + name);
        System.out.println("email id: " + email_id);
        System.out.println("phone no: " + ph_no);
        System.out.println("location: " + location);
        System.out.println("description: " + description);
        System.out.println("average cost for 1 person: " + avg_cost + " AED");
        System.out.println();
    }

    public void display2(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of people: ");
        peps = Integer.parseInt(input.nextLine());
        total = avg_cost*peps;
        System.out.println("The cost of booking a table for "  + peps + " people: " + total + " AED");
    }

    public double totalCost()
    {
        return this.total;
    }
}



//----------------------------------------------------------------------------------------------------------------
abstract class Emirate {

    String Emirate1="DXB";
    String Emirate2="AUH";
    String Emirate3="RAK";
    String Emirate4="FUJ" ;

    abstract double forFUJ();
    abstract double forRAK();
    abstract void Display();
    abstract double location();
    abstract double forDXB();
    abstract double forAUH();


}
class Tourist_Hotspot extends Emirate {
    Scanner scan = new Scanner(System.in);
   /* String Emirate1="DXB";
    String Emirate2="AUH";
    String Emirate3="RAK";
    String Emirate4="FUJ";
    double total_cost = 0;*/
    //String City=null;
    void Display()
    {
        System.out.println("Enter the city you want to enquire about:\n");
        System.out.println("Dubai:DXB\nAbu Dhabi:AUH\nRas-Al-Khaimah:RAK\nFujairah:FUJ\n");
        //City=scan.nextLine();
    }

 /*String City=scan.nextLine();
  boolean isDXB = City.equalsIgnoreCase(Emirate1);
  boolean isAUH = City.equalsIgnoreCase(Emirate2);
  boolean isRAK = City.equalsIgnoreCase(Emirate3);
  boolean isFUJ = City.equalsIgnoreCase(Emirate4);*/

    double location()
    {   double total_cost=0;
        String City=scan.nextLine();
        boolean isDXB = City.equalsIgnoreCase(Emirate1);
        boolean isAUH = City.equalsIgnoreCase(Emirate2);
        boolean isRAK = City.equalsIgnoreCase(Emirate3);
        boolean isFUJ = City.equalsIgnoreCase(Emirate4);

        if(isDXB==true)
        {
            total_cost = forDXB();
        }
        else if(isAUH==true)
        {
            total_cost = forAUH();
        }
        else if(isRAK==true)
        {
            total_cost = forRAK();
        }
        else if(isFUJ==true)
        {
            total_cost = forFUJ();
        }
        else
        {
            System.out.println("Invalid choice, pls enter correct emirate code again:");
            location();

        }

        return total_cost;

    }



    double forDXB()
    {   double Total_Cost=0;
        System.out.println();
        System.out.println("Places for Visit:");
        System.out.println("BURJ KHALIFA");
        System.out.println("Burj Khalifa is a highly exotic place to visit in Dubai."
                + "It is a skyscraper which has more than 160 stories"+ "and holds the following records:"
                + " Tallest building in the world,"
                + "Tallest free-standing structure in the world,"
                + "Highest number of stories in the world.");
        System.out.println("Price: AED: 136.45");
        System.out.println("Press y/n for confirmation");
        char dec1 = scan.next().charAt(0);
        if(dec1 == 'y')
        {
            Total_Cost = Total_Cost+136.45;
        }


        System.out.println();
        System.out.println("DUBAI DESERT SAFARI");
        System.out.println("Desert Safari is undoubtedly one of the most exclusive activities to try in Dubai."
                + "Exploring the endless deserts while on your Dubai trip is an adventure you must not miss. "
                + "The moments you spend taking the experience of a desert safari in Dubai will stay with you forever as a treasured memory.");
        System.out.println("Price: AED: 38.61");
        System.out.println("Press y/n for confirmation");
        char dec2 = scan.next().charAt(0);
        if(dec2 == 'y')
        {
            Total_Cost = Total_Cost+38.61;
        }


        System.out.println();
        System.out.println("GLOBAL VILLAGE");
        System.out.println(" Global Village is Dubai�s leading family entertainment,"
                + " undoubtedly one of the best places to visit in Dubai with family and cultural attraction that offers a unique shopping experience in Dubai through its 31 pavilions,"
                + " each representing a different country across the globe");
        System.out.println("Price: AED: 15");
        System.out.println("Press y/n for confirmation");
        char dec3 = scan.next().charAt(0);
        if(dec3 == 'y')
        {
            Total_Cost = Total_Cost+15;
        }

        System.out.println();
        System.out.println("DUBAI MIRACLE GARDEN");
        System.out.println("Dubai Miracle garden should be on top priority on the must do things in Dubai for nature lovers. "
                + "The lush gardens are a treat to your senses and will leave you with a pleasant and happy feeling throughout.");
        System.out.println("Price: AED: 108.07");
        System.out.println("Press y/n for confirmation");
        char dec4 = scan.next().charAt(0);
        if(dec4 == 'y')
        {
            Total_Cost = Total_Cost+108.07;
        }

        System.out.println();
        System.out.println("DUBAI FRAME");
        System.out.println("Dubai�s architectural designs and structures are always magnificent, and Dubai frame is one amongst most popular tourist places in Dubai. "
                + "This massive picture frame with height and breadth of 150m and 93m respectively is one of the best places to see in Dubai");
        System.out.println("Price: AED: 61.73");
        System.out.println("Press y/n for confirmation");
        char dec5 = scan.next().charAt(0);
        if(dec5 == 'y')
        {
            Total_Cost = Total_Cost+61.73;
        }

        System.out.println();
        System.out.println("DUBAI MALL");
        System.out.println("Among various Dubai tourist places, Dubai Mall is a place that attracts a major tourist crowd. "
                + "It�s magnificent a sprawling structure with the vivacious interior designs, the expensive shops, portray the rich and splendid lifestyle of Dubai."
                + " It is the largest mall in the world with respect to the total area."
                + " Inside it, there are more than 1200 shops. ");
        System.out.println("Price: FREE");
        char dec6 = scan.next().charAt(0);
        if(dec6 == 'y')
        {
            Total_Cost = Total_Cost+0;
        }

        System.out.println();
        System.out.println("Places you've selected to visit:");
        if(dec1=='y') {
            System.out.println("Burj Khalifa");
        }
        if(dec2=='y') {
            System.out.println("Dubai Desert Safari");
        }
        if(dec3=='y') {
            System.out.println("Global Village");
        }
        if(dec4=='y') {
            System.out.println("Dubai Miracle Garden");
        }
        if(dec5=='y') {
            System.out.println("Dubai Frame");
        }
        if(dec6=='y') {
            System.out.println("Dubai Mall");
        }
        System.out.println();
        System.out.println("How many people you want to book for:");
        int peps = scan.nextInt();
        Total_Cost=Total_Cost*peps;
        System.out.println("Total Cost for the places you've selected to visit is: AED "+Total_Cost);

        return Total_Cost;

    }

    double forAUH()
    {
        double Total_Cost=0;
        System.out.println();
        System.out.println("Places for Visit:");
        System.out.println("SHEIKH ZAYED MOSQUE");
        System.out.println("Sheikh Zayed Mosque is one of the best places to visit in Abu Dhabi."
                + "From its dome and minarets to its carpets and chandeliers, every single foot of Sheikh Zayed Mosque reminds the "
                + "lavishness of the Arab world and an amalgamation of Persian,"
                + " Moorish and Mughal architectures.");
        System.out.println("Price: No entry fee");
        System.out.println("Press y/n for confirmation");
        char dec1 = scan.next().charAt(0);
        if(dec1 == 'y')
        {
            Total_Cost = Total_Cost+0;
        }


        System.out.println();
        System.out.println("FERRARI WORLD");
        System.out.println("Ferrari World comes across the most popular places to visit in Abu Dhabi, "
                + "it is ones among the list of thrilling rides here are Flying Aces,  Turbo Track, Scuderia Challenge,"
                + " and the world�s fastest roller coaster � Formula Rossa. Numerous events are also held at Ferrari World.");
        System.out.println("Price: AED 249.97");
        System.out.println("Press y/n for confirmation");
        char dec2 = scan.next().charAt(0);
        if(dec2 == 'y')
        {
            Total_Cost = Total_Cost+249.97;
        }


        System.out.println();
        System.out.println("EMIRATES PARK ZOO");
        System.out.println(" This zoo in Abu Dhabi gives you an opportunity to come across a wide range of wildlife species."
                + " There are 1,700 animals in total which include species like White Tiger, Siberian Bear, Lion, and Cheetah, among many others");
        System.out.println("Price: AED 74.46");
        System.out.println("Press y/n for confirmation");
        char dec3 = scan.next().charAt(0);
        if(dec3 == 'y')
        {
            Total_Cost = Total_Cost+74.46;
        }

        System.out.println();
        System.out.println("LOUVRE MUSEUM");
        System.out.println("The museum showcases artwork from across the globe including works of Leonardo Da Vinci, Vincent Van Gogh, Claude Monet, Jacques-Louis David and Henri Matisse among others. "
                + "Not only the artwork but the architecture of the building itself with a floating dome-shaped structure is something not to be missed.");
        System.out.println("Price: AED 63");
        System.out.println("Press y/n for confirmation");
        char dec4 = scan.next().charAt(0);
        if(dec4 == 'y')
        {
            Total_Cost = Total_Cost+63;
        }

        System.out.println();
        System.out.println("WARNER BROS WORLD");
        System.out.println("Different features of the park have been inspired by different Warner Bros. "
                + "franchises like Looney Tunes, DC Comics and Hanna Barbra amongst others. "
                + "Some of the rides include The Joker Funhouse, Tom and Jerry: Swiss Cheese Spin, The Jetsons Cosmic Orbiter, Scooby-Doo ");
        System.out.println("Price: AED 250");
        char dec5 = scan.next().charAt(0);
        if(dec5 == 'y')
        {
            Total_Cost = Total_Cost+250;
        }


        System.out.println();
        System.out.println("Places you've selected to visit:");
        if(dec1=='y') {
            System.out.println("Sheikh Zayed Mosque");
        }
        if(dec2=='y') {
            System.out.println("Ferrari World");
        }
        if(dec3=='y') {
            System.out.println("Emirated Park Zoo");
        }
        if(dec4=='y') {
            System.out.println("Louvre Museum");
        }
        if(dec5=='y') {
            System.out.println("Warner Bros World");
        }

        System.out.println();
        System.out.println("How many people you want to book for:");
        int peps = scan.nextInt();
        Total_Cost=Total_Cost*peps;

        System.out.println("Total Cost for the places you've selected to visit is: AED "+Total_Cost);

        return Total_Cost;


    }



    double forRAK()
    {
        double Total_Cost=0;
        System.out.println();
        System.out.println("Places for Visit:");
        System.out.println("JEBEL JAIS");
        System.out.println("About 55 kilometers northeast of Ras Al-Khaimah, "
                + "Jebel Jais, part of the Hajar Mountain Range, is the United Arab Emirates' "
                + "tallest mountain, with its summit at 1,934 meters.");
        System.out.println("Price: AED 125.75");
        System.out.println("Press y/n for confirmation");
        char dec1 = scan.next().charAt(0);
        if(dec1 == 'y')
        {
            Total_Cost = Total_Cost+125.75;
        }


        System.out.println();
        System.out.println("RAS-AL-KHAIMAH NATIONAL MUSUEM");
        System.out.println("The Ras Al-Khaimah National Museum is in a fort that was the residence of the ruling "
                + "family up until the early 1960s. "
                + "The museum houses an excellent collection of archaeological and ethnological artifacts.");
        System.out.println("Price: AED 5");
        System.out.println("Press y/n for confirmation");
        char dec2 = scan.next().charAt(0);
        if(dec2 == 'y')
        {
            Total_Cost = Total_Cost+5;
        }


        System.out.println();
        System.out.println("RAS AL KHAIMAH BEACHES");
        System.out.println(" Ras Al-Khaimah has plenty for sun seekers and relaxation fans. "
                + "The emirate's long shoreline is strung with luxury resorts all offering their own private patch of golden sand.");
        System.out.println("Price: FREE");
        System.out.println("Press y/n for confirmation");
        char dec3 = scan.next().charAt(0);
        if(dec3 == 'y')
        {
            Total_Cost = Total_Cost+0;
        }



        System.out.println();
        System.out.println("Places you've selected to visit:");
        if(dec1=='y') {
            System.out.println("Jebel Jais");
        }
        if(dec2=='y') {
            System.out.println("Ras-Al-Khaimah National Musuem");
        }
        if(dec3=='y') {
            System.out.println("Ras-Al-Khaimah Beaches");
        }
        System.out.println();
        System.out.println("How many people you want to book for:");
        int peps = scan.nextInt();
        Total_Cost=Total_Cost*peps;
        System.out.println("Total Cost for the places you've selected to visit is: AED "+Total_Cost);

        return Total_Cost;


    }



    double forFUJ()
    {
        double Total_Cost=0;
        System.out.println();
        System.out.println("Places for Visit:");
        System.out.println("FUJAIRAH FORT");
        System.out.println("Considered the oldest fort in the United Arab Emirates, "
                + "it has served previously as both a defensive building and a home for the ruling family. "
                + "And for many centuries, it was the only stone building along the Fujairah coast. ");
        System.out.println("Price: AED 5");
        System.out.println("Press y/n for confirmation");
        char dec1 = scan.next().charAt(0);
        if(dec1 == 'y')
        {
            Total_Cost = Total_Cost+5;
        }


        System.out.println();
        System.out.println("AL AQAH BEACH");
        System.out.println(" Al Aqah beach, dominated by the rocky outcrop of "
                + "\"Snoopy Island\" just offshore, is the emirate of Fujairah's top beach resort.");
        System.out.println("Price: AED 300");
        System.out.println("Press y/n for confirmation");
        char dec2 = scan.next().charAt(0);
        if(dec2 == 'y')
        {
            Total_Cost = Total_Cost+300;
        }


        System.out.println();
        System.out.println("Fujairah Museum");
        System.out.println(" the Fujairah Museum has an excellent collection of artifacts, dating from the early Bronze Age, "
                + "that were unearthed during archaeological digs at Qidfa and Bithnah.");
        System.out.println("Price: AED 10");
        System.out.println("Press y/n for confirmation");
        char dec3 = scan.next().charAt(0);
        if(dec3 == 'y')
        {
            Total_Cost = Total_Cost+10;
        }



        System.out.println();
        System.out.println("Places you've selected to visit:");
        if(dec1=='y') {
            System.out.println("Fujairah Fort");
        }
        if(dec2=='y') {
            System.out.println("Al Aqah Beach");
        }
        if(dec3=='y') {
            System.out.println("Fujairah Museum");
        }
        System.out.println();
        System.out.println("How many people you want to book for:");
        int peps = scan.nextInt();
        Total_Cost=Total_Cost*peps;
        System.out.println("Total Cost for the places you've selected to visit is: AED "+Total_Cost);

        return Total_Cost;



    }




}



//-----------------------------------------------------------------------------------------------------------------

class Lodging {
    Scanner scan = new Scanner(System.in);
    int noOfNights;
    double total_cost;
    String hotel_name;
    String room_type;
    int noOfRooms;
    public double final_cost;

    public void dubai() {
        System.out.println("Enter how many nights are you planning to stay?");
        noOfNights = scan.nextInt();
        boolean check1=true;
        System.out.println("What type of hotel are you looking for in dubai");
        System.out.println("5 :- 5 star");
        System.out.println("4 :- 4 star");
        System.out.println("3 :- 3 star");
        int star = scan.nextInt();
        do{
            if((star>5) || (star <3))
            {
                System.out.println("invalid input pls try again");
                star= scan.nextInt();
            }
        }while( (star > 5) || (star < 3) );
        switch (star) {
            case 5:
                boolean check = true;
                System.out.println(" ");
                System.out.println("5 star hotel available are:");
                System.out.println("->Taj Dubai - Buisness Bay rooms starting @500 AED (code for input :- taj)");
                System.out.println("->Hyatt Regency rooms starting @465 AED (code for input :- hyatt)");
                System.out.println("->Atlantis the Palm rooms starting @750 AED (code for input :- palm)");
                System.out.println("Enter your option:");
                String hotel5star = scan.next();
                do{
                    if((hotel5star.equalsIgnoreCase("taj")) || (hotel5star.equalsIgnoreCase("hyatt")) ||(hotel5star.equalsIgnoreCase("palm"))){
                        break;
                    }
                    else{
                        System.out.println("invalid input for hotel name pls try again");
                        hotel5star = scan.next();
                        check = false;
                    }
                }while(check == false);
                if (hotel5star.equalsIgnoreCase("taj")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 500 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 800 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Taj Dubai Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Taj Dubai";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Taj Dubai Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((800 * noOfRooms) + (0.05 * (800 * noOfRooms)));
                            hotel_name = "Taj Dubai";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("hyatt")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 465 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 750 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Hyatt Regency Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((465 * noOfRooms) + (0.05 * (465 * noOfRooms)));
                            hotel_name = "Hyatt Regency";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Hyatt Regency Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Hyatt Regency";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("palm")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 750 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 900 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Atlantis the Palm Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Atlantis the Palm";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Atlantis the Palm Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((900 * noOfRooms) + (0.05 * (900 * noOfRooms)));
                            hotel_name = "Atlantis the Palm";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 4:
                System.out.println(" ");
                System.out.println("4 star hotel available are:");
                System.out.println("->Four Points by Sheraton rooms starting @400 AED (code for input :- four)");
                System.out.println("->Grand Excelsior rooms starting @420 AED (code for input :- grand)");
                System.out.println("->Holiday inn rooms starting @380 AED (code for input :- inn)");
                System.out.println("Enter your option:");
                String hotel4star = scan.next();
                do{
                    if((hotel4star.equalsIgnoreCase("four")) || (hotel4star.equalsIgnoreCase("grand")) ||(hotel4star.equalsIgnoreCase("inn"))){
                        break;
                    }
                    else{
                        System.out.println("invalid input for hotel name pls try again");
                        hotel4star = scan.next();
                        check = false;
                    }
                }while(check == false);
                if (hotel4star.equalsIgnoreCase("four")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 400 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 500 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Four Points by Sheraton Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((400 * noOfRooms) + (0.05 * (400 * noOfRooms)));
                            hotel_name = "Four Points by Sheraton";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Four Points by Sheraton Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Four Points by Sheraton";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("grand")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 420 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 550 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Grand Excelsior Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((420 * noOfRooms) + (0.05 * (420 * noOfRooms)));
                            hotel_name = "Grand Excelsior";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Grand Excelsior Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((550 * noOfRooms) + (0.05 * (550 * noOfRooms)));
                            hotel_name = "Grand Excelsior";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("inn")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 380 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 475 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Holiday inn Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((380 * noOfRooms) + (0.05 * (380 * noOfRooms)));
                            hotel_name = "Holiday inn";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Holiday inn Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((475 * noOfRooms) + (0.05 * (475 * noOfRooms)));
                            hotel_name = "Holiday inn";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 3:
                System.out.println(" ");
                System.out.println("3 star hotel available are:");
                System.out.println("->City Max Hotel rooms starting @180 AED (code for input :- city)");
                System.out.println("->Palm Beach Hotel rooms starting @150 AED (code for input :- palm)");
                System.out.println("->Golden Sands rooms starting @140 AED (code for input :- sands)");
                System.out.println("Enter your option:");
                String hotel3star = scan.next();
                do{
                    if((hotel3star.equalsIgnoreCase("city")) || (hotel3star.equalsIgnoreCase("palm")) ||(hotel3star.equalsIgnoreCase("sands"))){
                        break;
                    }
                    else{
                        System.out.println("invalid input for hotel name pls try again");
                        hotel3star = scan.next();
                        check = false;
                    }
                }while(check == false);
                if (hotel3star.equalsIgnoreCase("city")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 180 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 250 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            star= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected City Max Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((180 * noOfRooms) + (0.05 * (180 * noOfRooms)));
                            hotel_name = "City Max Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected City Max Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((250 * noOfRooms) + (0.05 * (250 * noOfRooms)));
                            hotel_name = "City Max Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("palm")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @150 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 270 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            star= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Palm Beach Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((150 * noOfRooms) + (0.05 * (150 * noOfRooms)));
                            hotel_name = "Palm Beach Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Palm Beach Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((270 * noOfRooms) + (0.05 * (270 * noOfRooms)));
                            hotel_name = "Palm Beach Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("sands")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 140 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 240 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            star= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Golden Sands Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((140 * noOfRooms) + (0.05 * (140 * noOfRooms)));
                            hotel_name = "Golden Sands";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Golden Sands Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((240 * noOfRooms) + (0.05 * (240 * noOfRooms)));
                            hotel_name = "Golden Sands";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;


        }


    }

    public void abudhabi() {
        boolean check = true;
        System.out.println("Enter how many nights are you planning to stay?");
        noOfNights = scan.nextInt();
        System.out.println("What type of hotel are you looking for in Abu-Dhabi");
        System.out.println("5 :- 5 star");
        System.out.println("4 :- 4 star");
        System.out.println("3 :- 3 star");
        int star = scan.nextInt();
        do{
            if((star>5) || (star <3))
            {
                System.out.println("invalid input pls try again");
                star= scan.nextInt();
            }
        }while( (star > 5) || (star < 3) );
        switch (star) {
            case 5:
                System.out.println(" ");
                System.out.println("5 star hotel available are:");
                System.out.println("->Emirates Palace starting @500 AED (code for input :- palace)");
                System.out.println("->Rosewood Abu-Dhabi rooms starting @465 AED (code for input :- rose)");
                System.out.println("->Grand Hyatt rooms starting @750 AED (code for input :- grand)");
                System.out.println("Enter your option:");
                String hotel5star = scan.next();
                do{
                    if((hotel5star.equalsIgnoreCase("palace")) || (hotel5star.equalsIgnoreCase("rose")) ||(hotel5star.equalsIgnoreCase("grand"))){
                        break;
                    }
                    else{
                        System.out.println("invalid input for hotel name pls try again");
                        hotel5star = scan.next();
                        check = false;
                    }
                }while(check == false);

                if (hotel5star.equalsIgnoreCase("palace")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 500 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 800 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Emirates Palace Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Emirates Palace";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Emirates Palace Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((800 * noOfRooms) + (0.05 * (800 * noOfRooms)));
                            hotel_name = "Emirates Palace";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("rose")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 465 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 750 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Rosewood Abu-Dhabi Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((465 * noOfRooms) + (0.05 * (465 * noOfRooms)));
                            hotel_name = "Rosewood Abu-Dhabi";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Rosewood Abu-Dhabi Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Rosewood Abu-Dhabi";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("grand")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 750 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 900 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Grand Hyatt Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Grand Hyatt";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Grand Hyatt Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((900 * noOfRooms) + (0.05 * (900 * noOfRooms)));
                            hotel_name = "Grand Hyatt";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 4:
                System.out.println(" ");
                System.out.println("4 star hotels available are:");
                System.out.println("->Le Meridien rooms starting @400 AED (code for input :- le)");
                System.out.println("->Novotel rooms starting @420 AED (code for input :- novo)");
                System.out.println("->Holiday inn rooms starting @380 AED (code for input :- inn)");
                System.out.println("Enter your option:");
                String hotel4star = scan.next();
                do{
                    if((hotel4star.equalsIgnoreCase("le")) || (hotel4star.equalsIgnoreCase("novo")) ||(hotel4star.equalsIgnoreCase("inn"))){
                        break;
                    }
                    else{
                        System.out.println("invalid input for hotel name pls try again");
                        hotel4star = scan.next();
                        check = false;
                    }
                }while(check == false);
                if (hotel4star.equalsIgnoreCase("le")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 400 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 500 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Le Meridien Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((400 * noOfRooms) + (0.05 * (400 * noOfRooms)));
                            hotel_name = "Le Meridien";
                            room_type = " Deluxe";
                            giveDisplay();

                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Le Meridien Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Le Meridien";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("novo")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 420 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 550 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Novotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((420 * noOfRooms) + (0.05 * (420 * noOfRooms)));
                            hotel_name = "Novotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Novotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((550 * noOfRooms) + (0.05 * (550 * noOfRooms)));
                            hotel_name = "Novotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("inn")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 380 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 475 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Holiday inn Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((380 * noOfRooms) + (0.05 * (380 * noOfRooms)));
                            hotel_name = "Holiday inn";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Holiday inn Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((475 * noOfRooms) + (0.05 * (475 * noOfRooms)));
                            hotel_name = "Holiday inn";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 3:
                System.out.println(" ");
                System.out.println("3 star hotel available are:");
                System.out.println("->ibis Abu Dhabi Gate rooms starting @180 AED (code for input :- ibis)");
                System.out.println("->Al Diar Mina Hotel rooms starting @150 AED (code for input :- diar)");
                System.out.println("->Premier inn Hotel rooms starting @140 AED (code for input :- inn)");
                System.out.println("Enter your option:");
                String hotel3star = scan.next();
                do{
                    if((hotel3star.equalsIgnoreCase("ibis")) || (hotel3star.equalsIgnoreCase("diar")) ||(hotel3star.equalsIgnoreCase("inn"))){
                        break;
                    }
                    else{
                        System.out.println("invalid input for hotel name pls try again");
                        hotel3star = scan.next();
                        check = false;
                    }
                }while(check == false);
                if (hotel3star.equalsIgnoreCase("ibis")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 180 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 250 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected ibis Abu Dhabi Gate Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((180 * noOfRooms) + (0.05 * (180 * noOfRooms)));
                            hotel_name = "ibis Abu Dhabi Gate";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected ibis Abu Dhabi Gate Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((250 * noOfRooms) + (0.05 * (250 * noOfRooms)));
                            hotel_name = "ibis Abu Dhabi Gate";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("diar")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @150 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 270 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Al Diar Mina hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((150 * noOfRooms) + (0.05 * (150 * noOfRooms)));
                            hotel_name = "Al Diar Mina";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Al Diar Mina Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((270 * noOfRooms) + (0.05 * (270 * noOfRooms)));
                            hotel_name = "Al Diar Mina";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("inn")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 140 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 240 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do{
                        if((type < 1) || (type > 2)){
                            System.out.println("invalid input pls try again");
                            type= scan.nextInt();
                        }
                    }while((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Premier inn Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((140 * noOfRooms) + (0.05 * (140 * noOfRooms)));
                            hotel_name = "Premier inn Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Premier inn Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((240 * noOfRooms) + (0.05 * (240 * noOfRooms)));
                            hotel_name = "Premier inn Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }

                break;


        }


    }

    public void fujairah() {
        boolean check = true;
        System.out.println("Enter how many nights are you planning to stay? ");
        noOfNights = scan.nextInt();
        System.out.println("What type of hotel are you looking for in Fujairah");
        System.out.println("5 :- 5 star");
        System.out.println("4 :- 4 star");
        System.out.println("3 :- 3 star");
        int star = scan.nextInt();
        do {
            if ((star > 5) || (star < 3)) {
                System.out.println("invalid input pls try again");
                star = scan.nextInt();
            }
        }while ((star > 5) || (star < 3)) ;
        switch (star) {
            case 5:
                System.out.println(" ");
                System.out.println("5 star hotel available are:");
                System.out.println("->Fairmont Hotel starting @500 AED (code for input :- fair)");
                System.out.println("->Radisson Blu Resort rooms starting @465 AED (code for input :- blu)");
                System.out.println("->Concorde Hotel Fujairah rooms starting @750 AED (code for input :- con)");
                System.out.println("Enter your option:");
                String hotel5star = scan.next();
                do {
                    if ((hotel5star.equalsIgnoreCase("fair")) || (hotel5star.equalsIgnoreCase("blu")) || (hotel5star.equalsIgnoreCase("con"))) {
                        break;
                    } else {
                        System.out.println("invalid input for hotel name pls try again");
                        hotel5star = scan.next();
                        check = false;
                    }
                } while (check == false);

                if (hotel5star.equalsIgnoreCase("fair")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 500 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 800 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Fairmont Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Fairmont Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Fairmont Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((800 * noOfRooms) + (0.05 * (800 * noOfRooms)));
                            hotel_name = "Fairmont Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("rose")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 465 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 750 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Radisson Blu Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((465 * noOfRooms) + (0.05 * (465 * noOfRooms)));
                            hotel_name = "Radisson Blu Resort";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Radisson Blu Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Radisson Blu Resort";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("con")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 750 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 900 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Concorde Hotel Fujairah Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Concorde Hotel Fujairah";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Concorde Hotel Fujairah Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((900 * noOfRooms) + (0.05 * (900 * noOfRooms)));
                            hotel_name = "Concorde Hotel Fujairah";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }

                break;
            case 4:
                System.out.println(" ");
                System.out.println("4 star hotels available are:");
                System.out.println("->City Tower Hotel rooms starting @400 AED (code for input :- city)");
                System.out.println("->Royal Beach Resort rooms starting @420 AED (code for input :- royal)");
                System.out.println("->Sandy Beach Resort inn rooms starting @380 AED (code for input :- sandy)");
                System.out.println("Enter your option:");
                String hotel4star = scan.next();
                do {
                    if ((hotel4star.equalsIgnoreCase("city")) || (hotel4star.equalsIgnoreCase("royal")) || (hotel4star.equalsIgnoreCase("sandy"))) {
                        break;
                    } else {
                        System.out.println("invalid input for hotel name pls try again");
                        hotel4star = scan.next();
                        check = false;
                    }
                } while (check == false);

                if (hotel4star.equalsIgnoreCase("city")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 400 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 500 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected City Tower Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((400 * noOfRooms) + (0.05 * (400 * noOfRooms)));
                            hotel_name = "City Tower Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected City Tower Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "City Tower Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("royal")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 420 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 550 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Royal Beach Resort Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((420 * noOfRooms) + (0.05 * (420 * noOfRooms)));
                            hotel_name = "Royal Beach Resort";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Royal Beach Resort Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((550 * noOfRooms) + (0.05 * (550 * noOfRooms)));
                            hotel_name = "Royal Beach Resort";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("sandy")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 380 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 475 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Sandy Beach Resort Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((380 * noOfRooms) + (0.05 * (380 * noOfRooms)));
                            hotel_name = "Sandy Beach Resort";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Sandy Beach Resort Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((475 * noOfRooms) + (0.05 * (475 * noOfRooms)));
                            hotel_name = "HSandy Beach Resort";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 3:
                System.out.println(" ");
                System.out.println("3 star hotel available are:");
                System.out.println("->Novotel Fujairah rooms starting @180 AED (code for input :- novo)");
                System.out.println("->East Coast Hotel rooms starting @150 AED (code for input :- east)");
                System.out.println("->Mirage Hotel rooms starting @140 AED (code for input :- mir)");
                System.out.println("Enter your option:");
                String hotel3star = scan.next();
                do {
                    if ((hotel3star.equalsIgnoreCase("novo")) || (hotel3star.equalsIgnoreCase("east")) || (hotel3star.equalsIgnoreCase("mir"))) {
                        break;
                    } else {
                        System.out.println("invalid input for hotel name pls try again");
                        hotel3star = scan.next();
                        check = false;
                    }
                } while (check == false);

                if (hotel3star.equalsIgnoreCase("novo")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 180 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 250 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Novotel Fujairah Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((180 * noOfRooms) + (0.05 * (180 * noOfRooms)));
                            hotel_name = "Novotel Fujairah";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Novotel Fujairah Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((250 * noOfRooms) + (0.05 * (250 * noOfRooms)));
                            hotel_name = "Novotel Fujairah";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("east")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @150 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 270 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected East Coast hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((150 * noOfRooms) + (0.05 * (150 * noOfRooms)));
                            hotel_name = "East Coast Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected East Coast Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((270 * noOfRooms) + (0.05 * (270 * noOfRooms)));
                            hotel_name = "East Coast Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("mir")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 140 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 240 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Mirage Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((140 * noOfRooms) + (0.05 * (140 * noOfRooms)));
                            hotel_name = "Mirage Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Mirage Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((240 * noOfRooms) + (0.05 * (240 * noOfRooms)));
                            hotel_name = "Mirage Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;

                        }
                    }


                }

                break;


        }


    }

    public void rak () {
        boolean check = true;
        System.out.println("Enter how many nights are you planning to stay?");
        noOfNights = scan.nextInt();
        System.out.println("What type of hotel are you looking for in Ras-Al-Khaimah");
        System.out.println("5 :- 5 star");
        System.out.println("4 :- 4 star");
        System.out.println("3 :- 3 star");
        int star = scan.nextInt();
        do {
            if ((star > 5) || (star < 3)) {
                System.out.println("invalid input pls try again");
                star = scan.nextInt();
            }
        } while ((star > 5) || (star < 3));
        switch (star) {
            case 5:
                System.out.println(" ");
                System.out.println("5 star hotel available are:");
                System.out.println("->Hilton RAK Resort starting @500 AED (code for input :- hilton)");
                System.out.println("->The Ritz Carlton rooms starting @465 AED (code for input :- ritz)");
                System.out.println("->Waldorf Astoria Ras-Al-Khaimah rooms starting @750 AED (code for input :- waldorf)");
                System.out.println("Enter your option:");
                String hotel5star = scan.next();
                do {
                    if ((hotel5star.equalsIgnoreCase("hilton")) || (hotel5star.equalsIgnoreCase("ritz")) || (hotel5star.equalsIgnoreCase("waldorf"))) {
                        break;
                    } else {
                        System.out.println("invalid input for hotel name pls try again");
                        hotel5star = scan.next();
                        check = false;
                    }
                } while (check == false);
                if (hotel5star.equalsIgnoreCase("hilton")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 500 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 800 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Hilton RAK Resort Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Hilton RAK Resort";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Hilton RAK Resort Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((800 * noOfRooms) + (0.05 * (800 * noOfRooms)));
                            hotel_name = "Hilton RAK Resort";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("ritz")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 465 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 750 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected The Ritz Carlton Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((465 * noOfRooms) + (0.05 * (465 * noOfRooms)));
                            hotel_name = "The Ritz Carlton";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected The Ritz Carlton Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "The Ritz Carlton";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel5star.equalsIgnoreCase("waldorf")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 750 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 900 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Waldorf Astoria Ras-Al-Khaimah Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((750 * noOfRooms) + (0.05 * (750 * noOfRooms)));
                            hotel_name = "Waldorf Astoria Ras-Al-Khaimah";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Waldorf Astoria Ras-Al-Khaimah Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((900 * noOfRooms) + (0.05 * (900 * noOfRooms)));
                            hotel_name = "Waldorf Astoria Ras-Al-Khaimah";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 4:
                System.out.println(" ");
                System.out.println("4 star hotels available are:");
                System.out.println("->Double Tree by hilton rooms starting @400 AED (code for input :- double)");
                System.out.println("->BM Beach Resort rooms starting @420 AED (code for input :- bm)");
                System.out.println("->Mangrove Hotel rooms starting @380 AED (code for input :- mangrove)");
                System.out.println("Enter your option:");
                String hotel4star = scan.next();
                do {
                    if ((hotel4star.equalsIgnoreCase("double")) || (hotel4star.equalsIgnoreCase("bm")) || (hotel4star.equalsIgnoreCase("mangrove"))) {
                        break;
                    } else {
                        System.out.println("invalid input for hotel name pls try again");
                        hotel4star = scan.next();
                        check = false;
                    }
                } while (check == false);

                if (hotel4star.equalsIgnoreCase("double")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 400 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 500 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Double Tree by Hilton Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((400 * noOfRooms) + (0.05 * (400 * noOfRooms)));
                            hotel_name = "Double Tree by hilton";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Double Tree by hilton Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((500 * noOfRooms) + (0.05 * (500 * noOfRooms)));
                            hotel_name = "Double Tree by hilton";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("bm")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 420 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 550 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected BM Beach Resort Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((420 * noOfRooms) + (0.05 * (420 * noOfRooms)));
                            hotel_name = "BM Beach Resort";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected BM Beach Resort Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((550 * noOfRooms) + (0.05 * (550 * noOfRooms)));
                            hotel_name = "BM Beach Resort";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel4star.equalsIgnoreCase("mangrove")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 380 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 475 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Mangrove Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((380 * noOfRooms) + (0.05 * (380 * noOfRooms)));
                            hotel_name = "Mangrove Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Mangrove Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((475 * noOfRooms) + (0.05 * (475 * noOfRooms)));
                            hotel_name = "Mangrove Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }
                break;
            case 3:
                System.out.println(" ");
                System.out.println("3 star hotel available are:");
                System.out.println("->Royal View Hotel Gate rooms starting @180 AED (code for input :- royal)");
                System.out.println("->Olive Tree Residence Hotel rooms starting @150 AED (code for input :- olive)");
                System.out.println("->Jannah Resort&Villas rooms starting @140 AED (code for input :- jannah)");
                System.out.println("Enter your option:");
                String hotel3star = scan.next();
                do {
                    if ((hotel3star.equalsIgnoreCase("royal")) || (hotel3star.equalsIgnoreCase("olive")) || (hotel3star.equalsIgnoreCase("jannah"))) {
                        break;
                    } else {
                        System.out.println("invalid input for hotel name pls try again");
                        hotel3star = scan.next();
                        check = false;
                    }
                } while (check == false);

                if (hotel3star.equalsIgnoreCase("royal")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 180 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 250 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Royal View Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((180 * noOfRooms) + (0.05 * (180 * noOfRooms)));
                            hotel_name = "Royal View Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Royal View Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((250 * noOfRooms) + (0.05 * (250 * noOfRooms)));
                            hotel_name = "Royal View Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("olive")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @150 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 270 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Olive Tree Residence Hotel Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((150 * noOfRooms) + (0.05 * (150 * noOfRooms)));
                            hotel_name = "Olive Tree Residence Hotel";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Olive Tree Residence Hotel Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((270 * noOfRooms) + (0.05 * (270 * noOfRooms)));
                            hotel_name = "Olive Tree Residence Hotel";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                } else if (hotel3star.equalsIgnoreCase("jannah")) {
                    System.out.println();
                    System.out.println("Types of room that are available are:-");
                    System.out.println("1 :- Deluxe Rooms @ 140 AED + 5% vat for single room (max occupancy 4 per room");
                    System.out.println("2 :- Suite Rooms @ 240 AED 5% vat for single room (max occupancy 4 per room");
                    System.out.println("enter your option");
                    int type = scan.nextInt();
                    do {
                        if ((type < 1) || (type > 2)) {
                            System.out.println("invalid input pls try again");
                            type = scan.nextInt();
                        }
                    } while ((type < 1) || (type > 2));
                    switch (type) {
                        case 1: {
                            System.out.println();
                            System.out.println("choice selected Jannah Resort&Villas Deluxe room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((140 * noOfRooms) + (0.05 * (140 * noOfRooms)));
                            hotel_name = "Jannah Resort&Villas";
                            room_type = " Deluxe";
                            giveDisplay();
                            break;
                        }
                        case 2: {
                            System.out.println();
                            System.out.println("choice selected Jannah Resort&Villas Suite room");
                            System.out.println("enter no of rooms you will need");
                            noOfRooms = scan.nextInt();
                            total_cost = ((240 * noOfRooms) + (0.05 * (240 * noOfRooms)));
                            hotel_name = "Jannah Resort&Villas";
                            room_type = "Suite";
                            giveDisplay();
                            break;
                        }
                    }


                }


                break;


        }


    }

    public void giveDisplay(){
        final_cost = total_cost * noOfNights;
        System.out.println("The total cost for " + noOfNights + " nights" + " for " + noOfRooms + " rooms at " + hotel_name + " is " + final_cost + " AED");
    }

}



//-------------------------------------------------------------------------------------------------------------

abstract class Transport{

    public String vehicle;
    public String emirate;
    public ArrayList<String> stopOvers;
    public double rate;
    public double fare;
    public double distTravelled;
    public int timeTaken;
    public String origin;
    public String destination;
    public String frequency;

    public void ride(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Source");
        origin = scan.nextLine();
        System.out.println("Enter Destination");
        destination = scan.nextLine();
    }

    public double calcFare(){

        double finalCost = rate*(stopOvers.indexOf(destination) - stopOvers.indexOf(origin));
        if (finalCost<0){finalCost = -finalCost;}
        fare = finalCost;
        return finalCost;

    }
}

class Metro extends Transport{

    public Metro(){

        vehicle = "Metro";
        stopOvers = new ArrayList<String>();
        rate = 1;
        fare = calcFare();
        frequency = "2 Mins";
    }

    static Metro initDubaiMetro() {
        // Metro init
        Metro metro = new Metro();
        metro.emirate = "Dubai";
        metro.stopOvers.add("UAE Excahnge");
        metro.stopOvers.add("Danube");
        metro.stopOvers.add("Energy");
        metro.stopOvers.add("Ibn Batutua");
        metro.stopOvers.add("Jabel Ali");
        metro.stopOvers.add("DMCC");
        metro.stopOvers.add("DAMAC");
        metro.stopOvers.add("Nakheel");
        metro.stopOvers.add("Dubai Internet City");
        metro.stopOvers.add("Mashreq");
        metro.stopOvers.add("MOE");
        metro.stopOvers.add("First Abu Dhabi Bank");
        metro.stopOvers.add("Noor Bank");
        metro.stopOvers.add("Business Bay");
        metro.stopOvers.add("Burj Khalifa/Dubai Mall");
        metro.stopOvers.add("Financial Centre");
        metro.stopOvers.add("Emirates Towers");
        metro.stopOvers.add("WTC");
        metro.stopOvers.add("Al jafiliya");
        metro.stopOvers.add("");
        metro.stopOvers.add("ADCB");
        metro.stopOvers.add("Union");
        metro.stopOvers.add("Al Raqqa");
        metro.stopOvers.add("Deira City Centre");
        metro.stopOvers.add("GGICO");
        metro.stopOvers.add("Airport T1");
        metro.stopOvers.add("Airport T2");
        metro.stopOvers.add("Emirates");
        metro.stopOvers.add("Rashidiya");
        System.out.println("You chose to travel by metro, the available stops are: " + metro.stopOvers);
        // convert each stop to the respective lower case so that destination and source can work
        for (int i = 0; i<metro.stopOvers.size();i++){metro.stopOvers.set(i, metro.stopOvers.get(i).toLowerCase(Locale.ROOT));}
        metro.ride();
        metro.calcFare();
        System.out.println("\nFare for the trip will be: AED "+ metro.fare);
        //System.out.print(metro.fare);

        return metro;
    }
    public void ride(){
        Scanner scan = new Scanner(System.in);

        loop:
        while(true) {
            System.out.println("Enter Source");
            origin = scan.nextLine();
            //update made below
            origin = origin.toLowerCase();

            if (stopOvers.contains(origin)){break loop;}
            else{System.out.println("Invalid Input");}
        }
        origin = origin.toLowerCase(Locale.ROOT);

        loop:
        while(true) {
            System.out.println("Enter Destination");
            destination = scan.nextLine();
            //update made below
            destination = destination.toLowerCase();
            if (stopOvers.contains(destination)){break loop;}
            else{System.out.println("Invalid Input");}
        }
        destination = destination.toLowerCase(Locale.ROOT);
    }
}

class Bus extends Transport{
    public Bus(){
        vehicle = "Bus";
        stopOvers = new ArrayList<String>();
        rate = 2.5;
        fare = calcFare();
        frequency = "20 Mins";
    }

    public void ride(){
        Scanner scan = new Scanner(System.in);

        loop:
        while(true) {
            System.out.println("Enter Source");
            origin = scan.nextLine();
            if (stopOvers.contains(origin)){break loop;}
            else{System.out.println("Invalid Input");}
        }
        origin = origin.toLowerCase(Locale.ROOT);

        loop:
        while(true) {
            System.out.println("Enter Destination");
            destination = scan.nextLine();
            if (stopOvers.contains(destination)){break loop;}
            else{System.out.println("Invalid Input");}
        }
        destination = destination.toLowerCase(Locale.ROOT);
    }

    static Bus initBus(String emir) {
        Bus bus = new Bus();
        Scanner scan = new Scanner(System.in);

        System.out.print("The available bus routes are:\n ");
        if (emir.equals("Dubai")) {
            loop:
            while (true) {
                System.out.printf("\nBus number %d: %s %s %s",83,"Stop 11","Stop 12", "Stop 13");
                System.out.printf("\nBus number %d: %s %s %s %s",32,"Stop 1","Stop 2", "Stop 3", "Stop 4\n");
                System.out.println("\nEnter Bus number: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 83: {
                        bus.stopOvers.add("Stop 11");
                        bus.stopOvers.add("Stop 12");
                        bus.stopOvers.add("Stop 13");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}
                    }
                    case 32: {
                        bus.stopOvers.add("Stop 1");
                        bus.stopOvers.add("Stop 2");
                        bus.stopOvers.add("Stop 3");
                        bus.stopOvers.add("Stop 4");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}
                    }
                }
            }
        }
        else if (emir.equals("Abu Dhabi")){
            loop:
            while (true) {
                System.out.printf("\nBus number %d: %s %s %s",83,"Stop 11","Stop 12", "Stop 13");
                System.out.printf("\nBus number %d: %s %s %s %s",32,"Stop 1","Stop 2", "Stop 3", "Stop 4");
                System.out.println("\n\nEnter Bus number: ");
                int choice=  scan.nextInt();
                switch (choice) {
                    case 83: {
                        bus.stopOvers.add("Stop 11");
                        bus.stopOvers.add("Stop 12");
                        bus.stopOvers.add("Stop 13");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}

                    }
                    case 32: {
                        bus.stopOvers.add("stop 1");
                        bus.stopOvers.add("Stop 2");
                        bus.stopOvers.add("Stop 3");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}

                    }
                }
            }
        }
        else if (emir.equals("Fujairah")){
            loop:
            while (true) {
                System.out.printf("\nBus number %d: %s %s %s",83,"Stop 11","Stop 12", "Stop 13");
                System.out.printf("\nBus number %d: %s %s %s %s",32,"Stop 1","Stop 2", "Stop 3", "Stop 4");
                System.out.println("\n\nEnter Bus number: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 83: {
                        bus.stopOvers.add("Stop 11");
                        bus.stopOvers.add("Stop 12");
                        bus.stopOvers.add("Stop 13");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}

                    }
                    case 32: {
                        bus.stopOvers.add("stop 1");
                        bus.stopOvers.add("Stop 2");
                        bus.stopOvers.add("Stop 3");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}

                    }
                }
            }
        }
        else if (emir.equals(("Ras Al Khaimah"))){
            loop:
            while (true) {
                System.out.printf("\nBus number %d: %s %s %s",83,"Stop 11","Stop 12", "Stop 13");
                System.out.printf("\nBus number %d: %s %s %s %s",32,"Stop 1","Stop 2", "Stop 3", "Stop 4");
                System.out.println("\n\nEnter Bus number: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 83: {
                        bus.stopOvers.add("Stop 11");
                        bus.stopOvers.add("Stop 12");
                        bus.stopOvers.add("Stop 13");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}
                    }
                    case 32: {
                        bus.stopOvers.add("stop 1");
                        bus.stopOvers.add("Stop 2");
                        bus.stopOvers.add("Stop 3");
                        System.out.println("Bus " + choice + " route:  " + bus.stopOvers);
                        System.out.println("would you like to ride on this bus? (Yes/No)");
                        String cho = scan.next().toLowerCase(Locale.ROOT);
                        if (cho.equalsIgnoreCase("yes") || cho.equalsIgnoreCase("y")){break loop;}
                        else {bus.stopOvers.clear(); break;}
                    }
                }
            }
        }
        for (int i = 0; i<bus.stopOvers.size();i++){bus.stopOvers.set(i, bus.stopOvers.get(i).toLowerCase(Locale.ROOT));}
        bus.ride();
        bus.calcFare();
        System.out.println("Fare for the trip will be: AED "+ bus.fare);
        //System.out.print(bus.fare);

        return bus;
    }
}

class Aeroplane extends Transport{
    String departureTime;
    String departureDate;
    public Aeroplane(){
        vehicle = "Aeroplane";
        stopOvers = new ArrayList<String>();
        rate = 200;
        fare = calcFare();
        frequency = null;
    }
    @Override
    public double calcFare(){
        Random rand = new Random();
        return rate*rand.nextInt(10);
    }

    @Override
    public void ride() {
        Scanner scan = new Scanner(System.in);
        super.ride();
        System.out.println("Enter the departure Date (DD/MM/YYYY)");
        departureDate = scan.nextLine();
        System.out.println("Enter the departure Time (HH:MM:SS)");
        departureTime = scan.nextLine();

    }

    static Aeroplane initAeroplane(String emir){
        Aeroplane aeroplane = new Aeroplane();
        Scanner scan = new Scanner(System.in);
        aeroplane.origin = emir;
        aeroplane.ride();

        aeroplane.calcFare();
        System.out.println("Fare for the trip will be:" + aeroplane.calcFare() + "and will depart from " + emir + " to " + aeroplane.destination + " at " + aeroplane.departureTime + "on" + aeroplane.departureDate);
        return aeroplane;
    }
}

class Taxi extends Transport {
    public Taxi() {
        vehicle = "Taxi";
        stopOvers = new ArrayList<String>();
        rate = 35;
        fare = calcFare();
        frequency = "5 Mins";
    }

    @Override
    public double calcFare() {
        Random rand = new Random();
        return rate * (rand.nextInt(10) + 1);   // +1 so that we dont get a 0
    }

    static Taxi initTaxi(){
        Taxi taxi = new Taxi();
        taxi.ride();
        taxi.calcFare();
        System.out.println("Fare for the trip will be: AED "+ taxi.fare);
        return taxi;
    }
}

class WaterWays extends Transport{
    public WaterWays(){
        vehicle = "Boat";
        stopOvers = new ArrayList<String>();
        rate = 2;
        fare = calcFare();
        frequency = "30 Mins";
    }
    @Override
    public double calcFare(){
        Random rand = new Random();
        return rate * (rand.nextInt(10)+1);
    }

    static WaterWays initWaterways(String emir){
        WaterWays waterway = new WaterWays();
        waterway.ride();
        // Scanner scan = new Scanner(System.in);
        //System.out.println("Please enter starting point");
        //waterway.origin = scan.nextLine();
        //System.out.println("Please enter Destination");
        // waterway.destination = scan.nextLine();
        waterway.calcFare();
        System.out.println("Fare for the trip will be: AED "+ waterway.fare);
        return waterway;
    }
}

class RentCar extends Transport{
    public RentCar(){
        vehicle = "Rent a car";
        stopOvers = new ArrayList<String>();
        rate = 35;
        fare = calcFare();
        frequency = null;
    }
    @Override
    public double calcFare(){
        Random rand = new Random();
        return rate * (rand.nextInt(10) + 1);
    }

    static RentCar initRentCar(){
        RentCar rentcar = new RentCar();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter starting point");
        rentcar.origin = scan.nextLine();
        System.out.println("Please enter Destination");
        rentcar.destination = scan.nextLine();
        rentcar.calcFare();
        System.out.println("Fare for the trip will be: AED "+ rentcar.fare);
        //System.out.print(rentcar.fare);
        return rentcar;
    }
}

class TransportChoice {
    boolean check[] = {false, false, false, false, false, false};
    Aeroplane aeroplane;
    Bus bus;
    Taxi taxi;
    RentCar rentcar;
    Metro metro;
    WaterWays waterway;

    void Choice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Hello! and Welcome to our Transport Management System!");
        System.out.println("******************************************************\n");
        System.out.println("please choose Emirate\n");
        System.out.println("1. Abu Dhabi\n2. Dubai\n3. RasAlKhaimah\n4. Fujairah");
        int choice = scan.nextInt();
        majorloop:
        while (true) {
            switch (choice) {
                case 1: {
                    System.out.println("\nWelcome to Abu Dhabi Transport Authority\n");
                    loop:
                    // no goto, we use labels in java. This is it's example.
                    while (true) {
                        System.out.println("please choose Mode of transport");
                        System.out.println("1. Bus\n2. Taxi\n3. Rent A Car\nSpecial options, check before booking\n4. Waterways\n5. Aeroplane");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                System.out.println("You chose to travel by Bus\n");
                                bus = Bus.initBus("Abu Dhabi");
                                bus.emirate = "Abu Dhabi";
                                check[1] = true;
                                break loop; // Break `label`
                            }
                            case 2: {
                                System.out.println("You chose to travel by Taxi\n");
                                taxi = Taxi.initTaxi();
                                taxi.emirate = "Abu Dhabi";
                                check[4] = true;
                                break loop;
                            }
                            case 3: {
                                System.out.println("You chose to Rent A Car\n");
                                rentcar = RentCar.initRentCar();
                                rentcar.emirate = "Abu Dhabi";
                                check[2] = true;
                                break loop;
                            }
                            case 4: {
                                System.out.println("You chose to travel by Waterways\n");
                                waterway = WaterWays.initWaterways("Abu Dhabi");
                                waterway.emirate = "Abu Dhabi";
                                check[5] = true;
                                break loop;
                            }
                            case 5: {
                                System.out.println("You chose to travel by Aeroplane\n");
                                aeroplane = Aeroplane.initAeroplane("Abu Dhabi");
                                aeroplane.emirate = "Abu Dhabi";
                                check[0] = true;
                                break loop;
                            }
                            default: {
                                System.out.println("Invalid choice");
                                break;
                            }
                        }
                    }
                    break majorloop;
                }
                case 2: {
                    System.out.println("\nWelcome to Dubai Transport Authority\n");
                    loop:
                    while (true) {
                        System.out.println("please choose Mode of transport");
                        System.out.println("1. Metro\n2. Bus\n3. Taxi\n4. Rent A Car\nSpecial options, check before booking\n5. Waterways\n6. Aeroplane");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                System.out.println("You chose to travel by Metro");
                                metro = Metro.initDubaiMetro();
                                metro.emirate = "Dubai";
                                check[3] = true;
                                break loop;
                            }
                            case 2: {
                                System.out.println("You chose to travel by Bus\n");
                                bus = Bus.initBus("Dubai");
                                bus.emirate = "Dubai";
                                check[1] = true;
                                break loop; // Break `label`
                            }
                            case 3: {
                                System.out.println("You chose to travel by Taxi\n");
                                taxi = Taxi.initTaxi();
                                taxi.emirate = "Dubai";
                                check[4] = true;
                                break loop;
                            }
                            case 4: {
                                System.out.println("You chose to Rent A Car\n");
                                rentcar = RentCar.initRentCar();
                                rentcar.emirate = "Dubai";
                                check[2] = true;
                                break loop;
                            }
                            case 5: {
                                System.out.println("You chose to travel by Waterways\n");
                                waterway = WaterWays.initWaterways("Dubai");
                                waterway.emirate = "Dubai";
                                check[5] = true;
                                break loop;
                            }
                            case 6: {
                                System.out.println("You chose to travel by Aeroplane\n");
                                aeroplane = Aeroplane.initAeroplane("Dubai");
                                aeroplane.emirate = "Dubai";
                                check[0] = true;
                                break loop;
                            }
                            default: {
                                System.out.println("Invalid choice");
                                break;
                            }
                        }

                    }
                    break majorloop;
                }
                case 3: {
                    System.out.println("\nWelcome to Ras Al Khaimah Transport Authority\n");
                    loop:
                    // no goto, we use labels in java. This is it's example.
                    while (true) {
                        System.out.println("please choose Mode of transport");
                        System.out.println("1. Bus\n2. Taxi\n3. Rent A Car\nSpecial options, check before booking\n4. Waterways\n5. Aeroplane");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                System.out.println("You chose to travel by Bus\n");
                                Bus RasAlKhaimahBus = Bus.initBus("Ras Al Khaimah");
                                RasAlKhaimahBus.emirate = "Ras Al Khaimah";
                                break loop; // Break `label`
                            }
                            case 2: {
                                System.out.println("You chose to travel by Taxi\n");
                                Taxi RasAlKhaimahTaxi = Taxi.initTaxi();
                                RasAlKhaimahTaxi.emirate = "Ras Al Khaimah";
                                break loop;
                            }
                            case 3: {
                                System.out.println("You chose to Rent A Car\n");
                                RentCar RasAlKhaimahRentCar = RentCar.initRentCar();
                                RasAlKhaimahRentCar.emirate = "Ras Al Khaimah";
                                break loop;
                            }
                            case 4: {
                                System.out.println("You chose to travel by Waterways\n");
                                WaterWays RasAlKhaimahWaterway = WaterWays.initWaterways("Ras Al Khaimah");
                                RasAlKhaimahWaterway.emirate = "Ras Al Khaimah";
                                break loop;
                            }
                            case 5: {
                                System.out.println("You chose to travel by Aeroplane\n");
                                Aeroplane RasAlKhaimahAeroplane = Aeroplane.initAeroplane("Ras Al Khaimah");
                                RasAlKhaimahAeroplane.emirate = "Ras Al Khaimah";
                                break loop;
                            }
                            default: {
                                System.out.println("Invalid choice");
                                break;
                            }
                        }
                    }
                    break majorloop;
                }
                case 4: {
                    System.out.println("\nWelcome to Fujairah Transport Authority\n");
                    loop:
                    // no goto, we use labels in java. This is it's example.
                    while (true) {
                        System.out.println("please choose Mode of transport");
                        System.out.println("1. Bus\n2. Taxi\n3. Rent A Car\nSpecial options, check before booking\n4. Waterways\n5. Aeroplane");
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1: {
                                System.out.println("You chose to travel by Bus\n");
                                bus = Bus.initBus("Fujairah");
                                bus.emirate = "Fujairah";
                                check[1] = true;
                                break loop; // Break `label`
                            }
                            case 2: {
                                System.out.println("You chose to travel by Taxi\n");
                                taxi = Taxi.initTaxi();
                                taxi.emirate = "Fujairah";
                                check[4] = true;
                                break loop;
                            }
                            case 3: {
                                System.out.println("You chose to Rent A Car\n");
                                rentcar = RentCar.initRentCar();
                                rentcar.emirate = "Fujairah";
                                check[2] = true;
                                break loop;
                            }
                            case 4: {
                                System.out.println("You chose to travel by Waterways\n");
                                waterway = WaterWays.initWaterways("Fujairah");
                                waterway.emirate = "Fujairah";
                                check[5] = true;
                                break loop;
                            }
                            case 5: {
                                System.out.println("You chose to travel by Aeroplane\n");
                                aeroplane = Aeroplane.initAeroplane("Fujairah");
                                aeroplane.emirate = "Fujairah";
                                check[0] = true;
                                break loop;
                            }
                            default: {
                                System.out.println("Invalid choice");
                                break;
                            }
                        }
                    }
                    break majorloop;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    void display() {
        if (check[0]) {
            System.out.println("You are travelling by plane from " + aeroplane.origin + " to " + aeroplane.destination + "and you will be departing on" + aeroplane.departureTime + ".\n Happy Journey!");
        } else if (check[1]) {
            System.out.println("You are travelling by Bus from " + bus.origin + " to " + bus.destination + ".\n Happy Journey!");
        } else if (check[2]) {
            System.out.println("You are Renting A Car from " + rentcar.origin + " to " + rentcar.destination + ".\n Happy Journey!");
        } else if (check[3]) {
            System.out.println("You are travelling by Metro from " + metro.origin + " to " + metro.destination + ".\n Happy Journey!");
        } else if (check[4]) {
            System.out.println("You are travelling by taxi from " + taxi.origin + " to " + taxi.destination + ".\n Happy Journey!");
        } else if (check[5]) {
            System.out.println("You are travelling by Boat from " + waterway.origin + " to " + waterway.destination + ".\n Happy Journey!");
        }
    }

    double fare() {
        if (check[0]) {
            return aeroplane.fare;
        } else if (check[1]) {
            return bus.fare;
        } else if (check[2]) {
            return rentcar.fare;
        } else if (check[3]) {
            return metro.fare;
        } else if (check[4]) {
            return taxi.fare;
        } else if (check[5]) {
            return waterway.fare;
        }
        return 0;
    }
}


//-----------------------------------------------------------------------------------------------------------