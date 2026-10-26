#include <iostream>
#include <string>
#include <stdexcept>

class Pasien0041 {
private:
    std::string nama;
    int umur;
    double biayaKonsultasi;

public:
    Pasien0041(std::string n, int u, double b) : nama(n) {
        setUmur(u);
        setBiayaKonsultasi(b);
    }

    std::string getNama() const { return nama; }
    void setNama(std::string n) { nama = n; }

    int getUmur() const { return umur; }
    void setUmur(int u) {
        if (u < 0) throw std::invalid_argument("Umur tidak valid");
        umur = u;
    }

    double getBiayaKonsultasi() const { return biayaKonsultasi; }
    void setBiayaKonsultasi(double b) {
        if (b < 0) throw std::invalid_argument("Biaya tidak boleh negatif");
        biayaKonsultasi = b;
    }

    double hitungTotalBiaya(bool isMember) const {
        return isMember ? biayaKonsultasi * 0.9 : biayaKonsultasi;
    }
};

class Klinik0041 {
private:
    std::string namaKlinik;

public:
    Klinik0041(std::string nama) : namaKlinik(nama) {}

    void cetakStruk(const Pasien0041& pasien, bool isMember) const {
        std::cout << "Klinik: " << namaKlinik << "\n"
                  << "Pasien: " << pasien.getNama() << " (" << pasien.getUmur() << " thn)\n"
                  << "Total Biaya: Rp" << pasien.hitungTotalBiaya(isMember) << "\n"
                  << "------------------------------\n";
    }
};

int main() {
    Pasien0041 p1("Budi", 25, 12000);
    Pasien0041 p2("Siti", 30, 12000);

    Klinik0041 klinik("Klinik Sehat");
    klinik.cetakStruk(p1, false);
    klinik.cetakStruk(p2, true);

    return 0;
}