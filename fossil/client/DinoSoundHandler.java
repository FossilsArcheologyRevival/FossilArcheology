package fossil.client;

import java.io.File;
import java.net.URL;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fossil.Fossil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class DinoSoundHandler
{
    @ForgeSubscribe
    @SideOnly(Side.CLIENT)
    public void onSoundsLoaded(SoundLoadEvent var1)
    {
    	Minecraft mc = Minecraft.getMinecraft();
    	String pathfolder;
		if(Fossil.DebugMode)
			pathfolder="resources/dinoSounds";
		else
			pathfolder="mods/Fossil-Archeology/fossil/dinoSounds";//fossil/
    	File folder =new File(mc.mcDataDir, pathfolder);        	
        
    	if (!folder.exists())System.out.println("Could not find Sound Folder "+folder.getAbsolutePath());
    	if (folder.isFile())System.out.println("Sound folder is file "+folder.getAbsolutePath());
    	if (!folder.canRead())System.out.println("Sound folder not readable "+folder.getAbsolutePath());
    	try
        {
	        File[] Filelist = folder.listFiles();
	        for (int i = 0; i < Filelist.length; ++i)
	        {
	            
	        	String soundfile=Filelist[i].getName();
	        	URL path = Filelist[i].toURI().toURL();
	        	if(var1.manager.soundPoolSounds.addSound(soundfile, path)==null)
	        		System.out.println("Could not Load Sound File "+path);
	        }
        }
        catch (Throwable var7)
        {
            //System.err.println("Error loading sound: " + var7.getMessage());
        	System.err.println("Error loading sound: Did you unzip?");
        }
    }
}
