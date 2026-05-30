#!/usr/bin/env python3
"""
Advanced texture generator for Citybuilder Mod
Creates realistic Minecraft-style textures for city blocks
"""

try:
    from PIL import Image, ImageDraw, ImageFilter
    import random
    import math
except ImportError:
    print("ERROR: Pillow library not found!")
    print("Install it with: pip install Pillow")
    exit(1)

import json
import os
import shutil
from pathlib import Path

def add_noise(img, intensity=0.1):
    """Add subtle noise to texture"""
    pixels = img.load()
    width, height = img.size

    for x in range(width):
        for y in range(height):
            r, g, b = pixels[x, y]
            noise = random.uniform(-intensity, intensity)
            r = max(0, min(255, int(r * (1 + noise))))
            g = max(0, min(255, int(g * (1 + noise))))
            b = max(0, min(255, int(b * (1 + noise))))
            pixels[x, y] = (r, g, b)

    return img

def create_asphalt_texture():
    """Create realistic asphalt texture"""
    img = Image.new('RGB', (16, 16), (35, 35, 35))
    pixels = img.load()

    # Add asphalt-like texture with small variations
    for x in range(16):
        for y in range(16):
            variation = random.randint(-5, 5)
            base = 35 + variation
            pixels[x, y] = (base, base, base)

    # Add some darker spots for texture
    for _ in range(8):
        x = random.randint(0, 15)
        y = random.randint(0, 15)
        pixels[x, y] = (25, 25, 25)

    return add_noise(img, 0.05)

def create_asphalt_line_texture():
    """Create asphalt with white road line"""
    img = create_asphalt_texture()
    draw = ImageDraw.Draw(img)

    # Draw white center line
    draw.rectangle([6, 0, 9, 15], fill=(220, 220, 220))

    # Add some edge wear
    for _ in range(3):
        x = random.randint(6, 9)
        y = random.randint(0, 15)
        if random.random() < 0.3:
            img.putpixel((x, y), (35, 35, 35))

    return img

def create_asphalt_curve_texture():
    """Create curved asphalt road piece"""
    img = create_asphalt_texture()
    draw = ImageDraw.Draw(img)

    # Draw curved white line
    for i in range(8):
        x = 7 + int(3 * math.sin(i * math.pi / 8))
        y = i * 2
        if y < 16:
            draw.rectangle([x-1, y, x+1, y], fill=(220, 220, 220))

    return img

def create_cobble_texture():
    """Create cobblestone-like texture"""
    img = Image.new('RGB', (16, 16), (140, 130, 120))
    pixels = img.load()

    # Create cobble pattern
    for x in range(16):
        for y in range(16):
            # Create irregular stone blocks
            block_x = x // 4
            block_y = y // 4
            variation = (block_x + block_y) % 3

            if variation == 0:
                color = (150, 140, 130)
            elif variation == 1:
                color = (130, 120, 110)
            else:
                color = (160, 150, 140)

            # Add mortar lines
            if x % 4 == 3 or y % 4 == 3:
                color = (120, 110, 100)

            pixels[x, y] = color

    return add_noise(img, 0.08)

def create_brick_texture():
    """Create brick texture"""
    img = Image.new('RGB', (16, 16), (160, 70, 50))
    pixels = img.load()

    for x in range(16):
        for y in range(16):
            # Brick pattern
            brick_height = 3
            brick_width = 6

            brick_x = x // brick_width
            brick_y = y // brick_height

            # Alternate brick pattern
            if brick_y % 2 == 1:
                x_offset = brick_width // 2
            else:
                x_offset = 0

            local_x = x % brick_width
            local_y = y % brick_height

            # Brick color
            if local_x < brick_width - 1 and local_y < brick_height - 1:
                color = (170, 80, 60)
            else:
                # Mortar
                color = (140, 120, 100)

            pixels[x, y] = color

    return add_noise(img, 0.06)

def create_gravel_texture():
    """Create gravel texture"""
    img = Image.new('RGB', (16, 16), (130, 130, 130))
    pixels = img.load()

    # Create gravel pebbles
    for x in range(16):
        for y in range(16):
            # Random pebble sizes and colors
            if random.random() < 0.4:
                gray = random.randint(110, 150)
                pixels[x, y] = (gray, gray, gray)
            else:
                gray = random.randint(120, 140)
                pixels[x, y] = (gray, gray, gray)

    return add_noise(img, 0.15)

def create_concrete_texture(base_color):
    """Create smooth concrete texture"""
    img = Image.new('RGB', (16, 16), base_color)
    pixels = img.load()

    # Add subtle concrete texture
    for x in range(16):
        for y in range(16):
            r, g, b = base_color
            variation = random.randint(-8, 8)
            pixels[x, y] = (
                max(0, min(255, r + variation)),
                max(0, min(255, g + variation)),
                max(0, min(255, b + variation))
            )

    return add_noise(img, 0.03)

