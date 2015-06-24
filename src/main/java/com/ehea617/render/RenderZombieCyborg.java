package com.ehea617.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.ehea617.entity.EntityZombieCyborg;
import com.ehea617.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderZombieCyborg extends RenderBiped
{
    public RenderZombieCyborg(ModelBiped par1ModelBiped, float par2)
    {
        super(par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(EntityZombieCyborg par1EntityZombieCyborg)
    {
        return new ResourceLocation(Strings.MODID + ":textures/entity/ZombieCyborg.png");
    }
    
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityZombieCyborg)par1Entity);
    }
}