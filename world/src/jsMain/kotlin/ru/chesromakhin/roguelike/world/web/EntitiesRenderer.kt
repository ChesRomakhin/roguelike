package ru.chesromakhin.roguelike.world.web

import org.w3c.dom.Element
import org.w3c.dom.asList
import ru.chesromakhin.roguelike.world.World

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
        " " + "*".repeat(exhaustion)
      } else {
        " 0";
      }

      entityElement.textContent = entity.char + exhaustionString
    }
  }

}