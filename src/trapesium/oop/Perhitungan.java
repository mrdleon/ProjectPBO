/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trapesium.oop;

/**
 *
 * @author ASUS
 */

import java.util.Random;

public class Perhitungan {

    private Trapesium trapesium;
    private LimasTrapesium limas;
    private PrismaTrapesium prisma;

    private final Random rand = new Random();

    private enum Giliran {

        TRAPESIUM,
        LIMAS,
        PRISMA
    }

    private Giliran giliran = Giliran.TRAPESIUM;

    public void setTrapesium(Trapesium trapesium) {
        this.trapesium = trapesium;
    }

    public void setLimas(LimasTrapesium limas) {
        this.limas = limas;
    }

    public void setPrisma(PrismaTrapesium prisma) {
        this.prisma = prisma;
    }

    public synchronized void setPerhitunganTrapesium(int index) {

        while (giliran != Giliran.TRAPESIUM) {

            try {

                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "\n===== TRAPESIUM " + index + " ====="
        );

        double atas = generateRandom();
        double bawah = generateRandom();
        double kiri = generateRandom();
        double kanan = generateRandom();
        double tinggi = generateRandom();

        trapesium.setSisiAtas(atas);
        trapesium.setSisiBawah(bawah);
        trapesium.setSisiMiringKiri(kiri);
        trapesium.setSisiMiringKanan(kanan);
        trapesium.setTinggi(tinggi);

        limas.setSisiAtas(atas);
        limas.setSisiBawah(bawah);
        limas.setSisiMiringKiri(kiri);
        limas.setSisiMiringKanan(kanan);
        limas.setTinggi(tinggi);

        prisma.setSisiAtas(atas);
        prisma.setSisiBawah(bawah);
        prisma.setSisiMiringKiri(kiri);
        prisma.setSisiMiringKanan(kanan);
        prisma.setTinggi(tinggi);

        try {

            System.out.println("a (Sisi Atas)          = " + atas);

            System.out.println("b (Sisi Bawah)         = " + bawah);

            System.out.println("c (Sisi Miring Kiri)   = " + kiri);

            System.out.println("d (Sisi Miring Kanan)  = " + kanan);

            System.out.println("t (Tinggi Trapesium)   = " + tinggi);

            System.out.println(
                    "Jenis Trapesium        = "
                            + trapesium.jenisTrapesium()
            );

            System.out.println(
                    "Luas Trapesium         = "
                            + trapesium.hitungLuas()
            );

            System.out.println(
                    "Keliling Trapesium     = "
                            + trapesium.hitungKeliling()
            );

        } catch (TrapesiumNotValidException e) {

            System.out.println(e.getMessage());
        }

        giliran = Giliran.LIMAS;

        notifyAll();
    }

    public synchronized void setPerhitunganLimas(int index) {

        while (giliran != Giliran.LIMAS) {

            try {

                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "\n===== LIMAS " + index + " ====="
        );

        limas.setTinggiLimas(generateRandom());

        try {

            System.out.println(
                    "Volume = " +
                            limas.hitungVolume()
            );

            System.out.println(
                    "Luas Permukaan = " +
                            limas.hitungLuasPermukaan()
            );

        } catch (TrapesiumNotValidException e) {

            System.out.println(e.getMessage());
        }

        giliran = Giliran.PRISMA;

        notifyAll();
    }

    public synchronized void setPerhitunganPrisma(int index) {

        while (giliran != Giliran.PRISMA) {

            try {

                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "\n===== PRISMA " + index + " ====="
        );

        prisma.setTinggiPrisma(generateRandom());

        try {

            System.out.println(
                    "Volume = " +
                            prisma.hitungVolume()
            );

            System.out.println(
                    "Luas Permukaan = " +
                            prisma.hitungLuasPermukaan()
            );

        } catch (TrapesiumNotValidException e) {

            System.out.println(e.getMessage());
        }

        giliran = Giliran.TRAPESIUM;

        notifyAll();
    }

    private int generateRandom() {

        return rand.nextInt(100) + 1;
    }
}
