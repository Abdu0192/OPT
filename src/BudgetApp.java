import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BudgetApp extends JPanel {

    private Transactions transactions;
    private  Budget budget = new Budget(500);
    private Font font = new Font("Arial", Font.BOLD, 20);
    private Color textColor = Color.black;
    private JTextArea textArea;
    private JButton addButton = new JButton("Add Transaction");
    private JButton BudgetButton = new JButton("Add Budget");
    private JButton InkomstButton = new JButton("inkomst Budget");
    public BudgetApp() {
        this.transactions = new Transactions();

        this.textArea = new JTextArea(1, 10);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String transactionName = JOptionPane.showInputDialog(BudgetApp.this, "Voer de naam van de transactie in:");
                double transactionAmount = Double.parseDouble(JOptionPane.showInputDialog(BudgetApp.this, "Voer het transactiebedrag in:"));
                transactions.SetTransacties(transactionName,transactionAmount);
                budget.setCurrentBudget(budget.getBudget()-transactions.getTotalCost());
                 Date date = new OverBudgetWaarschuwing(200);
                 date.setDatum("18-5-2023");
                repaint();
            }
        });

        BudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double transactionAmount = Double.parseDouble(JOptionPane.showInputDialog(BudgetApp.this, "Voer het budget in:"));
                budget.setBudget(transactionAmount);
                budget.setCurrentBudget(budget.getBudget()-transactions.getTotalCost());
                repaint();
            }
        });
        InkomstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double inkomst = Double.parseDouble(JOptionPane.showInputDialog(BudgetApp.this, "Voer het inkomst in:"));
                budget.setInkomst(inkomst);
                repaint();
            }
        });
        add(addButton);
        add(BudgetButton);
        add(InkomstButton);


    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        transactions.DrawTransactions(g,transactions,addButton,textArea);
        budget.draw(g,BudgetButton,InkomstButton);
    }
}
