package com.coolerpromc.moregears;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MODID = "moregears";
	public static final Logger LOG = LoggerFactory.getLogger(MODID);

	public static Identifier id(String name){
		return Identifier.fromNamespaceAndPath(MODID, name);
	}
}