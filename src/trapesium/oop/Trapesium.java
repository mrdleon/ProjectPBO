/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trapesium.oop;

/**
 *
 * @author ASUS
 */

public class Trapesium extends BangunDatar
        implements LuasAlas, KelilingAlas, Runnable {

    protected Perhitungan pht;

    private double sisiAtas;
    private double sisiBawah;
    private double sisiMiringKiri;
    private double sisiMiringKanan;
    private double tinggi;

    public Trapesium(Perhitungan pht) {
        this.pht = pht;
    }

    // OVERLOADING CONSTRUCTOR
    public Trapesium(Perhitungan pht,
            double sisiAtas,
            double sisiBawah,
            double sisiMiringKiri,
            double sisiMiringKanan,
            double tinggi) {

        this.pht = pht;

        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.sisiMiringKiri = sisiMiringKiri;
        this.sisiMiringKanan = sisiMiringKanan;
        this.tinggi = tinggi;
    }

    public double getSisiAtas() {
        return sisiAtas;
    }

    public void setSisiAtas(double sisiAtas) {
        this.sisiAtas = sisiAtas;
    }

    public double getSisiBawah() {
        return sisiBawah;
    }

    public void setSisiBawah(double sisiBawah) {
        this.sisiBawah = sisiBawah;
    }

    public double getSisiMiringKiri() {
        return sisiMiringKiri;
    }

    public void setSisiMiringKiri(double sisiMiringKiri) {
        this.sisiMiringKiri = sisiMiringKiri;
    }

    public double getSisiMiringKanan() {
        return sisiMiringKanan;
    }

    public void setSisiMiringKanan(double sisiMiringKanan) {
        this.sisiMiringKanan = sisiMiringKanan;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    protected void validasiTrapesium() {

        if (sisiAtas <= 0 ||
                sisiBawah <= 0 ||
                sisiMiringKiri <= 0 ||
                sisiMiringKanan <= 0 ||
                tinggi <= 0) {

            throw new TrapesiumNotValidException(
                    "Semua nilai trapesium harus lebih besar dari 0."
            );
        }
    }

    @Override
    public double hitungLuas() {

        validasiTrapesium();

        return 0.5 * (sisiAtas + sisiBawah) * tinggi;
    }

    @Override
    public double hitungKeliling() {

        validasiTrapesium();

        return sisiAtas + sisiBawah +
                sisiMiringKiri + sisiMiringKanan;
    }

    @Override
    public String jenisTrapesium() {

        if (sisiMiringKiri == sisiMiringKanan) {
            return "Trapesium Sama Kaki";
        }

        return "Trapesium Sembarang";
    }

    // OVERLOADING METHOD
    public void tampilkanInfo() {

        System.out.println("Jenis = " + jenisTrapesium());
    }

    // OVERLOADING METHOD
    public void tampilkanInfo(String judul) {

        System.out.println(judul);

        tampilkanInfo();
    }

    // OVERRIDING
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            pht.setPerhitunganTrapesium(i + 1);
        }
    }
}
