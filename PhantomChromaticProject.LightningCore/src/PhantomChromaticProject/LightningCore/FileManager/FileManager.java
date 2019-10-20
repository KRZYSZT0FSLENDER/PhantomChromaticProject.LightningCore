package PhantomChromaticProject.LightningCore.FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import PhantomChromaticProject.LightningCore.LightningCore;

@SuppressWarnings("unused")
public class FileManager {

	private static LightningCore pl = LightningCore.getPlugin(LightningCore.class);
	private static File f;
	
	public static void CheckFiles() {
		f = new File("plugins", "PhantomChromaticProject");
		if(!f.exists()) {
			f.mkdir();
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject", "Core");
		if(!f.exists()) {
			f.mkdir();
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "PlayersData");
		if(!f.exists()) {
			f.mkdir();
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "BackPacks");
		if(!f.exists()) {
			f.mkdir();
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "Advancements");
		if(!f.exists()) {
			f.mkdir();
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "Config.yml");
		if(!f.exists()) {
			LightningCore.firstrunnercfg = true;
			BufferedReader br = new BufferedReader(new InputStreamReader(pl.getResource("Config.yml")));
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(f));
				String s;
				while ((s = br.readLine()) != null) {
					bw.write(s);
					bw.newLine();
					
				}
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "Messages.yml");
		if(!f.exists()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(pl.getResource("Messages.yml")));
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(f));
				String s;
				while ((s = br.readLine()) != null) {
					bw.write(s);
					bw.newLine();
					
				}
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		f = new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "EconomyBank.yml");
		if(!f.exists()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(pl.getResource("EconomyBank.yml")));
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(f));
				String s;
				while ((s = br.readLine()) != null) {
					bw.write(s);
					bw.newLine();
					
				}
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static File getMessagesFile() {return new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "Messages.yml");}
	public static File getConfigFile() {return new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core", "Config.yml");}
	public static File getPlayerDataFile(Player player) {return new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core" + File.separator + "PlayersData", player.getUniqueId() + ".yml");}
	public static File getEconomyFile() {return new File("plugins" + File.separator + "PhantomChromaticProject" + File.separator + "Core" , "EconomyBank.yml");}
	public static YamlConfiguration getPlayerData(Player player) {
		return YamlConfiguration.loadConfiguration(FileManager.getPlayerDataFile(player));
	}
	
	public static void ResetFiles() {
		
	}
	
}
