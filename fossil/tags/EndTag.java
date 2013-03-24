package fossil.tags;


public final class EndTag extends Tag
{
    public EndTag()
    {
        super("");
    }

    public Object getValue()
    {
        return null;
    }

    public String toString()
    {
        return "TAG_End";
    }
}
