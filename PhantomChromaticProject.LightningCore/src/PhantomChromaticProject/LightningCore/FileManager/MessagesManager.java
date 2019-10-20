package PhantomChromaticProject.LightningCore.FileManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessagesManager {

	private static YamlConfiguration MessagesConfigurator;
	private static File MessagesFile;
	
	public static void loadMessages() {MessagesFile = FileManager.getMessagesFile();MessagesConfigurator = YamlConfiguration.loadConfiguration(MessagesFile);}
	
	public static class Errors{
		
		public static String getNoConsoleError(boolean chattranslate, String CommandName) {
			
			if(chattranslate) {
				return ChatColor.translateAlternateColorCodes('&', MessagesConfigurator.getString("Errors.NoForConsole").replace("%==COMMAND==%", CommandName));
			}
			return MessagesConfigurator.getString("Errors.NoForConsole").replace("%==COMMAND==%", CommandName);
			
		}
		public static void setNoConsoleError(String message) {
			
			MessagesConfigurator.set("Errors.NoForConsole", message);
			try {
				MessagesConfigurator.save(MessagesFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		public static String getNoFeedPlayer(boolean chattranslate, String PlayerName) {
			if(chattranslate) {
				return ChatColor.translateAlternateColorCodes('&', MessagesConfigurator.getString("Errors.FeedPlayerOffline").replace("%==PLAYER==%", PlayerName));
			}
			return MessagesConfigurator.getString("Errors.FeedPlayerOffline").replace("%==PLAYER==%", PlayerName);
			
		}
		public static void setNoFeedPlayer(String message) {
			
			MessagesConfigurator.set("Errors.FeedPlayerOffline", message);
			try {
				MessagesConfigurator.save(MessagesFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static class Economy{
		
	}
	
	public static class Commands{
		
		public static String getFeedMessage(boolean chattranslate) {
			
			if(chattranslate) {
				return ChatColor.translateAlternateColorCodes('&', MessagesConfigurator.getString("Commands.Feed"));
			}
			return MessagesConfigurator.getString("Commands.Feed");
			
		}
		
		public static void setFeedMessage(String message) {
			
			MessagesConfigurator.set("Commands.Feed", message);
			try {
				MessagesConfigurator.save(MessagesFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String getFeededOtherMessage(boolean chattranslate, String PlayerName) {
			
			if(chattranslate) {
				return ChatColor.translateAlternateColorCodes('&', MessagesConfigurator.getString("Commands.FeedOther").replace("%==PLAYER==%", PlayerName));
			}
			return MessagesConfigurator.getString("Commands.FeedOther").replace("%==PLAYER==%", PlayerName);
		}
		public static void setFeededOtherMessage(String message) {
			
			MessagesConfigurator.set("Commands.FeedOther", message);
			try {
				MessagesConfigurator.save(MessagesFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static class Permissions{
		
		public static String getFeedPermissionsErrorMessage(boolean chattranslate) {

			if(chattranslate) {
				return ChatColor.translateAlternateColorCodes('&', MessagesConfigurator.getString("Permissions.Feed"));
			}
			return MessagesConfigurator.getString("Commands.Feed");
			
		}
		
		public static void setFeedPermissionsErrorMessage(String message) {
			
			MessagesConfigurator.set("Permissions.Feed", message);
			try {
				MessagesConfigurator.save(MessagesFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
