package mcpi.boom;

import mcpi.MCPI;

import java.util.Collections;
import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.block.Block;

import org.bukkit.Material;

public class BoomCommand implements CommandExecutor {
    MCPI plugin;

    public BoomCommand(MCPI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cmdName = cmd.getName().toLowerCase();

        if (!cmdName.equals("boom")) {
            return false;
        }

        Player player = sender.getServer().getPlayer(sender.getName());

        if (player != null) {
          Block block = player.getTargetBlockExact(6);
          if (block != null) {
            for( int y = 0; y <= block.getY(); y++ ) {
              for( int dx = -1; dx <= 1; dx++ ) {
                for( int dz = -1; dz <= 1; dz++ ) {
                  if (dx != 0 || dz != 0) {
                    Block targetBlock = player.getWorld().getBlockAt(
                        block.getX() - dx,
                        y,
                        block.getZ() - dz
                    );
                    if (targetBlock != null && !targetBlock.getType().equals(Material.BEDROCK)) {
                      targetBlock.setType(Material.SAND);
                    }
                  }
                }
                Block targetBlock = player.getWorld().getBlockAt(
                    block.getX(),
                    y,
                    block.getZ()
                );
                if (targetBlock != null && !targetBlock.getType().equals(Material.BEDROCK)) {
                  targetBlock.setType(Material.TNT);
                }
              }
            }
          }
        }

        sender.sendMessage("goes the dznomite");

        return true;
    }
}
