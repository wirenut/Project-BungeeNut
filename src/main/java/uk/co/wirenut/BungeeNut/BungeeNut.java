package uk.co.wirenut.BungeeNut;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import uk.co.wirenut.BungeeNut.Commands.CommandLobby;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


public class BungeeNut extends Plugin {

    private static BungeeNut instance;
    private File file;
    public Configuration configuration;

	@Override
	public void onEnable() {
        setInstance(this);
        loadConfiguration();

        //Commands
		getProxy().getPluginManager().registerCommand(this, new CommandLobby());

		//Listeners
        getProxy().getPluginManager().registerListener(this, new Events());
		
	}

	private void loadConfiguration(){
        try {
            if (!getDataFolder().exists()){
                getDataFolder().mkdir();
            }

            file = new File(getDataFolder(), "config.yml");

            if(!file.exists()){
                try (InputStream in = getResourceAsStream("config.yml")) {
                    Files.copy(in, file.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static BungeeNut getInstance() {
	    return instance;
    }

    private static void setInstance(BungeeNut instance) {
	    BungeeNut.instance = instance;
    }

}
