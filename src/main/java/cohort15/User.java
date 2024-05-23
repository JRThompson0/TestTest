package cohort15;

public class User
{

    String handle;
    String nickName;
    public String getNickName()
    {
        return nickName;
    }
    public void setNickName(String nickName)
    {
        this.nickName=nickName;
    }
    public String getHandle()
    {
        return handle;
    }
    public void setHandle(String handle)
    {
        this.handle=handle;
    }
    public String getLowerCaseHandle()
    {
        return handle.toLowerCase();
    }
    public User(String handle)
    {
        this.handle = handle;
        this.nickName = handle;
    }
}
