package Controllers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.Menu;
import Views.PopUpTache;

import javax.swing.*;

public class PopUpTacheController implements ActionListener {
    private PopUpTache popUpTache;

    public PopUpTacheController(PopUpTache popUpTache) {
        this.popUpTache = popUpTache;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn.getActionCommand() == "Oui") {
            popUpTache.getText().setBackground(new Color(0,255,0));
            Menu.updateNbFaitesVert();

            //////////////////// TESTS ///////////////////////////////
				/* isGreen = true;
				isRed = false;
				System.out.println(isGreen);
				System.out.println(isRed);
				Views.Menu menu = new Views.Menu();
				menu.effectuees.setText("Tâches effectuées : "+(menu.Calendrier.NBFAITES+1));
				menu.Calendrier.NBFAITES++;
				menu.setVisible(true);
				menu.toFront(); */
            /////////////////////////////////////////////////////////

        }

        if (btn.getActionCommand() == "Non") {
            popUpTache.getText().setBackground(new Color(255,0,0));
            popUpTache.isRed = true;
            popUpTache.isGreen = false;
            System.out.println(popUpTache.isGreen);
            System.out.println(popUpTache.isRed);
        }
    }
}
