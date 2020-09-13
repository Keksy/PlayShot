package de.devjava.playshot.addon.utils.logger;

import de.devjava.playshot.addon.LabyAddon;

public class Logger {

    public void info(Object message) {
        System.out.println("[" + LabyAddon.getInstance().getLabyName() + "] " + message);
    }

    public void error(Object message) { info(message); }
    public void fatal(Object message) { info(message); }

}