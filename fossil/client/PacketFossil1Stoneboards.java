package fossil.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import fossil.entity.EntityStoneboard;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumArt;

public class PacketFossil1Stoneboards extends Packet250CustomPayload
{
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int direction;
    public String title;
    private final String CHANNEL_NAME;

    public PacketFossil1Stoneboards()
    {
        this.CHANNEL_NAME = "FossilChannel";
        this.channel = "FossilChannel";
    }

    public PacketFossil1Stoneboards(EntityStoneboard var1)
    {
        this();
        this.entityId = var1.entityId;
        this.xPosition = var1.xPosition;
        this.yPosition = var1.yPosition;
        this.zPosition = var1.zPosition;
        this.direction = var1.direction;
        this.title = var1.art.title;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream var1) throws IOException
    {
        this.entityId = var1.readInt();
        this.title = readString(var1, EnumArt.maxArtTitleLength);
        this.xPosition = var1.readInt();
        this.yPosition = var1.readInt();
        this.zPosition = var1.readInt();
        this.direction = var1.readInt();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream var1) throws IOException
    {
        var1.writeInt(this.entityId);
        writeString(this.title, var1);
        var1.writeInt(this.xPosition);
        var1.writeInt(this.yPosition);
        var1.writeInt(this.zPosition);
        var1.writeInt(this.direction);
    }
}
