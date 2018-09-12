package uk.co.wirenut.BungeeNut.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandLobby extends Command {

	public CommandLobby() {
		super("lobby");
		
	}
	
	public void execute(CommandSender sender, String[] args) {
		
		
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		ProxiedPlayer targetPlayer = null;
		
		if(player instanceof ProxiedPlayer) {
			
			if(player.hasPermission("wirenut.teleport.other") && args.length == 1) {
				targetPlayer = ProxyServer.getInstance().getPlayer(args[0]);
			} else if(player.hasPermission("wirenut.teleport.base") && args.length == 0) {
				targetPlayer = player;
				
			}
			
			if(targetPlayer == null) {
				sender.sendMessage(new ComponentBuilder("You do not have permission to run this command!").color(ChatColor.RED).create());
			} else {
				if(targetPlayer.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {
					targetPlayer.sendMessage(new ComponentBuilder("You are already connected to the Hub!").color(ChatColor.RED).create());
				} else {
					ServerInfo targetServer = ProxyServer.getInstance().getServerInfo("Hub");
					targetPlayer.connect(targetServer);
				}
			}
			
		}
		
		
		
	}
}
