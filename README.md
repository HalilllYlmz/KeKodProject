# KeKod Proje Yarışması İlk Hafta Projesi

Bu proje, **Jetpack Navigation** kullanılarak 6 adet `Switch` ve dinamik bir `BottomNavigationBar` oluşturmayı amaçlayan bir uygulamadır.

## Proje Açıklaması

Bu uygulama, kullanıcının bir dizi `Switch` ile etkileşime geçerek `BottomNavigationBar`'ı dinamik olarak güncellemesine olanak tanır. Proje kapsamında şunlar gerçekleştirilmiştir:

1. **Switch Kontrolleri:**
   - Uygulama açıldığında 6 `Switch` kullanıcıyı karşılar.
   - "Ego" `Switch`'i varsayılan olarak açık gelir ve açıkken diğer `Switch`'ler kullanılamaz.
   - "Ego" `Switch`'i kapalı olduğunda diğer `Switch`'ler aktif hale gelir ve açılabilir.

2. **BottomNavigationBar:**
   - `Ego` `Switch`'i kapalıyken `BottomNavigationBar` görünür olur.
   - Her bir `Switch` açıldığında, `BottomNavigationBar`'a bir ikon ve metin eklenir.
   - `BottomNavigationBar`'ın sıralaması `Switch`'lerin açılma sırasına göre dinamik olarak belirlenir.
   - Toplamda 4 adet `Switch` butonu eklenebilir, en son açılan `Switch` butonu eklenmez.
   - `Switch`'ler kapatıldığında, `BottomNavigationBar`'daki ilgili item'lar kaldırılır.
   - `BottomNavigationBar`'a eklenen her bir item'a tıklandığında, ilgili detay ekranına yönlendirme yapılır.

3. **ViewBinding ve DataBinding:**
   - Tüm ekranlarda `ViewBinding` kullanılarak veri bağlama işlemleri gerçekleştirilmiştir.

## Proje Yapısı

- **Activity:** Tüm fragment'ların yönetildiği tek bir `Activity` kullanılmıştır.
- **Fragment'lar:**
  - EgoFragment: Tüm switchlerin kontrol edildiği ana ekran.
  - GivingFragment
  - RespectFragment
  - KindnessFragment
  - HappinessFragment
  - OptimismFragment

## Kurulum

Bu projeyi kendi makinenizde çalıştırmak için aşağıdaki adımları izleyin:

1. **Proje Deposu:** Bu projeyi GitHub'dan klonlayın veya indirebilirsiniz:
    ```bash
    git clone https://github.com/HalilllYlmz/KeKodProject
    ```
2. **Android Studio:** Projeyi Android Studio ile açın.
3. **Build:** Projeyi build edin ve çalıştırın.

## Kullanım

1. **Uygulama Açılışı:** Uygulama açıldığında, "Ego" switch'inin açık olduğunu göreceksiniz.
2. **Switch'lerle Etkileşim:** "Ego" switch'ini kapattıktan sonra diğer switch'leri açarak `BottomNavigationBar`'ı güncelleyebilirsiniz.
3. **Navigation:** `BottomNavigationBar`'a eklenen item'lara tıklayarak ilgili detay ekranlarına ulaşabilirsiniz.

## Demo Video

[![Demo Video](https://img.youtube.com/vi/wd-VVGRSD_E/0.jpg)](https://www.youtube.com/shorts/wd-VVGRSD_E)
