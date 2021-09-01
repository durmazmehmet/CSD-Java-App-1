package org.csystem.commandpromptapp;

import org.csystem.util.Console;
import org.csystem.util.StringSplitOptions;
import org.csystem.util.StringUtil;

import java.util.function.Consumer;

public class CommandPrompt {
    private final CommandInfo [] m_commandInfos = {
            new CommandInfo("length", CommandPrompt::lengthProc),
            new CommandInfo() {{cmdStr = "reverse"; consumer = CommandPrompt::reverseProc;}},
            new CommandInfo() {{cmdStr = "upper"; consumer = CommandPrompt::upperProc;}},
            new CommandInfo() {{cmdStr = "lower"; consumer = CommandPrompt::lowerProc;}},
            new CommandInfo() {{cmdStr = "change"; consumer = CommandPrompt.this::changeProc;}},
            new CommandInfo() {{cmdStr = "quit"; consumer = CommandPrompt::quitProc;}},
    }; // Dikkat anonim sınıf olduğundan hepsi için ayrı arakod üretilir. Uygulama amaçlı yapıldı

    private String m_prompt;

    private class CommandInfo {
        public String cmdStr;
        public Consumer<String[]> consumer;

        public CommandInfo() {}
        public CommandInfo(String cmdStr, Consumer<String[]> consumer)
        {
            this.cmdStr = cmdStr;
            this.consumer = consumer;
        }
    }

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

    private void changeProc(String []cmdInfo)
    {
        if (checkForArgumentsLessOrEqualAndGreaterOne(cmdInfo, 2, "cha(nge) bir tane argüman ile kullanılabilir"))
            m_prompt = cmdInfo[1];
    }

    private static void quitProc(String []cmdInfo)
    {
        if (cmdInfo.length == 1) {
            Console.writeLine("Copyleft C ve Sistem Programcıları Derneği");
            Console.writeLine("Tekrar yapıyor musunuz?");
            System.exit(0);
        }

        Console.writeLine("quit tek başına çalışsan bir komuttur");
    }

    private CommandInfo findCommand(String cmdStr)
    {
        for (var ci : m_commandInfos)
            if (ci.cmdStr.startsWith(cmdStr))
                return ci;

        return null;
    }

    private void parseCommands(String str)
    {
        if (str.isBlank()) //Since Java 11
            return;

        String [] cmdInfo = StringUtil.split(str, " \t", StringSplitOptions.REMOVE_EMPTY_ENTRIES);

        if (cmdInfo[0].length() < 3) {
            Console.writeLine("Komut en az üç karakter içermelidir");
            return;
        }

        CommandInfo ci = findCommand(cmdInfo[0]);

        if (ci != null)
            ci.consumer.accept(cmdInfo);
        else
            System.out.println("Geçersiz komut");
    }

    public CommandPrompt(String prompt)
    {
        m_prompt = prompt;
    }

    public void run()
    {
        for (;;) {
            Console.write("%s>", m_prompt);
            String str = Console.readLine();
            this.parseCommands(str);
        }
    }
}
