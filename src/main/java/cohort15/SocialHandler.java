package cohort15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SocialHandler
{
    HashMap<String,User> daMap = new HashMap<String,User>();
    private final ArrayList<User> secretForeverLog = new ArrayList<User>();
    public String addGuy(String userNameMaybe)
    {
        if (userNameMaybe == null)
            throw new NullPointerException("null username?");
        if (userNameMaybe.isEmpty())
            throw new InputMismatchException("Enter a username!");
        if (userNameMaybe.length()>=10)
            throw new InputMismatchException("Username too long!");
        String bufferedString = "@" + userNameMaybe;
        String lowcaseBuffString = bufferedString.toLowerCase();
        if (daMap.containsKey(lowcaseBuffString))
            throw new InputMismatchException("Handle already taken!");
        //
        //the User object created will store the string as it was entered, such that we will see the
        //proper capitalization on the user's profile. Jacob -> @jacob in the map, but you'll still see "Jacob"
        // in certain spots
        daMap.put(bufferedString.toLowerCase(), new User(userNameMaybe));
        secretForeverLog.add(daMap.get(bufferedString.toLowerCase()));
        return bufferedString.toLowerCase();
    }
    public User getGuy(String handle)
    {
        if(daMap.containsKey(handle))
            return daMap.get(handle);
        return null;
    }
    public String changeHandle(String userNameMaybe, User theUser)
    {
        String oldHandle = theUser.getHandle();
        if (userNameMaybe == null)
            throw new NullPointerException("null username?");
        if (userNameMaybe.isEmpty())
            throw new InputMismatchException("Enter a username!");
        if (userNameMaybe.length()>=10)
            throw new InputMismatchException("Username too long!");
        String bufferedString = "@" + userNameMaybe;
        String lowcaseBuffString = bufferedString.toLowerCase();
        if(bufferedString.equals(oldHandle))
            throw new InputMismatchException("Can't be the same handle as before!");
        if (daMap.containsKey(lowcaseBuffString))
            throw new InputMismatchException("Handle already taken!");
        //
        //the User object created will store the string as it was entered, such that we will see the
        //proper capitalization on the user's profile. Jacob -> @jacob in the map, but you'll still see "Jacob"
        // in certain spots
        theUser.setHandle(bufferedString);
        daMap.remove("@"+oldHandle.toLowerCase(),theUser);
        daMap.put(lowcaseBuffString, theUser);
        return lowcaseBuffString;
    }
    public void removeGuy(String removeMaybe)
    {
        if (daMap.containsKey(removeMaybe))
        {
            daMap.remove(removeMaybe);
        }
        else
            throw new ArrayStoreException("User not found");
    }
    public ArrayList<User> getSecretForeverLog()
    {
        return secretForeverLog;
    }
    public static void makeFile(String fileName)
    {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public void fileWrite(String fileName)
    {
        SocialHandler.makeFile(fileName);
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("Social Handler Log");
            myWriter.write("\n");
            for (Map.Entry<String, User> stringUserEntry : daMap.entrySet())
            {
                myWriter.write(stringUserEntry.getKey()+": "+stringUserEntry.getValue().getHandle()+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static void readFile(String fileName)
    {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}
