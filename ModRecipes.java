package mytestmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void addRecipes()
	{

		
//Nugget Washer
		GameRegistry.addRecipe(new ItemStack(MyTestMod.nuggetWasherIdle), new Object[]{
			"XYX",
			"YBY",
			"XXX",
			'X', MyTestMod.modStone, 'Y', Block.fenceIron , 'B', Item.cauldron});
//Copper Ingot
		GameRegistry.addRecipe(new ItemStack(MyTestMod.ingot, 1, 0), new Object[]{
			"CCC",
			"CCC",
			"CCC",
		    'C', new ItemStack(MyTestMod.nugget, 1, 6)});
//Tin Ingot
		GameRegistry.addRecipe(new ItemStack(MyTestMod.ingot, 1, 1), new Object[]{
			"TTT",
			"TTT",
			"TTT",
			'T', new ItemStack(MyTestMod.nugget, 1, 7)});
//Iron Ingot		
		GameRegistry.addRecipe(new ItemStack(Item.ingotIron), new Object[]{
			"III",
			"III",
			"III",
			'I', new ItemStack(MyTestMod.nugget, 1, 8)});
//Silver		
		GameRegistry.addRecipe(new ItemStack(MyTestMod.ingot, 1, 2), new Object[]{
			"SSS",
			"SSS",
			"SSS",
			'S', new ItemStack(MyTestMod.nugget, 1, 9)});
//Lead		
		GameRegistry.addRecipe(new ItemStack(MyTestMod.ingot, 1, 3), new Object[]{
			"LLL",
			"LLL",
			"LLL",
			'L', new ItemStack(MyTestMod.nugget, 1, 10)});	
	
	
	
	}
}
