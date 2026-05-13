/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trapesium.oop;

/**
 *
 * @author ASUS
 */

public class PrismaTrapesium extends Trapesium {

    private double tinggiPrisma;

    public PrismaTrapesium(Perhitungan pht) {
        super(pht);
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    public double hitungVolume() {

        if (tinggiPrisma <= 0) {

            throw new TrapesiumNotValidException(
                    "Tinggi prisma harus lebih besar dari 0."
            );
        }

        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {

        return (2 * hitungLuas()) +
                (hitungKeliling() * tinggiPrisma);
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("=== PRISMA TRAPESIUM ===");

        System.out.println("Luas Alas = " + hitungLuas());

        System.out.println("Keliling Alas = " + hitungKeliling());

        System.out.println("Volume = " + hitungVolume());

        System.out.println("Luas Permukaan = " +
                hitungLuasPermukaan());
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            pht.setPerhitunganPrisma(i + 1);
        }
    }
}
