package com.viaversion.aas.platform;

import com.viaversion.viabackwards.api.ViaBackwardsPlatform;

import java.io.File;
import java.util.logging.Logger;

public class AspirinBackwards implements ViaBackwardsPlatform {
	private Logger logger = Logger.getLogger("ViaBackwards");
	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public void disable() {
	}

	@Override
	public File getDataFolder() {
		return new File("config/viabackwards");
	}
}
