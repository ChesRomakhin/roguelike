package ru.chesromakhin.vm.command.system

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command

class HaltCommand: Command {

  override val group: String
    get() = "system"
  override val name: String
    get() = "hlt"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    vm.stop()
    return null
  }
}