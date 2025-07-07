package com.mycompany.mavenproject4;


public class Student {

    private String nama;
     String id;
    private String jurusan;
    private String tujuan;
     private String jamKunjungan;

    public Student(String Nama, int id2, String Jurusan, String Tujuan, String JamKunjungan ) {
        this.nama = nama;
        this.id = id;
        this.jurusan = jurusan;
        this.tujuan = tujuan;
        this.jamKunjungan = jamKunjungan;
    }

    public Student(long l, String name, String id2, String jurusan2, String tujuan2, Object jamKunjungan2) {
        //TODO Auto-generated constructor stub
    }

    public String getName() {
        return nama;
    }

    public String getId() {
        return id;
    }

    public String getJurusan() {
        return jurusan;
    }

 public String getTujuan() {
        return tujuan;
    }
 public String getJamKunjungan() {
        return jamKunjungan;
    }

    public void setName(String name) {
        this.nama = name;
    }

    public void setId(int id2) {
        this.id = id;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

  public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

     public void setJamKunjungan(String tujuan) {
        this.jamKunjungan = jamKunjungan;
    }

    public void setAddress(String address) {
        throw new UnsupportedOperationException("Unimplemented method 'setAddress'");
    }
}