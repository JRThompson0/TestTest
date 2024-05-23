package cohort15;

public class User
{

    String handle;
    String originalHandle;
    public String getOriginalHandle()
    {
        return originalHandle;
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
        this.originalHandle = handle;
    }
}
