import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class MyFrame extends JFrame implements ActionListener {
    JButton sortEcanc = new JButton("SORTEGGIA E CANCELLA");

    JTextArea nrand = new JTextArea();
    boolean a[]=new boolean[90];
    JTable tabellone=new JTable(9,10);
    public MyFrame(){
        super("TOMBOLA");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(nrand);
        nrand.setPreferredSize(new Dimension(170, 16));

        c.add(tabellone);

        c.add(sortEcanc);
        sortEcanc.addActionListener(e->sorteggia());

        setSize(800, 300);
        setVisible(true);
        setResizable(false);

        for(int i=0; i<90; i++) {
            a[i]=false;
        }
    }

    public void sorteggia(){
        boolean cond=true;
        while (cond){
            int randomNum = (int)(Math.random() * 91);
            int row = (randomNum - 1)/10;
            int col = (randomNum - 1)%10;
            Object valoreCella = tabellone.getValueAt(row, col);
            if(valoreCella == null){
                tabellone.setValueAt(randomNum, row, col);
                cond=false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sortEcanc){
            sorteggia();
        }
    }
}
