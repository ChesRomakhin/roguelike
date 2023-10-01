package ru.chesromakhin.roguelike.world.entity

import ru.chesromakhin.roguelike.world.World
import ru.chesromakhin.roguelike.world.action.*
import ru.chesromakhin.roguelike.world.entity.component.HealthComponent
import ru.chesromakhin.roguelike.world.entity.component.Inventory
import ru.chesromakhin.roguelike.world.item.ItemComponent
import ru.chesromakhin.roguelike.world.vm.BehaviorDriver
import ru.chesromakhin.vm.VirtualMachine
import ru.chesromakhin.vm.command.system.NoopCommand
import kotlin.random.Random

class VmBot(id: String, health: Int): Entity(id) {

  private val vm: VirtualMachine = VirtualMachine()
  private val behaviorDriver = BehaviorDriver(this)

  init {
    this.addComponent(HealthComponent(health))
    this.addComponent(Inventory())

    vm.addDriver(behaviorDriver)
    behaviorDriver.onCommand(this::onActionEmitted)
  }

  override var char: String = "🤖"
  var speed: Int = 2

  private var action: Action? = null

  override fun process(world: World): Action {
    this.action = null;

    for (i in 0..1000) {
      vm.tick()

      if (this.action != null) {
        break
      }
    }

    return this.action ?: Idle();
  }

  private fun onActionEmitted(action: Action) {
    this.action = action
  }

}