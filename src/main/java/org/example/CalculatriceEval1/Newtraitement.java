package org.example.CalculatriceEval1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Newtraitement implements ActionListener {
    //-----------------------------------------------
// Déclarations des variables
//-----------------------------------------------
    double number;
    double answer = 0;  // Déclaration des doubles de calcul
    String nbreClique = "";        //* Décalartion du type d'opération de calcul
    String operateur = "";

    Boolean flag = false;   // Drapeau qui permet de réinitiliser les données

    JFrame frame = new JFrame("Calculatrice");  // Déclaration de la fenêtre
    JPanel panel = new JPanel();    // Déclaration du contneur
    JLabel labelCalc = new JLabel("Fait avec Java/Swing/AWT par Geneviève Giannasi", JLabel.CENTER);
    // Déclaration de la signature
    JButton button0 = new JButton("0"); // Décalaration des boutons
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttondiv = new JButton("÷");
    JButton buttonmul = new JButton("x");
    JButton buttonsou = new JButton("-");
    JButton buttonplu = new JButton("+");
    JButton buttonega = new JButton("=");
    JButton buttonpoint = new JButton(".");
    JButton buttonpou = new JButton("%");
    JButton buttonrac = new JButton("√");
    JButton buttonC = new JButton("C");
    JLabel label = new JLabel(); // Déclaration du conteneur du résultat du calcul à afficher
    JTextField textField = new JTextField(); // Déclaration du résultat du calcul à afficher
    JLabel labelSign = new JLabel("Fait avec Java/Swing/AWT par Geneviève Giannasi -2023-", JLabel.CENTER);
    // Déclaration de la signature

    Newtraitement() {
        interfaceGraphique();
        addActionEvent();
    }

    public void interfaceGraphique() {
//-------------------------------
//  Mise en forme de la fenêtre
//-------------------------------
        frame.setTitle("Calculatrice");         // Titre de la fenêtre
        frame.setSize(305, 460);    // Taille de la fenêtre
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        frame.getContentPane().setLayout(null); // Association du gestionnaire de disposition
                                                // : Flowlayout (défaut): saute à la ligne à la fin de la ligne
                                                // BorderLayout: haut, bas, gauche, droite et centre
                                                // CarLayout: en couche
                                                // GridLayout: en grille, pour des composants de même taille
                                                // GridBagLayout: placement plus fin
        frame.getContentPane().setBackground(Color.black);  // Couleur de fond noir
        frame.setLocationRelativeTo(null);      // Positionner de la fenêtre par rapport à un composant
                                                //    ("nul"=centré)
        frame.setResizable(true);               // Redimensionnement de la fenêtre (true/false)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configuration de l'action qui va être exécutée lors
                                                // de la fermeture de la fenêtre:
                                                // quitter le programme,
        frame.setVisible(true);  // fermer la fenêtre ou la rendre invisible
// ------------------------------------------------------------------------
// Ajout de la zone du résultat et du groupe de boutons dans le conteneur
//-------------------------------------------------------------------------
        //------------------------------------------------------------
        // Ajout de la zone d'affichage du résultat de l'opération
        //------------------------------------------------------------
        label.setBounds(10, 0, 270, 50);
        label.setForeground(Color.white);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(label);

        //-----------------------------------------------------------
        // Ajout de la zone de texte pour afficher le résultat
        //------------------------------------------------------------
        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        //-----------------------------------------------------------
        // Ajout du bouton "0"
        //------------------------------------------------------------
        button0.setBounds(10, 350, 60, 40);
        button0.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button0);

        //-----------------------------------------------------------
        //Ajout du bouton "1"
        //------------------------------------------------------------
        button1.setBounds(10, 290, 60, 40);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button1);

        //-----------------------------------------------------------
        // Ajout du bouton "2"
        //------------------------------------------------------------
        button2.setBounds(80, 290, 60, 40);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button2);

        //-----------------------------------------------------------
        // Ajout du bouton "3"
        //------------------------------------------------------------
        button3.setBounds(150, 290, 60, 40);
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button3);

        //-----------------------------------------------------------
        // Ajout du bouton "4"
        //------------------------------------------------------------
        button4.setBounds(10, 230, 60, 40);
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button4);

        //-----------------------------------------------------------
        // Ajout du bouton "5"
        //------------------------------------------------------------
        button5.setBounds(80, 230, 60, 40);
        button5.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button5);

        //-----------------------------------------------------------
        // Ajout du bouton "6"
        //------------------------------------------------------------
        button6.setBounds(150, 230, 60, 40);
        button6.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button6);

        //-----------------------------------------------------------
        // Ajout du bouton "7"
        //------------------------------------------------------------
        button7.setBounds(10, 170, 60, 40);
        button7.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button7);

        //-----------------------------------------------------------
        // Ajout du bouton "8"
        //------------------------------------------------------------
        button8.setBounds(80, 170, 60, 40);
        button8.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button8);

        //-----------------------------------------------------------
        // Ajout du bouton "9"
        //------------------------------------------------------------
        button9.setBounds(150, 170, 60, 40);
        button9.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button9);

        //-----------------------------------------------------------
        // Ajout du bouton "/"
        //------------------------------------------------------------
        buttondiv.setBounds(220, 110, 60, 40);
        buttondiv.setFont(new Font("Arial", Font.BOLD, 15));
        buttondiv.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttondiv);

        //-----------------------------------------------------------
        // Ajout du bouton "*"
        //------------------------------------------------------------
        buttonmul.setBounds(220, 230, 60, 40);
        buttonmul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonmul.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonmul);

        //-----------------------------------------------------------
        // Ajout du bouton "-"
        //------------------------------------------------------------
        buttonsou.setBounds(220, 170, 60, 40);
        buttonsou.setFont(new Font("Arial", Font.BOLD, 20));
        buttonsou.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonsou);

        //-----------------------------------------------------------
        // Ajout du bouton "+"
        //------------------------------------------------------------
        buttonplu.setBounds(220, 290, 60, 40);
        buttonplu.setFont(new Font("Arial", Font.BOLD, 20));
        buttonplu.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonplu);

        //-----------------------------------------------------------
        // Ajout du bouton "="
        //------------------------------------------------------------
        buttonega.setBounds(150, 350, 130, 40);
        buttonega.setFont(new Font("Arial", Font.BOLD, 20));
        buttonega.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonega);

        //-----------------------------------------------------------
        // Ajout du bouton "."
        //------------------------------------------------------------
        buttonpoint.setBounds(80, 350, 60, 40);
        buttonpoint.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonpoint);

        //-----------------------------------------------------------
        // Ajout du bouton "%"
        //------------------------------------------------------------
        buttonpou.setBounds(150, 110, 60, 40);
        buttonpou.setFont(new Font("Arial", Font.BOLD, 20));
        buttonpou.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonpou);

        //-----------------------------------------------------------
        // Ajout du bouton "√"
        //------------------------------------------------------------
        buttonrac.setBounds(80, 110, 60, 40);
        buttonrac.setFont(new Font("Arial", Font.BOLD, 20));
        buttonrac.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonrac);

        //-----------------------------------------------------------
        // Ajout du bouton "C"
        //------------------------------------------------------------
        buttonC.setBounds(10, 110, 60, 40);
        buttonC.setFont(new Font("Arial", Font.BOLD, 12));
        buttonC.setBackground(Color.red);
        buttonC.setForeground(Color.white);
        frame.add(buttonC);

        //-----------------------------------------------------------
        // Ajout du label de la signature
        //------------------------------------------------------------
        labelSign.setBounds(15, 400, 250, 15);
        labelSign.setForeground(Color.gray);
        labelSign.setFont(new Font("Arial", Font.ITALIC, 9));
        frame.add(labelSign);
    }


    public void addActionEvent() {
//---------------------
// AJOUT DES BOUTONS
//---------------------
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonC.addActionListener(this);
        buttondiv.addActionListener(this);
        buttonrac.addActionListener(this);
        buttonpou.addActionListener(this);
        buttonsou.addActionListener(this);
        buttonmul.addActionListener(this);
        buttonplu.addActionListener(this);
        buttonega.addActionListener(this);
        buttonpoint.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Object source = e.getSource();
        System.out.println("Début actionPerformed!!");
        JButton jSource = (JButton) e.getSource();      // Conversion le typage de l'évemenet en bouton
        String buttonText = jSource.getText();          // Chargement le texte du bouton
        System.out.println("Bouton : "+buttonText);
        System.out.println("Opérateur précédent: "+operateur);

        //----------------------------------------------------------------
        // Traitement du Bouton CLEAR, effacement de toutes les données
        //----------------------------------------------------------------
        if (buttonText.equals("C")) {
            System.out.println("Début traitement button C");
            flag = true;            // drapeau indiquant la fin d'une suite d'opérations
        }

        //----------------------------------------------------------------
        // Initialisation des données de calcul
        //----------------------------------------------------------------
        if (flag.equals(true)) {
            System.out.println("Début traitement flag egal true");
            label.setText("");      // zone d'affichage de tous les clics
            textField.setText("");  // zone d'affichage sur l'écran des chiffres cliqués
            nbreClique="";          // valeur string pour stocker le nombre cliqué
            operateur = "";         // avant dernier signe opération cliqué
            number = 0;             // valeur double pour stocker le nombre cliqué
            answer = 0;             // valeur double contenant le résultat des opérations
            flag=false;             // drapeau indiquant le début d'une suite d'opérations
            //return;
        }
        //--------------------------------------------------------------------------
        // Controle premier bouton cliqué: qu'il ne soit pas un signe par exemple
        //--------------------------------------------------------------------------
        System.out.println("label.getText().length(): "+label.getText().length());
        System.out.println("label.getText(): "+label.getText());
        System.out.println("Character.isDigit(buttonText.charAt(0): "+Character.isDigit(buttonText.charAt(0)));

        if (Character.isDigit(buttonText.charAt(0)) == false) {   // Controle que le bouton a un nom avec un chiffre
            if (label.getText().length() == 0) {                  // sur le premier clic
                if (buttonText.equals("-") == true) {   // signe moins accepté pour le 1er chiffre (devient négatif)
                    //operateur="-";
                    nbreClique="-";
                    label.setText("-");
                    return;
                } else {
                    System.out.println("Aie le premier clic n'est pas numérique!!");
                    return;
                }
            }
        }
        //--------------------------------------------------------------------------------------------------
        // Verifier le botuon cliqué, avec le dernier élement enregistré (pas deux fois des signes par ex)
        //--------------------------------------------------------------------------------------------------
        if (Character.isDigit(buttonText.charAt(0)) == false) {  // Controle que le bouton a un nom avec un chiffre
            // Controle que le dernier caractère cliqué de l'opération est un chiffre
            if (Character.isDigit(label.getText().charAt(label.getText().length()-1)) == false) {
                System.out.println("Aie le clic dans l'opération n'est pas numérique!!");
                return;
            }
        }

        //---------------------------------------------------------------------------------------------
        // La touche appuyée est un point
        //---------------------------------------------------------------------------------------------
        if (buttonText.equals(".")) {
            System.out.println("Clic sur '.', nbreClique.contains(\".\"): "+nbreClique.contains("."));
            if (nbreClique.contains(".")) {     // Verif si le point n'a pas déja été cliqué une première fois
                return;                         // la touche . a déjà été sélectionnée pour ce nombre
            } else {
                if (nbreClique == "") {         // vérif si le point est le premier clic
                    return;                     // ignore le premier point, il faudrait un 0 au moins (0.)
                }
                nbreClique = nbreClique + buttonText;   // Charge le string du chiffre cliqué
            }
        }

        System.out.println("Nbreclique: "+nbreClique+" buttonText: "+buttonText);
        //---------------------------------------------------------------------------------
        // Affichage de l'opération complète telle que les données ont été sélectionnées
        //---------------------------------------------------------------------------------
        if (buttonText.equals("C") == false ) {             // On n'affiche pas le C
            label.setText(label.getText() + buttonText);
        }

        //----------------------------------
        // La touche appuyée est un nombre
        //----------------------------------
        if (Character.isDigit(buttonText.charAt(0)) == true) {  // Controle que le bouton a un nom avec un chiffre
        //if (isNumeric(buttonText)) {
            System.out.println("Début isnumeric(buttonText)");
            nbreClique = nbreClique + buttonText;   // Sauvegarde du nombre dans une chaine de caractère
            textField.setText(nbreClique);          // Affichage du chiffre à l'écran
            System.out.println("nbreClique: "+nbreClique);
            System.out.println("-------------------------------");
        }

        // -----------------------------------------------------------------------------------------------------------
        // La touche appuyée est un signe +, -, *, ÷, =
        // Faire les OPERATIONS INERMEDIAIRES entre le résultat des opérations précédentes,
        // le signe opératoire précédent celui-ci et le dernier nombres sélectionnés
        //------------------------------------------------------------------------------------------------------------
        if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("x")
                || buttonText.equals("÷") || buttonText.equals("=")) {
            System.out.println("Début buttonText + - * : = ----> " + buttonText);
//            System.out.println("Début operateur précédent: "+operateur);
//            System.out.println("nbreclic: "+ nbreClique);
//            System.out.println("numbre avant opération: "+number);
//            System.out.println("answer avant: "+answer);

            System.out.println("nbreclique avant test operation précédente: "+nbreClique+" -> "+nbreClique.length());
            System.out.println("-------------------------------");
            number = Double.parseDouble(nbreClique);    // Convertir le nombre cliqé string en double
            //------------------------------------------------------------------------------
            // Verif quelle a été la précédente opération sélectionnée
            //------------------------------------------------------------------------------
            if (operateur.equals("")) {                 // Première suite de nombre, il n'y a pas eu d'opération précédente
                answer = answer + number;
            }

            if (operateur.equals("+")) {                // Opération précédente est +
                answer = answer + number;
            }

            if (operateur.equals("-")) {                // Opération précédente est -
                System.out.println("answer avant soustraction: "+answer+" numbre: "+number);
                // Pour éviter les erreurs de d'affichage, par ex: 9-3.01 = 5.99000000004, il faut convertir les doubles:
                // Conversion du double en String, puis du string en BigDecimal
                // Calcul sur les Bigdecimal data
                // Conversion en Double du résultat, ce qui donne mainetant : 9-3.01 = 5.99
                // String stringAnswer = Double.toString(answer) - Double.toString(number);
                BigDecimal bigDecimalAnswer = BigDecimal.valueOf(Double.valueOf(answer));
                BigDecimal bigDecimalNumber = BigDecimal.valueOf((Double.valueOf(number)));
                BigDecimal bigDecimalTotal = bigDecimalAnswer.subtract(bigDecimalNumber);
                System.out.println("bigDecimalNumber: "+bigDecimalNumber+" bigDecimalAnswer: "+bigDecimalAnswer+" bigDecimalTotal: "+bigDecimalTotal);
                answer = bigDecimalTotal.doubleValue() ;
                System.out.println("answer après soustraction: "+answer+" numbre: "+number);
            }

            if (operateur.equals("x")) {                // Opération précédente est x
                answer = answer * number;
            }

            if (operateur.equals("÷")) {                // Opération précédente est ÷
                answer = answer / number;
            }

            System.out.println("numbre après opération: "+number);
            System.out.println("-------------------------------");
            number = 0;
            operateur = buttonText;
            nbreClique = "";
            //textField.setText("");
        }

        //--------------------------------------------------------------------------------------------------
        // La touche appuyée est =, %, √
        // Faire L'OPERATION FINALE
        //--------------------------------------------------------------------------------------------------
        if (buttonText.equals("=") || buttonText.equals("%") || buttonText.equals("√")) {
            //------------------------------------------------------------------------------
            // Verif quelle est l'opération sélectionnée
            //------------------------------------------------------------------------------
            if (buttonText.equals("√")) {               // La touche appuyée est la Racine carrée
                System.out.println("Début buttonText = '√'");
                number = Double.parseDouble(nbreClique);
                if (number <0) {                        // Conversion du nombre négatif sélectionné en nombre positif
                    number = - number;
                }
                answer = Math.sqrt(number);             // Opération de calcul
                label.setText(label.getText() +"=");    // Ajout du signe = dans l'affichage de la suite d'opérations
            }

            if (buttonText.equals("%")) {               // La touche appuyée est le %
                System.out.println("Début buttonText = '√'");
                answer = Double.parseDouble(nbreClique) / 100;         // Opération de calcul
                label.setText(label.getText() +"=");    // Ajout du signe = dans l'affichage de la suite d'opérations
            }

            //----------------------------
            // Formatage du calcul total
            //----------------------------
            System.out.println("Début buttonText = '='");
            System.out.println("Chargement 1 de textfield et de label: " + textField.getText());

            if (Math.ceil(answer) == Math.floor(answer)) {  // Verif si le double est entier
                label.setText(label.getText() +convertFromDoubleToInteger(answer));
                textField.setText(String.valueOf(convertFromDoubleToInteger(answer)));
            } else {
                textField.setText(String.valueOf(answer));
                label.setText(label.getText() +answer);
            }
            System.out.println("Chargement 2 de textfield et de label: " + textField.getText());
            flag = true;    // L'opération finale est terminée
            }

        System.out.println("answer après: "+answer);
        System.out.println("operateur fin " + operateur);
    }




