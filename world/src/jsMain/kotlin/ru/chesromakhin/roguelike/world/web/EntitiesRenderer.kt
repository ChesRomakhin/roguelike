package ru.chesromakhin.roguelike.world.web

import org.w3c.dom.Element
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.component.HealthComponent

class EntitiesRenderer(private val world: World, private val element: Element) {

  fun render() {
    while (element.firstChild != null) {
      element.removeChild(element.lastChild!!)
    }

    val document = element.ownerDocument!!
    world.entities.forEach { entity ->
      val entityElement = document.createElement("div")
      element.appendChild(entityElement)

      val exhaustion = entity.exaust

      val exhaustionString: String = if (exhaustion > 0) {
        "*".repeat(exhaustion)
      } else {
        "0"
      }

      val healthString = if (entity.hasComponent(HealthComponent::class)) {
        val healthComponent = entity.getComponent(HealthComponent::class)!!
        "${healthComponent.getCurrentHealth()}/${healthComponent.maxHealth}"
      } else {
        "-/-"
      }

      entityElement.textContent = arrayOf(entity.char.toString(), healthString, exhaustionString).joinToString("  ")
    }
  }

}