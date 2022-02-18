import java.util.ArrayList;

public class CafeUtil {
    // BONUS NINJA
    public int getStreakGoal(int numWeeks){
        int streakGoal = 0;
        for (int i = 1; i<=numWeeks; i++){
            streakGoal += i;
        }
        return streakGoal;
    }

    public double getOrderTotal(double[] prices){
        double orderTotal = 0;
        for (double itemPrice: prices){
            System.out.println(itemPrice);
            orderTotal += itemPrice;
        }
        return orderTotal;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Por favor, ingresa tu nombre:");
        String userName = System.console().readLine();
        System.out.println("¡Hola, "+userName+"!");
        System.out.println("Hay "+ customers.size() +" personas frente a ti");
        customers.add(userName);
        System.out.println(customers);
    }

    // BONUS NINJA
    public void printPriceChart(String product, double price, int maxQuantity){
        for (int i = 1; i <= maxQuantity; i++){
            System.out.print(i + " - $" + String.format("%,.0f", price*i)+"\n");
        }
    }

    // BONUS SENSEI
    public void addCustomers(ArrayList<String> customers){
        String userName ="";
        while ( true ){
            System.out.println("\n Por favor, ingresa el nombre del cliente:");
            userName = System.console().readLine();
            // System.out.println(userName == "q");
            if (userName.equals("q")){ break; }
            System.out.println("¡Hola, "+userName+"!");
            System.out.println("Hay "+ customers.size() +" personas frente a ti");
            customers.add(userName);
            System.out.println(customers);
        }
    }
}