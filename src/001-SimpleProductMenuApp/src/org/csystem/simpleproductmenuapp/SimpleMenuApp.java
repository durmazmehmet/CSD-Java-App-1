package org.csystem.simpleproductmenuapp;

import org.csystem.simpleproductmenuapp.dal.ProductAppDAL;
import org.csystem.simpleproductmenuapp.entity.Product;
import org.csystem.util.Console;

import static org.csystem.util.CommandLineUtil.*;

import java.math.BigDecimal;

public class SimpleMenuApp {
    private static ProductAppDAL ms_productAppDAL;

    private static void displayMenu()
    {
        Console.writeLine("1.Ekle");
        Console.writeLine("2.En pahalı ürün");
        Console.writeLine("3.En ucuz ürün");
        Console.writeLine("4.Tümünü sat");
        Console.writeLine("5.Çıkış");
        Console.writeLine("Seçenek:");
    }
    private static void saveProc()
    {
        var code = Console.read("Kodu giriniz:");
        var name = Console.read("İsmi giriniz:");
        var stock = Console.readInt("Stok miktarını giriniz");
        var cost = BigDecimal.valueOf(Console.readDouble("Alış fiyatını giriniz:"));
        var price = BigDecimal.valueOf(Console.readDouble("Satış fiyatını giriniz:"));
        var p = new Product(0, code, name, stock, cost, price);

        if (ms_productAppDAL.saveProduct(p))
            Console.writeLine("%s", p.toString());
        else
            Console.writeLine("Ekleme başarısız");
    }

    private static void findExpensiveProc()
    {
        var max = ms_productAppDAL.findExpensiveProduct();

        if (max != null)
            Console.writeLine("En pahalı ürün:%s", max.toString());
        else
            Console.writeLine("Stokta hiç ürün yok");
    }

    private static void findCheapProc()
    {
        var min = ms_productAppDAL.findCheapProduct();

        if (min != null)
            Console.writeLine("En ucuz ürün:%s", min.toString());
        else
            Console.writeLine("Stokta hiç ürün yok");
    }

    private static void selAllProc()
    {
        Console.writeLine("Durum:%s", ms_productAppDAL.findSellAll());
    }

    private static int getMaxStock(String [] args)
    {
        args = getCommandLineArgs(args, "Maximum stok değerini giriniz:");
        controlForLengthEqual(args, 1, "Sadece maximum stok miktarını girmelisiniz!!");

        return Integer.parseUnsignedInt(args[0]);
    }

    public static void run(String[] args)
    {
        var n = getMaxStock(args);

        ms_productAppDAL = new ProductAppDAL(n);

        EXIT_MENU:
        for (;;) {
            displayMenu();
            int option = Console.readInt();

            switch (option) {
                case 1:
                    saveProc();
                    break;
                case 2:
                    findExpensiveProc();
                    break;
                case 3:
                    findCheapProc();
                    break;
                case 4:
                    selAllProc();
                    break;
                case 5:
                    break EXIT_MENU;
            }
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
