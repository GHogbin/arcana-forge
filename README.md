# Arcana — Forge 1.20.1

Starter high-fantasy spellcasting mod for Minecraft 1.20.1 / Forge 47.4.0 / Java 17.

## Build and run

1. Install a 64-bit JDK 17 and ensure `java -version` reports 17.
2. From this folder run `gradlew build` (Windows) or `./gradlew build` (Linux/macOS).
3. The jar is written to `build/libs/arcana-0.1.0.jar`.
4. For a dev client use `gradlew runClient`; for a dev server use `gradlew runServer`.
5. Copy the built jar into the `mods` folder of a Forge 1.20.1 installation.

## Controls

Press **V** to cast Arcane Bolt, **B** to Blink up to 12 blocks, and **N** to activate Ward. Arcane Bolt ignores gravity and travels 32 blocks by default; its range is isolated as an upgrade-ready value. The spells are server-authoritative: the client sends only a cast request; the server validates cooldown and mana, performs the action, and broadcasts effects.

## Included vertical slice

- Persistent player mana capability (100 maximum, 5 mana/second regeneration).
- Server-to-client mana synchronization on login, respawn, dimension change, and use.
- Mana HUD rendered client-side.
- Network channel and validated cast request packet.
- Glowing Arcane Bolt projectile with trail, impact burst, knockback, and configurable metadata seed.
- JSON spell metadata at `data/arcana/spells/arcane_bolt.json`.

The packages intentionally separate capability, networking, spells, entities, and client presentation so skill progression, a skill-tree screen, Blink, Ward, hotbar slots, and more schools can be added without moving the foundation.

## Crafting diagrams

Use a crafting table. Each diagram is read left-to-right, top-to-bottom. `_` means an empty slot.

### Mana Crystal

```text
A L A
L A L
A L A
```

`A` Amethyst Shard — `L` Lapis Lazuli

### Sage's Ring

```text
_ G _
G A G
_ G _
```

`G` Gold Ingot — `A` Amethyst Shard

### Arcane Focus

```text
_ _ A
_ S _
S _ _
```

`A` Amethyst Shard — `S` Stick

### Blinkstone

```text
_ E _
A P A
_ E _
```

`E` Ender Pearl — `A` Amethyst Shard — `P` Purpur Block

### Ward Sigil

```text
A B A
B E B
A B A
```

`A` Amethyst Shard — `B` Iron Ingot — `E` Emerald
