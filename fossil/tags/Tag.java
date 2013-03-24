package fossil.tags;

public abstract class Tag
{
    private final String name;

    public Tag(String var1)
    {
        this.name = var1;
    }

    public final String getName()
    {
        return this.name;
    }

    public abstract Object getValue();
}
