# JVM Benchmark: refleksje

Uruchomienie:
```sh
mvn exec:java
```

Zasoby systemu:
```sh
System: Linux Mint 17.3
Pamięć: 4096 MB, DDR3 1600 MHz
Procesor: 2x 2.6 GHz
```

Wersja javy:
```sh
java version "1.7.0_85"
OpenJDK Runtime Environment (IcedTea 2.6.1) (7u85-2.6.1-5ubuntu0.14.04.1)
OpenJDK 64-Bit Server VM (build 24.85-b03, mixed mode)
```

Parametry testów:
- 100 pomiarów i 1000 instrukcji na pomiar podczas rozgrzewki
- 100 pomiarów i 10 milionów instrukcji na pomiar podczas testu
- wynik: uśredniony czas wykonania 10 milionów instrukcji w milisekundach

| Test                                                     | Wynik |
|----------------------------------------------------------|-------|
| odczyt i zapis pola publicznego - bezpośrednio           | 0.39  |
| odczyt i zapis pola publicznego - refleksja              | 80.51 |
| wywołanie metody publicznej z argumentami - bezpośrednio | 0.26  |
| wywołanie metody publicznej z argumentami - refleksja    | 205.6 |
