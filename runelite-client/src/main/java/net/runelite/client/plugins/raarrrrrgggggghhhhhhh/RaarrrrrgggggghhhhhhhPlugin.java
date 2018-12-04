package net.runelite.client.plugins.raarrrrrgggggghhhhhhh;

import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SetMessage;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Raarrrrrgggggghhhhhhh",
	description = "Raarrrrrgggggghhhhhhh"
)
public class RaarrrrrgggggghhhhhhhPlugin extends Plugin
{
	private int count;
	@Getter(AccessLevel.PACKAGE)
	private boolean isRenderingOverhead;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RaarrrrrgggggghhhhhhhOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onSetMessage(SetMessage event)
	{
		if (event.getType() == ChatMessageType.PUBLIC
			&& event.getValue().equals("Raarrrrrgggggghhhhhhh!")
			&& event.getName().equals(client.getLocalPlayer().getName()))
		{
			event.getMessageNode().setValue("Reeeeeeeeeeeeeeeeeeeeee!");
			overlayManager.add(overlay);
			count = 1;
			client.setLocalPlayerHidden2D(true);
			isRenderingOverhead = true;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (count == 0)
		{
			return;
		}

		count++;

		if (count == 8)
		{
			client.setLocalPlayerHidden2D(false);
			isRenderingOverhead = false;
			count = 0;
		}
	}
}
