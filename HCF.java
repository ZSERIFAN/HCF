package by.zserifan.hcf;

import org.bukkit.plugin.java.JavaPlugin;

import by.zserifan.hcf.command.CommandFaction;
import by.zserifan.hcf.connection.MySQLManager;
import by.zserifan.hcf.faction.FactionManager;

public class HCF extends JavaPlugin {
	
	private static FactionManager MANAGER = null;
	
	@Override
	public void onEnable() {
		MySQLManager.openConnection();
		MANAGER = new FactionManager(this);
	}

	public static FactionManager getManager() {
		return MANAGER;
	}
	

}	