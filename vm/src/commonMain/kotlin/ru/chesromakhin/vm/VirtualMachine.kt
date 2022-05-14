package ru.chesromakhin.vm

import ru.chesromakhin.vm.command.Command
import ru.chesromakhin.vm.command.NoopCommand
import ru.chesromakhin.vm.driver.Driver

class VirtualMachine {

  private var currentCommand: Int = 0
  private var drivers: Map<String, Driver> = emptyMap()
  private var program: List<Long> = emptyList()
  private var commandMap: MutableMap<Int, Command> = mutableMapOf()

  init {
    commandMap = commandMap.withDefault { NoopCommand() }
  }

  fun runForTicks(ticks: Int) {
    for (i in 0 until ticks) {
      tick()
    }
  }

  fun setCommands(commands: Map<Int, Command>) {
    commandMap.putAll(commands)
  }

  fun tick() {
    if (program.isEmpty()) {
      return
    }

    val commandAndParams = program[currentCommand]
    val commandCode = commandAndParams.shr(16).and(0xFFFF).toInt()
    val firstParam = commandAndParams.and(0x0000FF00).shr(8).toShort()
    val secondParam = commandAndParams.and(0x000000FF).toShort()
    val command = commandMap[commandCode]
    
    currentCommand = command?.execute(this, firstParam, secondParam) ?: (currentCommand + 1)
    currentCommand %= program.size
  }

  fun <D: Driver> getDriver(name: String): D? {
    val driver = drivers[name]
    return if (driver != null) {
      driver as D
    } else {
      null
    }
  }

  fun addDriver(driver: Driver) {
    drivers = drivers + Pair(driver.name, driver)
  }

  fun loadProgram(newProgram: List<Long>) {
    program = newProgram
    currentCommand = 0
  }

}