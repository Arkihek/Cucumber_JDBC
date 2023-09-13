# Database üzerinden transport_route tablosuna yeni bir kayıt eklenebilmeli.

Feature: Query 07

  @Q07
  Scenario: transport_route tablosuna yeni bir kayıt eklenebilmeli
    * Database baglantisi kurulur.
    * Kayit ekleme query`si hazirlanir ve calistirilir.
    * Yeni kayit eklendigi dogrulanir.
    * Database baglantisi kapatilir.
