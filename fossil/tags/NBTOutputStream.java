package fossil.tags;

import java.io.Closeable;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public final class NBTOutputStream implements Closeable
{
    private final DataOutputStream os;

    public NBTOutputStream(OutputStream var1) throws IOException
    {
        this.os = new DataOutputStream(new GZIPOutputStream(var1));
    }

    public void writeTag(Tag var1) throws IOException
    {
        int var2 = NBTUtils.getTypeCode(var1.getClass());
        String var3 = var1.getName();
        byte[] var4 = var3.getBytes(NBTConstants.CHARSET);
        this.os.writeByte(var2);
        this.os.writeShort(var4.length);
        this.os.write(var4);

        if (var2 == 0)
        {
            throw new IOException("Named TAG_End not permitted.");
        }
        else
        {
            this.writeTagPayload(var1);
        }
    }

    private void writeTagPayload(Tag var1) throws IOException
    {
        int var2 = NBTUtils.getTypeCode(var1.getClass());

        switch (var2)
        {
            case 0:
                this.writeEndTagPayload((EndTag)var1);
                break;

            case 1:
                this.writeByteTagPayload((ByteTag)var1);
                break;

            case 2:
                this.writeShortTagPayload((ShortTag)var1);
                break;

            case 3:
                this.writeIntTagPayload((IntTag)var1);
                break;

            case 4:
                this.writeLongTagPayload((LongTag)var1);
                break;

            case 5:
                this.writeFloatTagPayload((FloatTag)var1);
                break;

            case 6:
                this.writeDoubleTagPayload((DoubleTag)var1);
                break;

            case 7:
                this.writeByteArrayTagPayload((ByteArrayTag)var1);
                break;

            case 8:
                this.writeStringTagPayload((StringTag)var1);
                break;

            case 9:
                this.writeListTagPayload((ListTag)var1);
                break;

            case 10:
                this.writeCompoundTagPayload((CompoundTag)var1);
                break;

            default:
                throw new IOException("Invalid tag type: " + var2 + ".");
        }
    }

    private void writeByteTagPayload(ByteTag var1) throws IOException
    {
        this.os.writeByte(var1.getValue().byteValue());
    }

    private void writeByteArrayTagPayload(ByteArrayTag var1) throws IOException
    {
        byte[] var2 = var1.getValue();
        this.os.writeInt(var2.length);
        this.os.write(var2);
    }

    private void writeCompoundTagPayload(CompoundTag var1) throws IOException
    {
        Iterator var2 = var1.getValue().values().iterator();

        while (var2.hasNext())
        {
            Tag var3 = (Tag)var2.next();
            this.writeTag(var3);
        }

        this.os.writeByte(0);
    }

    private void writeListTagPayload(ListTag var1) throws IOException
    {
        Class var2 = var1.getType();
        List var3 = var1.getValue();
        int var4 = var3.size();
        this.os.writeByte(NBTUtils.getTypeCode(var2));
        this.os.writeInt(var4);

        for (int var5 = 0; var5 < var4; ++var5)
        {
            this.writeTagPayload((Tag)var3.get(var5));
        }
    }

    private void writeStringTagPayload(StringTag var1) throws IOException
    {
        byte[] var2 = var1.getValue().getBytes(NBTConstants.CHARSET);
        this.os.writeShort(var2.length);
        this.os.write(var2);
    }

    private void writeDoubleTagPayload(DoubleTag var1) throws IOException
    {
        this.os.writeDouble(var1.getValue().doubleValue());
    }

    private void writeFloatTagPayload(FloatTag var1) throws IOException
    {
        this.os.writeFloat(var1.getValue().floatValue());
    }

    private void writeLongTagPayload(LongTag var1) throws IOException
    {
        this.os.writeLong(var1.getValue().longValue());
    }

    private void writeIntTagPayload(IntTag var1) throws IOException
    {
        this.os.writeInt(var1.getValue().intValue());
    }

    private void writeShortTagPayload(ShortTag var1) throws IOException
    {
        this.os.writeShort(var1.getValue().shortValue());
    }

    private void writeEndTagPayload(EndTag var1) {}

    public void close() throws IOException
    {
        this.os.close();
    }
}
