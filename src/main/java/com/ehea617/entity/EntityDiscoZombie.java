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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDiscoZombie extends EntityMob
{
	public EntityDiscoZombie(World par1World)
	{
		super(par1World);
        this.getNavigator().setBreakDoors(true);
        this.setJumping(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.3D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 0.3D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.3D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 0.3D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 0.3D));
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
    	this.worldObj.spawnParticle("note", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.rand.nextGaussian() * 0.02D, this.rand.nextGaussian() * 0.02D, this.rand.nextGaussian() * 0.02D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
            {
                boolean flag = true;
                ItemStack itemstack = this.getEquipmentInSlot(4);

                if (itemstack != null)
                {
                    if (itemstack.isItemStackDamageable())
                    {
                        itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));

                        if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage())
                        {
                            this.renderBrokenItemStack(itemstack);
                            this.setCurrentItemOrArmor(4, (ItemStack)null);
                        }
                    }
                    flag = false;
                }
                if (flag)
                {
                    this.setFire(8);
                }
            }
        }
        super.onLivingUpdate();
    }
	
    protected String getLivingSound()
    {
        return "note.bass";
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
    
    public ItemStack getHeldItem()
    {
		return new ItemStack(Blocks.noteblock, 1);
    }
    
    protected Item getDropItem()
    {
        return Item.getItemFromBlock(Blocks.noteblock);
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(13))
        {
            case 0:
                this.dropItem(Item.getItemFromBlock(Blocks.jukebox), 1);
                break;
            case 1:
                this.dropItem(Items.record_11, 1);
                break;
            case 2:
                this.dropItem(Items.record_13, 1);
                break;
            case 3:
                this.dropItem(Items.record_blocks, 1);
                break;
            case 4:
                this.dropItem(Items.record_cat, 1);
                break;
            case 5:
                this.dropItem(Items.record_chirp, 1);
                break;
            case 6:
                this.dropItem(Items.record_far, 1);
                break;
            case 7:
                this.dropItem(Items.record_mall, 1);
                break;
            case 8:
                this.dropItem(Items.record_mellohi, 1);
                break;
            case 9:
                this.dropItem(Items.record_stal, 1);
                break;
            case 10:
                this.dropItem(Items.record_strad, 1);
                break;
            case 11:
                this.dropItem(Items.record_wait, 1);
                break;
            case 12:
                this.dropItem(Items.record_ward, 1);
        }
    }
}
