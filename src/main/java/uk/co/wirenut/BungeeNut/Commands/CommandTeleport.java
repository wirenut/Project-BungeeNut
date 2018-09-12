package uk.co.wirenut.BungeeNut.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandTeleport extends Command {

	public CommandTeleport() {
		super("tp");
		
	}
	
	public void execute(CommandSender sender, String[] args) {
		
		
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		ProxiedPlayer targetPlayer = null;
		
		
		
		
		
	}
}
