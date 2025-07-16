package com.guitarshack

class Inventory(
  private val inventoryMap: MutableMap<Guitars, Int> = HashMap()
) {

  fun removeItem(item: Guitars, quantity: Int) {
    val currentStock = inventoryMap[item] ?: 0
    val newStock = (currentStock - quantity).coerceAtLeast(0)
    inventoryMap[item] = newStock
  }

  fun addItem(item: Guitars, quantity: Int) {
    val currentStock = inventoryMap[item] ?: 0
    inventoryMap[item] = currentStock + quantity
  }

  fun getStock(item: Guitars): Int {
    return inventoryMap[item] ?: 0
  }
}
