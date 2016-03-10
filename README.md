# JVM Benchmark: refleksje

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
- pomiarów: 100
- wywołań metod / odczyt pól na jeden pomiar: 10 milionów
- wynik: uśredniony czas w milisekundach

| Test                                                     | Średni wynik w milisekundach |
|----------------------------------------------------------|------------------------------|
| odczyt i zapis pola publicznego - bezpośredno            | 0                            |
| odczyt i zapis pola publicznego - refleksja              | 75                           |
| wywołanie metody publicznej z argumentami - bezpośrednio | 0                            |
| wywołanie metody publicznej z argumentami - refleksja    | 206                          |
