package cohort15;

import java.util.HashMap;
import java.util.InputMismatchException;

public class SocialHandler
{
    HashMap<String,User> daMap = new HashMap<String,User>();
    public String addGuy(String userNameMaybe)
    {
        if (userNameMaybe == null)
            throw new NullPointerException("null username?");
        if (userNameMaybe.isEmpty())
            throw new InputMismatchException("Enter a username!");
        if (userNameMaybe.length()>=10)
            throw new InputMismatchException("Username too long!");
        String bufferedString = "@" + userNameMaybe;
        if (daMap.containsKey(bufferedString.toLowerCase()))
            throw new InputMismatchException("Handle already taken!");
        daMap.put(bufferedString.toLowerCase(), new User(bufferedString));
        return bufferedString.toLowerCase();
    }
    public User getGuy(String handle)
    {
        if(daMap.containsKey(handle))
            return daMap.get(handle);
        return null;
    }
    public void removeGuy(String removeMaybe)
    {
        daMap.remove(removeMaybe);
    }
}
