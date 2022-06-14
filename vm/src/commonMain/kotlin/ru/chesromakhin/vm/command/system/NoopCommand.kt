package ru.chesromakhin.vm.command.system

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command

class NoopCommand: Command {
  override val group: String
    get() = "noop"
  override val name: String
    get() = "noop"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    return null
  }
}