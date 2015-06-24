package com.ehea617.main;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelZombie;

import com.ehea617.entity.EntityDiscoZombie;
import com.ehea617.entity.EntityNetherZombie;
import com.ehea617.entity.EntitySurvivor;
import com.ehea617.entity.EntityZombieChef;
import com.ehea617.entity.EntityZombieCreeper;
import com.ehea617.entity.EntityZombieCyborg;
import com.ehea617.entity.EntityZombieDwarf;
import com.ehea617.entity.EntityZombieHerobrine;
import com.ehea617.entity.EntityZombieKing;
import com.ehea617.entity.EntityZombieKnight;
import com.ehea617.entity.EntityZombieMiner;
import com.ehea617.entity.EntityZombieNotch;
import com.ehea617.entity.EntityZombiePa;
import com.ehea617.entity.EntityZombiePirate;
import com.ehea617.render.RenderDiscoZombie;
import com.ehea617.render.RenderNetherZombie;
import com.ehea617.render.RenderSurvivor;
import com.ehea617.render.RenderZombieChef;
import com.ehea617.render.RenderZombieCreeper;
import com.ehea617.render.RenderZombieCyborg;
import com.ehea617.render.RenderZombieDwarf;
import com.ehea617.render.RenderZombieHerobrine;
import com.ehea617.render.RenderZombieKing;
import com.ehea617.render.RenderZombieKnight;
import com.ehea617.render.RenderZombieMiner;
import com.ehea617.render.RenderZombieNotch;
import com.ehea617.render.RenderZombiePa;
import com.ehea617.render.RenderZombiePirate;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieNotch.class, new RenderZombieNotch(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieMiner.class, new RenderZombieMiner(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieChef.class, new RenderZombieChef(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieCreeper.class, new RenderZombieCreeper(new ModelCreeper(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombiePirate.class, new RenderZombiePirate(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombiePa.class, new RenderZombiePa(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherZombie.class, new RenderNetherZombie(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieCyborg.class, new RenderZombieCyborg(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieDwarf.class, new RenderZombieDwarf(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieHerobrine.class, new RenderZombieHerobrine(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieKing.class, new RenderZombieKing(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieKnight.class, new RenderZombieKnight(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiscoZombie.class, new RenderDiscoZombie(new ModelZombie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntitySurvivor.class, new RenderSurvivor(new ModelBiped(), 0));
	}
}
