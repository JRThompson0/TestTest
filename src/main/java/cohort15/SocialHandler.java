package cohort15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

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
}
