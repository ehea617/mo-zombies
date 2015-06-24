package com.ehea617.main;

import com.ehea617.entity.EntityMain;
import com.ehea617.lib.Strings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.MODID, name = Strings.NAME, version = Strings.VERSION)

public class RegistryMain
{
	@SidedProxy(clientSide = Strings.CLIENTSIDE, serverSide = Strings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@Instance(Strings.MODID)
	public static RegistryMain modInstance;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		EntityMain.registryMain();
		proxy.registerRenderThings();
	}
}