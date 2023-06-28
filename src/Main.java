import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Main extends JFrame {

    public static void main( String[] args ) {
        JFrame frame = new Main();
        frame.setSize( 1000, 800 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "BudgetApp");
        JPanel paneel = new BudgetApp();
        frame.setContentPane(paneel);
        frame.setVisible( true );



    }

}
