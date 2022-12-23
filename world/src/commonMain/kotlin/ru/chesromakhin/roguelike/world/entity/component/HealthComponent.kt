package ru.chesromakhin.roguelike.world.entity.component

class HealthComponent(
  var maxHealth: Int
): Component {

  private val name: String = "health"

  private var currentHealth: Int = maxHealth

  override fun getName(): String {
    return this.name
  }

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