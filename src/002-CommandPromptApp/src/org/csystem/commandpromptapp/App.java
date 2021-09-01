package org.csystem.commandpromptapp;

import org.csystem.util.CommandLineUtil;

class App {
    public static void main(String[] args)
    {
        args = CommandLineUtil.getCommandLineArgs(args, "Komut yazısını giriniz:");
        CommandPrompt cmd = new CommandPrompt(args[0]);

        cmd.run();
    }
}
