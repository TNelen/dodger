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

OPMERKINGEN
- Afhankelijk van de constructor die gebruikt wordt bij het maken van een enemy, zijn de parameters willekeurig of niet.
- De kleur kan als parameter doorgegeven worden bij het aanmaken van een player.
- Om muziek af te spelen, uncomment de code vanonder in Game. Verander het path naar de .wav file die je wilt afspelen.
- bij enemy bij 3e constructor type vedl toegevoeg zodat onderscheis is tussen enemies (zie EnemyLine spawn)

UITBREIDINGEN
- Achtergrondkleur veranderen
- special enemie (moelijke vijand) aankonidigen door uitroepteken met ne countdown
- als ge pakt, de andere speler begint te flikkeren
- hele kleine klokjes die damage doon tegen andere plater
- skins ipv gewone kleuren voor players & enemies
- in waves werken, na einde wave health bij krijgen?
- BOM : als je die aanraakt gaat hij af en verwijdert hij alle enemys in een bepaalde range
- Boss mode
- mijnenveld. Overal health boxes, die heel klein beetje health bij geven, en vermomde enemys (health boxes zonder kruis?), als je die raakt ga je half dood, en verwijnt de enemy?
- Speler van kleur veranderen
- HUD beetje doorzichtig maken als je onder deze gaat met een speler
 - speedups (idem healthboxes) geven tijdelijk voor #ticks een speedup
 - enemy die groter wordt (in het midden van veld ofzo) (of 2 aan elke kant)

