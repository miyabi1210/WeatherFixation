package kazuki.weather;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.level.ThunderChangeEvent;
import cn.nukkit.event.level.WeatherChangeEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Fixation extends PluginBase implements Listener{
	private Config setting;
	@SuppressWarnings("deprecation")
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getLogger().info("§a起動しました §bby kazuki102812");
		this.getDataFolder().mkdirs();
		this.setting = new Config(new File(this.getDataFolder(), "setting.yml"),Config.YAML,
				new LinkedHashMap<String, Object>() {
			{
				put("WeatherChange", "false");
				put("Thunder", "false");
			}
		}
		);
	}
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent event) {
		if(this.setting.getString("WeatherChange").equals("true")) {
			event.setCancelled();
		}
	}
	@EventHandler
	public void onThunderChange(ThunderChangeEvent event) {
		if(this.setting.getString("Thunder").equals("true")) {
			event.setCancelled();
		}
	}
}
