package Bridge.Assignment.Runner;

import Bridge.Assignment.OS.OS;
import Bridge.Assignment.Works.Works;

import java.util.Arrays;

public class Runner {
    public void Start(){

        OS windows = new OS.WindowsOS(Arrays.asList(
                new Works.Terminal(), new Works.FileExplorer(), new Works.SecurityCenter()));

        OS linux = new OS.LinuxOS(Arrays.asList(
                new Works.Terminal(), new Works.Settings()));

        OS mac = new OS.MacOS(Arrays.asList(
                new Works.FileExplorer(), new Works.Settings(), new Works.SecurityCenter()));

        System.out.println("---- Windows ----");
        windows.coding();

        System.out.println("---- Linux ----");
        linux.coding();

        System.out.println("---- MacOS ----");
        mac.coding();
    }
}
