# Arcana Skill Tree Design

This is the proposed first usable skill tree. Nodes cost one skill point unless noted otherwise. A node can only be purchased when its prerequisite is unlocked.

```mermaid
flowchart TD
    ROOT[Arcane Awakening\nStarting node]

    ROOT --> MANA[Attunement I\n+10 maximum mana]
    MANA --> MANA2[Attunement II\n+15 maximum mana]
    MANA2 --> MANA3[Deep Reservoir\n+25 maximum mana]

    ROOT --> BOLT[Arcane Bolt\nUnlock spell]
    BOLT --> RANGE[Far-Reaching Bolt\n+8 block range]
    RANGE --> RANGE2[Horizon Bolt\n+8 block range]
    RANGE2 --> PIERCE[Spellpiercer\nPierce one target]
    BOLT --> POWER[Arcane Force\n+2 damage]
    POWER --> POWER2[Arcane Mastery\n+3 damage]

    ROOT --> BLINK[Veilstep\nUnlock Blink]
    BLINK --> BLINKR[Long Step\n+4 block Blink range]
    BLINKR --> BLINKSAFE[Safe Arrival\nBetter landing checks]

    ROOT --> WARD[Wardcraft\nUnlock Ward]
    WARD --> WARDTIME[Persistent Ward\n+2 seconds duration]
    WARDTIME --> WARDABSORB[Bulwark\nAbsorbs extra damage]

    RANGE2 --> HYBRID[Arcane Mobility\nRequires Horizon Bolt + Long Step]
    BLINKR --> HYBRID
    HYBRID --> RIFT[Riftstep\nBlink leaves an arcane afterimage]

    classDef root fill:#8e5bd6,color:#fff,stroke:#d9bdff;
    classDef combat fill:#573b9d,color:#fff,stroke:#bba1ff;
    classDef utility fill:#276b78,color:#fff,stroke:#91efff;
    classDef defense fill:#3f6c4a,color:#fff,stroke:#a8f0b2;
    classDef hybrid fill:#873f78,color:#fff,stroke:#f2a8e7;
    class ROOT root;
    class BOLT,RANGE,RANGE2,PIERCE,POWER,POWER2 combat;
    class MANA,MANA2,MANA3 utility;
    class BLINK,BLINKR,BLINKSAFE defense;
    class WARD,WARDTIME,WARDABSORB defense;
    class HYBRID,RIFT hybrid;
```

## In-game presentation

- The tree opens with **K**.
- Locked nodes are dimmed and show their prerequisite.
- Available nodes glow when the player has a skill point.
- Purchased nodes use the school color and show their current rank.
- Cross-branch nodes use a distinct hybrid color.
- The first implementation should expose the Arcane Bolt range node, then add the remaining nodes incrementally.

## Implementation order

1. Add node definitions and prerequisite validation.
2. Sync skill points and unlocked nodes to the client.
3. Render the tree with pan/zoom-friendly spacing.
4. Add node purchase packets with server validation.
5. Connect mana, Bolt, Blink, and Ward upgrades.
