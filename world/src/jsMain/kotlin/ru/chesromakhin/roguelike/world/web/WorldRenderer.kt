package ru.chesromakhin.roguelike.world.web

import kotlinx.browser.document
import kotlinx.dom.addClass
import org.w3c.dom.Element
import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.entity.component.Passable

class WorldRenderer(private val world: World, private val element: Element) {

  private var mainNode: Element? = null

  private var elementsByLocation: Map<Location, Element> = mapOf()
  private var rowElements: List<Element> = ArrayList()

  fun render() {
    if (mainNode == null) {
      mainNode = element.ownerDocument!!.createElement("div")
      element.appendChild(mainNode!!)
    }

    for ((y, row) in world.cells.withIndex()) {
      val rowNode = if (rowElements.size > y) {
        rowElements[y]
      } else {
        val e = document.createElement("div")
        e.setAttribute("row-index", y.toString())
        e.classList.add("row")
        mainNode!!.appendChild(e)
        rowElements += e

        e
      }

      for ((x, cell) in row.withIndex()) {
        val location = Location(x, y)
        val cellNode = if (elementsByLocation.containsKey(location)) {
          elementsByLocation[location]
        } else {
          val e = document.createElement("span")
          e.setAttribute("cell-index", x.toString())
          e.addClass("cell")
          elementsByLocation += location to e
          rowNode.appendChild(e)

          e
        }!!

        cellNode.textContent = when (cell.type) {
          CellType.FLOOR -> "."
          CellType.WALL -> "🧱"
          else -> "?"
        }
      }
    }

    val entitiesByPassable = world.entities.groupBy { it.hasComponent(Passable::class) }.withDefault { listOf() }
    (entitiesByPassable[true]!! + entitiesByPassable[false]!!).forEach {
      val element = elementsByLocation[it.location]
      element!!.textContent = it.char.toString()
    }
  }

}