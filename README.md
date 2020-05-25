# Döviz Kur Bilgileri Veri Asistanı
## Amaç 
Merkez bankasından alınan döviz kur verilerini merkez bankası APİleri yardımıyla düzenli, güncel olarak kullanıcıya göstermeyi ve kullanıcının istediği tarih aralıklarındaki geçmiş döviz kurları verilerini düzenli biçimde sunulmasını amaçlar.

## Kullanıcı Dökümanı 

### Gereksinimler 
 •	İnternet Bağlantısı
 
 Bilgilendirme : Hafta sonları ve resmi tatil günlerinde merkez bankası çalışmaması nedeniyle verileri güncellememektedir. Dolayısıyla o tarihlerdeki veriler gösterilmemektedir.
 
 ### Kullanım
 Programımızın ana ekranında o gün ki güncel döviz kurları verileri listelenmektedir.
 
 <br>
<img src="https://i.ibb.co/pbMypTm/1.png" width="400"/>
<br>

Herhangi bir döviz kuruna çift tıklayarak o kurun geçmiş tarihlerdeki alış satış bilgilerine erişebiliriz.

Tarih aralığı olarak başlangıçta geçmiş 10 günden günümüze kadar olan döviz kurlarını günlük olarak çekerek listelenmektedir.

 <br>
<img src="https://i.ibb.co/Zzmthdh/2.png" width="400"/>
<br>

Kullanıcı eğer isterse başlangıç veya bitiş tarihlerini seçerek belirtilen aralıklarındaki döviz kuru verilerini listeye bilir.


 <br>
<img src="https://i.ibb.co/qNKh7Vt/3.png" width="400"/>
<br>

Program verileri internet aracılığıyla kullanıcıya sağlamaktadır dolayısıyla internet bağlantısı kopyası durumunda veya çalıştırılmaya çalışıldığı sırata internet mevcut değilse internet bağlantısı olmadığı konusunda kullanıcıya internet bağlantısı sağlanıp programa tekrar girilmesi gerektiği bilgilendirilip programdan çıkacaktır.

 <br>
<img src="https://i.ibb.co/3yCjNnP/4.png" width="300"/>
<br>

## Geliştirici Dökümanı 

Program altyapı olarak merkez bankası apilerini kullanmaktadır. Apilerin kullanımını kolaylaştırmak için apilere uygun bir bağlantı ve kullanım modülü yazdık.

### Örnek Api kullanımı 
Aşağıdaki gibi bir kullanımda verilen başlangıç ve bitiş tarihleri arasındaki Dolar Satış kurlarını döndürecektir. (key kısmı girilmeden çalışmayacaktır.)
“https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.S.YTL&startDate=01-01-2005&endDate=01-02-2017&type=json&key=XXXXXXXX”
Apimizin series kısmına istenilen para biriminin kodu yer almaktadır.  <br>
"TP.DK.USD.A" kodunda "USD" Dolar PARA BİRİMİNİ "A" ise ALIŞ ı temsil eder. <br>
"TP.DK.EUR.S" kodunda "EUR" Euro PARA BİRİMİNİ "S" ise SATIŞ ı temsil eder. <br>

#### Diğer Kodlar

"TP.DK.USD.A"   "TP.DK.USD.S"   ABD DOLARI <br>
“TP.DK.AUD.A"   "TP.DK.AUD.S"   AVUSTRALYA DOLARI <br>
"TP.DK.DKK.A"   "TP.DK.DKK.S"   DANİMARKA KRONU <br>
 "TP.DK.EUR.A"   "TP.DK.EUR.S"   EURO <br>
 "TP.DK.GBP.A"   "TP.DK.GBP.S"   İNGİLİZ STERLİNİ <br>
 "TP.DK.CHF.A"   "TP.DK.CHF.S"   İSVİÇRE FRANGI <br>
 "TP.DK.SEK.A"   "TP.DK.SEK.S"   İSVEÇ KRONU <br>
 "TP.DK.CAD.A"   "TP.DK.CAD.S"   KANADA DOLARI <br>
 "TP.DK.KWD.A"   "TP.DK.KWD.S"   KUVEYT DİNARI <br>
 "TP.DK.NOK.A"   "TP.DK.NOK.S"   NORVEÇ KRONU <br>
 "TP.DK.SAR.A"   "TP.DK.SAR.S"   SUUDİ ARABİSTAN RİYALİ <br>
 "TP.DK.JPY.A"   "TP.DK.JPY.S"   JAPON YENİ <br>
 "TP.DK.BGN.A"   "TP.DK.BGN.S"   BULGAR LEVASI <br>
 "TP.DK.RON.A"   "TP.DK.RON.S"   RUMEN LEYİ <br>
 "TP.DK.RUB.A"   "TP.DK.RUB.S"   RUS RUBLESİ <br>
 "TP.DK.IRR.A"   "TP.DK.IRR.S"   İRAN RİYALİ <br>
 "TP.DK.CNY.A"   "TP.DK.CNY.S"   ÇİN YUANI <br>
 "TP.DK.PKR.A"   "TP.DK.PKR.S"   PAKİSTAN RUPİSİ <br>
 "TP.DK.QAR.A"   "TP.DK.QAR.S"   KATAR RİYALİ <br>


Tarih belirlemeleri “dd-MM-yyyy” tipinde kullanılmalıdır. <br>
startDate  başlangıç tarihi <br>
endDate son tarihdir <br>

Type geriye döndürülecek dosya tipini belirler (xml,json) <br>
Key api keyimizi giriyoruz. (//https://evds2.tcmb.gov.tr/   a üye olup profil kısmından api anahtarı diyerek api anahtarınızı alabilirsiniz.)

Api kullanımı hakkında daha fazla detay için aşağıdaki linkten merkez bankası dokümanını inceleyebilirsiniz.
https://evds2.tcmb.gov.tr/help/videos/EVDS_Web_Servis_Kullanim_Kilavuzu.pdf


## Ekstra Kütüphaneler
•	 Gson <br>
	Gson kütüp hanesi json dosyasını Map ve Modellere dönüştürmek için kullanılmıştır.
•	JCalendar <br>
	JCalendar kütüphanesi tarih seçim işlemleri için kullanılmıştır.

Pom.xml dosyasına eklenenler : <br>
<dependencies> 
        <dependency> 
             <groupId>com.google.code.gson</groupId> <br>
             <artifactId>gson</artifactId> <br>
             <version>2.8.6</version> <br>
        </dependency>
        <dependency> 
            <groupId>com.toedter</groupId> <br>
            <artifactId>jcalendar</artifactId> <br>
            <version>1.4</version> <br>
        </dependency> <br>
   </dependencies> <br>

 <br>
Projede api işleme işlemleri  com.ibrahim.dovizAPI  package’i altında yapılmıştır. 
Uygulama ve ara yüz kısmı com.ibrahim.dovizAPP package’i altında yapılmıştır.
Test Packages altında bir Test.java adında java klasöründe yazılan modülle ilgili örnek kullanımlar , açıklamalar bulunmaktadır.
<br>
Diğer kullanım detayları ve açıklamalar açıklama bloklarıyla projeye eklenmiştir.
