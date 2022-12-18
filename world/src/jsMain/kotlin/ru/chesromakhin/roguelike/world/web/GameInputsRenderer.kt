package ru.chesromakhin.roguelike.world.web

import org.w3c.dom.Element
import ru.chesromakhin.roguelike.world.Game
import kotlinx.browser.window
import org.w3c.dom.events.Event
import org.w3c.dom.events.InputEvent

class GameInputsRenderer(private val game: Game, private val element: Element) {

  private var running: Boolean = false
  private var timeoutHandler: Int = -1
  private var timeoutMs: Int = 1000

  fun render() {
    if (element.children.length != 0) {
      return
    }

    val document = element.ownerDocument!!
    val nextButton = document.createElement("button")
    nextButton.textContent = "Next"
    nextButton.addEventListener("click", { this.game.cycle() })

    element.appendChild(nextButton)

    renderRunButton()
    renderStopButton()
    renderInput()
  }

  private fun renderRunButton() {
    val document = element.ownerDocument!!
    val runButton = document.createElement("button")
    runButton.textContent = "Run"
    runButton.addEventListener("click", {
      this.running = true
      scheduleCycle()
    })

    element.appendChild(runButton)
  }

  private fun renderStopButton() {
    val document = element.ownerDocument!!
    val stopButton = document.createElement("button")
    stopButton.textContent = "Stop"
    stopButton.addEventListener("click", { stop() })

    element.appendChild(stopButton)
  }

  private fun renderInput() {
    val document = element.ownerDocument!!
    val timeoutInput = document.createElement("input")
    timeoutInput.setAttribute("type", "number")
    timeoutInput.setAttribute("min", "100")
    timeoutInput.setAttribute("step", "10")
    timeoutInput.setAttribute("value", timeoutMs.toString())
    timeoutInput.addEventListener("change", { event: Event ->
      this.timeoutMs = event.target.asDynamic()["value"].toString().toInt()
    })

    element.appendChild(timeoutInput)
  }

  private fun scheduleCycle() {
    this.game.cycle()

    if (running) {
      this.timeoutHandler = window.setTimeout(
        { this.scheduleCycle() },
        this.timeoutMs,
      )
    }
  }

  private fun stop() {
    this.running = false

    if (this.timeoutHandler > 0) {
      window.clearTimeout(this.timeoutHandler)
      this.timeoutHandler = -1
    }
  }

}