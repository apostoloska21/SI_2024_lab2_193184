# SI_2024_lab2_193184

Martina Apostoloska 193184 
![CFG](https://github.com/apostoloska21/SI_2024_lab2_193184/assets/64848105/ccf13482-256a-4c48-a186-7eb69819b1d4)


Цикломатската Комплексност ја пресметав со формулата E-N+2P каде E е бројот на ребра а N е бројот на јазли, и го добив резултатот 10.

Тест случаи според критериумот EveryBranch
Имам вкупно 8 тест случаи:
1)Првиот тест е за RuntimeException.
2)Вториот тест е за name кога е null или празно 
3)Третиот тест е if условот кога се проверува баркодот дали е null
4)Четвртиот тест е кога се проверува дали сите услови се исполнети без discount
5)Петиот тест е кога се проверува дали discount се става со валиден баркод започнувајќи со 0
6)Шестиот тест е кога се проверува дали discount се става но да не започнува со 0
7) Седмиот тест е кога се проверува дали цената е над 300 но нема попуст
8) Осмиот тест е кога плаќањето е помало од тоталната сума

Тест случаи според критериумот Multiple Condition
if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0') { // 16
TXX - кога item.getPrice() е поголемо од 300
FTX - кога item.getPrice() не е  поголемо од 300, но item.getDiscount() е поголемо од 0, има попуст
FFT - кога item.getPrice() не е  поголемо од 300, но item.getDiscount() не е поголемо од 0, нема попуст но баркодот започнува со 0, item.getBarcode().charAt(0) започнува со '0'
FFF - кога item.getPrice() не е  поголемо од 300, но item.getDiscount() не е поголемо од 0, нема попуст,  баркодот не започнува со 0, item.getBarcode().charAt(0) не започнува со '0'