//    //---------------------------------
//    // FONCTION DE CONTROLE NUMERIQUE
//    //---------------------------------
//    public static boolean isNumeric (String str) {
//        if (str == null || str.length() == 0) {
//            System.out.println("Isnumeric est false1: "+str);
//            return false;
//        }
//        try {
//            Double.parseDouble(str);
//            System.out.println("Isnumeric est true: "+str);
//            return true;
//        } catch (NumberFormatException e) {
//            System.out.println("Isnumeric est false2: "+str);
//            return false;
//        }
//    }
//    //---------------------------------
//    // FONCTION DE CALCUL ADDITION
//    //---------------------------------
//    public static Double addition (Double dble1, Double dble2) {
//        System.out.println("dble1 : "+dble1+ " dble2: "+dble2);
//        dble1 = dble1 + dble2;
//        System.out.println("résultat adition: "+dble1);
//        return dble1;
//    }
//    //-----------------------------------
//    // FONCTION DE CALCUL SOUSTRACTION
//    //-----------------------------------
//    public static Double soustraction (Double dble1, Double dble2) {
//        System.out.println("dble1 : "+dble1+ " dble2: "+dble2);
//        //if (dble1 > 0) {
//            dble1 = dble1 - dble2;
//        //} else {
//        //    dble1 = dble1 + dble2;
//        //}
//        System.out.println("résultat soustraction: "+dble1);
//        return dble1;
//    }
//    //------------------------------------
//    // FONCTION DE CALCUL LULTIPLICATION
//    //------------------------------------
//    public static Double multiplication (Double dble1, Double dble2) {
//        System.out.println("dble1 : "+dble1+ " dble2: "+dble2);
//        dble1 = dble1 * dble2;
//        System.out.println("résultat multiplication: "+dble1);
//        return dble1;
//    }
//    //---------------------------------
//    // FONCTION DE CALCUL DIVISION
//    //---------------------------------
//    public static Double division (Double dble1, Double dble2) {
//        System.out.println("dble1 : "+dble1+ " dble2: "+dble2);
//        dble1 = dble1 / dble2;
//        System.out.println("résultat division: "+dble1);
//        return dble1;
//    }
    //--------------------------------------------
    // FONCTION DE CONTROLE D'UNE VALEUR INTEGER
    //--------------------------------------------
