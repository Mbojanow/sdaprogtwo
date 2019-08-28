package pl.sdacademy.prog.comm;

/*

Stwórz program, który będzie prostym komunikatorem typu Slack.
Jako, że nie znamy jeszcze protokołu HTTP i nie potrafimy budować interfejsów graficznych za pomocą CSS/HTML/JS, output z kanałów będzie wypisywany do pliku.

Zacznijmy od budowy modelu. Komunikator będzie składał się z kanałów (channel), użytkowników (User) którzy będzie mogli wysyłać wiadomość(message) na konkretny kanał.

Stwórz klasy odpowiadające, użytkownikowi, kanałowi i wiadomości

Kanał powinien mieć: nazwę, temat, listę użytkowników na kanale, listę wiadomości i informację czy kanał jest prywatny.

Wiadomość powinna mieć: i  wartość, datę utworzenia i informację kto ją napisał (nazwa
użytkownika)

Użytkownik powinien mieć: pola email, nazwę użytkownika, znać listę kanałów i informację o wszystkich dostępnych kanałach

Stwórz klasę ze stałymi do tego programu. zahardkowuj sciężkę do ogólnodostęp
nego katalogu na swoim systemie.

Stwórz klasę komunikator, który zachowuje listę kanałów.

Dodaj następujące funkcjonalności:
Do klasy Message dodaj możliwośc pobrania jej jako string (data i nick w 1 linijce, wiadomość w drugiej

Do klasy komunikator dodaj następujące funkcjonalności:
- pobierz kanały publiczne
- dodaj kanał do komunikatora (nazwa musi być unikatowa, próba wstawienia kanału o tej samej nazwie powinna zostać zignotowana)

Do klasy channel dodaj możliwość wysłania wiadomości. Metoda wysyłająca wiadomość powinna przyjmować instację użytkownika i treść (string) wiadomości. Oprócz dodawania wiadomości do kanału powinna poinformować innych użytkowników na kanale o nowej wiadomości.
Dodaj również metodę pozwalającą dodać użytkownika do kanału. Zignoruj dodanie użytkownika o tym samym nicku. Pamiętaj że do kanału wiadomości nie może dodać użytkownik który nie jest obecny na kanale
Dodaj możliwość pobrania wszystkich wiadomości (jako lista stringow)

Do klasy User dodaj:
- metodę, która pozwala dołączyć do kanału (weż nazwę kanału na input), niech metoda ta zwraca Optional<Channel>. Metoda ta powinna stworzyć użytkownikowi plik w katalogu o nazwie nazwaKanalu_uzytkownik.txt i zapisać tam całą dostępną historię kanału (jako stringi)
- metodę możliwość wysyłania wiadomości (message jako string i nazwa kanału jako string na input). jeżeli użytkownik jest na danym kanale -> wiadomość jest wysłana do kanału. Jeżeli użytkownik nie jest na kanale -> dołącz do kanału i dopiero wtedy wyślij wiadomość. Zignoruj fakt wysyłania wiadomości do nieistniejącego kanału
- metodę reagującą na wysłaną wiadomość. Metoda ta powinna dokładać nową wiadomość do pliku z listą wiadomości dla użytkownika danego kanału

 */

public interface CommunicatorAppConsts {
  String BASE_DIR = "/tmp";
}
