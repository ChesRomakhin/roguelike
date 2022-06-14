package ru.chesromakhin.vm.command.math

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.memory.MemoryDriver

class DecreaseCommand: Command {

  override val group: String
    get() = "math"

  override val name: String
    get() = "sub"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    val driver: MemoryDriver? = vm.getDriver("memory")
    if (driver != null) {
      val op1 = driver.read(parameter1)
      var result = op1 - 1
      result = if (result < 0) {
        0
      } else {
        result.and(0xFF)
      }
      driver.write(parameter1, result.toShort())
    }

    return null
  }
}