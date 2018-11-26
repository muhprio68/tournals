package com.tournals.tournals;

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

public class Rencana {
    private String rencana;
    private String perjalanan;
    private String tanggalMulai;
    private String tanggalSelesai;

    public Rencana(String rencana, String perjalanan, String tanggalMulai, String tanggalSelesai){
        this.rencana=rencana;
        this.perjalanan=perjalanan;
        this.tanggalMulai=tanggalMulai;
        this.tanggalSelesai=tanggalSelesai;
    }
    public void setRencana(String rencana) {
        this.rencana = rencana;
    }

    public void setPerjalanan(String perjalanan) {
        this.perjalanan = perjalanan;
    }

    public void setTanggalMulai(String tanggal) {
        this.tanggalMulai = tanggalMulai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getRencana() {
        return rencana;
    }

    public String getPerjalanan() {
        return perjalanan;
    }

    public String getTanggalMulai() {
        return tanggalMulai;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }
}
