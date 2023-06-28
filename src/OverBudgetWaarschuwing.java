import javax.swing.JOptionPane;

public class OverBudgetWaarschuwing extends Budget implements Date{
    public OverBudgetWaarschuwing(double budget) {
        super(budget);
    }

@Override
    public void CheckBudgetisOnder0(double currentBudget) {
        if (currentBudget < 0) {
            JOptionPane.showMessageDialog(null, "Waarschuwing je bent over je budget!");
        }
    }

    @Override
    public void setDatum(String datum) {
        System.out.println(datum);
    }
}
