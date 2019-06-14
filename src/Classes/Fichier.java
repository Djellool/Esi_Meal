package Classes;
import java.io.*;

public class Fichier implements Serializable {
    public static void OutClient (Client client)
    {ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("Client.dat"))));
            out.writeObject(client );//on sauvegarde l'objet esimeal dans le fichier.
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public  static Client InClient()
    {
        ObjectInputStream in;
        Client client = null;
        try {
            in = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("Client.dat"))));
            try {


                client = ((Client)in.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            in.close();}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }
    public static void OutEsi (EsiMeal Esi)
    {ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("Esi.dat"))));
            out.writeObject(Esi );//on sauvegarde l'objet esimeal dans le fichier.
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public  static EsiMeal InEsi()
    {
        ObjectInputStream in;
        EsiMeal Esi = null;
        try {
            in = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("Esi.dat"))));
            try {
                Esi = ((EsiMeal)in.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            in.close();}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Esi;
    }
}
