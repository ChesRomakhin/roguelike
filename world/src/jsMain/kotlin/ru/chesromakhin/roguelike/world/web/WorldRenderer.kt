package ru.chesromakhin.roguelike.world.web

import kotlinx.browser.document
import kotlinx.dom.addClass
import org.w3c.dom.Element
import org.w3c.dom.asList
import ru.chesromakhin.roguelike.world.CellType
import ru.chesromakhin.roguelike.world.Location
import ru.chesromakhin.roguelike.world.World

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
          CellType.WALL -> "#"
          else -> "?"
        }
      }
    }

    world.entities.forEach {
      val element = elementsByLocation[it.location]
      element!!.textContent = it.char.toString()
    }
  }

}