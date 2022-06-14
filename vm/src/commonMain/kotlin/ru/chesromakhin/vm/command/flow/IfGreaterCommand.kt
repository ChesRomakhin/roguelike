package ru.chesromakhin.vm.command.flow

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.memory.MemoryDriver

class IfGreaterCommand: Command {

  private val ZERO: Short = 0

  override val group: String
    get() = "flow"

  override val name: String
    get() = "ifgt"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    val driver: MemoryDriver? = vm.getDriver(MemoryDriver.NAME)
    if (driver != null) {
      val op1 = driver.read(parameter1)
      val op2 = driver.read(parameter2)

      return if (op1 > op2) {
        1
      } else {
        2
      }
    }

    return null
  }

}