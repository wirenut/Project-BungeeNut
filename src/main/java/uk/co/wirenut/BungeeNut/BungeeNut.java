package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import uk.co.wirenut.BungeeNut.commands.ban;
import uk.co.wirenut.BungeeNut.commands.hub;
import uk.co.wirenut.BungeeNut.commands.vanilla;
import uk.co.wirenut.BungeeNut.configuration.config;
import uk.co.wirenut.BungeeNut.configuration.players;
import uk.co.wirenut.BungeeNut.configuration.PostLogin;


public class BungeeNut extends Plugin {

    private static BungeeNut instance;
    public Configuration config;
    public Configuration playersCache;


	@Override
	public void onEnable() {
        setInstance(this);
        loadConfiguration();



        //commands
		getProxy().getPluginManager().registerCommand(this, new hub());
        getProxy().getPluginManager().registerCommand(this, new vanilla());
        getProxy().getPluginManager().registerCommand(this, new ban());

		//Listeners
        getProxy().getPluginManager().registerListener(this, new PostLogin());

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
