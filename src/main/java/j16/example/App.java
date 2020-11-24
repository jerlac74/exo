package j16.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //SuperChat sc =(Chat) new SuperChat(); => ne compile pas car chat ne connait pas le SuperChat

        Chat chat =(Chat) new SuperChat();
        chat.miauler();

        System.out.println(Civilite.MADAME +":ordinal:"+Civilite.MADAME.ordinal());
        System.out.println(Civilite.MONSIEUR +":ordinal:"+Civilite.MONSIEUR.ordinal());
        System.out.println(Civilite.values());
        Civilite civil =Civilite.MADEMOISELLE;
        switch (civil){
            case MADAME:
                break;
            case MADEMOISELLE:
                break;
            case MONSIEUR:
                break;
        }

        Planet planet =Planet.MERCURE;
        System.out.println(planet);
        System.out.println(planet.mass());
    }
}
