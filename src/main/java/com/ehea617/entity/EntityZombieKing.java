package com.ehea617.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityZombieKing extends EntityMob
{
	public EntityZombieKing(World par1World)
	{
		super(par1World);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.20D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 0.20D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.20D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 0.20D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 0.20D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(0.6F, 1.8F);
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	public void onLivingUpdate()
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		super.onLivingUpdate();
	}
	
    protected String getLivingSound()
    {
        return "mob.zombie.say";
    }
    
    protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }
    
    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }
    
    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
    
    protected Item getDropItem()
    {
        return Items.gold_ingot;
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(8))
        {
            case 0:
                this.dropItem(Items.golden_axe, 1);
                break;
            case 1:
                this.dropItem(Items.golden_pickaxe, 1);
                break;
            case 2:
                this.dropItem(Items.golden_shovel, 1);
                break;
            case 3:
                this.dropItem(Items.golden_hoe, 1);
                break;
            case 4:
                this.dropItem(Items.golden_helmet, 1);
                break;
            case 5:
                this.dropItem(Items.golden_leggings, 1);
                break;
            case 6:
                this.dropItem(Items.golden_boots, 1);
                break;
            case 7:
                this.dropItem(Items.golden_chestplate, 1);
        }
    }
}
