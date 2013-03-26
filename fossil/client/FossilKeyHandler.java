package fossil.client;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.settings.KeyBinding;

public class FossilKeyHandler extends KeyBindingRegistry
{
    public static KeyBinding jumpKeyBinding = new KeyBinding("jumpKey", 24);
    public static KeyBinding forwardKeyBinding = new KeyBinding("forwardKey", 23);
    public static KeyBinding backwardKeyBinding = new KeyBinding("backwardKey", 37);
    public static KeyBinding rightturnKeyBinding = new KeyBinding("rightturnKey", 38);
    public static KeyBinding leftturnKeyBinding = new KeyBinding("leftturnKey", 36);
    public static boolean[] pressedKey = new boolean[] {false, false, false, false, false};

    public FossilKeyHandler()
    {
        super();
    }

    public boolean isJumpPressed()
    {
        return pressedKey[0];
    }

    public boolean isForwardPressed()
    {
        return pressedKey[1];
    }

    public boolean isBackwardPressed()
    {
        return pressedKey[2];
    }

    public boolean isRightTurnPressed()
    {
        return pressedKey[3];
    }

    public boolean isLeftTurnPressed()
    {
        return pressedKey[4];
    }

    public String getLabel()
    {
        return "FossilMotionHandler";
    }

    public void keyDown(EnumSet var1, KeyBinding var2, boolean var3, boolean var4)
    {
        if (var2.keyCode == jumpKeyBinding.keyCode)
        {
            pressedKey[0] = true;
        }

        if (var2.keyCode == forwardKeyBinding.keyCode)
        {
            pressedKey[1] = true;
        }

        if (var2.keyCode == backwardKeyBinding.keyCode)
        {
            pressedKey[2] = true;
        }

        if (var2.keyCode == rightturnKeyBinding.keyCode)
        {
            pressedKey[3] = true;
        }

        if (var2.keyCode == leftturnKeyBinding.keyCode)
        {
            pressedKey[4] = true;
        }
    }

    public void keyUp(EnumSet var1, KeyBinding var2, boolean var3)
    {
        if (var2.keyCode == jumpKeyBinding.keyCode)
        {
            pressedKey[0] = false;
        }

        if (var2.keyCode == forwardKeyBinding.keyCode)
        {
            pressedKey[1] = false;
        }

        if (var2.keyCode == backwardKeyBinding.keyCode)
        {
            pressedKey[2] = false;
        }

        if (var2.keyCode == rightturnKeyBinding.keyCode)
        {
            pressedKey[3] = false;
        }

        if (var2.keyCode == leftturnKeyBinding.keyCode)
        {
            pressedKey[4] = false;
        }
    }

    public EnumSet ticks()
    {
        return EnumSet.of(TickType.PLAYER);
    }
}
