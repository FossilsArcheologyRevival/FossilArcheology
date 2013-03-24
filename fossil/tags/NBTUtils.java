package fossil.tags;


public final class NBTUtils
{
    public static String getTypeName(Class var0)
    {
        if (var0.equals(ByteArrayTag.class))
        {
            return "TAG_Byte_Array";
        }
        else if (var0.equals(ByteTag.class))
        {
            return "TAG_Byte";
        }
        else if (var0.equals(CompoundTag.class))
        {
            return "TAG_Compound";
        }
        else if (var0.equals(DoubleTag.class))
        {
            return "TAG_Double";
        }
        else if (var0.equals(EndTag.class))
        {
            return "TAG_End";
        }
        else if (var0.equals(FloatTag.class))
        {
            return "TAG_Float";
        }
        else if (var0.equals(IntTag.class))
        {
            return "TAG_Int";
        }
        else if (var0.equals(ListTag.class))
        {
            return "TAG_List";
        }
        else if (var0.equals(LongTag.class))
        {
            return "TAG_Long";
        }
        else if (var0.equals(ShortTag.class))
        {
            return "TAG_Short";
        }
        else if (var0.equals(StringTag.class))
        {
            return "TAG_String";
        }
        else
        {
            throw new IllegalArgumentException("Invalid tag classs (" + var0.getName() + ").");
        }
    }

    public static int getTypeCode(Class var0)
    {
        if (var0.equals(ByteArrayTag.class))
        {
            return 7;
        }
        else if (var0.equals(ByteTag.class))
        {
            return 1;
        }
        else if (var0.equals(CompoundTag.class))
        {
            return 10;
        }
        else if (var0.equals(DoubleTag.class))
        {
            return 6;
        }
        else if (var0.equals(EndTag.class))
        {
            return 0;
        }
        else if (var0.equals(FloatTag.class))
        {
            return 5;
        }
        else if (var0.equals(IntTag.class))
        {
            return 3;
        }
        else if (var0.equals(ListTag.class))
        {
            return 9;
        }
        else if (var0.equals(LongTag.class))
        {
            return 4;
        }
        else if (var0.equals(ShortTag.class))
        {
            return 2;
        }
        else if (var0.equals(StringTag.class))
        {
            return 8;
        }
        else
        {
            throw new IllegalArgumentException("Invalid tag classs (" + var0.getName() + ").");
        }
    }

    public static Class getTypeClass(int var0)
    {
        switch (var0)
        {
            case 0:
                return EndTag.class;

            case 1:
                return ByteTag.class;

            case 2:
                return ShortTag.class;

            case 3:
                return IntTag.class;

            case 4:
                return LongTag.class;

            case 5:
                return FloatTag.class;

            case 6:
                return DoubleTag.class;

            case 7:
                return ByteArrayTag.class;

            case 8:
                return StringTag.class;

            case 9:
                return ListTag.class;

            case 10:
                return CompoundTag.class;

            default:
                throw new IllegalArgumentException("Invalid tag type : " + var0 + ".");
        }
    }
}
