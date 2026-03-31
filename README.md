# Selenium Framework - Lab 9 Starter

Framework mẫu theo kiểu POM để bạn dùng tiếp cho Lab 11.

## Chạy local

Smoke test:

```bash
mvn clean test -Dbrowser=chrome -Denv=dev -DsuiteXmlFile=src/test/resources/testng-smoke.xml
```

Regression test:

```bash
mvn clean test -Dbrowser=chrome -Denv=dev -DsuiteXmlFile=src/test/resources/testng-regression.xml
```

## Cấu trúc chính
- BasePage, BaseTest, DriverFactory
- ConfigReader
- LoginPage, InventoryPage, CartPage
- LoginTest, CartTest
- testng-smoke.xml, testng-regression.xml

## Ghi chú
- Dùng được làm nền cho Lab 11 (GitHub Actions, Grid, Allure, Secrets)
- Nếu Chrome local không chạy được, thử cập nhật Chrome và chạy lại