def create_parking_spot_texture():
    """Create parking spot with markings"""
    img = create_asphalt_texture()
    draw = ImageDraw.Draw(img)

    # Draw parking lines
    draw.rectangle([2, 2, 13, 13], outline=(200, 200, 200), width=1)
    draw.rectangle([4, 4, 11, 11], outline=(200, 200, 200), width=1)

    return img

def create_parking_line_texture():
    """Create parking area line markings"""
    img = create_asphalt_texture()
    draw = ImageDraw.Draw(img)

    # Draw parking space lines
    for i in range(0, 16, 4):
        draw.rectangle([i, 0, i+1, 15], fill=(220, 220, 220))

    return img

def create_sidewalk_texture(base_color):
    """Create sidewalk texture"""
    img = Image.new('RGB', (16, 16), base_color)
    pixels = img.load()

    # Add stone-like texture
    for x in range(16):
        for y in range(16):
            r, g, b = base_color
            variation = random.randint(-10, 10)
            pixels[x, y] = (
                max(0, min(255, r + variation)),
                max(0, min(255, g + variation)),
                max(0, min(255, b + variation))
            )

    return add_noise(img, 0.08)

def create_street_lamp_texture():
    """Create street lamp texture"""
    img = Image.new('RGB', (16, 16), (60, 60, 60))
    pixels = img.load()

    # Metal pole
    for x in range(6, 10):
        for y in range(16):
            pixels[x, y] = (70, 70, 70)

    # Lamp head
    for x in range(4, 12):
        for y in range(2, 6):
            pixels[x, y] = (80, 80, 80)

    return add_noise(img, 0.05)

def create_street_sign_texture():
    """Create street sign texture"""
    img = Image.new('RGB', (16, 16), (120, 80, 40))
    pixels = img.load()

    # Wooden pole
    for x in range(7, 9):
        for y in range(16):
            pixels[x, y] = (130, 90, 50)

    # Sign board
    for x in range(2, 14):
        for y in range(2, 8):
            pixels[x, y] = (140, 100, 60)

    return add_noise(img, 0.04)

def create_bench_texture():
    """Create bench texture"""
    img = Image.new('RGB', (16, 16), (120, 80, 40))
    pixels = img.load()

    # Wooden structure
    for x in range(16):
        for y in range(12, 16):
            pixels[x, y] = (130, 90, 50)

    # Seat
    for x in range(2, 14):
        for y in range(8, 12):
            pixels[x, y] = (140, 100, 60)

    return add_noise(img, 0.04)

def create_trash_bin_texture():
    """Create trash bin texture"""
    img = Image.new('RGB', (16, 16), (50, 50, 50))
    pixels = img.load()

    # Metal bin
    for x in range(4, 12):
        for y in range(4, 16):
            pixels[x, y] = (60, 60, 60)

    # Lid
    for x in range(3, 13):
        for y in range(2, 5):
            pixels[x, y] = (70, 70, 70)

    return add_noise(img, 0.05)

# Define textures with their creation functions
PREDEFINED_TEXTURES = {
    # Roads
    "block/asphalt_road": create_asphalt_texture,
    "block/asphalt_road_line": create_asphalt_line_texture,
    "block/asphalt_curve": create_asphalt_curve_texture,

    # Paths
    "block/cobble_path": create_cobble_texture,
    "block/brick_path": create_brick_texture,
    "block/gravel_path": create_gravel_texture,

    # Concrete
    "block/gray_concrete": lambda: create_concrete_texture((120, 120, 120)),
    "block/white_concrete": lambda: create_concrete_texture((200, 200, 200)),
    "block/red_concrete": lambda: create_concrete_texture((140, 50, 50)),

    # Parking
    "block/parking_spot": create_parking_spot_texture,
    "block/parking_line": create_parking_line_texture,

    # Sidewalk
    "block/stone_sidewalk": lambda: create_sidewalk_texture((160, 150, 140)),
    "block/tiled_sidewalk": lambda: create_sidewalk_texture((180, 170, 160)),

    # Street Furniture
    "block/street_lamp": create_street_lamp_texture,
    "block/street_sign": create_street_sign_texture,
    "block/bench": create_bench_texture,
    "block/trash_bin": create_trash_bin_texture,
}


