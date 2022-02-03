package utilitaires;

public class Utilitaires
{

    public static int alea(int pMin, int pMax)
    {
        int minTemp = Math.min(pMin, pMax);
        int maxTemp = Math.max(pMin, pMax);

        return (int) (Math.random() * (maxTemp - minTemp + 1)) + minTemp;
    }

}