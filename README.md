# E-Ticaret Ürün Arama ve Sepet Doğrulama Otomasyonu

Bu proje, testcase.myideasoft.com e-ticaret platformunda aşağıdaki işlemleri otomatikleştirmek için geliştirilmiştir:

- "ürün" anahtar kelimesi ile bir ürün arama.  
- Listelenen ürünlerden birinin detay sayfasına gitme.  
- İlgili üründen 5 adet sepete ekleme.  
- "SEPETİNİZE EKLENMİŞTİR" mesajının göründüğünü doğrulama.  
- Sepet sayfasına (/sepet) giderek sepet içerisinde 5 adet ürün olduğunu kontrol etme.

## Proje Özeti
Bu otomasyon, Page Object Model (POM) yaklaşımını kullanmaktadır. Bu yaklaşım, farklı web sayfalarıyla etkileşim için gereken mantığı test senaryolarından ayırarak testlerin bakımını kolaylaştırır ve genişletilebilir hale getirir.

## Kullanılan Teknolojiler:
- Java JDK 21: Projenin geliştirilmesi ve çalıştırılması için kullanılan Java - Geliştirme Kiti.  
- Maven (V4.0.0): Bağımlılıkların ve proje yaşam döngüsünün yönetilmesi için kullanılan - bir otomasyon aracı.  
- Google Chrome Tarayıcı V(130.0.6723.44): Testlerin gerçekleştirildiği web tarayıcısı.
- ChromeDriver (V129.0.6668.100): Google Chrome üzerinde otomatik test yapılmasına olanak sağlayan bir WebDriver uygulaması.  
- JUnit (V5.11.2): Test senaryolarının yazılması, çalıştırılması ve raporlanması için kullanılan bir test framework’ü.  
- Selenium (V4.25.0): E-ticaret platformuyla etkileşime geçmek için kullanılan tarayıcı  otomasyon aracı.  
- Cucumber (V7.20.0): Testlerin anlaşılabilir bir dilde yazılmasına olanak sağlayan   Davranış Odaklı Gelişim (BDD) aracıdır.

## Kurulum
1. Git ile Depoyu Klonlama  
```bash
git clone https://github.com/seliinerkan/IdeaSoftCase.git 
```  
  

2. Proje Dizini İçine Geçin  
```bash
cd IdeaSoftCase/ShoppingTestAutomationProject 
```
 
3. Gereksinimleri Yükleme  
Projede kullanılan bağımlılıkları (Selenium, JUnit, Cucumber vb.) yüklemek için Maven kullanılır. Maven, bu bağımlılıkları otomatik olarak yönetecektir.  
Proje dizinindeyken aşağıdaki komutu çalıştırarak tüm bağımlılıkları yükleyin:   
```bash
mvn clean install
``` 

4. ChromeDriver Yükleme  
ChromeDriver (V129.0.6668.100) ya da pom.xml dosyası içindeki webdrivermanager bağımlılığını kullanabilirsiniz. 

##  Testleri Çalıştırma    
Testleri çalıştırmak için src/test/java/runners/Runner.java dosya dizinindeki Runner dosyasını çalıştırabilirsiniz.

- Test Sonuçlarını Görüntüleme  
Test sonuçları, target/cucumber-reports.html dosya dizininde oluşturulacaktır. Test sonuçlarını ve raporları görmek için bu klasörü inceleyebilirsiniz.   


## Proje Yapısı  
Bu proje, Cucumber ile yazılmış test senaryolarını çalıştırmak ve raporlamak için yapılandırılmıştır.
- src/test/resources/features/Cucumber.feature  
Bu dosya, Cucumber ile yazılmış test senaryolarını barındırır.    

- src/test/java/runners/Runner.java  
JUnit ile Cucumber senaryolarını çalıştıran sınıf. Testlerin başlatılması, senaryoların çalıştırılması ve sonuçların raporlanması bu sınıf ile yönetilir.  
   
- src/test/java/steps/ShoppingSteps.java  
Cucumber test senaryolarında tanımlanan adımların Java ile uygulanmasıdır. Her bir Gherkin adımına karşılık gelen fonksiyonlar burada yer alır.

- target/cucumber-reports.html  
Testler çalıştırıldıktan sonra oluşturulan Cucumber raporları HTML formatında burada saklanır.




