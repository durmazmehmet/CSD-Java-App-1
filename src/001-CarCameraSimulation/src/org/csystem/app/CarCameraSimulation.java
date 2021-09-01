package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.datetime.DateTime;

import java.util.ArrayList;
import java.util.HashMap;

public class CarCameraSimulation {
    private final HashMap<String, ArrayList<CarCameraInfo>> m_carInfo;
    private final ArrayList<CommandInfo> m_commands;
    private static String ms_menuStr;

    private interface ICommandProc {
        void proc();
    }

    private class CommandInfo {
        int option;
        ICommandProc cmdProc;

        public CommandInfo(int option)
        {
            this(option, null);
        }

        public CommandInfo(int option, ICommandProc cmdProc)
        {
            this.option = option;
            this.cmdProc = cmdProc;
        }

        public boolean equals(Object other)
        {
            return option == ((CommandInfo)other).option;
        }
    }

    {
        m_commands = new ArrayList<>();
        m_commands.add(new CommandInfo(1, this::insertProc));
        m_commands.add(new CommandInfo(2, this::listByPlateProc));
        m_commands.add(new CommandInfo(3, this::listAllProc));
        m_commands.add(new CommandInfo(4, this::listByPlaceProc));
        m_commands.add(new CommandInfo(5, this::exitProc));
    }

    static {
        ms_menuStr = "1.Ekle\n";
        ms_menuStr += "2.Plakaya göre listele\n";
        ms_menuStr += "3.Tamamını listele\n";
        ms_menuStr += "4.Yere göre listele\n";
        ms_menuStr += "5.Çıkış\n";
        ms_menuStr += "Seçenek:";
    }

    private void insertProc()
    {
        Console.writeLine("Araç ekleme menüsüne hoş geldiniz");
        Console.writeLine("Tekrar yapıyor musunuz?");

        String plate = Console.readLine("Plakayı giriniz");
        String place = Console.readLine("Lokasyonu giriniz");


        if (!m_carInfo.containsKey(plate))
            m_carInfo.put(plate, new ArrayList<>());

        m_carInfo.get(plate).add(new CarCameraInfo(plate, DateTime.randomLongDateTime(2017, 2019), place));
    }

    private void listByPlateProc()
    {
        String plate = Console.readLine("Plakayı giriniz");

        if (m_carInfo.containsKey(plate)) {
            Console.writeLine("Plaka:%s", plate);
            for (var cci : m_carInfo.get(plate))
                Console.writeLine("%s", cci);
        }
        else
            Console.writeLine("Girilen plakaya ilişkin kayıt bulunamadı");
    }

    private void listAllProc()
    {
        if (m_carInfo.isEmpty()) {
            Console.writeLine("Hiç veri yok");
            return;
        }

        for (var list : m_carInfo.values()) {
            for (var cci : list)
                Console.writeLine("%s", cci);

            Console.writeLine("*****************");
        }
    }

    private void listByPlaceProc()
    {
        Console.writeLine("Ellerinizden öper");
    }

    private void exitProc()
    {
        Console.writeLine("Tekrar yapıyor musunuz?");

        System.exit(0);
    }

    public CarCameraSimulation()
    {
        m_carInfo = new HashMap<>();
    }

    public void run()
    {
        for (;;) {
            int option = Console.readInt(ms_menuStr, "Rakam dışı seçenek\n");
            int index = m_commands.indexOf(new CommandInfo(option));

            if (index >= 0)
                m_commands.get(index).cmdProc.proc();
            else
                Console.writeLine("Geçersiz seçenek");
        }
    }
}
