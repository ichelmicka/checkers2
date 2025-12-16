# Checkers – Gra sieciowa z logiką planszy i serwerem TCP

Projekt implementuje uproszczoną wersję gry planszowej chineese checkers z obsługą dwóch graczy, logiką ruchów, zbijaniem kamieni oraz komunikacją sieciową opartą o gniazda TCP. Pozwala na zbijanie otoczonych przez przeciwnika kamieni.
Aplikacja składa się z trzech głównych części:

- **logika gry** (`Game`, `Board`, `Move`, `Player`)
- **serwer** (`Server`, `ClientHandler`)
- **testy jednostkowe** (JUnit 5 + Mockito)

### 1. Budowanie aplikacji

W katalogu głównym projektu:

```bash
mvn clean package 
```
Po zbudowaniu powstaje plik: target/checkers-1.0-SNAPSHOT.jar

### 2. Uruchamianie serwera
```bash
java -cp target/checkers-1.0-SNAPSHOT.jar com.example.server.Server
```

### 3. Połączenie klienta
```bash
nc localhost 8888
```
JOIN <nazwa>
Następnie można wykonywać ruchy:
MOVE 3 3
MOVE 4 4

### 4. Testy
Projekt korzysta z JUnit 5 i Mockito
Uruchamianie testów:
```bash
mvn test 
```

