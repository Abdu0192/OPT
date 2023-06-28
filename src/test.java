import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void conditioncoverage() {
       assertEquals(true, Budget.Budgetrapportgemaaktals(true,false,true));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,true,false));

    }
    @Test
    public void decisioncoverage(){
        assertEquals(true, Budget.Budgetrapportgemaaktals(true,false,true));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,true,false));
    }
    @Test
    public void coverage_decision_coverage(){
        assertEquals(true, Budget.Budgetrapportgemaaktals(true,false,true));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,true,false));
    }

    @Test
    public void modiefiedmultipledecisioncoverage(){
        assertEquals(true, Budget.Budgetrapportgemaaktals(true,false,true));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,false,true));
        assertEquals(true, Budget.Budgetrapportgemaaktals(false,true,true));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,true,false));
    }

    @Test
    public void multipledecisioncoverage(){
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,false,false));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,false,true));
        assertEquals(false, Budget.Budgetrapportgemaaktals(false,true,false));
        assertEquals(true, Budget.Budgetrapportgemaaktals(false,true,true));


        assertEquals(true, Budget.Budgetrapportgemaaktals(true,false,false));
        assertEquals(true, Budget.Budgetrapportgemaaktals(true,false,true));
        assertEquals(true, Budget.Budgetrapportgemaaktals(true,true,false));
        assertEquals(true, Budget.Budgetrapportgemaaktals(true,true,true));

    }


    @Test
    public void equivalentieAndRANDwaarden() {

        assertEquals(0/100*10,Budget.BudgetAdvies_EQ_RD(0));
        assertEquals(1/100*10,Budget.BudgetAdvies_EQ_RD(1));
        assertEquals(999/100*10,Budget.BudgetAdvies_EQ_RD(999));

        assertEquals(1000/100*20,Budget.BudgetAdvies_EQ_RD(1000));
        assertEquals(1001/100*20,Budget.BudgetAdvies_EQ_RD(1001));
        assertEquals(9999/100*20,Budget.BudgetAdvies_EQ_RD(9999));


        assertEquals(10000/100*30,Budget.BudgetAdvies_EQ_RD(10000));
        assertEquals(10001/100*30,Budget.BudgetAdvies_EQ_RD(10001));
    }



    @Test
    public void pairwisetesting() {
        assertEquals(-1, Budget.appcoste(8, false, false, 10));
        assertEquals(50, Budget.appcoste(8, true, true, 13));
///
        assertEquals(0, Budget.appcoste(15, false, true, 10));
        assertEquals(-1, Budget.appcoste(15, true, false, 13));
///
        assertEquals(50, Budget.appcoste(21, false, true, 13));
        assertEquals(-1, Budget.appcoste(21, true, false, 10));

    }
}