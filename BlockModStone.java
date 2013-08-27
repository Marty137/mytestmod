package mytestmod;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModStone extends Block
{

	protected BlockModStone(int id, Material par2Material) 
	{
		super(id, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock).setHardness(1.5F).setResistance(10.0F).setStepSound(soundStoneFootstep);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }
	
	@Override
    public int quantityDropped(Random par1Random)
    {
		return 1;
    }

	
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> list = new ArrayList<ItemStack>();
		int nugChance = 0;
		int count = quantityDropped(metadata, fortune, world.rand);
		int idDropped = 0;
		int nugMeta = 0;
		for(int i = 0; i < count; i++)
	    {
	      	Random itemcount = new Random();
	       	nugChance = itemcount.nextInt(50);
	        idDropped = 0;
	        nugMeta = 0;
	        	
	        if (nugChance == 0)
	      	{
	       	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
	       	nugMeta = 0;
	       	}
	       	if (nugChance == 1)
		   	{
		   	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 0;
		   	}
	       	if (nugChance == 2)
		   	{
		   	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 0;
		   	}
	       	if (nugChance == 3)
		   	{
		   	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 1;
		   	}
	       	if (nugChance == 4)
		   	{
		   	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 1;
		   	}
	       	if (nugChance == 5)
		   	{
		   	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 1;
		   	}
	        if (nugChance == 6)
		   	{
		  	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 2;
		   	}
	        if (nugChance == 7)
		   	{
		  	idDropped = (new ItemStack(MyTestMod.nugget).itemID);
		   	nugMeta = 2;
		   	}
	        if (nugChance == 8)
		   	{
			idDropped = (new ItemStack(MyTestMod.nugget).itemID);
			nugMeta = 3;
		   	}  	
	        if (nugChance == 9)
		   	{
			idDropped = (new ItemStack(MyTestMod.nugget).itemID);
			nugMeta = 4;
		   	}
	        if (nugChance == 10)
		   	{
			idDropped = (new ItemStack(MyTestMod.nugget).itemID);
			nugMeta = 5;
		   	}
	        if (nugChance > 10)
		   	{
		   	idDropped = (new ItemStack(Block.cobblestone).itemID);
		   	}
	        if (idDropped > 0)
		  	{
		    list.add(new ItemStack(idDropped, 1, nugMeta));
		    {			
		}
	}
}
return list;	
	}
		
@SideOnly(Side.CLIENT)
	
	public void registerIcons(IconRegister par1IconRegister)
	{
	this.blockIcon = par1IconRegister.registerIcon(MyTestMod.modid + ":" + "modstone");
	}
}
