# Arcana Project Tracker

This tracker records the planned work for the Arcana high-fantasy magic mod.

## Status legend

- **Done** — implemented and built successfully
- **In progress** — current development focus
- **Planned** — approved for a future build
- **Backlog** — ideas to evaluate later

## Current release: 0.1.0

### Completed

- [x] Forge 1.20.1 / Forge 47.4.0 / Java 17 project setup
- [x] Persistent player mana capability
- [x] Mana regeneration and client synchronization
- [x] Mana HUD
- [x] Server-authoritative spell casting
- [x] Arcane Bolt projectile
- [x] Arcane Bolt no-gravity movement
- [x] Arcane Bolt fixed 32-block base range
- [x] Blink spell
- [x] Ward spell
- [x] V/B/N spell controls
- [x] First-login Arcana guide book
- [x] Five starter items registered
- [x] Crafting recipes for starter items
- [x] README crafting artwork
- [x] Public GitHub repository

## Next milestone: progression foundation

Priority: **High**

- [ ] Add persistent skill points
- [ ] Add configurable ways to earn skill points
- [ ] Add basic skill-tree data model
- [ ] Add first skill-tree screen
- [ ] Add Arcane Bolt range upgrade
- [ ] Add Arcane Bolt damage upgrade
- [ ] Make Mana Crystal increase maximum mana
- [ ] Make Sage's Ring improve mana regeneration
- [ ] Make Arcane Focus improve spell damage or range
- [ ] Make Blinkstone reduce Blink cooldown
- [ ] Make Ward Sigil improve Ward duration or strength

## Milestone: spell hotbar

Priority: **High**

- [ ] Add 4–8 spell slots
- [ ] Add selected-spell HUD display
- [ ] Add number-key spell selection
- [ ] Add mouse-wheel spell selection
- [ ] Display spell cooldowns
- [ ] Validate selected spells on the server

## Milestone: spell upgrades and presentation

Priority: **Medium**

- [ ] Arcane Bolt impact burst
- [ ] Arcane Bolt piercing upgrade
- [ ] Arcane Bolt explosive upgrade
- [ ] Blink departure and arrival effects
- [ ] Blink safe-landing improvements
- [ ] Ward visible magical barrier
- [ ] Ward damage absorption
- [ ] Ward reflect upgrade
- [ ] School-specific sounds and particles

## Milestone: items and world content

Priority: **Medium**

- [ ] Spellbook item
- [ ] Attunement Shards
- [ ] Arcane Lantern
- [ ] Leyline Compass
- [ ] Staffs and wands
- [ ] Elemental catalysts
- [ ] Boss relics
- [ ] Ritual altar
- [ ] Leyline nodes
- [ ] Arcane ruins
- [ ] Magical bosses

## Milestone: additional magic schools

Priority: **Long term**

- [ ] Fire school
- [ ] Storm school
- [ ] Nature school
- [ ] Blood school
- [ ] Void school
- [ ] Frost school
- [ ] Cross-school hybrid skills
- [ ] School capstones

## Multiplayer and quality checklist

- [ ] Test on a dedicated server
- [ ] Verify invalid cast packets cannot spend or create resources
- [ ] Test dimension changes and respawns
- [ ] Add configuration files for costs, damage, range, and cooldowns
- [ ] Add localization support
- [ ] Add particle-performance settings
- [ ] Add advancements
- [ ] Add automated server-side tests

## Definition of done

A feature is complete when it works in singleplayer and on a dedicated multiplayer server, has server-side validation, is documented in the guide or README when player-facing, and has been included in a successful Forge build.

## Current next action

Implement the progression foundation: skill points, a basic skill-tree model, and the first upgradeable Arcane Bolt and mana-item effects.
