## LDTS_t11g02 - Jetpack Sidescroller
In this infinite sidescroller game, you play as Hero with a Jetpack and try to dodge the red laser beams and survive as long as possible. Use the arrow keys to move up and down, Enter on the menu to select an option and q to go to the menu. Be careful with your life value!

This project was developed by David Monteiro (up202306751@fc.up.pt), David Pinto (up202404233@fe.up.pt) and Luca Zielinsky (up202302132@fe.up.pt) for LDTS 2025-2026.

### IMPLEMENTED FEATURES
- **Flying and falling** - The game character will move up and down when the respective arrows are pressed, but it will also move down automatically if you don't press any key for a bit.

- **Lasers** - Red lasers are generated randomly on the right edge of the screen and they move left at a constant speed.

- **Life Total** - When you character hits a laser beam, it will lose a life. You start with 10 and the game ends when you lose all your lives.

### PLANNED FEATURES

- **Coins** - When your character hits a coin, their score increases by 1. The objective of the game will be to collect as many coins as possible.

- **Power-ups** - When your character hits a power-up, it will gain a certain power, like an extra life or a way to destroy lasers.

<p align="center" justify="center">
  <img src="docs/PlannedFeatures.png" alt="Planned Features">
</p>
<p align="center" justify="center"><b><i>Coins are C's, Heart and Bomb are Power-ups</i></b></p>




### DESIGN


### The Creation of Lasers

**Problem in Context**

The amount of lasers (we call them Monsters in our code) could be a problem as instantiating too many lasers could slow down the game. We needed a way to avoid the excessive creation of new lasers.

**The Pattern**

We have applied the **Object Pool** pattern. This pattern allows us to store the objects we aren't currently using and get them when we do need them, thereby avoiding extra instantiations. This pattern allowed to address the problem because we could now store the lasers that hit the left border of the screen in a pool and reuse them when we were generating new lasers on the right border.

**Implementation**

The Arena uses the MonsterPool whenever it wants access to the lasers. The MonsterPool stores the lasers (called Monsters in out code) that have been created and knows whether they are being used or not. When a new laser is needed, the MonsterPool returns one of the unused ones (if any are available)

<p align="center" justify="center">
  <img src="docs/MonsterPool.png" alt="Monster Pool"/>
</p>
<p align="center" justify="center"><b><i>MonsterPool Class Diagram</i></b></p>


**Consequences**

- The MonsterPool handles the creation and reuse of lasers, reducing the amount of unnecessary instantiations.
- When we iterate over the Monsters in the MonsterPool to reuse the ones that have left the screen, we store those in a buffer and then clear it after the iteration so we won’t delete them while we are iterating over them.
- We could run into issues if we try to generate new lasers when there are none available. This hasn't been a problem so far, but it could become one if we decide to increase the size of the Arena and/or the amount of lasers generated.

#### MVC
We used the MVC pattern, separating the model, the view and the controller for easier maintenance and development. This was made easier by our use of the Hero-Solid repository (available on Moodle) as a base for our project.

#### Menus
Since we used the Hero-Solid repository (available on Moodle) as a base for our project, we also used the menu system made by professor André Restivo.

#### KNOWN CODE SMELLS

- Some classes have a lot of methods/logic, which hurts readability.
- More tests should be added.
- More comments should be added for better readability.

### TESTING
Mutation testing hasn't been done yet.

<p align="center" justify="center">
  <img src="docs/Coverage.png" alt="Coverage Report"/>
</p>
<p align="center" justify="center">
<b><i>Coverage Report</i></b>
</p>