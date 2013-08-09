package mytestmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = MyTestMod.modid, name = "My Test Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MyTestMod
{
	public static final String modid = "marty_mytestmod";

	public static Block modStone;

	public static Item oreNugget;
	public static Item washedNugget;

	@EventHandler
	public void load(FMLInitializationEvent event)
	{

		Block.blocksList[1] = null;
		Block BlockTutorialBlock = modStone;

		modStone = new BlockModStone(1, Material.rock).setUnlocalizedName("modStone");

		GameRegistry.registerBlock(modStone, modid + modStone.getUnlocalizedName().substring(5));

		LanguageRegistry.addName(modStone, "Stone");

		oreNugget = new ItemGeneric(5000).setUnlocalizedName("oreNugget");
		washedNugget = new ItemGeneric(5001).setUnlocalizedName("washedNugget");
		
		LanguageRegistry.addName(oreNugget, "Ore Nugget");
		LanguageRegistry.addName(washedNugget, "Washed Nugget");
	}


}
