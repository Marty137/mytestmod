package mytestmod;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;



public class Nuggets  extends Item
{

	public Nuggets(int id) 
	{
		super(id);
		this.setHasSubtypes(true);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		icons = new Icon[11];
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = par1IconRegister.registerIcon(MyTestMod.modid + ":" + (this.getUnlocalizedName().substring(5)) +i);
		}
	}

	public static final String[] names = new String[] {"nugget0", "nugget1", "nugget2", "nugget3", "nugget4", "nugget5", "nugget6", "nugget7", "nugget8", "nugget9", "nugget10"};
	
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[i];
	}
	
	public Icon getIconFromDamage(int par1)
    {
        return icons[par1];
    }
  
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
          for(int x = 0; x < 11; x++)
          {
                 par3List.add(new ItemStack(par1, 1, x));
          }
    }

}
