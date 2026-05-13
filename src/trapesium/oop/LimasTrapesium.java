/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trapesium.oop;

/**
 *
 * @author ASUS
 */

public class LimasTrapesium extends Trapesium {

    private double tinggiLimas;

    public LimasTrapesium(Perhitungan pht) {
        super(pht);
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    public double hitungVolume() {

        if (tinggiLimas <= 0) {

            throw new TrapesiumNotValidException(
                    "Tinggi limas harus lebih besar dari 0."
            );
        }

        return (hitungLuas() * tinggiLimas) / 3.0;
    }

    public double hitungLuasPermukaan() {

        double luasSelimut =
                0.5 * hitungKeliling() * tinggiLimas;

        return hitungLuas() + luasSelimut;
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("=== LIMAS TRAPESIUM ===");

        System.out.println("Luas Alas = " + hitungLuas());

        System.out.println("Keliling Alas = " + hitungKeliling());

        System.out.println("Volume = " + hitungVolume());

        System.out.println("Luas Permukaan = " +
                hitungLuasPermukaan());
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            pht.setPerhitunganLimas(i + 1);
        }
    }
}
