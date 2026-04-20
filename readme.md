# Giriş

Aşağıdaki ayarları yap

>$docker-compose up

>schema-based-multi-tenancy.postman_collection.json

### Senaryo
3 adet merchant var; Apple, Amazon, Adidas.

>Her merchant'ın kendi admin'i var(*merchant_user*)

- mdeveci -> adidas
- adogan -> amazon
- mnasifoğlu -> apple

>Her merchant'ın kendi member'ları var(*merchant_member*);

### Uygulama

login işlemi iki adımda gerçekleşir;

> POST: /api/v1/public/login/initialize

- 1. adım; merchant'a ait clientId&clientSecret 
ve merchantUsername bilgileri ile yukarıdaki
endpoint'e istek atılır. 
Gelen istek *public* şeması altındaki *merchant* tablosunda
clientId&clientSecret bilgileri ile kontrol edilir ve 
*merchantUsername* için otp token oluşturulur.

> POST: /api/v1/public/login/complete

- 2.adım; merchantPassword bilgisi ilk adımda alınan 
*completeToken* bilgisi ile birlikte yukarıdaki
adrese istek atılır. Response olarak bir JWT dönülür,
içerisinde tenant bilgisi ve yetkiler tanımlanmış olur.

> GET: /api/v1/private/merchant/members
- 3.adım; Alınan jwt ile yukarıdaki adrese gidilerek, ilgili merchant'a ait *merchant_member* tablosundan member'lar getirilir. 


# Avantajlar
- Tek bir proje yapısı ile işin içine clientId bilgisi
katmadan tüm proje yönetilebilir.
- Her tenant ayrı schema → veri karışma riski çok düşük
- Büyük tenant küçük tenantı etkilemez (index, vacuum, vs.)
- Esnek onboarding. Yeni tenant = yeni schema
- Tüm business logic tek codebase
- Bug fix hızlı
- İstenirse tenant bazlı backup / restore
- Çoğu durumda strategy pattern'e gerek kalmaz. Örneğin komisyon
oranı için mutlitenant olmayan bir proje için strategy yazılabilecekken,
bu yaklaşımda şema içerisindeki bir x_a_settings tablosundan okunabilir.

# Dezavantajlar
- DB seviyesindeki işlemlerin takibi ve yönetimi zor.
- Tüm şemaları etkileyecek bir script çalıştırılacağında bir 
fail sistem inconsistent bozacağından script'ler transactional çalıştırılmalı
- Şemalarda uyumsuzluk çıkarsa 💥 runtime exception 
- DB tasarımı çok önemli, şemalar arası cross-join'e ihtiyaç duyulmayacak
bir mimari kurulmalı. Bir merchant şeması içerisinden default şemaya ihtiyaç duyulmamalı.
- Mimari açıdan yapıya hakim olmayı gerektiriyor. Örneğin
public şema içerisinde ortak iş akışı için kullanılacak common-tablolar 
aşağıdaki gibi işaretlenmelidir. Böyce sorgular tenant schema’dan etkilenmez.

> @Entity \
 @Table(name = "common_settings", schema = "public")\
public class CommonSettings { \
}
