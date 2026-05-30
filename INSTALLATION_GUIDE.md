# Citybuilder Mod - Installation and Usage Guide

## Overview

Citybuilder adds city-style building content to Minecraft via Fabric 1.20.4. It provides new road and sidewalk blocks, parking markings, functional street furniture, and decorative city items.

## Installation

### Install the Mod
1. Install **Java 17+**
2. Install **Fabric Loader 1.20.4**
3. Install **Fabric API 1.20.4**
4. Copy the built mod JAR into your Minecraft mods folder:

```text
.minecraft/mods/
```

5. Launch Minecraft using the Fabric profile.

### Build from Source

From the project root:

```bash
.\gradlew.bat build
```

The built JAR will appear in `build/libs/`.

## In-Game Content

### City Blocks
- Asphalt road pieces, curves, and corners
- Parking spots, lines, and yellow stripe blocks
- Cobble, brick, gravel, and dirt paths
- Stone, tiled, brick, and marble sidewalks
- Multiple concrete colors: gray, white, red, black, yellow, blue

### Street Furniture & Decorations
- Street Lamp, Street Sign, Bench, Trash Bin
- Wooden Bench, Wooden Table, Metal Chair
- Bus Stop, Phone Booth, Street Clock, Fire Hydrant, Bollard, Planter, Informational Sign

### Items
- Construction Tape, Barrier Tape, Construction Sign
- Manhole Cover, Traffic Cone, Street Dust, Street Paint

## Creative Tabs
The mod registers custom item groups:
- `CTB Blocks`
- `CTB Furniture`
- `CTB Items`

## Textures and Models
Texture assets now exist for all registered block and item models. If you want to regenerate or refresh textures, run:

```bash
python generate_textures.py
```

Texture folders:
- `src/main/resources/assets/citybuilder/textures/block/`
- `src/main/resources/assets/citybuilder/textures/item/`

## Languages
- English
- German
- Russian

## Troubleshooting

### Invisible or Broken Textures
- Verify texture files exist under `src/main/resources/assets/citybuilder/textures/`
- Run `python generate_textures.py` to regenerate missing textures
- Ensure the mod JAR is in `.minecraft/mods/`
- Make sure Fabric API 1.20.4 is installed

### Build Problems
- Confirm Java 17+ is installed and on your PATH
- Delete `build/` and rebuild if needed
- Use:

```bash
.\gradlew.bat build --refresh-dependencies
```

## Notes
- Block and item models are already configured to use matching texture assets.
- The mod includes custom creative tabs and translation files for English, German, and Russian.

```
citybuilder-1.20.4/
├── src/
│   └── main/
│       ├── java/net/imp/ctb/
│       │   ├── Citybuilder.java (Main mod class)
│       │   ├── CitybuilderDataGenerator.java
│       │   ├── block/ModBlocks.java (Block registry)
│       │   ├── item/ModItems.java (Item registry)
│       │   └── mixin/
│       └── resources/
│           ├── assets/citybuilder/
│           │   ├── models/block/ (Block models)
│           │   ├── models/item/ (Item models)
│           │   ├── textures/block/ (Block textures)
│           │   ├── textures/item/ (Item textures)
│           │   └── lang/en_us.json (English translations)
│           ├── fabric.mod.json (Mod metadata)
│           └── citybuilder.mixins.json
├── gradle/ (Gradle build tools)
├── build.gradle (Build configuration)
├── gradle.properties
└── README.md
```

## 🎨 Customizing Textures

### Realistic Textures Included

The mod now includes **realistic Minecraft-style textures** instead of simple placeholders! Each texture is procedurally generated with:

