
import java.util.*;
class Marketplace {

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        // User data
        int[] userIds = {1,2,3};
        String[] userFirstNames = {"Nick", "John", "Mike"};
        String[] userLastName = {"Keigek", "Wood", "Jordan"};
        int[] userMoney = {1000, 1500, 2000};
        String[][] usersProducts = new String[3][3];

        // Products data
        int[] productIds = {1,2,3};
        String[] productNames = {"iPhone SE", "iPhone X", "iPhone 13" };
        int[] productPrices = {600, 1000, 1200 };
        String[][] productsUsers = new String[3][3];

        boolean endAll = true;

        // Navigation
        while (endAll) {
            System.out.print("\n");
            System.out.print("Display list of all users - push 1\n");
            System.out.print("Display list of all products - push 2\n");
            System.out.print("Buy product - push 3\n");
            System.out.print("Display list of user products by user id - push 4\n");
            System.out.print("Display list of users that bought product by product id - push 5\n");
            System.out.print("Exit - push 9\n");


            int menuNumber = scanner.nextInt();
            // Print all users
            if(menuNumber == 1) {
                System.out.println("list of all users:");
                for(int i = 0; i < userIds.length; i++) {
                    System.out.println(userFirstNames[i] + " " + userLastName[i]);
                }
            //print all products
            } else if (menuNumber == 2) {
                System.out.println("list of all products:");
                for(int i = 0; i < productIds.length; i++) {
                    System.out.println(productNames[i]);
                }
            // purchase
            } else if (menuNumber == 3) {
                System.out.print("Insert your ID\n");
                int buyerId = scanner.nextInt();
                System.out.print("What products du you want to buy?\n");
                for(int i = 0; i < productIds.length; i++) {
                    System.out.println(productNames[i] + ", " + productPrices[i] + " USD" + " - push " + i);
                }
                int product = scanner.nextInt();
                for(int i = 0; i < userIds.length; i++) {
                    if(buyerId == userIds[i]) {
                        if (productPrices[product] <= userMoney[i]) {
                            userMoney[i] -= productPrices[product];
                            usersProducts[i][product] = productNames[product];
                            productsUsers[product][i] = userFirstNames[i];
                            System.out.println("Congrats! You got " + productNames[product] + " !");
                            System.out.println("You have " + userMoney[i] + " USD on your account.");
                        } else {
                            System.out.print("You don`t have enough money \n");
                        }

                    }
                }
            // print products by user ID
            } else if (menuNumber == 4) {
                System.out.print("Insert your ID\n");
                int buyerId = scanner.nextInt();
                for(int i = 0; i < userIds.length; i++) {
                    if(buyerId == userIds[i]) {
                        System.out.println("You have bought these products:");
                        for(int j = 0; j < usersProducts[i].length; j++) {
                            if(usersProducts[i][j] == null) {
                                System.out.print("");
                            } else {
                                System.out.println(usersProducts[i][j]);
                            }
                        }
                    }
                }
            // print users by product ID
            } else if (menuNumber == 5) {
                System.out.print("Insert product ID\n");
                for(int i = 0; i < productIds.length; i++) {
                    System.out.println(productNames[i] + ", " + " ID - " + productIds[i]);
                }
                int productId = scanner.nextInt();
                for(int i = 0; i < productIds.length; i++) {
                    if(productId == productIds[i]) {
                        System.out.println(productNames[i] + " bought:");
                        for(int j = 0; j < productsUsers[i].length; j++) {
                            if(productsUsers[i][j] == null) {
                                System.out.print("");
                            } else {
                                System.out.println(productsUsers[i][j]);
                            }
                        }
                    }
                }
            // Exit check
            } else if (menuNumber == 9) {
                endAll = !true;
            }

        }
        scanner.close();
    }

    public static void main(String[] args) {
        Marketplace money = new Marketplace();
        money.Menu();
    }
}