public class Song
{
    private String Title;
    private String Duration;

    public Song(String title, String duration)
    {
        Title = title;
        Duration = duration;
    }

    public String getTitle()
    {
        return Title;
    }

    public String getDuration()
    {
        return Duration;
    }
}
