package cohort15;

public class User
{

    final String handle;
    String nickName;
    public String getNickName()
    {
        return nickName;
    }
    public String getHandle()
    {
        return handle;
    }
    public User(String handle)
    {
        this.handle = handle;
        this.nickName = handle;
    }

}
