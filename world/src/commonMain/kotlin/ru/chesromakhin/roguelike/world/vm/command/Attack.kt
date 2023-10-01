package ru.chesromakhin.roguelike.world.vm.command

import ru.chesromakhin.roguelike.world.action.Attack
import ru.chesromakhin.roguelike.world.action.Direction
import ru.chesromakhin.roguelike.world.vm.BehaviorDriver
import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.Command

class AttackCommand : Command {
  override val group: String
    get() = "world"
  override val name: String
    get() = "attack"

  override fun execute(vm: VirtualMachine, parameter1: Short, parameter2: Short): Int {
    val behaviorDriver = vm.getDriver<BehaviorDriver>(BehaviorDriver.NAME)

    val directionValue = parameter1.toInt() and 3

    val direction = when (directionValue) {
      Direction.UP.ordinal -> {
        Direction.UP
      }
      Direction.RIGHT.ordinal -> {
        Direction.RIGHT
      }
      Direction.BOTTOM.ordinal -> {
        Direction.BOTTOM
      }
      Direction.LEFT.ordinal -> {
        Direction.LEFT
      }
      else -> {
        Direction.UP
      }
    }

    behaviorDriver?.sendCommand(Attack(direction))
    return 1
  }

}