- **Asphalt Road**: Dark asphalt with subtle texture variations and darker spots
- **Asphalt Road Line**: Asphalt with painted white center lines and wear effects
- **Asphalt Curve**: Asphalt with curved white road markings
- **Cobble Path**: Irregular cobblestone blocks with mortar lines
- **Brick Path**: Red brick pattern with alternating rows and mortar
- **Gravel Path**: Random pebble textures with high noise variation
- **Concrete Blocks**: Smooth concrete with subtle surface variations
- **Parking Blocks**: Asphalt with white parking space markings
- **Sidewalk Blocks**: Stone-like textures with natural variations
- **Street Furniture**: Detailed metal poles, wooden signs, benches, and trash bins

### Texture Generation Script

The `generate_textures.py` script creates all textures automatically using Python PIL:

```bash
python generate_textures.py
```

**Features:**
- Procedural texture generation
- Realistic noise and variation
- Minecraft-style 16x16 pixel format
- Automatic block and item texture creation

### Manual Texture Customization

To create custom textures:

1. **Create PNG files** (16x16 pixels recommended)
2. **Place in texture folders:**
   - Block textures: `src/main/resources/assets/citybuilder/textures/block/`
   - Item textures: `src/main/resources/assets/citybuilder/textures/item/`

3. **Rebuild the mod:**
   ```bash
   .\gradlew.bat build
   ```

### Texture Tools

**Recommended Tools for Custom Textures:**
- **Aseprite** ($20) - Professional pixel art editor
- **GIMP** (Free) - Advanced image editor
- **Blockbench** (Free) - Minecraft model and texture editor
- **Piskel** (Free, web-based) - Simple pixel art tool

### Texture Color Reference

| Block Type | Base Color | Details |
|------------|------------|---------|
| Asphalt | RGB(35, 35, 35) | Dark gray with variations |
| Concrete | RGB(120-200, 120-200, 120-200) | Smooth with subtle noise |
| Brick | RGB(170, 80, 60) | Red with mortar lines |
| Cobble | RGB(140, 130, 120) | Irregular blocks |
| Gravel | RGB(130, 130, 130) | High noise variation |
| Wood | RGB(120-140, 80-100, 40-60) | Wooden furniture |
| Metal | RGB(50-80, 50-80, 50-80) | Street lamps, trash bins |

## 🔧 Troubleshooting

### Blocks Don't Appear
- Make sure Fabric API for 1.20.4 is installed
- Check that the mod JAR is in `.minecraft/mods/`
- Verify Java 17+ is installed

### Wrong Colors/Textures
- The mod uses realistic procedurally-generated textures by default
- Run `python generate_textures.py` to regenerate textures if needed
- Or create custom PNG files in the textures folder

### Building Issues
- Ensure Java 17 is in your PATH
- Delete `build/` folder and try again
- Run `.\gradlew.bat build --refresh-dependencies`

## 📝 Modifying the Mod

### Adding New Blocks
1. Edit `src/main/java/net/imp/ctb/block/ModBlocks.java`
2. Add your block definition
3. Edit `src/main/java/net/imp/ctb/item/ModItems.java`
4. Create JSON model files
5. Add textures and rebuild

### Changing Block Properties
- Edit `ModBlocks.java` to adjust:
  - Block hardness (`.strength()`)
  - Blast resistance
  - Light level (`.luminance()`)
  - Friction, speedFactor, etc.

## 📚 Useful Resources

- [Fabric Wiki](https://fabricmc.net/wiki/doku.php)
- [Minecraft Wiki Block Reference](https://minecraft.wiki/w/Block)
- [Yarn Mappings](https://github.com/FabricMC/yarn) - Decompiled Minecraft code

## 🎯 Next Steps

1. ✅ Install the compiled mod (`build/libs/citybuilder-1.0.0.jar`)
2. ✅ Launch Minecraft and test the blocks with realistic textures
3. 📦 Consider creating custom textures using the tools mentioned above
4. 🎨 Experiment with combining blocks for your city designs
5. 🚀 Share your creations!

## 📄 License

CC0-1.0 - You're free to use, modify, and distribute this mod!

## 🎉 Have Fun Building!

Your citybuilder mod is ready to use. Start creating amazing cities in Minecraft!

For updates or to share your modifications, visit the Fabric community forums or GitHub.
