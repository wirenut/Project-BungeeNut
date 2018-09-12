package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.plugin.Plugin;
import uk.co.wirenut.BungeeNut.Commands.CommandLobby;

public class BungeeNut extends Plugin {

	@Override
	public void onEnable() {
		
		getProxy().getPluginManager().registerCommand(this, new CommandLobby());
		
	}

}
