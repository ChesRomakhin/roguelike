package ru.chesromakhin.vm.command.flow

import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command

class GoBackCommand: Command {

  override val group: String
    get() = "flow"

  override val name: String
    get() = "gobk"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int {
    return (parameter1.toInt().shl(8).and(0xFF00).or(parameter2.toInt()).and(0xFFFF)).unaryMinus()
  }

}