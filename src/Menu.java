import Models.Calendrier;
import Models.Tache;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    public static Calendrier Calendrier;
    public static JLabel effectuees;
    private static PopUpTache PopUpTache;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Menu() {

        List<Tache> Taches = new LinkedList<Tache>();
        this.Calendrier = new Calendrier(Taches);
        Calendrier.NBFAITES = 0;
        Calendrier.NBPASFAITES = 0;

        String[] Jour = new String[7];
        Jour[0]= "Lundi";
        Jour[1]= "Mardi";
        Jour[2]= "Mercredi";
        Jour[3]= "Jeudi";
        Jour[4]= "Vendredi";
        Jour[5]= "Samedi";
        Jour[6]= "Dimanche";

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
        String formattedDate = df.format(new Date());
        String[] DateEnLettres = formattedDate.split(" ");

        String JournéeToday = DateEnLettres[0];
        String NuméroWeek;
        String MoisWeek = DateEnLettres[2];
        String AnnéeWeek = DateEnLettres[3];

        switch(MoisWeek){

            case "janvier":
                MoisWeek = "01";
                break;

            case "février":
                MoisWeek = "02";
                break;

            case "mars":
                MoisWeek = "03";
                break;

            case "avril":
                MoisWeek = "04";
                break;

            case "mai":
                MoisWeek = "05";
                break;

            case "juin":
                MoisWeek = "06";
                break;

            case "juillet":
                MoisWeek = "07";
                break;

            case "août":
                MoisWeek = "08";
                break;

            case "septembre":
                MoisWeek = "09";
                break;

            case "octobre":
                MoisWeek = "10";
                break;

            case "novembre":
                MoisWeek = "11";
                break;

            case "décembre":
                MoisWeek = "12";
                break;
        }

        List<String> Mois31 = new LinkedList<String>();
        Mois31.add("01");
        Mois31.add("03");
        Mois31.add("05");
        Mois31.add("07");
        Mois31.add("08");
        Mois31.add("10");
        Mois31.add("12");
        List<String> Mois30 = new LinkedList<String>();
        Mois30.add("04");
        Mois30.add("06");
        Mois30.add("09");
        Mois30.add("11");
        int JoursAEnlevé = 0;
        for (String Journée : Jour) {
            if (!(JournéeToday.toUpperCase().equals(Jour[JoursAEnlevé].toUpperCase()))) {
                JoursAEnlevé = JoursAEnlevé+1;
            }
        }
        if (Integer.valueOf(DateEnLettres[1])-JoursAEnlevé > 0) {
            NuméroWeek = String.valueOf(Integer.valueOf(DateEnLettres[1])-JoursAEnlevé);
        } else {
            NuméroWeek = String.valueOf(DateEnLettres[1]);
            while (Integer.valueOf(NuméroWeek) > 0) {
                NuméroWeek = String.valueOf(Integer.valueOf(DateEnLettres[1])-1);
                JoursAEnlevé --;
            }
            if (Mois31.contains(MoisWeek)) {
                NuméroWeek = String.valueOf(31-JoursAEnlevé);
            } else if (Mois30.contains(MoisWeek)) {
                NuméroWeek = String.valueOf(30-JoursAEnlevé);
            } else if ((Integer.valueOf(AnnéeWeek)%4==0 && Integer.valueOf(AnnéeWeek)%100!=0) || Integer.valueOf(AnnéeWeek)%400==0) {
                NuméroWeek = String.valueOf(29-JoursAEnlevé);
            } else {
                NuméroWeek = String.valueOf(28-JoursAEnlevé);
            }
        }


        setTitle("To-Do Lister by Dracolf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\img\\todolist.png"));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel Titre = new JPanel();
        contentPane.add(Titre, BorderLayout.NORTH);
        Titre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(".\\src\\img\\todolist mini.png"));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Titre.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("<HTML><U>To-Do Lister</U></HTML>");
        lblNewLabel.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        Titre.add(lblNewLabel);

        JPanel PanelPrincipal = new JPanel();
        PanelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));

        // Créez un JScrollPane pour panel_3
        JScrollPane scrollPane = new JScrollPane(PanelPrincipal);
        PanelPrincipal.setLayout(new BorderLayout(0, 0));

        JPanel panel_principal = new JPanel();
        panel_principal.setBorder(new LineBorder(new Color(0, 0, 0)));
        PanelPrincipal.add(panel_principal);
        panel_principal.setLayout(new GridLayout(12, 7, 0, 0));

        for (int i=0;i<84;i++) {
            JTextField text = new JTextField();
            text.setBorder(new LineBorder(new Color(0, 0, 0)));
            text.setText(String.valueOf(i));
            text.setEditable(false);
            text.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(Calendrier.NBFAITES);
                    if (PopUpTache == null || !PopUpTache.isVisible()) {
                        PopUpTache = new PopUpTache(text);
                        PopUpTache.setVisible(true);
                    } else {
                        PopUpTache.toFront();
                    }
                }
            });
            panel_principal.add(text);
        }

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_west = new JPanel();
        panel_west.setBorder(new LineBorder(new Color(0, 0, 0)));
        PanelPrincipal.add(panel_west, BorderLayout.WEST);
        panel_west.setLayout(new GridLayout(12, 1, 0, 0));

        JLabel lblNewLabel_2 = new JLabel("8h-9h");
        panel_west.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("9h-10h");
        panel_west.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("10h-11h");
        panel_west.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("11h-12h");
        panel_west.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("12h-13h");
        panel_west.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("13h-14h");
        panel_west.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("14h-15h");
        panel_west.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("15h-16h");
        panel_west.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("16h-17h");
        panel_west.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("17h-18h");
        panel_west.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("18h-19h");
        panel_west.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("19h-20h");
        panel_west.add(lblNewLabel_13);

        JPanel panel_north = new JPanel();
        panel_north.setBorder(new LineBorder(new Color(0, 0, 0)));
        PanelPrincipal.add(panel_north, BorderLayout.NORTH);
        panel_north.setLayout(new BorderLayout(0, 0));

        JPanel panel_week = new JPanel();
        panel_north.add(panel_week, BorderLayout.NORTH);

        JLabel semaine = new JLabel("Semaine du "+NuméroWeek+"/"+MoisWeek+"/"+AnnéeWeek);
        semaine.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
        panel_week.add(semaine);

        JPanel panel_days = new JPanel();
        panel_north.add(panel_days, BorderLayout.CENTER);
        panel_days.setLayout(new GridLayout(0, 7, 0, 0));

        JPanel panel_invisible = new JPanel();
        panel_north.add(panel_invisible, BorderLayout.WEST);
        panel_invisible.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel_16 = new JLabel("13h-14h");
        lblNewLabel_16.setVisible(false);
        panel_invisible.add(lblNewLabel_16);

        JPanel panel_south = new JPanel();
        panel_south.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_south.setBackground(new Color(240, 240, 240));
        contentPane.add(panel_south, BorderLayout.SOUTH);
        panel_south.setLayout(new BorderLayout(0, 0));

        JPanel panel_s1 = new JPanel();
        panel_s1.setBackground(new Color(240, 240, 240));
        FlowLayout flowLayout = (FlowLayout) panel_s1.getLayout();
        flowLayout.setHgap(30);
        panel_south.add(panel_s1, BorderLayout.NORTH);

        this.effectuees = new JLabel("Tâches effectuées : "+this.Calendrier.NBFAITES);
        effectuees.setBackground(new Color(255, 255, 255));
        effectuees.setForeground(new Color(0, 255, 0));
        effectuees.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        panel_s1.add(effectuees);

        JLabel nonEffectuees = new JLabel("Tâches non effectuées : "+this.Calendrier.NBPASFAITES);
        nonEffectuees.setBackground(new Color(255, 255, 255));
        nonEffectuees.setForeground(new Color(255, 0, 0));
        nonEffectuees.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        panel_s1.add(nonEffectuees);

        JPanel panel_s2 = new JPanel();
        panel_s2.setBackground(new Color(240, 240, 240));
        panel_south.add(panel_s2);

        JLabel ratio = new JLabel("Ratio effectuées/total :");
        ratio.setBackground(new Color(255, 255, 255));
        ratio.setForeground(new Color(0, 0, 0));
        ratio.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        panel_s2.add(ratio);

        JLabel valRatio = new JLabel(this.Calendrier.NBFAITES+"/"+String.valueOf(this.Calendrier.NBFAITES+this.Calendrier.NBPASFAITES));
        valRatio.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        panel_s2.add(valRatio);

        JPanel panel_s3 = new JPanel();
        panel_s3.setBackground(new Color(240, 240, 240));
        panel_south.add(panel_s3, BorderLayout.SOUTH);

        JLabel lblNewLabel_14 = new JLabel("");
        if ((double) this.Calendrier.NBFAITES/ (this.Calendrier.NBFAITES+this.Calendrier.NBPASFAITES)>= (double) 1.5/2) {
            lblNewLabel_14.setText("Tu es goatesque chef !");
            lblNewLabel_14.setForeground(new Color(0, 255, 0));
            valRatio.setForeground(new Color(0, 255, 0));
        } else {
            if ((double) this.Calendrier.NBFAITES/ (this.Calendrier.NBFAITES+this.Calendrier.NBPASFAITES) >= (double) 1/2 &&
                    (double) this.Calendrier.NBFAITES/ (this.Calendrier.NBFAITES+this.Calendrier.NBPASFAITES) < (double)1.5/2) {
                lblNewLabel_14.setText("Pas mal chef, mais tu peux encore t'améliorer !");
                lblNewLabel_14.setForeground(new Color(0, 255, 0));
                valRatio.setForeground(new Color(0, 255, 0));
            } else {
                lblNewLabel_14.setText("T'es vraiment une fraude.");
                lblNewLabel_14.setForeground(new Color(255, 0, 0));
                valRatio.setForeground(new Color(255, 0, 0));
            }
        }

        lblNewLabel_14.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        panel_s3.add(lblNewLabel_14);

        for (int i=0;i<7;i++) {
            JLabel label = new JLabel("");
            if (Mois31.contains(MoisWeek)) {
                if (Integer.valueOf(NuméroWeek)+i > 31) {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i-31));
                } else {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i));
                }
            } else if (Mois30.contains(MoisWeek)) {
                if (Integer.valueOf(NuméroWeek)+i > 30) {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i-30));
                } else {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i));
                }
            } else if ((Integer.valueOf(AnnéeWeek)%4==0 && Integer.valueOf(AnnéeWeek)%100!=0) || Integer.valueOf(AnnéeWeek)%400==0) {
                if (Integer.valueOf(NuméroWeek)+i > 29) {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i-29));
                } else {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i));
                }
            } else {
                if (Integer.valueOf(NuméroWeek)+i > 28) {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i-28));
                } else {
                    label.setText("  "+Jour[i]+" "+String.valueOf(Integer.valueOf(NuméroWeek)+i));
                }
            }
            label.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
            String[] JourLabel = label.getText().split(" ");
            if (JourLabel[2].toUpperCase().equals(JournéeToday.toUpperCase())) {
                label.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
                label.setForeground(new Color(0,0,255));
            }
            panel_days.add(label);
        }
    }

    public static void updateNbFaitesVert() {
        Calendrier.NBFAITES++;
        effectuees.setText("Tâches effectuées : "+Calendrier.NBFAITES);
    }

}
