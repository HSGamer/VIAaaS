package com.viaversion.aas.provider;

import com.viaversion.aas.handler.UtilKt;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.CompressionProvider;

import java.util.Objects;

public class AspirinCompressionProvider extends CompressionProvider {
	@Override
	public void handlePlayCompression(UserConnection user, int threshold) {
		UtilKt.setCompression(Objects.requireNonNull(user.getChannel()), threshold);
	}
}
