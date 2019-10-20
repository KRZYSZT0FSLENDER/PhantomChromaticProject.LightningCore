package PhantomChromaticProject.LightningCore.FileManager;

import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import PhantomChromaticProject.LightningCore.DataModulation.EconomyValue;

@SuppressWarnings("unused")
public class PlayerDataManager {

	private YamlConfiguration PlayerData;
	private Player DataPlayer;
	private UUID PlayerUUID;
	private String PlayerName;
	private String LastIPAdress;
	private String FirstIPAdress;
	private EconomyValue PlayerEconomy;
	
	public PlayerDataManager(Player player) {
		this.DataPlayer = player;
		this.PlayerUUID = player.getUniqueId();
		this.LastIPAdress = player.getAddress().getAddress().toString().replace("/", "");
		this.PlayerData = FileManager.getPlayerData(player);
		this.PlayerEconomy = EconomyValue.loadData(player, FileManager.getEconomyFile());
	}
	
	public static void CreatePlayerData(Player player) {
		
	}
	
}
