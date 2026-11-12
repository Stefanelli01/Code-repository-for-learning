package janela;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Main {

    static void main(String[] args) {
        // Janela
        JFrame janela = new JFrame();
        janela.setSize(700, 700);
        janela.getContentPane().setBackground(new Color(200, 30, 50));
        janela.add(label);
        janela.setVisible(true);

    }
}
