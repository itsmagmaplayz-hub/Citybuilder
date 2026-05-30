# Citybuilder

Citybuilder is a Minecraft Fabric 1.20.4 mod that adds urban road, path, parking, and furniture blocks with custom creative tabs and multilingual support.

## Features

- 20+ city building blocks including roads, sidewalks, parking lines, and concrete surfaces
- Functional furniture-style blocks such as benches, chairs, tables, street lamps, and phone booths
- Custom creative item groups: `CTB Blocks`, `CTB Furniture`, and `CTB Items`
- Built-in translations for English, German, and Russian
- Asset support for block and item models with textures generated or included in `src/main/resources/assets/citybuilder`

## Installation

1. Install **Java 17+**
2. Install **Fabric Loader 1.20.4**
3. Install **Fabric API 1.20.4**
4. Place the compiled `citybuilder` JAR into your `.minecraft/mods/` folder
5. Launch Minecraft with the Fabric profile

## Build from Source

```bash
./gradlew.bat build
```

The compiled JAR will be available in `build/libs/`.

## Custom Textures

If you want to replace or regenerate textures, use the included script:

```bash
python generate_textures.py
```

Texture assets are stored in:

- `src/main/resources/assets/citybuilder/textures/block/`
- `src/main/resources/assets/citybuilder/textures/item/`

## Notes

The mod now includes texture assets for all registered blocks and items, so models should load correctly in both the world and the inventory.
