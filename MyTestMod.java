package mytestmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
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
	
	public static final String modid = "marty_mytestmod";
	
	private GuiHandler guihandler = new GuiHandler();
		
	public static Block nuggetWasherIdle;
	public static Block nuggetWasherWorking;
	
	public static Block modStone;
	
	public static Item nugget;
	public static Item ingot;

	public static void oreRegistration()
	{
		OreDictionary.registerOre("nuggetCopper", (new ItemStack(nugget, 1, 6)));
		OreDictionary.registerOre("nuggetTin", (new ItemStack(nugget, 1, 7)));
		OreDictionary.registerOre("nuggetIron", (new ItemStack(nugget, 1, 8)));
		OreDictionary.registerOre("nuggetSilver", (new ItemStack(nugget, 1, 9)));
		OreDictionary.registerOre("nuggetLead", (new ItemStack(nugget, 1, 10)));
		OreDictionary.registerOre("ingotCopper", (new ItemStack(ingot, 1, 0)));
		OreDictionary.registerOre("ingotTin", (new ItemStack(ingot, 1, 1)));
		OreDictionary.registerOre("ingotSilver", (new ItemStack(ingot, 1, 2)));
		OreDictionary.registerOre("ingotLead", (new ItemStack(ingot, 1, 3)));
	}
	
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

		nugget = new Nuggets(5000).setUnlocalizedName("nugget");
		ingot = new Ingots(5001).setUnlocalizedName("ingot");
				
		LanguageRegistry.addName(new ItemStack(nugget, 1, 0), "Dirty Copper Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 1), "Dirty Tin Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 2), "Dirty Iron Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 3), "Dirty Gold Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 4), "Dirty Silver Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 5), "Dirty Lead Nugget");
		
		LanguageRegistry.addName(new ItemStack(nugget, 1, 6), "Copper Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 7), "Tin Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 8), "Iron Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 9), "Silver Nugget");
		LanguageRegistry.addName(new ItemStack(nugget, 1, 10), "Lead Nugget");
		
		LanguageRegistry.addName(new ItemStack(ingot, 1, 0), "Copper Ingot");
		LanguageRegistry.addName(new ItemStack(ingot, 1, 1), "Tin Ingot");
		LanguageRegistry.addName(new ItemStack(ingot, 1, 2), "Silver Ingot");
		LanguageRegistry.addName(new ItemStack(ingot, 1, 3), "Lead Ingot");
		
		
		
		ModRecipes.addRecipes();
		
	}


}
