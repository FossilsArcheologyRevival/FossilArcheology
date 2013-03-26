package fossil.tags;

import java.io.Closeable;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

public final class NBTInputStream implements Closeable
{
    private final DataInputStream is;

    public NBTInputStream(InputStream var1) throws IOException
    {
        this.is = new DataInputStream(new GZIPInputStream(var1));
    }

    public Tag readTag() throws IOException
    {
        return this.readTag(0);
    }

    private Tag readTag(int var1) throws IOException
    {
        int var2 = this.is.readByte() & 255;
        String var3;

        if (var2 != 0)
        {
            int var4 = this.is.readShort() & 65535;
            byte[] var5 = new byte[var4];
            this.is.readFully(var5);
            var3 = new String(var5, NBTConstants.CHARSET);
        }
        else
        {
            var3 = "";
        }

        return this.readTagPayload(var2, var3, var1);
    }

    private Tag readTagPayload(int var1, String var2, int var3) throws IOException
    {
        int var4;
        byte[] var5;
        Tag var9;

        switch (var1)
        {
            case 0:
                if (var3 == 0)
                {
                    throw new IOException("TAG_End found without a TAG_Compound/TAG_List tag preceding it.");
                }

                return new EndTag();

            case 1:
                return new ByteTag(var2, this.is.readByte());

            case 2:
                return new ShortTag(var2, this.is.readShort());

            case 3:
                return new IntTag(var2, this.is.readInt());

            case 4:
                return new LongTag(var2, this.is.readLong());

            case 5:
                return new FloatTag(var2, this.is.readFloat());

            case 6:
                return new DoubleTag(var2, this.is.readDouble());

            case 7:
                var4 = this.is.readInt();
                var5 = new byte[var4];
                this.is.readFully(var5);
                return new ByteArrayTag(var2, var5);

            case 8:
                short var10 = this.is.readShort();
                var5 = new byte[var10];
                this.is.readFully(var5);
                return new StringTag(var2, new String(var5, NBTConstants.CHARSET));

            case 9:
                byte var6 = this.is.readByte();
                var4 = this.is.readInt();
                ArrayList var7 = new ArrayList();

                for (int var11 = 0; var11 < var4; ++var11)
                {
                    var9 = this.readTagPayload(var6, "", var3 + 1);

                    if (var9 instanceof EndTag)
                    {
                        throw new IOException("TAG_End not permitted in a list.");
                    }

                    var7.add(var9);
                }

                return new ListTag(var2, NBTUtils.getTypeClass(var6), var7);

            case 10:
                HashMap var8 = new HashMap();

                while (true)
                {
                    var9 = this.readTag(var3 + 1);

                    if (var9 instanceof EndTag)
                    {
                        return new CompoundTag(var2, var8);
                    }

                    var8.put(var9.getName(), var9);
                }

            default:
                throw new IOException("Invalid tag type: " + var1 + ".");
        }
    }

    public void close() throws IOException
    {
        this.is.close();
    }
}
