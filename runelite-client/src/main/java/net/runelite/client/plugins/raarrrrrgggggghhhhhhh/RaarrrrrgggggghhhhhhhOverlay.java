package net.runelite.client.plugins.raarrrrrgggggghhhhhhh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class RaarrrrrgggggghhhhhhhOverlay extends Overlay
{
	private final Client client;
	private final RaarrrrrgggggghhhhhhhPlugin plugin;
	private static final Color YELLOW = new Color(255, 255, 0);
	private static final Font FONT = FontManager.getRunescapeFont().deriveFont(Font.BOLD, 16);

	@Inject
	RaarrrrrgggggghhhhhhhOverlay(Client client, RaarrrrrgggggghhhhhhhPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isRenderingOverhead())
		{
			return null;
		}

		graphics.setFont(FONT);
		Player local = client.getLocalPlayer();
		OverlayUtil.renderActorOverlayTextOnly(graphics, local, "Reeeeeeeeeeeeeeeeeeeeee!", YELLOW);
		return null;
	}
}
