package ru.chesromakhin.vm.memory

import ru.chesromakhin.vm.driver.Driver

class MemoryDriver(memorySize: Int, stackSize: Int) : Driver {

  private var memory: Array<Short> = emptyArray()
  private var stack: MutableList<Short> = mutableListOf()
  private var stackSize = 0

  init {
    memory = Array(memorySize) { 0 }
    this.stackSize = stackSize
  }

  override val name: String
    get() {
      return "memory"
    }

  fun write(address: Short, value: Short) {
    if (address >= 0 && address < memory.size) {
      memory[address.toInt()] = value
    }
  }

  fun read(address: Short): Short {
    return if (address >= 0 && address < memory.size) {
      memory[address.toInt()]
    } else {
      0
    }
  }

  fun pop(): Short {
    return stack.lastOrNull() ?: 0
  }

  fun push(value: Short) {
    if (stack.size < stackSize) {
      stack.add(value)
    }
  }

}