
# ATMan

 Vue.js 2, Spring Boot 2, ve MySQL ile yapılmış gelişmiş görev yöneticisi

## Local development setup

### Gereksinimler

- JDK8 - OpenJDK  Preferred
- MySQL 5.7+
- RabbitMQ 3.6+


### Database setup

-  `atman` ismi ile mysql üzerinde veri tabanı oluşturun
-  `setup` klasörünün içerisindeki komutları sırasıyla çalıştırın

### RabbitMQ setup on docker

- Init code 


### Add dev properties file

- ApplicationProperties içerisinde gerekli düzenlemeleri kendi ayarlarınıza göre yapın.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/atman?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=<username>
spring.datasource.password=<password>
```

## Commands
- `docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management` rabbitmq ile realtime server kullanımı için
- `mvn spring-boot:run` back-end kısmını başlatmak için
- `front-end` klasörü içerisinde `npm run serve` kullanarak arayüzü başlatın
