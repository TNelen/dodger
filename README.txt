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

TO DO:
- Game states (menu, help, game, end) !!!!
- onderscheid powerups en enmeies (powerups rond maken) 

OPMERKINGEN
- Afhankelijk van de constructor die gebruikt wordt bij het maken van een enemy, zijn de parameters willekeurig of niet.
- De kleur kan als parameter doorgegeven worden bij het aanmaken van een player.
- Om muziek af te spelen, uncomment de code vanonder in Game. Verander het path naar de .wav file die je wilt afspelen.
- bij enemy bij 3e constructor type veld toegevoegd zodat onderscheid is tussen enemies (zie EnemyLine spawn)

UITBREIDINGEN
- Achtergrondkleur veranderen
- rode gloed rond speler als hij geraakt wordt?
- schield (tijdenlijk geen collision krijgen voor # ticks, eventueel ook een cirkel rond speler)
- in waves werken, na einde wave health bij krijgen?
- BOM : als je die aanraakt gaat hij af en verwijdert hij alle enemys in een bepaalde range
- Boss mode
- mijnenveld. Overal health boxes, die heel klein beetje health bij geven, en vermomde enemys (health boxes zonder kruis?), als je die raakt ga je half dood, en verwijnt de enemy?
- Speler van kleur veranderen
- HUD beetje doorzichtig maken als je onder deze gaat met een speler
 - speedups (idem healthboxes) geven tijdelijk voor #ticks een speedup
 - enemy die groter wordt (in het midden van veld ofzo) (of 2 aan elke kant)

