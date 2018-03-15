# dodger
SoftwareProject Wouter en Timo

Werkend:
- Player movement
- Window Border
- Gewone Enemy 
- Muziek
- Spawn
- Health box                      (ik heb lay out lichtjes aangepast, beetje groter #Timo ) 
- Collision (staat in Player)
- HUD, health
- Following enemy
- vertical enemy
- Blob Enemy
- Healthboxes op willekeurige momenten
- Game states <3
- Menu's

TO DO:
- GUI opfrissen
- Enemies worden allemaal met zelfde velocities gemaakt. Hoe komt het dat dat niet random is, en how to fix?
- Opties ingeklikt -> Back-> Nog eens opties indrukken werkt niet correct. Het effectieve klikvierkant van de knop past dan aan :/
- Genieten van het eindproduct

OPMERKINGEN
- Afhankelijk van de constructor die gebruikt wordt bij het maken van een enemy, zijn de parameters willekeurig of niet.
- De kleur kan als parameter doorgegeven worden bij het aanmaken van een player.
- Om muziek af te spelen, uncomment de code vanonder in Game. Verander het path naar de .wav file die je wilt afspelen.
- bij enemy bij 3e constructor type vedl toegevoeg zodat onderscheis is tussen enemies (zie EnemyLine spawn)

UITBREIDINGEN
- in waves werken, na einde wave health bij krijgen?
- BOM : als je die aanraakt gaat hij af en verwijdert hij alle enemys in een bepaalde range
- Boss mode
- mijnenveld. Overal health boxes, die heel klein beetje health bij geven, en vermomde enemys (health boxes zonder kruis?), als je die raakt ga je half dood, en verwijnt de enemy?
- Speler van kleur veranderen
- HUD beetje doorzichtig maken als je onder deze gaat met een speler (wil ik wel doen! xxx wouter)
 - speedups (idem healthboxes) geven tijdelijk voor #ticks een speedup
 - enemy die groter wordt (in het midden van veld ofzo) (of 2 aan elke kant)

