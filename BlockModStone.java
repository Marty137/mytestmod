package mytestmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModStone extends Block
{

	protected BlockModStone(int id, Material par2Material) 
	{
		super(id, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock).setHardness(1.5F).setResistance(10.0F).setStepSound(soundStoneFootstep);

	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if (par3 > 3)
		 {
		 	par3 = 3;
		 }
		 return par2Random.nextInt(10 - par3 * 3) == 0 ? MyTestMod.oreNugget.itemID : Block.cobblestone.blockID;
	}
		
@SideOnly(Side.CLIENT)
	
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(MyTestMod.modid + ":" + this.getUnlocalizedName());
	}
}
