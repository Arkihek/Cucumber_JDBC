# Database üzerinden class_sections tablosundaki datalar arasından
# class_id ve section_id verisi birbirine eşit olan içeriklerin id'lerini listeleyiniz

  Feature: Query 02
    @Q2
    Scenario: class_sections tablosundan class_id ve section_id verisi birbirine eşit olan içeriklerin id'lerini listeleyiniz

      * Database baglantisi kurulur.
      * class_sections tablosundaki test icin query hazirlanir ve calistirilir.
      * class_sections tablosundaki liste yazdirilir.
      * Database baglantisi kapatilir.