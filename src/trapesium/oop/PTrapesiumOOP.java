/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trapesium.oop;

/**
 *
 * @author ASUS
 */

public class PTrapesiumOOP {

    public static void main(String[] args) {

        Perhitungan pht = new Perhitungan();

        Trapesium trapesium =
                new Trapesium(pht);

        LimasTrapesium limas =
                new LimasTrapesium(pht);

        PrismaTrapesium prisma =
                new PrismaTrapesium(pht);

        pht.setTrapesium(trapesium);

        pht.setLimas(limas);

        pht.setPrisma(prisma);

        // POLYMORPHISM
        Trapesium obj1 = limas;

        Trapesium obj2 = prisma;

        Thread thread1 =
                new Thread(trapesium, "Trapesium");

        Thread thread2 =
                new Thread(obj1, "Limas");

        Thread thread3 =
                new Thread(obj2, "Prisma");

        thread1.start();

        thread2.start();

        thread3.start();
    }
}