//    public static boolean isInteger (Double dble) {
//        if (dble == null) {
//            System.out.println("IsIntEGER est false1: "+dble);
//            return false;
//        }
//        System.out.println("dble.doubleValue(): "+dble.doubleValue()+" dble.intValue(): "+dble.intValue());
//        if (dble.doubleValue() == dble.intValue()) {
//            System.out.println("Isinteger est true1: "+dble);
//            return true;
//        } else {
//            System.out.println("Isinteger est false2: "+dble);
//            return false;
//        }
//    }
//    //------------------------------------------
//    // FONCTION DE CONTROLE SI VALEUR DOUBLE
//    //------------------------------------------
//    public static boolean isDouble (String str) {
//        if (str == null) {
//            System.out.println("IsDouble est false1: "+str);
//            return false;
//        }
//        Double dble = Double.parseDouble(str);
//        System.out.println("dble.doubleValue(): "+dble.doubleValue()+" dble.intValue(): "+dble.intValue());
//        if (dble.doubleValue() == dble.intValue()) {
//            System.out.println("IsDouble est false2: "+dble);
//            return false;
//        } else {
//            System.out.println("IsDouble est true1: "+dble);
//            return true;
//        }
//    }
    //---------------------------------------------------------------
    // FONCTION DE CONVERSION EN ENTIER POUR ENLEVER LES DECIMALES
    //---------------------------------------------------------------
    public int convertFromDoubleToInteger(Double valeur) {
        // Suppression des décimales
        int variable = 0;
        variable = (int) valeur.intValue();
        System.out.println("valeur"+valeur+" valeur): "+valeur.toString(variable));
        return variable; // Supression des décimales
    }
}