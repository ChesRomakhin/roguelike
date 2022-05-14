package ru.chesromakhin.vm.command.math

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.memory.MemoryDriver

class AddCommand: Command {

  override val group: String
    get() = "math"

  override val name: String
    get() = "add"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    val driver: MemoryDriver? = vm.getDriver("memory")
    if (driver != null) {
      val op1 = driver.read(parameter1)
      val op2 = driver.read(parameter2)
      var result = op1 + op2
      result = if (result > 255) {
        255
      } else {
        result.and(0xFF)
      }
      driver.write(parameter1, result.toShort())
    }

    return null
  }
}