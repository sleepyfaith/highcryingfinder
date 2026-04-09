# highcryingfinder

a kotlin program that finds coordinates generating ruined portals with high crying obsidian counts, for use with structure-finding tools like [cubiomes](https://github.com/Cubitect/cubiomes).

## usage

download the `.jar` from [releases](https://github.com/sleepyfaith/highcryingfinder/releases), then run: `java -jar highcryingfinder.jar`

### options

| option | type | default | description |
|---|---|---|---|
| `portalType` | string | `portal_1` | [portal type](https://minecraft.wiki/w/Ruined_Portal#Structure) |
| `searchRadius` | int | `10000` | chunk radius |
| `yMin` | int | `15` | minimum y level |
| `yMax` | int | `85` | maximum y level |
| `threads` | int | `4` | thread count |
| `minCrying` | int | `10` | minimum crying obsidian |

## build

```bash
git clone https://github.com/sleepyfaith/highcryingfinder.git
cd highcryingfinder
./gradlew build
```
