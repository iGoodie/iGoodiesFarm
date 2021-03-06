package igoodie.igoodiesfarm.items.type;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GoodiesFarmItemFood extends Item
{
	/** Number of ticks to run while 'EnumAction'ing until result. */
	public final int itemUseDuration;
	/** The amount this food item heals the player. */
	private final int healAmount;
	private final float saturationModifier;
	/** Whether wolves like this food (true for raw and cooked porkchop). */
	private final boolean isWolfsFavoriteMeat;
	/** If this field is true, the food can be consumed even if the player don't need to eat. */
	private boolean alwaysEdible = false;
	/** represents the potion effect that will occurr upon eating this food. Set by setPotionEffect */
	private int potionId;
	/** set by setPotionEffect */
	private int potionDuration;
	/** set by setPotionEffect */
	private int potionAmplifier;
	/** probably of the set potion effect occurring */
	private float potionEffectProbability;
	private static final String __OBFID = "CL_00000036";

	public GoodiesFarmItemFood(int hunger, float satK, boolean wolf, int useDur)
	{
		this.itemUseDuration = useDur;
		this.healAmount = hunger;
		this.isWolfsFavoriteMeat = wolf;
		this.saturationModifier = satK;
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		--stack.stackSize;
		player.getFoodStats().addStats(healAmount, saturationModifier);
		world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		//this.onFoodEaten(stack, world, player);
		return stack;
	}

	/*protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        if (!p_77849_2_.isRemote && this.potionId > 0 && p_77849_2_.rand.nextFloat() < this.potionEffectProbability)
        {
            p_77849_3_.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
    }*/

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return this.itemUseDuration;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
	{
		return EnumAction.eat;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	{
		if (p_77659_3_.canEat(this.alwaysEdible))
		{
			p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
		}

		return p_77659_1_;
	}

	public int func_150905_g(ItemStack p_150905_1_)
	{
		return this.healAmount;
	}

	public float func_150906_h(ItemStack p_150906_1_)
	{
		return this.saturationModifier;
	}
	

	/**
	 * Whether wolves like this food (true for raw and cooked porkchop).
	 */
	public boolean isWolfsFavoriteMeat()
	{
		return this.isWolfsFavoriteMeat;
	}

	/**
	 * sets a potion effect on the item. Args: int potionId, int duration (will be multiplied by 20), int amplifier,
	 * float probability of effect happening
	 */
	public Item setPotionEffect(int p_77844_1_, int p_77844_2_, int p_77844_3_, float p_77844_4_)
    {
        this.potionId = p_77844_1_;
        this.potionDuration = p_77844_2_;
        this.potionAmplifier = p_77844_3_;
        this.potionEffectProbability = p_77844_4_;
        return this;
    }

	/**
	 * Set the field 'alwaysEdible' to true, and make the food edible even if the player don't need to eat.
	 */
	public Item setAlwaysEdible()
    {
        this.alwaysEdible = true;
        return this;
    }
}
