package mytestmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = MyTestMod.modid, name = "My Test Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = "MyTestMod", packetHandler = MTMPacketHandler.class)

public class MyTestMod
{
	@Instance
	public static MyTestMod instance = new MyTestMod();
	
	private GuiHandler guihandler = new GuiHandler();
	
	
	public static final String modid = "marty_mytestmod";

	public static Block nuggetWasherIdle;
	public static Block nuggetWasherWorking;
	
	public static Block modStone;

	
	public static Item oreNugget;
	public static Item washedNugget;


	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{

		Block.blocksList[1] = null;
		Block BlockTutorialBlock = modStone;

		nuggetWasherIdle = new NuggetWasher(1000, false).setUnlocalizedName("nuggetWasherIdle").setCreativeTab(CreativeTabs.tabDecorations).setHardness(1.5F).setResistance(10.0F);
		nuggetWasherWorking = new NuggetWasher(1001, true).setUnlocalizedName("nuggetWasherWorking").setHardness(1.5F).setResistance(10.0F);
		
		
		GameRegistry.registerBlock(nuggetWasherIdle, modid + nuggetWasherIdle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nuggetWasherWorking, modid + nuggetWasherWorking.getUnlocalizedName().substring(5));
		GameRegistry.registerTileEntity(TileEntityNuggetWasher.class, "tileentitynuggetwasher");
		NetworkRegistry.instance().registerGuiHandler(this, guihandler);
		
		LanguageRegistry.addName(nuggetWasherIdle, "Nugget Washer");
		LanguageRegistry.addName(nuggetWasherWorking, "Nugget Washer");
		
		
		
		modStone = new BlockModStone(1, Material.rock).setUnlocalizedName("modStone");

		GameRegistry.registerBlock(modStone, modid + modStone.getUnlocalizedName().substring(5));

		LanguageRegistry.addName(modStone, "Stone");

		oreNugget = new ItemGeneric(5000).setUnlocalizedName("oreNugget");
		washedNugget = new ItemGeneric(5001).setUnlocalizedName("washedNugget");
		
		LanguageRegistry.addName(oreNugget, "Ore Nugget");
		LanguageRegistry.addName(washedNugget, "Washed Nugget");
	}


}
