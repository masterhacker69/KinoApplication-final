import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Favoritenliste {
    private JTextArea FlFeld;
    public JPanel flPanel;
    private JButton loeschenButton;
    private JButton zurückButton;
    private Hauptmenu hm1;
    Filter kategorien = new Filter();
    private Favoriten m1;

    public void favoritenlisteFunktionen(JFrame frame) {

        this.hm1 = new Hauptmenu(frame);
        this.m1 = new Favoriten();
        String gespeichertefavoriten = "Keine Favoriten";
        try {
            gespeichertefavoriten = kategorien.favoritenaufnahme();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        FlFeld.setText(gespeichertefavoriten);


        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    m1.loeschen();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                String keinefavoriten = "Keine Favoriten";
                FlFeld.setText(keinefavoriten);
            }
        });

        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(hm1.hmPanel);
                frame.invalidate();
                frame.validate();
            }
        });
    }
}