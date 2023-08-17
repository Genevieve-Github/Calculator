package org.example.CalculatriceEval1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Arrays;

public class Newtraitement implements ActionListener {
//--------------------------------------------------------------------------------------
// Déclarations des variables
//--------------------------------------------------------------------------------------
    double number;
    double answer = 0;  // Déclaration des doubles de calcul
    String nbreClique = "";        //* Décalartion du type d'opération de calcul
    String operateur = "";

    Boolean flag = false;   // Drapeau qui permet de réinitiliser les données

    JFrame frame = new JFrame("Calculatrice");  // Déclaration de la fenêtre
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
//------------------------------------------------------------------------------
// Traitement principal
//------------------------------------------------------------------------------
        interfaceGraphique();   // Chargement de l'interface graphique
        addActionEvent();       // Appel aux listeners
    }



    public void interfaceGraphique() {
//------------------------------------------------------------------------------
//  Mise en forme de l'interface graphique '
//------------------------------------------------------------------------------
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
        frame.setResizable(false);               // Redimensionnement de la fenêtre (true/false)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configuration de l'action qui va être exécutée lors
                                                // de la fermeture de la fenêtre:
                                                // quitter le programme,
        frame.setVisible(true);  // fermer la fenêtre ou la rendre invisible


// ------------------------------------------------------------------------
// Ajout de la zone du résultat et du groupe de boutons dans le conteneur
//-------------------------------------------------------------------------
        label.setBounds(10, 0, 270, 50);        // Zone de texte pour afficher la suite des opérations
        label.setForeground(Color.white);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);   // Zone de texte pour afficher le dernier nombre
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);

        button0.setBounds(10, 350, 60, 40);     // Bouton 0
        button0.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button0);

        button1.setBounds(10, 290, 60, 40);     // Bouton 1
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button1);

        button2.setBounds(80, 290, 60, 40);     // Bouton 2
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button2);

        button3.setBounds(150, 290, 60, 40);    // Bouton 3
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button3);

        button4.setBounds(10, 230, 60, 40);     // Bouton 4
        button4.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button4);

        button5.setBounds(80, 230, 60, 40);     // Bouton 5
        button5.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button5);

        button6.setBounds(150, 230, 60, 40);    // Bouton 6
        button6.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button6);

        button7.setBounds(10, 170, 60, 40);     // Bouton 7
        button7.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button7);

        button8.setBounds(80, 170, 60, 40);     // Bouton 8
        button8.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button8);

        button9.setBounds(150, 170, 60, 40);    // Bouton 9
        button9.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(button9);

        buttondiv.setBounds(220, 110, 60, 40);  // Bouton ÷
        buttondiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttondiv.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttondiv);

        buttonmul.setBounds(220, 230, 60, 40);  // Bouton *
        buttonmul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonmul.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonmul);

        buttonsou.setBounds(220, 170, 60, 40);  // Bouton -
        buttonsou.setFont(new Font("Arial", Font.BOLD, 20));
        buttonsou.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonsou);

        buttonplu.setBounds(220, 290, 60, 40);  // Bouton +
        buttonplu.setFont(new Font("Arial", Font.BOLD, 20));
        buttonplu.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonplu);

        buttonega.setBounds(150, 350, 130, 40); // Bouton =
        buttonega.setFont(new Font("Arial", Font.BOLD, 20));
        buttonega.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonega);

        buttonpoint.setBounds(80, 350, 60, 40);    // Bouton .
        buttonpoint.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonpoint);

        buttonpou.setBounds(150, 110, 60, 40);      // Bouton %
        buttonpou.setFont(new Font("Arial", Font.BOLD, 20));
        buttonpou.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonpou);

        buttonrac.setBounds(80, 110, 60, 40);       // Bouton √
        buttonrac.setFont(new Font("Arial", Font.BOLD, 20));
        buttonrac.setBackground(new Color(199, 195, 195, 255));
        frame.add(buttonrac);

        buttonC.setBounds(10, 110, 60, 40);         // Bouton C
        buttonC.setFont(new Font("Arial", Font.BOLD, 16));
        buttonC.setBackground(Color.red);
        buttonC.setForeground(Color.white);
        frame.add(buttonC);

        labelSign.setBounds(15, 400, 250, 15);      // label de la signature
        labelSign.setForeground(Color.gray);
        labelSign.setFont(new Font("Arial", Font.ITALIC, 9));
        frame.add(labelSign);
    }


    public void addActionEvent() {
//-------------------------------------------------------------------------------------------
// AJOUT DES BOUTONS COMME LISTENER
//-------------------------------------------------------------------------------------------
        for (JButton jButton : Arrays.asList(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonC, buttondiv, buttonrac, buttonpou, buttonsou, buttonmul, buttonplu, buttonega, buttonpoint)) {
            jButton.addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    //------------------------------------------------------------------------------------
    // Méthode qui gère l'interface ActionListener
    //----------------------------------------------------------------------------------
        JButton jSource = (JButton) e.getSource();      // Conversion le typage de l'évemenet en bouton
        String buttonText = jSource.getText();          // Chargement le texte du bouton

        //----------------------------------------------------------------
        // Traitement du Bouton CLEAR, effacement de toutes les données
        //----------------------------------------------------------------
        if (buttonText.equals("C")) {
            flag = true;                                // drapeau indiquant la fin d'une suite d'opérations
        }

        //----------------------------------------------------------------
        // Initialisation des données de calcul
        //----------------------------------------------------------------
        if (flag.equals(true)) {
            label.setText("");                          // zone d'affichage de tous les clics
            textField.setText("");                      // zone d'affichage sur l'écran des chiffres cliqués
            nbreClique="";                              // valeur string pour stocker le nombre cliqué
            operateur = "";                             // avant dernier signe opération cliqué
            number = 0;                                 // valeur double pour stocker le nombre cliqué
            answer = 0;                                 // valeur double contenant le résultat des opérations
            flag=false;                                 // drapeau indiquant le début d'une suite d'opérations
            //return;
        }
        //--------------------------------------------------------------------------
        // Controle premier bouton cliqué: qu'il ne soit pas un signe par exemple
        //--------------------------------------------------------------------------
        if (!Character.isDigit(buttonText.charAt(0))) { // Controle que le bouton a un nom avec un chiffre
            if (label.getText().length() == 0) {        // sur le premier clic
                if (buttonText.equals("-")) {           // signe moins accepté pour le 1er chiffre (devient négatif)
                    nbreClique="-";
                    label.setText("-");
                    return;
                } else {
                    return;
                }
            }
        }

        //--------------------------------------------------------------------------------------------------
        // Verifier le botuon cliqué, avec le dernier élement enregistré (pas deux fois des signes par ex)
        //--------------------------------------------------------------------------------------------------
        if (!Character.isDigit(buttonText.charAt(0))) {  // Controle que le bouton a un nom avec un chiffre
            // Controle que le dernier caractère cliqué de l'opération est un chiffre
            if (!Character.isDigit(label.getText().charAt(label.getText().length() - 1))) {
                return;
            }
        }

        //---------------------------------------------------------------------------------------------
        // La touche appuyée est un point
        //---------------------------------------------------------------------------------------------
        if (buttonText.equals(".")) {
            if (nbreClique.contains(".")) {             // Verif si le point n'a pas déja été cliqué une première fois
                return;                                 // la touche . a déjà été sélectionnée pour ce nombre
            } else {
                if (nbreClique.equals("")) {            // vérif si le point est le premier clic
                    return;                             // ignore le premier point, il faudrait un 0 au moins (0.)
                }
                nbreClique = nbreClique + buttonText;   // Charge le string du chiffre cliqué
            }
        }

        //---------------------------------------------------------------------------------
        // Affichage de l'opération complète telle que les données ont été sélectionnées
        //---------------------------------------------------------------------------------
        if (!buttonText.equals("C")) {                  // On n'affiche pas le C
            label.setText(label.getText() + buttonText);
        }

        //----------------------------------
        // La touche appuyée est un nombre
        //----------------------------------
        if (Character.isDigit(buttonText.charAt(0))) {  // Controle que le bouton a un nom avec un chiffre
            nbreClique = nbreClique + buttonText;       // Sauvegarde du nombre dans une chaine de caractère
            textField.setText(nbreClique);              // Affichage du chiffre à l'écran
        }

        // -----------------------------------------------------------------------------------------------------------
        // La touche appuyée est un signe +, -, *, ÷, =
        // Faire les OPERATIONS INERMEDIAIRES entre le résultat des opérations précédentes,
        // le signe opératoire précédent celui-ci et le dernier nombres sélectionnés
        //------------------------------------------------------------------------------------------------------------
        if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("x")
                || buttonText.equals("÷") || buttonText.equals("=")) {
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

            //-------------------------------------------------------------------------------------
            // Opération de soustration
            // Pour éviter les erreurs de d'affichage, par ex: 9-3.01 = 5.99000000004, il faut convertir les doubles:
            // Conversion du double en String, puis du string en BigDecimal
            // Calcul sur les Bigdecimal data
            // Conversion en Double du résultat, ce qui donne mainetant : 9-3.01 = 5.99
            //--------------------------------------------------------------------------------------
            if (operateur.equals("-")) {                // Opération précédente est -
                BigDecimal bigDecimalAnswer = BigDecimal.valueOf(answer);
                BigDecimal bigDecimalNumber = BigDecimal.valueOf((number));
                BigDecimal bigDecimalTotal = bigDecimalAnswer.subtract(bigDecimalNumber);
                answer = bigDecimalTotal.doubleValue() ;
            }

            if (operateur.equals("x")) {                // Opération précédente est x
                answer = answer * number;
            }

            if (operateur.equals("÷")) {                // Opération précédente est ÷
                if (number == 0) {
                    answer = 0;                         // Division par 0, le résultat est 0
                } else {
                    answer = answer / number;
                }
            }

            number = 0;
            operateur = buttonText;
            nbreClique = "";
        }

        //--------------------------------------------------------------------------------------------------
        // La touche appuyée est =, %, √
        // Faire L'OPERATION FINALE
        //--------------------------------------------------------------------------------------------------
        if (buttonText.equals("=") || buttonText.equals("%") || buttonText.equals("√")) {
            //-------------------------------------------------------
            // Verif quelle est l'opération sélectionnée
            //-------------------------------------------------------
            if (buttonText.equals("√")) {              // La touche appuyée est la Racine carrée
                number = Double.parseDouble(nbreClique);
                if (number <0) {                            // Conversion du nombre négatif sélectionné en nombre positif
                    number = - number;
                }
                answer = Math.sqrt(number);                 // Opération de calcul
                label.setText(label.getText() +"=");        // Ajout du signe = dans l'affichage de la suite d'opérations
            }

            if (buttonText.equals("%")) {                   // La touche appuyée est le %
                answer = Double.parseDouble(nbreClique) / 100; // Opération de calcul
                label.setText(label.getText() +"=");        // Ajout du signe = dans l'affichage de la suite d'opérations
            }

            //------------------------------
            // Formatage du calcul total
            //------------------------------
            if (Math.ceil(answer) == Math.floor(answer)) {  // Verif si le double est entier
                label.setText(label.getText() +convertFromDoubleToInteger(answer));
                textField.setText(String.valueOf(convertFromDoubleToInteger(answer)));
            } else {
                textField.setText(String.valueOf(answer));
                label.setText(label.getText() +answer);
            }
            flag = true;    // L'opération finale est terminée
            }
    }

   public int convertFromDoubleToInteger(Double valeur) {
        // Suppression des décimales
       return valeur.intValue(); // Supression des décimales
    }
}