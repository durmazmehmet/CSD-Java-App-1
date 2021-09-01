package org.csystem.util;

import java.util.Scanner;

public class Console {
    private static Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }

    private Console() {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }

    public static int readInt(String msg, String errMsg)
    {
        int val = 0;
        boolean flag = true;

        do {
            try {
                System.out.print(msg);
                val = Integer.parseInt(ms_kb.nextLine());
                flag = false;
            } catch (Throwable ex) {
                System.out.print(errMsg);
            }
        } while (flag);

        return val;
    }

    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(msg + "\n", errMsg + "\n");
    }
    public static int readIntLine(String msg)
    {
        return readInt(msg + "\n");
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }

    public static double readDouble(String msg, String errMsg)
    {
        double val = 0;
        boolean flag = true;

        do {
            try {
                System.out.print(msg);
                val = Double.parseDouble(ms_kb.nextLine());
                flag = false;
            } catch (Throwable ex) {
                System.out.print(errMsg);
            }
        } while (flag);

        return val;
    }

    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(msg + "\n", errMsg + "\n");
    }
    public static double readDoubleLine(String msg)
    {
        return readDouble(msg + "\n");
    }


    public static String readLine()
    {
        return readLine("");
    }

    public static String read(String msg)
    {
        Console.write(msg);
        return ms_kb.nextLine();
    }

    public static String readLine(String msg)
    {
        return read(msg + "\n");
    }

    public static void writeLine()
    {
        write("\n");
    }

    public static void write(String fmt, Object...objs)
    {
        System.out.printf(fmt, objs);
    }

    public static void writeLine(String fmt, Object...objs)
    {
        write(fmt + "\n", objs);
    }
}
