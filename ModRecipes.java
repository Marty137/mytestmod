package mytestmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MyTestMod.nuggetWasherIdle), new Object[]{
			"XYX",
			"YBY",
			"XXX",
			'X', MyTestMod.modStone, 'Y', Block.fenceIron , 'B', Item.cauldron});
	}
}
