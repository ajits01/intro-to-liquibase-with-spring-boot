# Intro to Liquibase with Spring Boot

This repo explores Liquibase with basic bare-bones Spring Boot Application.

***
# Getting Started

### **Step 1:**
Create a lightweight H2 database to play with Liquibase
```
> java -cp liquibase_jar\h2-1.4.200.jar org.h2.tools.Shell
```
```
    Welcome to H2 Shell 1.4.200 (2019-10-14)
    Exit with Ctrl+C
    [Enter]   jdbc:h2:~/test
    URL       jdbc:h2:./db/appDB
    [Enter]   org.h2.Driver
    Driver    org.h2.Driver
    [Enter]
    User      sa
    Password
    Type the same password again to confirm database creation.
    Password
    Connected
    Commands are case insensitive; SQL statements end with ';'
    help or ?      Display this help
    list           Toggle result list / stack trace mode
    maxwidth       Set maximum column width (default is 100)
    autocommit     Enable or disable autocommit
    history        Show the last 20 statements
    quit or exit   Close the connection and exit

    sql> exit
    Connection closed
```
### **Step 2:**
**Start H2 Server:**
```
> java -jar liquibase_jar\h2-1.4.200.jar -baseDir .\db

    Web Console server running at http://192.168.56.1:8082?key=b15debbf1292029cc7ba5d700b730d30e0cb3f8f26db1d4ae5a822ee1a5e11dc (only local c
    onnections)
    TCP server running at tcp://192.168.56.1:9092 (only local connections)
    PG server running at pg://192.168.56.1:5435 (only local connections)
```
**Connect DB with H2 Web Console:**<br>

Setting | Generic H2 (Embedded)
--------|--------------------------
Driver Class|	org.h2.Driver
JDBC URL| jdbc:h2:./appDB
User Name| sa
Password| 

### **Step 3:**
Run the application through command-line:<br>
```mvn clean package```<br>
```java -jar target\intro-to-liquibase-with-spring-boot-0.0.1.jar```<br>
or through Eclipse or STS or VSCode

***
**Generate Migration SQL:**<br>
Change directory to ```src/main/resources/```<br>
then run: <br>
```liquibase --changeLogFile=liquibase\master.xml --url=offline:mssql --outputFile=migrateSQL.sql updateSQL```
<br>(liquibase must be added to env PATH)
<br>
<br>Generated files:<br>
```databasechangelog.csv, migrateSQL.sql```
<br>

***

Useful Links:
- [liquibase download link](https://download.liquibase.org/download/?frm=n)
- [liquibase v3.8.7](https://github.com/liquibase/liquibase/releases/download/v3.8.7/liquibase-3.8.7.zip)
- [Installing Liquibase Command Line for Windows](https://www.liquibase.org/documentation/installation-windows.html)
- [How Liquibase Works](https://www.liquibase.org/get_started/how-lb-works.html)
- [Liquibase Documentation](https://www.liquibase.org/documentation/index.html)