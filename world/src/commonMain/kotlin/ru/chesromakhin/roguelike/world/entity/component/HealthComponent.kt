package ru.chesromakhin.roguelike.world.entity.component

import ru.chesromakhin.roguelike.world.entity.Entity

class HealthComponent(
  var maxHealth: Int
): Component {

  private var currentHealth: Int = maxHealth

  override var entity: Entity? = null
  override val name: String = "health"

  fun isAlive(): Boolean {
    return currentHealth > 0
  }

  fun getCurrentHealth(): Int {
    return currentHealth
  }

  fun damage(damage: Int) {
    if (this.isAlive()) {
      this.currentHealth -= damage
    }
  }

  fun heal(amount: Int) {
    if (this.isAlive()) {
      this.currentHealth += amount
      if (this.currentHealth > maxHealth) {
        this.currentHealth = maxHealth
      }
    }
  }

}