package ru.chesromakhin.vm.command

import ru.chesromakhin.vm.VirtualMachine

interface Command {

  val group: String
  val name: String

  fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int?

}