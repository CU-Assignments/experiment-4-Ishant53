import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class Project4_2 {
    public static void main(String[] args) {
        Map<String, List<Card>> cardCollection = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cards: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter card symbol: ");
            String symbol = scanner.nextLine();
            System.out.print("Enter card value: ");
            String value = scanner.nextLine();

            cardCollection.putIfAbsent(symbol, new ArrayList<>());
            cardCollection.get(symbol).add(new Card(symbol, value));
        }

        System.out.print("Enter symbol to search: ");
        String searchSymbol = scanner.nextLine();

        List<Card> cards = cardCollection.get(searchSymbol);
        if (cards != null) {
            System.out.println("Cards with symbol " + searchSymbol + ":");
            for (Card card : cards) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found with symbol " + searchSymbol);
        }

        scanner.close();
    }
}
