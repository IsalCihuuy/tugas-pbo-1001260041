package src.java;

class Pasien0041 {
    private String nama;
    private int umur;
    private double biayaKonsultasi;

    public Pasien0041(String nama, int umur, double biayaKonsultasi) {
        this.nama = nama;
        this.umur = umur;
        setBiayaKonsultasi(biayaKonsultasi);
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getUmur() { return umur; }
    public void setUmur(int umur) {
        if (umur < 0) throw new IllegalArgumentException("Umur tidak valid");
        this.umur = umur;
    }

    public double getBiayaKonsultasi() { return biayaKonsultasi; }
    public void setBiayaKonsultasi(double biaya) {
        if (biaya < 0) throw new IllegalArgumentException("Biaya tidak boleh negatif");
        this.biayaKonsultasi = biaya;
    }

    public double hitungTotalBiaya(boolean isMember) {
        return isMember ? biayaKonsultasi * 0.9 : biayaKonsultasi;
    }
}

class Klinik0041 {
    private String namaKlinik;

    public Klinik0041(String namaKlinik) {
        this.namaKlinik = namaKlinik;
    }

    public void cetakStruk(Pasien0041 pasien, boolean isMember) {
        System.out.println("Klinik: " + namaKlinik);
        System.out.println("Pasien: " + pasien.getNama() + " (" + pasien.getUmur() + " thn)");
        System.out.println("Total Biaya: Rp" + pasien.hitungTotalBiaya(isMember));
        System.out.println("------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Pasien0041 p1 = new Pasien0041("Budi", 25, 12000);
        Pasien0041 p2 = new Pasien0041("Siti", 30, 12000);

        Klinik0041 klinik = new Klinik0041("Klinik Sehat");
        klinik.cetakStruk(p1, false);
        klinik.cetakStruk(p2, true);
    }
}