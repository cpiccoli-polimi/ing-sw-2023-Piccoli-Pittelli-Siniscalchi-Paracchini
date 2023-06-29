# 🇮🇹: Prova Finale Ingegneria del Software AA 2022/23 - Politecnico di Milano
## Panoramica

### Componenti del Gruppo
- [Lorenzo Paracchini](https://github.com/lorblock)
- [Christian Piccoli](https://github.com/cpiccoli-polimi)
- [Lorenzo Pittelli](https://github.com/LorenzoPittelli)
- [Nicola Siniscalchi](https://github.com/niloca)

### Scopo del Progetto
Realizzare in Java il gioco [My Shelfie by Cranio Creations](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwjX_6f46fH9AhVXO-wKHSV8BJUQFnoECBUQAQ&url=https%3A%2F%2Fwww.craniocreations.it%2Fprodotto%2Fmy-shelfie&usg=AOvVaw0Xiu7y75two3j9fD7_Pgnc) seguendo il pattern architetturale Model View Controller per la realizzazione del modello secondo il paradigma di programmazione orientato agli oggetti.

![immagine_gioco](https://cf.geekdo-images.com/sv0EgmPdxJeioJU3Pzcg3g__original/img/7pQTKAID9037N71FeOndX3y23HM=/0x0/filters:format(jpeg)/pic7005100.jpg)

### Diagrammi UML
- Consultabili [qui](https://github.com/cpiccoli-polimi/ing-sw-2023-Piccoli-Pittelli-Siniscalchi-Paracchini/tree/main/UML)

### Funzionalità Implementate
- [x] **Regole Complete**
- [x] **TUI/CLI**
- [x] **GUI**
- [x] **Socket**
- [x] **Partite multiple**: Il server può gestire più partite contemporaneamente.

### Come eseguire il gioco
È presente un file .jar chiamato MyShelfie.jar: posizionarsi nella stessa cartella del file con il terminale e poi eseguire il comando
```
java -jar MyShelfieApp.jar
```
Dopo aver avviato il jar è possibile:
- Premere 1 per avviare il Server
- Premere 2 per avviare il Client
  - Inserire l'IP del Server
  - Premere 1 per giocare attraverso la CLI (TUI)
  - Premere 2 per giocare attraverso la GUI
## Copertura dei Test
### Panoramica Copertura
<img width="779" alt="Screenshot 2023-06-29 alle 18 56 09" src="https://github.com/cpiccoli-polimi/ing-sw-2023-Piccoli-Pittelli-Siniscalchi-Paracchini/assets/125984660/70d1b7a8-fdfa-4064-a06e-df01a13c8c48">

### Copertura Model
<img width="779" alt="Screenshot 2023-06-29 alle 18 56 31" src="https://github.com/cpiccoli-polimi/ing-sw-2023-Piccoli-Pittelli-Siniscalchi-Paracchini/assets/125984660/8b7bf16d-2551-47e3-b790-5b6391d00672">

### Copertura Controller
<img width="779" alt="Screenshot 2023-06-29 alle 18 56 49" src="https://github.com/cpiccoli-polimi/ing-sw-2023-Piccoli-Pittelli-Siniscalchi-Paracchini/assets/125984660/8796a99b-bd44-4f53-a60b-b5e680a4135b">
