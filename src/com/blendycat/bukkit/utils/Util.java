package com.blendycat.bukkit.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by EvanMerz on 11/8/17.
 */
public class Util extends JavaPlugin implements Listener {

    private static FileConfiguration config;
    private static Util instance;
    private static boolean info = false;

    @Override
    public void onEnable(){
        config = getConfig();
        saveConfig();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    private static void setUpConfig() {
        config.addDefault("db_host", "localhost");
        config.addDefault("db_name", "name");
        config.addDefault("db_user", "username");
        config.addDefault("db_password", "password");
        config.options().copyDefaults(true);
        instance.saveConfig();
    }

    /**
     *
     * @return database host as string or shutdown plugin if not set up
     */
    static String getDatabaseHost(){
        String host = null;
        if(config.contains("db_host")) {
            host = config.getString("db_host");
        }else{
            setUpConfig();
            Bukkit.getPluginManager().disablePlugin(instance);
        }
        return host;
    }

    /**
     *
     * @return database name
     */
    static String getDatabaseName(){
        String name = null;
        if(config.contains("db_name")) {
            name = config.getString("db_name");
        }else{
            setUpConfig();
            Bukkit.getPluginManager().disablePlugin(instance);
        }
        return name;
    }

    /**
     *
     * @return database user
     */
    static String getDatabaseUser(){
        String user = null;
        if(config.contains("db_user")) {
            user = config.getString("db_user");
        }else{
            setUpConfig();
            Bukkit.getPluginManager().disablePlugin(instance);
        }
        return user;
    }

    /**
     *
     * @return database password
     */
    static String getDatabasePassword(){
        String password = null;
        if(config.contains("db_password")) {
            password = config.getString("db_password");
        }else{
            setUpConfig();
            Bukkit.getPluginManager().disablePlugin(instance);
        }
        return password;
    }

    public static boolean isInfo(){
        return info;
    }

    public static void setInfo(boolean info){
        Util.info = info;
    }
}
