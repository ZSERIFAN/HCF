package by.zserifan.hcf.faction;

import java.sql.ResultSet;

import org.bukkit.Bukkit;

import by.zserifan.hcf.HCF;
import by.zserifan.hcf.Settings;

public class Faction {
	
	private String name, description;
	
	public Faction(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public  Faction(ResultSet set) throws Exception {
		this.name = set.getString("name");
		this.description = set.getString("description");
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		if (description == null || description.equals(""))
			description = Settings.DEFAULT_FACTION_DESCRIPTION;
		return description;
	}
	
	public void notifyMembers(String message) {
			for (FactionPlayer fp : HCF.getManager().getPlayers())
				if (fp.getFaction() == this || (fp.getFaction() != null && fp.getName() == name))
					if (Bukkit.getPlayer(fp.getId()) != null)
						Bukkit.getPlayer(fp.getId()).sendMessage(message);
	}

	public void setDescription(String newDesc) {
		this.description = newDesc;
	}
	
}
