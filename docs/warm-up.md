## Rozcvička
[Home](../)

Úlohou prvého cvičenia bolo pripraviť si (vlastné) knižnice na prácu s bitmapovou a vektorovou grafikou.

Ja som sa rozhodol, že cvičenia bude vypracovávať v [Kotline](kotlinlang.org), pretože je to moderný jazyk a považujem ho za sľubnú alternatívu k "príliš objektovej a ukecanej" Jave.

Keďže som nenašiel žiadnu knižnicu, ktorá by vedela pracovať s vektorovou grafikou a bola by jednoduchá, rozhodol som sa napísať si vlastnú ([trieda `SVG`](../javadoc/iv122/com.github.mseleng.iv122.util/-s-v-g)).

Pre prácu s bitmapovou grafikou (zatial len operácie čítania) som si rozšíril funkcionalitu Javovskej triedy `BufferedImage` ([rozširujúce funkcie](../javadoc/iv122/com.github.mseleng.iv122.util/java.awt.image.-buffered-image)).

Pre prácu s grafmi som sa rozhodol využiť externú knižnicu `jfreechart` (a jej závislosť `jcommon`), ktorú som taktiež rozšíril o pomocné funkcie ([trieda `Chart`](../javadoc/iv122/com.github.mseleng.iv122.util/-chart)).

Príklady v tomto cvičení boli zamerané na vyskúšanie a demonštráciu funkcií týchto "knižníc"

* Na demonštráciu práce s bitmapovou grafikou bolo za úlohu vytvoriť farebný gradient. Na počítanie farieb bola použitá bilineárna interpolácia a tu je výsledok: 
    ![Gradient](/iv122_outputs/assignment1/gradient.png)
* B
* C
* D