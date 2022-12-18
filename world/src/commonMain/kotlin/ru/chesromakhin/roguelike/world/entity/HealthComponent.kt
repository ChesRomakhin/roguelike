package ru.chesromakhin.roguelike.world.entity

class HealthComponent(
  maxHealth: Int
): Component {

  private val name: String = "health"

  var maxHealth: Int = maxHealth
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
    }
  }

}