def get_color_for_name(name, brightness=120):
    hash_value = int.from_bytes(name.encode('utf-8'), 'little')
    r = (hash_value >> 0) & 0xFF
    g = (hash_value >> 8) & 0xFF
    b = (hash_value >> 16) & 0xFF
    return (
        max(0, min(255, (r + brightness) // 2)),
        max(0, min(255, (g + brightness) // 2)),
        max(0, min(255, (b + brightness) // 2)),
    )


def create_generic_texture(name):
    base_color = get_color_for_name(name)
    img = Image.new('RGB', (16, 16), base_color)
    draw = ImageDraw.Draw(img)

    if 'stripe' in name or 'line' in name or 'tape' in name:
        draw.rectangle([0, 6, 15, 9], fill=(255, 255, 255))
        draw.line([0, 3, 15, 3], fill=(0, 0, 0), width=1)
        draw.line([0, 12, 15, 12], fill=(0, 0, 0), width=1)
    elif 'corner' in name or 'curve' in name:
        draw.arc([0, 0, 15, 15], 90, 180, fill=(220, 220, 220), width=2)
    elif 'bus_stop' in name or 'phone_booth' in name:
        draw.rectangle([4, 2, 11, 13], fill=(180, 180, 180))
        draw.line([4, 6, 11, 6], fill=(80, 80, 80), width=1)
    elif 'fire_hydrant' in name:
        draw.rectangle([5, 3, 10, 13], fill=(220, 60, 60))
    elif 'planter' in name:
        draw.rectangle([3, 6, 12, 14], fill=(100, 140, 80))
    elif 'clock' in name:
        draw.ellipse([4, 4, 11, 11], outline=(220, 220, 220), width=1)
        draw.line([8, 8, 8, 5], fill=(220, 220, 220), width=1)
        draw.line([8, 8, 11, 8], fill=(220, 220, 220), width=1)
    elif 'sign' in name or 'bench' in name or 'table' in name or 'chair' in name or 'fence' in name:
        draw.rectangle([2, 8, 13, 13], fill=(130, 100, 70))
        draw.rectangle([6, 2, 9, 8], fill=(90, 90, 90))
    else:
        for x in range(0, 16, 4):
            draw.line([x, 0, x, 15], fill=(255, 255, 255), width=1)

    return add_noise(img, 0.06)


def collect_texture_references(base_path):
    json_paths = list((base_path / 'models' / 'block').glob('*.json'))
    json_paths += list((base_path / 'models' / 'item').glob('*.json'))
    refs = set()

    for p in json_paths:
        data = json.loads(p.read_text('utf-8'))

        def extract(node):
            if isinstance(node, dict):
                for key, value in node.items():
                    if key in ('texture', 'textures'):
                        if isinstance(value, str):
                            refs.add(value)
                        elif isinstance(value, dict):
                            for texture_value in value.values():
                                if isinstance(texture_value, str):
                                    refs.add(texture_value)
                    else:
                        extract(value)
            elif isinstance(node, list):
                for item in node:
                    extract(item)

        extract(data)

    result = []
    for ref in sorted(refs):
        if ref.startswith('citybuilder:'):
            ref_path = Path(ref.split(':', 1)[1])
            if len(ref_path.parts) == 2:
                category, name = ref_path.parts
                result.append((category, name))
    return result


def create_texture(name, create_func):
    """Create a texture using the provided function"""
    return create_func()


def main():
    # Determine base path
    script_dir = Path(__file__).parent.absolute()
    base_path = script_dir / "src" / "main" / "resources" / "assets" / "citybuilder"

    # Create texture directories
    block_dir = base_path / "textures" / "block"
    item_dir = base_path / "textures" / "item"

    block_dir.mkdir(parents=True, exist_ok=True)
    item_dir.mkdir(parents=True, exist_ok=True)

    print("Creating realistic Minecraft-style textures...")

    refs = collect_texture_references(base_path)
    if not refs:
        print("No texture references found in model files.")
        return

    created = 0
    for category, name in refs:
        target_dir = block_dir if category == 'block' else item_dir
        path = target_dir / f"{name}.png"
        if path.exists():
            continue

        if category == 'item':
            corresponding_block = block_dir / f"{name}.png"
            if corresponding_block.exists():
                shutil.copy(corresponding_block, path)
                print(f"✓ Copied block texture to item texture: {path.relative_to(script_dir)}")
                created += 1
                continue
            if f"block/{name}" in PREDEFINED_TEXTURES:
                img = create_texture(name, PREDEFINED_TEXTURES[f"block/{name}"])
                img.save(path)
                created += 1
                print(f"✓ Created item texture {path.relative_to(script_dir)}")
                continue

        if f"{category}/{name}" in PREDEFINED_TEXTURES:
            img = create_texture(f"{category}/{name}", PREDEFINED_TEXTURES[f"{category}/{name}"])
        else:
            img = create_generic_texture(name)

        img.save(path)
        created += 1
        print(f"✓ Created {path.relative_to(script_dir)}")

    if created == 0:
        print("All referenced textures already exist.")
    else:
        print(f"\n✓ Created {created} missing texture(s).")

    print(f"\nTextures located in:")
    print(f"  - {block_dir.relative_to(script_dir)}")
    print(f"  - {item_dir.relative_to(script_dir)}")


if __name__ == "__main__":
    main()
