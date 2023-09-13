#Database üzerinden students tablosundaki lastname bilgisi
# 'T' ile başlayan öğrencinin mother_name ve mother:occupation
# degerlerini listeleyiniz

  Feature: Query 05
@Q5
    Scenario: students tablosundaki lastname bilgisi 'T' ile başlayan öğrencinin mother_name ve mother:occupation degerlerini listeleyiniz

      * Database baglantisi kurulur.
      * Student tablosu icin query hazirlanir
      * student tablosundan donen sonuclari listeleyiniz
      * Database baglantisi kapatilir.