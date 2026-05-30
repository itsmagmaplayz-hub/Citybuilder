# Citybuilder Mod

Citybuilder is a Fabric 1.20.4 Minecraft mod that brings new city-building blocks, street furniture, and world decoration to your game.

## Features

### City Blocks
- Asphalt roads, curved asphalt, and corner pieces
- Parking markings and yellow stripes for custom lots
- Cobblestone, brick, gravel, and dirt paths
- Stone, tiled, brick, and marble sidewalks
- Gray, white, red, black, yellow, and blue concrete variants

### Street Furniture and Decorations
- Functional **Street Lamp** with built-in light
- **Street Sign** and **Informational Sign** decorative blocks
- **Bench**, **Wooden Bench**, **Wooden Table**, and **Metal Chair** seating
- **Trash Bin**, **Bollard**, **Fire Hydrant**, **Bus Stop**, **Phone Booth**, **Planter**, and **Street Clock**

### Items
- **Construction Tape**, **Barrier Tape**, **Construction Sign**
- **Manhole Cover**, **Traffic Cone**, **Street Dust**, **Street Paint**

### Gameplay Enhancements
- Custom creative tabs: **CTB Blocks**, **CTB Furniture**, **CTB Items**
- Multi-language support: English, German, Russian
- Block and item textures load correctly in the world and inventory

## Installation

1. Install **Java 17+**
2. Install **Fabric Loader 1.20.4**
3. Install **Fabric API 1.20.4**
4. Place the compiled mod JAR into your `.minecraft/mods/` folder

## Building from Source

```bash
./gradlew.bat build
```

The generated JAR can be found in `build/libs/`.

## Texture Support

This mod includes texture assets for all registered block and item models.
To regenerate textures, run:

```bash
python generate_textures.py
```

## Notes

The mod adds custom item groups and should load its new textures in both inventory and world rendering.
