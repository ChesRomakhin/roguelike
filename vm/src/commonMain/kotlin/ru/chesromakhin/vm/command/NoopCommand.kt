package ru.chesromakhin.vm.command

import ru.chesromakhin.vm.VirtualMachine

class NoopCommand: Command {
  override val group: String
    get() = "noop"
  override val name: String
    get() = "noop"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int? {
    return null
  }
}