package ru.chesromakhin.vm.command.flow

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.memory.MemoryDriver

class IfLessZeroCommand: Command {

  private val ZERO: Short = 0

  override val group: String
    get() = "flow"

  override val name: String
    get() = "iflz"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    val driver: MemoryDriver? = vm.getDriver(MemoryDriver.NAME)
    if (driver != null) {
      val op1 = driver.read(parameter1)

      if (op1 < ZERO) {
        return parameter2.toInt()
      }
    }

    return null
  }

}