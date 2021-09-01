package org.csystem.commandpromptapp;

import org.csystem.util.CommandLineUtil;

class App {
    public static void main(String[] args)
    {
        args = CommandLineUtil.getCommandLineArgs(args, "Komut yazısını giriniz:");
        var myCommantPrompt = new StringOperationsCommandPrompt(args[0], "$");

        myCommantPrompt.run();
    }
}
