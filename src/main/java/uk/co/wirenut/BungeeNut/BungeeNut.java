package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import uk.co.wirenut.BungeeNut.Commands.CommandBan;
import uk.co.wirenut.BungeeNut.Commands.CommandLobby;
import uk.co.wirenut.BungeeNut.configuration.config;
import uk.co.wirenut.BungeeNut.configuration.players;


public class BungeeNut extends Plugin {

    private static BungeeNut instance;
    public Configuration config;
    public Configuration playersCache;


	@Override
	public void onEnable() {
        setInstance(this);
        loadConfiguration();



        //Commands
		getProxy().getPluginManager().registerCommand(this, new CommandLobby());
        getProxy().getPluginManager().registerCommand(this, new CommandBan());

		//Listeners
        getProxy().getPluginManager().registerListener(this, new Events());

	}

	private void loadConfiguration() {
	    config = new config().load();
        playersCache = new players().load();

    }

	public static BungeeNut getInstance() {

	    return instance;
    }

    private static void setInstance(BungeeNut instance) {

	    BungeeNut.instance = instance;
    }


}
