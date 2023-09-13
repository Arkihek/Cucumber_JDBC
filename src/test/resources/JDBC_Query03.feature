# Database üzerinden students
# tablosundaki firstname= Edward ve lastname= Thomas olan öğrencinin
# email bilgisinin edvard@gmail.com olduğunu doğrulayınız.
  @Q3
  Feature: Query 03
    Scenario: students tablosundaki firstname= Edward ve lastname= Thomas olan öğrencinin email bilgisinin edvard@gmail.com olduğunu doğrulayınız.

      * Database baglantisi kurulur.
      * Query firstname ve lastname`e gore hazirlanir
      * Query sonuclarinin email bilgisi "edvard@gmail.com" oldugu dogrulanir
      * Database baglantisi kapatilir.