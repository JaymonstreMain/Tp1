package utilitaires;

import javax.swing.JOptionPane;


public class Input
{

    public static Integer saisirEntier(String pQuestion)
    {
        return Input.saisirEntier(pQuestion, "Saisie d'une valeur...");
    }

    public static Integer saisirEntier(String pQuestion, String sTitre)
    {
        Integer objetEntier = null;
        boolean valide = false;
        String reponse = "";

        // Saisir tant que pas valide
        do
        {
            // Boîte de dialogue de saisie
            reponse = JOptionPane.showInputDialog(null, pQuestion, sTitre,
                    JOptionPane.QUESTION_MESSAGE);

            if (reponse != null)
            {
                try
                {
                    objetEntier = new Integer(Integer.parseInt(reponse));
                    valide = true;
                }
                catch (Exception e)
                {
                    valide = false;
                }
            }
        }
        while (!valide && reponse != null);

        return objetEntier;
    }


    public static String saisirString(String pQuestion)
    {
        String stringTemp = null;
        boolean valide = false;
        String reponse = "";

        // Saisir tant que pas valide
        do
        {
            // Boîte de dialogue de saisie
            reponse = JOptionPane.showInputDialog(null, pQuestion);

            if (reponse != null)
            {
                stringTemp = reponse;
                valide = true;
            }
        }
        while (!valide && reponse != null);

        return stringTemp;
    }


    public static int confirmerMessage(String pQuestion)
    {
        // Boîte de dialogue d'affichage
        return Input.confirmerMessage(pQuestion, "Confirmation");
    }

    public static int confirmerMessage(String pQuestion, String pTitre)
    {
        // Boîte de dialogue d'affichage
        return JOptionPane.showConfirmDialog(null, pQuestion, pTitre,
                JOptionPane.YES_NO_OPTION);
    }
}