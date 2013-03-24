package fossil.client;

import cpw.mods.fml.common.network.IChatListener;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet3Chat;

public class FossilMessageHandler implements IChatListener
{
    public Packet3Chat serverChat(NetHandler var1, Packet3Chat var2)
    {
        return var2;
    }

    public Packet3Chat clientChat(NetHandler var1, Packet3Chat var2)
    {
        return var2;
    }
}
