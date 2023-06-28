import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Transactions {

    private HashMap<String, Double> transactions = new HashMap<>();
    private Random rand = new Random();

    public Transactions() {
        transactions.put("T-Shirt", 12.99); transactions.put("Jeans", 24.99); transactions.put("Sneakers", 49.99);
    }

    public void SetTransacties(String transaction, double amount) {
        transactions.put(transaction, amount);
    }

    public HashMap<String, Double> getTranacties() {
        return transactions;
    }

    public double getTotalCost() {
        double total = 0.0;
        for (Double cost : transactions.values()) { total += cost;}
        return total;
    }

    public void DrawTransactions(Graphics g, Transactions transactions, JButton addButton, JTextArea textArea) {
        Color backgroundColor = Color.WHITE;
        Color textColor = Color.BLACK;
        Font font = new Font("Arial", Font.PLAIN, 14);
        g.setFont(font);

        int y = 40;
        int maxPriceWidth = 0;
        int rectangleWidth = 200 + 10;
        int rectangleHeight = 20;
        int Xposition = 500;
        int padding = 5;

        for (Map.Entry<String, Double> transaction : transactions.getTranacties().entrySet()) {
            String transactionName = transaction.getKey();
            double price = transaction.getValue();

            String transactionString = transactionName + " - " + price;

            // Draw a rectangle for the background
            g.setColor(backgroundColor);
            g.fillRect(Xposition, y - rectangleHeight + padding, rectangleWidth, rectangleHeight);
            g.setColor(Color.BLACK);
            g.drawRect(Xposition, y - rectangleHeight + padding, rectangleWidth, rectangleHeight);

            // Draw the transaction string
            g.setColor(textColor);
            g.drawString(transactionName, Xposition + padding, y);

            // Determine the X position coordinate of the price string
            String priceString = String.format("%.2f", price);
            int priceWidth = g.getFontMetrics().stringWidth(priceString);
            if (priceWidth > maxPriceWidth) {
                maxPriceWidth = priceWidth;
            }
            int priceX = Xposition + rectangleWidth - padding - priceWidth;
            g.drawString(priceString, priceX, y);

            y += 20;
        }

        // Add button and text area at the end
        addButton.setBounds(Xposition, y + 50, 200, 30);
        textArea.setLocation(Xposition, y + 20);
    }
}
