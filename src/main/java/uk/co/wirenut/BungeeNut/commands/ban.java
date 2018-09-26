package uk.co.wirenut.BungeeNut.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;
import uk.co.wirenut.BungeeNut.BungeeNut;
import uk.co.wirenut.BungeeNut.SQL.db;
import uk.co.wirenut.BungeeNut.modules.uuid;

public class ban extends Command {


    public ban() {
        super("ban");

    }

    public void execute(CommandSender sender, String[] args) {



        if (!sender.hasPermission("wirenut.ban")){
            sender.sendMessage(new ComponentBuilder("You do not have permission to run this command!").color(ChatColor.RED).create());
            return;
        }

        if(args.length == 0){
            sender.sendMessage(new ComponentBuilder("Invalid usage: /ban <player>").color(ChatColor.RED).create());
            return;
        }

        String targetUUID = String.valueOf(new uuid().get(args[0]));

        BungeeNut.getInstance().getLogger().info(args[0]);
        BungeeNut.getInstance().getLogger().info(targetUUID);

        StringBuilder reason = new StringBuilder();
        for(int i = 1; i < args.length; ++i) {
            reason.append(args[i]).append(' ');
        }



            String sql = "INSERT INTO bans (uuid, reason) VALUES ('" + targetUUID + "', '" + reason.toString() + "');";

            new db().insert(sql);

    }
}

