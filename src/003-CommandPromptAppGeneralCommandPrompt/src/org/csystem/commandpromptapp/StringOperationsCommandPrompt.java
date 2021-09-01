package org.csystem.commandpromptapp;

import org.csystem.util.Console;
import org.csystem.util.commandprompt.CommandPrompt;

public class StringOperationsCommandPrompt {
    private CommandPrompt m_commandPrompt;

    private static boolean checkForArgumentsLessOrEqualAndGreaterOne(String [] cmdInfo, int val, String msg)
    {
        if (cmdInfo.length > val || cmdInfo.length == 1) {
            Console.writeLine(msg);
            return false;
        }

        return true;
    }
    private static void lengthProc(String []cmdInfo)
    {
        if (checkForArgumentsLessOrEqualAndGreaterOne(cmdInfo, 2, "len(gth) bir tane argüman ile kullanılabilir"))
            Console.writeLine(cmdInfo[1].length());
    }

    private static void upperProc(String []cmdInfo)
    {
        if (checkForArgumentsLessOrEqualAndGreaterOne(cmdInfo, 2, "upp(er) bir tane argüman ile kullanılabilir"))
            Console.writeLine(cmdInfo[1].toUpperCase());
    }

    private static void lowerProc(String []cmdInfo)
    {
        if (checkForArgumentsLessOrEqualAndGreaterOne(cmdInfo, 2, "low(er) bir tane argüman ile kullanılabilir"))
            Console.writeLine(cmdInfo[1].toLowerCase());
    }

    private static void reverseProc(String []cmdInfo)
    {
        if (checkForArgumentsLessOrEqualAndGreaterOne(cmdInfo, 2, "rev(erse) bir tane argüman ile kullanılabilir"))
            Console.writeLine(new StringBuilder(cmdInfo[1]).reverse());
    }

    private void changePromptProc(String []cmdInfo)
    {
        if (checkForArgumentsLessOrEqualAndGreaterOne(cmdInfo, 2, "cha(nge) bir tane argüman ile kullanılabilir"))
            m_commandPrompt.setPrompt(cmdInfo[1]);
    }

    private static void exitProc(String []cmdInfo)
    {
        if (cmdInfo.length == 1) {
            Console.writeLine("Copyleft C ve Sistem Programcıları Derneği");
            Console.writeLine("Tekrar yapıyor musunuz?");
            System.exit(0);
        }

        Console.writeLine("exit tek başına çalışan bir komuttur");
    }

    public StringOperationsCommandPrompt(String prompt, String prefix)
    {
        m_commandPrompt = new CommandPrompt(prompt, prefix, "Geçersiz Komut girildi");
    }

    public void run()
    {
        m_commandPrompt
                .add("len", StringOperationsCommandPrompt::lengthProc)
                .add("upr", StringOperationsCommandPrompt::upperProc)
                .add("lwr", StringOperationsCommandPrompt::lowerProc)
                .add("rev", StringOperationsCommandPrompt::reverseProc)
                .add("chprm", this::changePromptProc)
                .add("exit", StringOperationsCommandPrompt::exitProc)
                .run();
    }
}
