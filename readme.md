# Eventor
A Minecraft mod for Forge (1.8.9) that sends requests to a URL.

## Building
1. Clone the repo
2. Make sure you have JDK 8 installed!
3. Setup the decomp workspace: `./gradlew setupDecompWorkspace`
4. Build the JAR `./gradlew build` or if you want to test with a client `./gradlew runClient`


## Currently Implmented Events:
- Hypixel Bedwars Bedbreak - When another team breaks your bed.

## Planned Events:
- Hypixel Bedwars Player Dies
- Hypixel Bedwars Player Breaks Bed
- Hypixel Bedwars Player Kills?
- Hypixel Bedwars Player Wins (probably next)



## Why
The reason I made this mod was to control my leds in my room when my bed breaks. I thought it was a unqiue.
Though if it is bannable on Hypixel. Please let me know, that's all I ask or should I ask? Idc at this point. :)

## No information on request?
To make this a far mod when the even triggers no data is sent within the request (because that "could" be bannable?)
The reason its a web request in the first place is because my LEDs API I made only works with a http request. 