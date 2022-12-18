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

  fun render() {
    if (mainNode == null) {
      mainNode = element.ownerDocument!!.createElement("div")
      element.appendChild(mainNode!!)
    }

    mainNode!!.children.asList().forEach { mainNode!!.removeChild(it) }

    for ((y, row) in world.cells.withIndex()) {
      val rowNode = document.createElement("div")
      rowNode.setAttribute("row-index", y.toString())
      for ((x, cell) in row.withIndex()) {
        val cellNode = document.createElement("span")
        cellNode.setAttribute("cell-index", x.toString())
        cellNode.addClass("cell")

        cellNode.textContent = when (cell.type) {
          CellType.FLOOR -> "."
          CellType.WALL -> "#"
          else -> "?"
        }

        rowNode.appendChild(cellNode)

        elementsByLocation += Location(x, y) to cellNode
      }

      mainNode!!.appendChild(rowNode)
    }

    console.log(elementsByLocation)
    world.entities.forEach {
      val element = elementsByLocation[it.location]
      element!!.textContent = it.char.toString()
    }
  }

}