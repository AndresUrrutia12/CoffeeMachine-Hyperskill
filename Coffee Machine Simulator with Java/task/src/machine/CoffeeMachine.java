package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public String  option ( String userInput){
        return userInput;
    }

    public static void main(String[] args) {

        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/

        /*System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(cups * 200 + " ml of water");
        System.out.println(cups * 50 + " ml of milk");
        System.out.println(cups * 15 + " g of coffee beans");*/

        /*System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int cupsPossible = Math.min(water / 200, Math.min(milk / 50, beans / 15));
        if (cupsPossible == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsPossible > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (cupsPossible - cups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + cupsPossible + " cup(s) of coffee");
        }*/
        CoffeeMachine coffeeMaker = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!coffeeMaker.option(userInput).equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            userInput = scanner.next();
            String option = coffeeMaker.option(userInput);
            switch (option){
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
            }
        }


    }

    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = scanner.next();
        if (water < 200) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if ( milk < 75) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println("Did you change your mind? Type 'back' to return to the main menu :");
        switch (choice) {
            case "1":
                water -= 250;
                beans -= 16;
                money += 4;
                cups--;
                break;
            case "2":
                water -= 350;
                milk -= 75;
                beans -= 20;
                money += 7;
                cups--;
                break;
            case "3":
                water -= 200;
                milk -= 100;
                beans -= 12;
                money += 6;
                cups--;
                break;
            case "back":
                break;
        }
    }
    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }
    public static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }
    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$"+ money + " of money");
    }
}
