# Hearthstone — card game engine in Java

Bachelor's project (German University in Cairo): a playable re-implementation of the Hearthstone card game in plain Java.

- `model/` — cards (minions and spells), heroes, rarity; each hero class with its own hero power.
- `engine/` — `Game`, turn handling, an `ActionValidator` and a `GameListener` interface for the view.
- `exceptions/` — typed rule violations (`NotEnoughManaException`, `TauntBypassException`, `FullFieldException`, …) instead of return codes.
- `controller/` and `Game/view/` — Swing GUI following an MVC layout.

Open `HS-M2` in Eclipse or IntelliJ and run `Game/view/MainMenu`.

---

## Deutsch

# Hearthstone — Kartenspiel-Engine in Java

Bachelor-Projekt (German University in Cairo): eine spielbare Nachbildung des Kartenspiels Hearthstone in reinem Java.

- `model/` — Karten (Diener und Zauber), Helden, Seltenheit; jede Heldenklasse mit eigener Heldenfähigkeit.
- `engine/` — `Game`, Zugablauf, ein `ActionValidator` und ein `GameListener`-Interface für die Ansicht.
- `exceptions/` — typisierte Regelverstöße statt Rückgabecodes.
- `controller/` und `Game/view/` — Swing-Oberfläche nach MVC.

`HS-M2` in Eclipse oder IntelliJ öffnen und `Game/view/MainMenu` starten.
