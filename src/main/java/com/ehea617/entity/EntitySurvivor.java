package com.ehea617.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySurvivor extends EntityAnimal
{
	public EntitySurvivor(World par1World)
	{
		super(par1World);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAITempt(this, 0.45D, Items.iron_ingot, false));
        this.tasks.addTask(2, new EntityAIWander(this, 0.45D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
		this.setSize(0.6F, 2.0F);
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	public void onLivingUpdate()
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.75D);
		super.onLivingUpdate();
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		return null;
	}
    
    protected String getHurtSound()
    {
        return "game.neutral.hurt";
    }
    
    protected String getDeathSound()
    {
        return "game.neutral.hurt";
    }
    
    protected Item getDropItem()
    {
        return Items.bread;
    }
}
